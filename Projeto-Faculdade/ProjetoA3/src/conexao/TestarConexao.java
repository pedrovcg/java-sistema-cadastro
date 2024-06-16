package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TestarConexao {
    
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        JOptionPane.showMessageDialog (null, "Conexão aberta com sucesso");
        connection.close();
    }
    
}
