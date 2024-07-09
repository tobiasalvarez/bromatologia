/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import telas.PagInicioLogado;
import telas.PagInicioLogin;

/**
 *
 * @author Tobias
 */
public class ConsultasDao {
    
    private conexaoBanco conexao;
    
    public ConsultasDao()
    {
        this.conexao = new conexaoBanco();
    }
    
    public void ConsultarUsuario(String Usuario, String Senha, PagInicioLogin pagInicioLogin)
    {
       String sql = "SELECT Usuario, Contrasenha FROM Usuarios WHERE Usuario = ? AND Contrasenha = ? UNION SELECT Usuario, Contrasenha FROM Supermercados WHERE Usuario = ? AND Contrasenha = ?";      
       try
       {
           if(this.conexao.conectar())
           {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql); 
                sentenca.setString(1,Usuario);
                sentenca.setString(2,Senha);
                sentenca.setString(3,Usuario);
                sentenca.setString(4,Senha);
                ResultSet resultSet = sentenca.executeQuery();
                
                
                if(resultSet.next())
                {
                    JOptionPane.showMessageDialog(null,"Login Correcto");
                    PagInicioLogado pagInicioLogado = new PagInicioLogado();
                    pagInicioLogado.setVisible(true);
                    pagInicioLogin.dispose();
                }else
                {
                    JOptionPane.showMessageDialog(null,"Login Incorrecto, Volver a intentar.");
                    
                }
           }
       }
       catch(SQLException ex)
       {
           throw new RuntimeException(ex);
       }
       
    }
    
}
