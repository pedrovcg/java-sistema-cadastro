package modelo;

public class Aluno {

    int id;
    String nome;
    String cpf;
    String nascimento;
    int idade;
    

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getNascimento() {
        return nascimento;
    }
    

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

}

