/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Producto;
import model.Usuario;

/**
 *
 * @author Tobias
 */
public class UsuarioDao{
    
    private conexaoBanco conexao;
    
    public UsuarioDao()
    {
        this.conexao = new conexaoBanco();
    }
    
    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (Usuario, Contrasenha) VALUES(?,?)";
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setString(1,usuario.getUsuario());
                sentenca.setString(2,usuario.getContrasenha());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    
}
