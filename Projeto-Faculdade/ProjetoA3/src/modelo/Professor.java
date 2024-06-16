package modelo;

import modelo.Aluno;


public class Professor extends Aluno {

    private String salario;

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getSalario() {
        return salario;
    }
    
    //@Override
    //Polimorfismo - metodo para que eu consiga chamar os outros metodos
    @Override 
    public String toString(){
        return """
               Professor
               Nome"""+ nome+"\n"+
                "Cpf"+ cpf+"\n"+
                "Nascimento"+nascimento+"\n"+
                "Idade"+idade+"\n"+
                "Salario"+salario+"\n";
    }

}
