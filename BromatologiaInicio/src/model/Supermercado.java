/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tobias
 */
public class Supermercado {
    private int ID_Supermercado;
    private String CUIT_CUIL;
    private String Nombre;
    private String Telefone;
    private String Usuario;
    private String Senha;
    private int Tipo_User;
    
    public Supermercado(){
        
    };

    public int getID_Supermercado() {
        return ID_Supermercado;
    }

    public void setID_Supermercado(int ID_Supermercado) {
        this.ID_Supermercado = ID_Supermercado;
    }

    public String getCUIT_CUIL() {
        return CUIT_CUIL;
    }

    public void setCUIT_CUIL(String CUIT_CUIL) {
        this.CUIT_CUIL = CUIT_CUIL;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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

    public int getTipo_User() {
        return Tipo_User;
    }

    public void setTipo_User(int Tipo_User) {
        this.Tipo_User = Tipo_User;
    }
    
    

}
