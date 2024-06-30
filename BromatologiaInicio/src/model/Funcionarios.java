/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tobias
 */
public class Funcionarios {
    private int ID_funcionario;
    private String CPF;
    private String Nome;
    private String Telefone;
    private String Usuario;
    private String Senha;
    private String FK1_Sexo;
    private int Tipo_User;
    
    public Funcionarios(){
  
    };
    
    public Funcionarios(String CPF, String Nome, String Telefone, String Usuario, String Senha, String FK1_Sexo, int Tipo_User){
        this.CPF = CPF;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Usuario = Usuario;
        this.Senha = Senha;
        this.FK1_Sexo = FK1_Sexo;
        this.Tipo_User = Tipo_User;
    };
    
    public Funcionarios(int ID_Funcionario,String CPF, String Nome, String Telefone, String Usuario, String Senha, String FK1_Sexo, int Tipo_User){
        this.ID_funcionario = ID_Funcionario;
        this.CPF = CPF;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Usuario = Usuario;
        this.Senha = Senha;
        this.FK1_Sexo = FK1_Sexo;
        this.Tipo_User = Tipo_User;
    };

    public int getID_funcionario() {
        return ID_funcionario;
    }

    public void setID_funcionario(int ID_funcionario) {
        this.ID_funcionario = ID_funcionario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getFK1_Sexo() {
        return FK1_Sexo;
    }

    public void setFK1_Sexo(String FK1_Sexo) {
        this.FK1_Sexo = FK1_Sexo;
    }
    
    public int getTipo_User() {
        return Tipo_User;
    }

    public void setTipo_User(int Tipo_User) {
        this.Tipo_User = Tipo_User;
    }
}
