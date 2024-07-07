/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Funcionarios;
import model.Supermercado;

/**
 *
 * @author Tobias
 */
public class SupermercadoDao implements DaoGenerica<Supermercado>{
    
    private conexaoBanco conexao;
    
    public SupermercadoDao()
    {
        this.conexao = new conexaoBanco();
    }

    @Override
    public void inserir(Supermercado supermercado) {
        String sql = "INSERT INTO Supermercados (CUIT_CUIL, Nombre, Telefono, Usuario, Contrasenha, Tipo_User) VALUES(?,?,?,?,?,?)";
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setString(1,supermercado.getCUIT_CUIL());
                sentenca.setString(2,supermercado.getNombre());
                sentenca.setString(3,supermercado.getTelefone());
                sentenca.setString(4,supermercado.getUsuario());
                sentenca.setString(5,supermercado.getSenha());
                sentenca.setInt(6,supermercado.getTipo_User());
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

    @Override
    public void alterar(Supermercado supermercado) {
        String sql = "UPDATE Supermercados SET CUIT_CUIL = ?, Nombre = ?, Telefono = ?, Usuario = ?, Contrasenha = ?, Tipo_User = ? WHERE ID_Supermercado = ?";
        try{
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setString(1,supermercado.getCUIT_CUIL());
                sentenca.setString(2,supermercado.getNombre());
                sentenca.setString(3,supermercado.getTelefone());
                sentenca.setString(4,supermercado.getUsuario());
                sentenca.setString(5,supermercado.getSenha());
                sentenca.setInt(6,supermercado.getTipo_User());
                sentenca.setInt(7,supermercado.getID_Supermercado());
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

    public void excluirID(int id) {
        String sql = "DELETE FROM Supermercados WHERE ID_Supermercado = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setInt(1,id);
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

    @Override
    public ArrayList<Supermercado> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Supermercado> dashboard() {
        ArrayList<Supermercado> ListarDashBoard = new ArrayList<Supermercado>();
        String sql = "SELECT ID_Supermercado,CUIT_CUIL,Nombre,Telefono,Usuario,Tipo_User FROM Supermercados";
        
        try
        {
         if(this.conexao.conectar())
         {
             PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
             ResultSet resultSentenca = sentenca.executeQuery(); 
             
             while(resultSentenca.next())
             {
                 Supermercado supermercado = new Supermercado();
                 supermercado.setID_Supermercado(resultSentenca.getInt("ID_Supermercado"));
                 supermercado.setCUIT_CUIL(resultSentenca.getString("CUIT_CUIL"));
                 supermercado.setNombre(resultSentenca.getString("Nombre"));
                 supermercado.setTelefone(resultSentenca.getString("Telefono"));
                 supermercado.setUsuario(resultSentenca.getString("Usuario"));
                 supermercado.setTipo_User(resultSentenca.getInt("Tipo_User"));
                 
                 ListarDashBoard.add(supermercado);
             }
             sentenca.close();
             this.conexao.getConnection().close();
         } 
         return ListarDashBoard;
        }
        catch(SQLException ex)
        {
            throw new RuntimeException (ex);
        }
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
