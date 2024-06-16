package dao;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Professor;

public class ProfessorDAO {
    
    public void create(Professor professor) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO professor (nome, cpf, nascimento, idade, salario) VALUES (?,?,?,?,?)");
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getCpf());
            stmt.setString(3, professor.getNascimento());
            stmt.setInt(4, professor.getIdade());
            stmt.setString(5, professor.getSalario());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
    
    public void delete (Professor professor) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM professor WHERE id = ?");
            stmt.setInt(1, professor.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        }
    }
    
    public List<Professor> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Professor> professores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM professor");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Professor professor = new Professor();

                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setCpf(rs.getString("cpf"));
                professor.setNascimento(rs.getString("nascimento"));
                professor.setIdade(rs.getInt("idade"));
                professor.setSalario(rs.getString("salario"));
                professores.add(professor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return professores;   
    }
       
    public List<Professor> readFor(String nome) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Professor> professores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM professor WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Professor professor = new Professor();

                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setCpf(rs.getString("cpf"));
                professor.setNascimento(rs.getString("nascimento"));
                professor.setIdade(rs.getInt("idade"));
                professor.setSalario(rs.getString("salario"));
                professores.add(professor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professores;
    }
}