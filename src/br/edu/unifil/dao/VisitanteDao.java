package br.edu.unifil.dao;

import br.edu.unifil.config.DBConnection;
import br.edu.unifil.model.VisitanteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Quarto CRUD Object
 * @author ThiagoAugustus
 */
public class VisitanteDao {
    
    /**
     * Insere o visitante no banco de dados
     * @param VisitanteModel visitante
     * @return boolean
     * @throws SQLException 
     */
    public int insertPerfil( VisitanteModel visitante ) throws SQLException {
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        ResultSet         res;
        String            sql;
        
        // Verifica se existe o nome
        try {
            if ( visitante.getNomeVisitante() == null ||
                    visitante.getNomeVisitante().trim().equals("") ) {
                System.out.println("Não foi possivel inserir o visitante.");
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel inserir o visitante.");
            return 0;
        }
        
        // Query de inserção
        sql = "INSERT INTO visitantes VALUES (NULL, ?, ?, ?)";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString( 1, visitante.getNomeVisitante() );
            stm.setString( 2, visitante.getTelefoneVisitante() );
            stm.setString( 3, visitante.getEmailVisitante() );
            
            // Executa a query
            stm.execute();
            
            // Recupera o id de inserção
            res = stm.getGeneratedKeys();
            res.next();
            visitante.setIdVisitante( res.getInt(1) );
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao cadastrar o visitante.");
            return 0;
            
        } finally {
            
            // Fecha as instancias abertas
            stm.close();
            con.close();
            
        }
        
        return visitante.getIdVisitante();
    
    }
    
    /**
     * Atualiza o visitante no banco de dados
     * @param VisitanteModel visitante
     * @return boolean
     * @throws SQLException 
     */
    public boolean updateVisitante( VisitanteModel visitante ) throws SQLException {
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        ResultSet         res;
        String            sql;
        
        // Verifica se existe o nome
        try {
            if ( visitante.getNomeVisitante() == null ||
                    visitante.getNomeVisitante().trim().equals("") ||
                    visitante.getIdVisitante() <= 0 ) {
                System.out.println("Não foi possivel atualizar o visitante.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel atualizar o visitante.");
            return false;
        }
        
        // Query de inserção
        sql = "UPDATE visitantes SET nome = ?, telefone = ?, email = ? WHERE idvisitante = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString( 1, visitante.getNomeVisitante() );
            stm.setString( 2, visitante.getTelefoneVisitante() );
            stm.setString( 3, visitante.getEmailVisitante() );
            stm.setInt( 4, visitante.getIdVisitante() );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao atualizar o visitante.");
            return false;
            
        } finally {
            
            // Fecha as instancias abertas
            stm.close();
            con.close();
            
        }
        
        return true;
    
    }
    
    /**
     * Exclui o visitante do banco de dados
     * @param VisitanteModel visitante
     * @return boolean
     * @throws SQLException 
     */
    public boolean deleteVisitante(VisitanteModel visitante) throws SQLException{
        
        // Verifica se os id existem
        if ( visitante.getIdVisitante() <=0 ) {
            System.out.println("Não foi possivel excluir o visitante, falta o ID.");
            return false;
        }
        
        Connection        con = DBConnection.getConnection();
        PreparedStatement stm = null;
        String            sql;
        
        // Query de inserção
        sql = "DELETE FROM visitantes WHERE idvisitante = ?";
        
        try {
            
            // Prepara para a inserção
            stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt( 1, visitante.getIdVisitante() );
            
            // Executa a query
            stm.execute();
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao excluir o visitante.");
            return false;
            
        } finally {
            
            // Fecha as instancias abertas
            stm.close();
            con.close();
            
        }
        
        return true;

    }

}
