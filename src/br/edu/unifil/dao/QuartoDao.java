package br.edu.unifil.dao;

import br.edu.unifil.config.DBConnection;
import br.edu.unifil.model.QuartoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Quarto CRUD Object
 * @author ThiagoAugustus
 */
public class QuartoDao {
    
    /**
     * Insere o quarto no banco de dados
     * @param QuartoModel quarto
     * @return boolean
     * @throws SQLException 
     */
    public boolean insertPerfil( QuartoModel quarto ) throws SQLException {
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        ResultSet         res;
        String            sql;
        int               idPermissoes;
        
        // Verifica se existe permissões
        try {
            if ( quarto.getTipoQuarto().getIdTipoQuarto() <= 0 ) {
                System.out.println("Não foi possivel atualizar o quarto, tipo do quarto não foi localizado.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel atualizar o quarto, tipo do quarto não foi localizado.");
            return false;
        }
        
        // Query de inserção
        sql = "UPDATE quartos SET descricao = ?, idtipo = ?, capacidade = ? WHERE idquarto = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString( 1, quarto.getDescricaoQuarto() );
            stm.setInt( 2, quarto.getTipoQuarto().getIdTipoQuarto() );
            stm.setInt( 3, quarto.getCapacidadeQuarto() );
            stm.setInt( 4, quarto.getIdQuarto() );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao atualizar o quarto.");
            return false;
            
        } finally {
            
            // Fecha as instancias abertas
            stm.close();
            con.close();
            
        }
        
        return true;
    
    }
    /**
     * Exclui o quarto no banco de dados
     * @param QuartoModel quarto
     * @return boolean
     * @throws SQLException 
     */
    public boolean deleteQuarto(QuartoModel quarto) throws SQLException{
        
        // Verifica se os id existem
        if ( quarto.getIdQuarto() <=0 ) {
            System.out.println("Não foi possivel excluir o quarto, falta o ID.");
            return false;
        }
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        String            sql;
        
        // Query de inserção
        sql = "DELETE FROM quartos WHERE idquarto = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt( 1, quarto.getIdQuarto() );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao excluir o quarto.");
            return false;
            
        } finally {
            
            // Fecha as instancias abertas
            stm.close();
            con.close();
            
        }
        
        return true;

    }

}
