package br.edu.unifil.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnection Object
 * @author ThiagoAugustus
 */
public class DBConnection {
    
    private static Connection connection = null;
    
    /**
     * Metodo abstrato
     * @return DBConnection
     */
    public static Connection getConnection() {
        
        // Verifica se a conexão já existe
        if ( connection != null ) {
            return connection;
        }

        // Inializa o driver
	try {
            
            Class.forName(DBConstants.DB_DRIVER);
        
        } catch (ClassNotFoundException e) {
        
            System.out.println("Não foi encontrato o Driver " + DBConstants.DB_DRIVER);
            return connection;
        
        }
        
        // Recupera a conexao
        try {
            
            connection = DriverManager.getConnection(DBConstants.DB_CONNECTION, DBConstants.DB_USER,
                         DBConstants.DB_PASSWORD);
        
        } catch (SQLException e) {
        
            System.out.println("Erro na conexão");
            return connection;
	
        }
        
        // Retorna a conexão
        return connection;
   
    }
    
}
