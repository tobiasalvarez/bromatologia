/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Tobias
 */
public class Producto {
    private int ID_Producto;
    private String NombreProducto;
    private String Supermercado;
    private int Cantidad;
    private String Valor_Anterior;
    private String Valor_Actual;       
    private String Vencimiento;
    
    public Producto(){
        
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getSupermercado() {
        return Supermercado;
    }

    public void setSupermercado(String Supermercado) {
        this.Supermercado = Supermercado;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getVencimiento() {
        return Vencimiento;
    }

    public void setVencimiento(String Vencimiento) {
        this.Vencimiento = Vencimiento;
    }

    public String getValor_Anterior() {
        return Valor_Anterior;
    }

    public void setValor_Anterior(String Valor_Anterior) {
        this.Valor_Anterior = Valor_Anterior;
    }

    public String getValor_Actual() {
        return Valor_Actual;
    }

    public void setValor_Actual(String Valor_Actual) {
        this.Valor_Actual = Valor_Actual;
    }
    
    
}
