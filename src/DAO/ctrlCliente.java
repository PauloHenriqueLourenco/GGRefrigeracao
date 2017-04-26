/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;
import modelo.Conexao;

/**
 *
 * @author semuso
 */
public class ctrlCliente {
    
    public int inserirCliente(Cliente c){        
        int rc=0;
        String sql = "INSERT INTO cliente VALUES('"+c.getNome()+"','"+c.getTelefone()+"')";
        Connection cn = Conexao.getConnection();
        System.out.println(sql);
        try{
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            rc=0;
            cn.close();
        }catch(SQLException e){
            rc=111;
            e.printStackTrace();
        }       
        return rc;
    }
    
    public int alterarCliente(Cliente c){
        int rc=0;
        String sql = "UPDATE cliente SET nome='"+c.getNome()+"', telefone="+c.getTelefone()+" WHERE codigo="+c.getCod();
        Connection cn = Conexao.getConnection();
        System.out.println(sql);
        try{
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            rc=0;
            cn.close();
        }catch(SQLException e){
            rc=111;
            e.printStackTrace();
        }
        return rc;
    }
    
    public int excluirCliente(Cliente c){
        int rc=0;
        String sql = "DELETE FROM cliente WHERE codigo="+c.getCod();
        Connection cn = Conexao.getConnection();
        System.out.println(sql);
        try{
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            rc=0;
            cn.close();
        }catch(SQLException e){
            rc=111;
            e.printStackTrace();
        }
        return rc;
    }
   
    public int consultar(int cod, Cliente c){        
        int rc=111;
        String sql = "SELECT * FROM cliente WHERE codigo="+cod;
        Connection cn = Conexao.getConnection();
        System.out.println(sql);
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                c.setCod(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setTelefone(rs.getString(3));
                rc=0;
            }
        }catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        return rc;
    }
    
}
