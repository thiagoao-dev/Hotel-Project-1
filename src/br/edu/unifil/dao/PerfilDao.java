package br.edu.unifil.dao;

import br.edu.unifil.config.DBConnection;
import br.edu.unifil.model.PerfilModel;
import br.edu.unifil.model.PermissaoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Perfil CRUD Object
 * @author ThiagoAugustus
 */
public class PerfilDao {
    
    /**
     * Insere o perfil no banco de dados
     * @param PerfilModel perfil
     * @return boolean
     * @throws SQLException 
     */
    public boolean insertPerfil( PerfilModel perfil ) throws SQLException {
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        ResultSet         res;
        String            sql;
        int               idPermissoes;
        
        // Verifica se existe permissões
        try {
            if ( perfil.getPermissaoPerfil().getIdPermissao() <= 0 ) {
                System.out.println("Não foi possivel cadastrar perfil, permissões não encontradas.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel cadastrar perfil, permissões não encontradas.");
            return false;
        }
        
        // Cadastra permissoes
        idPermissoes = insertPermissoesPerfil(perfil.getPermissaoPerfil(), con, stm);
        if ( idPermissoes <= 0) {
            System.out.println("Não foi possivel cadastrar perfil.");
            return false;
        }
        
        // Query de inserção
        sql = "INSERT INTO perfil VALUES (NULL, ?, ?, ? )";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString( 1, perfil.getDescricaoPerfil() );
            stm.setBoolean( 2, perfil.isStatusPerfil() );
            stm.setInt( 3, idPermissoes );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao inserir o usuario.");
            return false;
            
        } finally {
            
            // Fecha as instancias abertas
            stm.close();
            con.close();
            
        }
        
        return true;
    
    }
    
    /**
     * Cadastra as permissões do perfil
     * @param PermissaoModel permissoes
     * @param Connection con
     * @param PreparedStatement stm
     * @return boolean
     */
    private int insertPermissoesPerfil( PermissaoModel permissoes, Connection con, PreparedStatement stm ) {
        
        stm = null;
        ResultSet res;
        String    sql;
        
        // Query de inserção
        sql = "INSERT INTO permissoes VALUES ( NULL, ?, ?, ?, ? )";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setBoolean( 1, permissoes.isCreatePermissao() );
            stm.setBoolean( 2, permissoes.isReadPermissao() );
            stm.setBoolean( 3, permissoes.isUpdatePermissao() );
            stm.setBoolean( 4, permissoes.isDeletePermissao() );
            
            // Executa a query
            stm.execute();
            
            // Recupera o id de inserção
            res = stm.getGeneratedKeys();
            res.next();
            return res.getInt(1);
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao criar relacionamento de perfil com usuario.");
            return 0;
            
        }
        
    }
    
    /**
     * Atualiza os registros do perfil do usuario
     * @param PerfilModel perfil
     * @return boolean
     * @throws SQLException 
     */
    public boolean updatePerfil( PerfilModel perfil ) throws SQLException {
        
        // Caso não aja id do usuario
        if ( perfil.getIdPerfil() <= 0 || perfil.getPermissaoPerfil().getIdPermissao() <= 0 ) {
            System.out.println("Não foi possivel recuperar o id do perfil/permissões.");
            return false;
        }
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        String            sql;
        
        // Query de inserção
        sql = "UPDATE perfil SET descricao = ?, status = ?, idpermissao = ? WHERE idperfil = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString( 1, perfil.getDescricaoPerfil() );
            stm.setBoolean( 2, perfil.isStatusPerfil() );
            stm.setInt( 3, perfil.getPermissaoPerfil().getIdPermissao() );
            stm.setInt( 4, perfil.getIdPerfil() );
            
            // Executa a query
            stm.execute();
            
            // Insere o registro de relacionamento entre usuario e perfil
            updatePermissaoPerfil( perfil.getPermissaoPerfil(), con, stm );
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao atualizar o usuário.");
            return false;
            
        } finally {
            
            // Fecha as instancias abertas
            stm.close();
            con.close();
            
        }
        
        return true;
    
    }
    
    /**
     * Faz update do permissoes do perfil do usuario
     * @param PermissaoModel permissoes
     * @param Connection con
     * @param PreparedStatement stm
     * @return boolean
     */
    private boolean updatePermissaoPerfil( PermissaoModel permissao, Connection con, PreparedStatement stm ) {
        
        stm    = null;
        String   sql;
        
        // Query de inserção
        sql = "UPDATE permissoes SET create = ?, read = ?, update = ?, delete = ? WHERE idpermissao = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setBoolean( 1, permissao.isCreatePermissao() );
            stm.setBoolean( 2, permissao.isReadPermissao() );
            stm.setBoolean( 3, permissao.isUpdatePermissao() );
            stm.setBoolean( 4, permissao.isDeletePermissao() );
            stm.setInt( 5, permissao.getIdPermissao() );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao atualizar as permissoes do perfil do usuário.");
            return false;
            
        }
        
        return true;
    }
    
    /**
     * Faz update do permissoes perfil do usuario
     * @param PermissaoModel permissao
     * @return boolean
     * @throws SQLException 
     */
    public boolean updatePermisaoPerfil( PermissaoModel permissao ) throws SQLException {
        
        // Verifica se o id do perfil foi encontrado
        if ( permissao.getIdPermissao() <= 0 ) {
            System.out.println("ID da permissão não encontrada.");
        }
        
        // Inicializa a conexao
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        String            sql;
        
        // Query de inserção
        sql = "UPDATE permissoes SET create = ?, read = ?, update = ?, delete = ? WHERE idpermissao = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setBoolean( 1, permissao.isCreatePermissao() );
            stm.setBoolean( 2, permissao.isReadPermissao() );
            stm.setBoolean( 3, permissao.isUpdatePermissao() );
            stm.setBoolean( 4, permissao.isDeletePermissao() );
            stm.setInt( 5, permissao.getIdPermissao() );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao atualizar o perfil do usuário.");
            return false;
            
        } finally {
            
            // Fechas as conexoes pendentes
            stm.close();
            con.close();
            
        }
        
        return true;
    }
    
    /**
     * Exclui o perfil do banco
     * @param PerfilModel perfil
     * @return boolean
     * @throws SQLException 
     */
    public boolean deletePerfil(PerfilModel perfil) throws SQLException{
        
        // Verifica se os id existem
        if ( perfil.getIdPerfil() <=0 || perfil.getPermissaoPerfil().getIdPermissao() <= 0 ) {
            System.out.println("Não foi possivel excluir o perfil, falta o ID do perfil e/ou das permissões.");
            return false;
        }
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        String            sql;
        
        // Exclui o perfil do usuario primeiro
        if ( !deletePermissaoPerfil(perfil.getPermissaoPerfil(), con, stm) ) {
            System.out.println("Não foi possível excluir o perfil.");
            return false;
        }
        
        // Query de inserção
        sql = "DELETE FROM perfil WHERE idperfil = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt( 1, perfil.getIdPerfil() );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao excluir o perfil.");
            return false;
            
        } finally {
            
            // Fecha as instancias abertas
            stm.close();
            con.close();
            
        }
        
        return true;

    }
    
    /**
     * Exclui as permissoes do perfil
     * @param PermissaoModel permissao
     * @param Connection con
     * @param PreparedStatement stm
     * @return boolean
     */
    private boolean deletePermissaoPerfil(PermissaoModel permissao, Connection con, PreparedStatement stm ){
        
        String sql;
        
        // Query de inserção
        sql = "DELETE FROM permissoes WHERE idpermissao = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt( 1, permissao.getIdPermissao() );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao excluir as permissões do perfil.");
            return false;
            
        }
        
        return true;
    }
    
}
