/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Producto;
import model.Supermercado;

/**
 *
 * @author Tobias
 */
public class ProductoDao implements DaoGenerica<Producto>{
    private conexaoBanco conexao;
    
    public ProductoDao()
    {
        this.conexao = new conexaoBanco();
    }

    @Override
    public void inserir(Producto producto) {
        String sql = "INSERT INTO Productos (Nombre_Producto,Nombre_Supermercado,Cantidad_Disponible,Valor_Anterior,Valor_Actual,Vencimiento) VALUES(?,?,?,?,?,?)";
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setString(1,producto.getNombreProducto());
                sentenca.setString(2,producto.getSupermercado());
                sentenca.setInt(3,producto.getCantidad());
                sentenca.setString(4,producto.getValor_Anterior());
                sentenca.setString(5,producto.getValor_Actual());
                sentenca.setString(6,producto.getVencimiento());
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
    public void alterar(Producto producto) {
        String sql = "UPDATE Productos SET Nombre_Producto = ?, Nombre_Supermercado = ?, Cantidad_Disponible = ?, Valor_Anterior = ?, Valor_Actual = ?, Vencimiento = ? WHERE ID_Producto = ?";
        try{
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setString(1,producto.getNombreProducto());
                sentenca.setString(2,producto.getSupermercado());
                sentenca.setInt(3,producto.getCantidad());
                sentenca.setString(4,producto.getValor_Anterior());
                sentenca.setString(5,producto.getValor_Actual());
                sentenca.setString(6,producto.getVencimiento());
                sentenca.setInt(7,producto.getID_Producto());
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
        String sql = "DELETE FROM Productos WHERE ID_Producto = ?";
        
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
    public ArrayList<Producto> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Producto> dashboard() {
        ArrayList<Producto> ListarDashBoard = new ArrayList<Producto>();
        String sql = "SELECT ID_Producto, Nombre_Producto, Nombre_Supermercado, Cantidad_Disponible, Valor_Anterior,Valor_Actual, Vencimiento FROM Productos";
        
        try
        {
         if(this.conexao.conectar())
         {
             PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
             ResultSet resultSentenca = sentenca.executeQuery(); 
             
             while(resultSentenca.next())
             {
                 Producto producto = new Producto();
                 producto.setID_Producto(resultSentenca.getInt("ID_Producto"));
                 producto.setNombreProducto(resultSentenca.getString("Nombre_Producto"));
                 producto.setSupermercado(resultSentenca.getString("Nombre_Supermercado"));
                 producto.setCantidad(resultSentenca.getInt("Cantidad_Disponible"));
                 producto.setValor_Anterior(resultSentenca.getString("Valor_Anterior"));
                 producto.setValor_Actual(resultSentenca.getString("Valor_Actual"));
                 producto.setVencimiento(resultSentenca.getString("Vencimiento"));
                 ListarDashBoard.add(producto);
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
