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
import modelo.Aluno;

public class AlunoDAO {
    
    public void create(Aluno aluno) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO aluno (nome, cpf, nascimento, idade) VALUES (?,?,?,?)");
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getNascimento());
            stmt.setInt(4, aluno.getIdade());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } 

    }
    
    public void delete (Aluno aluno) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM aluno WHERE id = ?");
            stmt.setInt(1, aluno.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        }

    }
    
    public List<Aluno> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Aluno> alunos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM aluno");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Aluno aluno = new Aluno();

                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setNascimento(rs.getString("nascimento"));
                aluno.setIdade(rs.getInt("idade"));
                alunos.add(aluno);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return alunos;
    
    }
    
    
    public List<Aluno> readFor(String nome) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Aluno> alunos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM aluno WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Aluno aluno = new Aluno();

                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setNascimento(rs.getString("nascimento"));
                aluno.setIdade(rs.getInt("idade"));
                alunos.add(aluno);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return alunos;

    }
    
}
