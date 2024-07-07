
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import dao.DaoGenerica;
import dao.conexaoBanco;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import model.Funcionarios;
import telas.PagInicioLogin;
//import telas.TelaLogin;
//import telas.TelaPrincipal;
import telas.CadastroSupermercados;

public class FuncionariosDao implements DaoGenerica<Funcionarios>{

    private conexaoBanco conexao;
    
    public FuncionariosDao()
    {
        this.conexao = new conexaoBanco();
    }
    
    /*public List<Funcionarios> listar(){
        List<Funcionarios> listaFuncionarios = new ArrayList<>();
        String sql = "Select ID_Funcionario, CPF, Nome, Telefone, Usuario,(select ID_Genero from Genero where Tipo_Genero = FK1_sexo), Tipo_User";
        
        try
        {
            if(this.conexao.conectar())
            {PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios funcionario = new Funcionarios();
                funcionario.setID_funcionario(rs.getInt("ID_Funcionario"));
                funcionario.setCPF(rs.getString("CPF"));
                funcionario.setNome(rs.getString("Nome"));
                funcionario.setTelefone(rs.getString("Telefone"));
                funcionario.setUsuario(rs.getString("Usuario"));
                funcionario.setFK1_Sexo(rs.getString("Genero"));
                funcionario.setTipo_User(rs.getInt("Tipo_User"));

                listaFuncionarios.add(funcionario);
            }
        }}
        catch (SQLException e) {
            e.printStackTrace();
        }

        return listaFuncionarios;
    }*/
    @Override
    public void inserir(Funcionarios funcionarios) {
        //string com a consulta que será executada no banco
        String sql = "INSERT INTO Funcionario (ID_Funcionario, DNI, Nombre, Telefono, Usuario, Contrasenha, Sexo, Tipo_User) VALUES (?,?,?,?,?,?,?,?)";
        
        try
        {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if(this.conexao.conectar())
            {
                //prepara a sentença com a consulta da string
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //subtitui as interrograções da consulta, pelo valor específico
                sentenca.setInt(1,funcionarios.getID_funcionario());
                sentenca.setString(2,funcionarios.getCPF());
                sentenca.setString(3,funcionarios.getNome()); 
                sentenca.setString(4,funcionarios.getTelefone());
                sentenca.setString(5,funcionarios.getUsuario());
                sentenca.setString(6,funcionarios.getSenha());
                sentenca.setString(7,funcionarios.getFK1_Sexo()); 
                sentenca.setInt(8,funcionarios.getTipo_User());
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }

    @Override
    public void alterar(Funcionarios funcionarios) {
        String sql = "UPDATE Funcionario SET CPF = ?, Nome = ?, Telefone = ?, Usuario = ?, Tipo_User = ? WHERE ID_Funcionario = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setInt(6,funcionarios.getID_funcionario());
                sentenca.setString(1,funcionarios.getCPF());
                sentenca.setString(2,funcionarios.getNome());
                sentenca.setString(3,funcionarios.getTelefone());
                sentenca.setString(4,funcionarios.getUsuario());
                //sentenca.setString(6, funcionarios.getSenha());
               // sentenca.setString(7, funcionarios.getFK1_Sexo());
                sentenca.setInt(5, funcionarios.getTipo_User());
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

    public void excluir() {
        String sql = "DELETE FROM ESCOLA";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
   
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
        String sql = "DELETE FROM Funcionario WHERE ID_Funcionario = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setInt(1, id);
                
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
    
    public void Login(PagInicioLogin pagInicioLogin, String Usuario, String Senha) {
        String sql = "SELECT * FROM Funcionario WHERE Usuario = ? AND Senha = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setString(1, Usuario);
                sentenca.setString(2, Senha);
                ResultSet respuesta = sentenca.executeQuery();
                if(respuesta.next()){
                    JOptionPane.showMessageDialog(null, "Usuario encontrado");
                    PagInicioLogin tela = new PagInicioLogin();
                    tela.setVisible(true);
                    pagInicioLogin.dispose();
                   /* TelaLogin telaLogin = new TelaLogin();
                    telaLogin.setVisible(false);*/
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario Inexcistente");
                    System.exit(0);
                }
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
    public ArrayList<Funcionarios> consultar() {
        
        ArrayList<Funcionarios> listaFuncionarios = new ArrayList<Funcionarios>();
        String sql = "SELECT c.ID_Funcionario, c.CPF, c.Nome, c.Telefone, c.Usuario, s.Tipo_Genero, c.Tipo_User "+
                     "FROM Funcionario as c "+
                     "LEFT JOIN Genero AS s ON (s.ID_Genero = c.FK1_Sexo) "+  
                     "ORDER BY c.ID_Funcionario ";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //recebe o resultado da consulta
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Funcionarios funcionario = new Funcionarios();
                    funcionario.setID_funcionario(resultadoSentenca.getInt("ID_Funcionario"));
                    funcionario.setCPF(resultadoSentenca.getString("CPF"));
                    funcionario.setNome(resultadoSentenca.getString("Nome"));
                    funcionario.setTelefone(resultadoSentenca.getString("Telefone"));
                    funcionario.setUsuario(resultadoSentenca.getString("Usuario"));
                    funcionario.setFK1_Sexo(resultadoSentenca.getString("FK1_Sexo"));
                    funcionario.setTipo_User(resultadoSentenca.getInt("Tipo_User"));
                    listaFuncionarios.add(funcionario);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return listaFuncionarios;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    public ArrayList<Funcionarios> consultar(String str) {
        
        ArrayList<Funcionarios> listaFuncionariosStr = new ArrayList<Funcionarios>();
        String sql = "SELECT c.ID_Funcionario, c.CPF, c.Nome, c.Telefone, c.Usuario, s.Tipo_Genero, c.Tipo_User "+
                     "FROM Funcionarios as c "+
                     "LEFT JOIN Genero AS s ON (s.ID_Genero = c.FK1_Sexo) "+
                     "WHERE ( UPPER(c.Nome like UPPER(?))) "+   
                     "ORDER BY s.Tipo_Genero ";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //recebe o resultado da consulta
                sentenca.setString(1, "%"+str+"%");
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Funcionarios funcionario = new Funcionarios();
                    funcionario.setID_funcionario(resultadoSentenca.getInt("ID_Funcionario"));
                    funcionario.setCPF(resultadoSentenca.getString("CPF"));
                    funcionario.setNome(resultadoSentenca.getString("Nome"));
                    funcionario.setTelefone(resultadoSentenca.getString("Telefone"));
                    funcionario.setUsuario(resultadoSentenca.getString("Usuario"));
                    funcionario.setFK1_Sexo(resultadoSentenca.getString("FK1_Sexo"));
                    funcionario.setTipo_User(resultadoSentenca.getInt("Tipo_User"));
                    
                    listaFuncionariosStr.add(funcionario);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return listaFuncionariosStr;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    
    public ArrayList<Funcionarios> dashboard() {
        ArrayList<Funcionarios> ListarDashBoard = new ArrayList<Funcionarios>();
        String sql = "SELECT ID_Funcionario,CPF,Nome,Telefone,Usuario,Tipo_User FROM Funcionario";//"SELECT c.ID_Funcionario, c.CPF, c.Nome, c.Telefone, c.Usuario, s.Tipo_Genero, c.Tipo_User " +
                 //"FROM Funcionario c " +
                // "LEFT JOIN Genero s ON c.FK1_Sexo = s.ID_Genero";
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //recebe o resultado da consulta
                 ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    Funcionarios funcionario = new Funcionarios();
                    funcionario.setID_funcionario(resultadoSentenca.getInt("ID_Funcionario"));
                    funcionario.setCPF(resultadoSentenca.getString("CPF"));
                    funcionario.setNome(resultadoSentenca.getString("Nome"));
                    funcionario.setTelefone(resultadoSentenca.getString("Telefone"));
                    funcionario.setUsuario(resultadoSentenca.getString("Usuario"));
                    //funcionario.setFK1_Sexo(resultadoSentenca.getString("FK1_Sexo"));
                    funcionario.setTipo_User(resultadoSentenca.getInt("Tipo_User"));

                    ListarDashBoard.add(funcionario);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return ListarDashBoard;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
}