package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public static Connection getConnection(){
    
        try {
            return
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoa3","root","admin");
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }

    }
}