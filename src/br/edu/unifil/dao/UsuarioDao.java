package br.edu.unifil.dao;

import br.edu.unifil.config.DBConnection;
import br.edu.unifil.model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Usuario CRUD Object
 * @author ThiagoAugustus
 */
public class UsuarioDao {
    
    /**
     * Insere o usuario no banco de dados
     * @param usuario
     * @return
     * @throws SQLException 
     */
    public boolean insertUsuario( UsuarioModel usuario ) throws SQLException {
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        ResultSet         res;
        String            sql;
        
        // Verifica se existe perfil
        try {
            if ( usuario.getPerfilUsuario().getIdPerfil() <= 0 ) {
                System.out.println("Não foi possivel cadastrar usuário, perfil não encontrado.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel cadastrar usuário, perfil não encontrado.");
            return false;
        }
        
        // Query de inserção
        sql = "INSERT INTO usuarios VALUES (NULL, ?, MD5(?) )";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString( 1, usuario.getLoginUsuario() );
            stm.setString( 2, usuario.getPasswordUsuario() );
            
            // Executa a query
            stm.execute();
            
            // Recupera o id de inserção
            res = stm.getGeneratedKeys();
            res.next();
            usuario.setIdUsuario( res.getInt(1) );
            
            // Insere o registro de relacionamento entre usuario e perfil
            insertUsuarioPerfil( usuario.getIdUsuario(), usuario.getPerfilUsuario().getIdPerfil(), con, stm );
            
        } catch (SQLException e) {
            
            if ( e.getErrorCode() == 1062 ) {
                JOptionPane.showMessageDialog(null, "O login [ "+usuario.getLoginUsuario()+" ]" +
                        ", já esta cadastrado.");
            }
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
     * Registra o relacionamento entre usuario e perfil
     * @param idusuario
     * @param idperfil
     * @return boolean
     */
    private boolean insertUsuarioPerfil( int idusuario, int idperfil, Connection con, PreparedStatement stm ) {
        
        stm = null;
        String            sql;
        
        // Query de inserção
        sql = "INSERT INTO usuario_has_perfil VALUES ( ?, ? )";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, idusuario );
            stm.setInt(2, idperfil );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao criar relacionamento de perfil com usuario.");
            return false;
            
        }
        
        return true;
    }
    
    /**
     * Atualiza os registros do usuario
     * @param usuario
     * @return
     * @throws SQLException 
     */
    public boolean updateUsuario( UsuarioModel usuario ) throws SQLException {
        
        // Caso não aja id do usuario
        if ( usuario.getIdUsuario() <= 0 ) {
            System.out.println("Não foi possivel recuperar o id o usuário.");
            return false;
        }
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        String            sql;
        
        // Query de inserção
        sql = "UPDATE usuarios SET password = MD5(?) WHERE idusuario = ? )";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString( 1, usuario.getPasswordUsuario() );
            stm.setInt( 2, usuario.getIdUsuario() );
            
            // Executa a query
            stm.execute();
            
            // Insere o registro de relacionamento entre usuario e perfil
            updateUsuarioPerfil( usuario.getIdUsuario(), usuario.getPerfilUsuario().getIdPerfil(), con, stm );
            
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
     * Faz update do perfil do usuario
     * @param idusuario
     * @param idperfil
     * @return boolean
     */
    private boolean updateUsuarioPerfil( int idusuario, int idperfil, Connection con, PreparedStatement stm ) {
        
        // Verifica se o id do perfil foi encontrado
        if ( idperfil <= 0 ) {
            System.out.println("ID do perfil não encontrado");
        }
        
        stm = null;
        String            sql;
        
        // Query de inserção
        sql = "UPDATE usuario_has_perfil SET idperfil = ? WHERE idusuario = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, idperfil );
            stm.setInt(2, idusuario );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao atualizar o perfil do usuário.");
            return false;
            
        }
        
        return true;
    }
    
    /**
     * Faz update do perfil do usuario
     * @param idusuario
     * @param idperfil
     * @return boolean
     */
    public boolean updateUsuarioPerfil( int idusuario, int idperfil ) throws SQLException {
        
        // Verifica se o id do perfil foi encontrado
        if ( idperfil <= 0 ) {
            System.out.println("ID do perfil não encontrado");
        }
        
        // Inicializa a conexao
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        String            sql;
        
        // Query de inserção
        sql = "UPDATE usuario_has_perfil SET idperfil = ? WHERE idusuario = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, idperfil );
            stm.setInt(2, idusuario );
            
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
     * Delete o usuario do banco
     * @param usuario
     * @return
     * @throws SQLException 
     */
    public boolean deleteUsuario(UsuarioModel usuario) throws SQLException{
        
        // Verifica se os id existem
        if ( usuario.getIdUsuario() <=0 || usuario.getPerfilUsuario().getIdPerfil() <= 0 ) {
            System.out.println("Não foi possivel excluir usuário, falta o ID do usuário e/ou perfil.");
            return false;
        }
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        String            sql;
        
        // Exclui o perfil do usuario primeiro
        if ( !deletePerfilUsuario(usuario.getIdUsuario(), usuario.getPerfilUsuario().getIdPerfil(), con, stm) ) {
            System.out.println("Não foi possível excluir o usuário.");
            return false;
        }
                
        // Verifica se existe perfil
        try {
            if ( usuario.getPerfilUsuario().getIdPerfil() <= 0 ) {
                System.out.println("Não foi possivel cadastrar usuário, perfil não encontrado.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel cadastrar usuário, perfil não encontrado.");
            return false;
        }
        
        // Query de inserção
        sql = "DELETE FROM usuarios WHERE idusuario = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt( 1, usuario.getIdUsuario() );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao excluir o usuario.");
            return false;
            
        } finally {
            
            // Fecha as instancias abertas
            stm.close();
            con.close();
            
        }
        
        return true;

    }
    
    /**
     * Exclui o perfil do usuário
     * @param idUsuario
     * @param idPerfil
     * @param con
     * @param stm
     * @return 
     */
    private boolean deletePerfilUsuario(int idUsuario, int idPerfil, Connection con, PreparedStatement stm ){
        
        String sql;
        
        // Query de inserção
        sql = "DELETE FROM usuario_has_perfil WHERE idusuario = ? AND idperfil = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt( 1, idUsuario );
            stm.setInt( 2, idPerfil );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao excluir perfil do usuário." + e.getMessage());
            return false;
            
        }
        
        return true;
    }
    
}
