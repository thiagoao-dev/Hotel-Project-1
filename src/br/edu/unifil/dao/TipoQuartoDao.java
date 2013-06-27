package br.edu.unifil.dao;

import br.edu.unifil.config.DBConnection;
import br.edu.unifil.model.TipoQuartoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * TipoQuarto CRUD Object
 * @author ThiagoAugustus
 */
public class TipoQuartoDao {
    
    /**
     * Insere o tipo do quarto no banco de dados
     * @param TipoQuartoModel tipoQuarto
     * @return int
     * @throws SQLException 
     */
    public int insertTipoQuarto( TipoQuartoModel tipoQuarto ) throws SQLException {
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        ResultSet         res;
        String            sql;
        
        // Verifica se existe permissões
        try {
            if ( tipoQuarto.getDescricaoTipoQuarto() == null || tipoQuarto.getDescricaoTipoQuarto().trim().equals("") ) {
                System.out.println("Não foi possivel cadastrar o tipo do quarto, descrição imcompleta.");
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel cadastrar o tipo do quarto, descrição imcompleta.");
            return 0;
        }
        
        // Query de inserção
        sql = "INSERT INTO tipos_quartos VALUES (NULL, ?)";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString( 1, tipoQuarto.getDescricaoTipoQuarto() );
            
            // Executa a query
            stm.execute();
            
            // Recupera o id de inserção
            res = stm.getGeneratedKeys();
            res.next();
            tipoQuarto.setIdTipoQuarto(res.getInt(1) );
            
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao inserir o tipo do quarto.");
            return 0;
            
        } finally {
            
            // Fecha as instancias abertas
            stm.close();
            con.close();
            
        }
        
        return tipoQuarto.getIdTipoQuarto();
    
    }
    
    /**
     * Atualiza o tipo do quarto no banco de dados
     * @param TipoQuartoModel tipoQuarto
     * @return boolean
     * @throws SQLException 
     */
    public boolean updateTipoQuarto( TipoQuartoModel tipoQuarto ) throws SQLException {
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        String            sql;
        
        // Verifica se existe permissões
        try {
            if ( tipoQuarto.getDescricaoTipoQuarto() == null || 
                    tipoQuarto.getDescricaoTipoQuarto().trim().equals("") ||
                    tipoQuarto.getIdTipoQuarto() <= 0 ) {
                System.out.println("Não foi possivel cadastrar o tipo do quarto, descrição e/ou Id imcompleto(s).");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel cadastrar o tipo do quarto, descrição e/ou Id imcompleto(s).");
            return false;
        }
        
        // Query de inserção
        sql = "UPDATE tipos_quartos SET descricao = ? WHERE idtipo = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString( 1, tipoQuarto.getDescricaoTipoQuarto() );
            stm.setInt( 2, tipoQuarto.getIdTipoQuarto() );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao inserir o tipo do quarto.");
            return false;
            
        } finally {
            
            // Fecha as instancias abertas
            stm.close();
            con.close();
            
        }
        
        return true;
    
    }
    
    /**
     * Exclui o tipo do quarto do banco
     * @param TipoQuartoModel tipoQuarto
     * @return boolean
     * @throws SQLException 
     */
    public boolean deleteTipoQuarto(TipoQuartoModel tipoQuarto) throws SQLException{
        
        // Verifica se os id existem
        if ( tipoQuarto.getIdTipoQuarto() <=0) {
            System.out.println("Não foi possivel excluir o tipo do quarto, erro ao recuperar o ID.");
            return false;
        }
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        String            sql;
        
        // Query de inserção
        sql = "DELETE FROM tipo_quartos WHERE idtipo = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt( 1, tipoQuarto.getIdTipoQuarto() );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao excluir o tipo do quarto.");
            return false;
            
        } finally {
            
            // Fecha as instancias abertas
            stm.close();
            con.close();
            
        }
        
        return true;

    }
    
}
