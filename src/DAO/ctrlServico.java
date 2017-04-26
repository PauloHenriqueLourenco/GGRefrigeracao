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
import modelo.Servico;
import modelo.Conexao;

/**
 *
 * @author semuso
 */
public class ctrlServico {
    
    public int inserirServico(Servico s){        
        int rc=0;
        String sql = "INSERT INTO servico VALUES('"+s.getEndereco()+"','"+s.getEndereco2()+"',"+s.getPreco()+")";
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
    
    public int alterarServico(Servico s){
        int rc=0;
        String sql = "UPDATE servico SET endereco='"+s.getEndereco()+"', endereco2='"+s.getEndereco2()+"' preco="+s.getPreco()+" WHERE codigo="+s.getCod();
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
    
    public int excluirServico(Servico s){
        int rc=0;
        String sql = "DELETE FROM servico WHERE codigo="+s.getCod();
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
   
    public int consultar(int cod, Servico s){        
        int rc=111;
        String sql = "SELECT * FROM servico WHERE codigo="+cod;
        Connection cn = Conexao.getConnection();
        System.out.println(sql);
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                s.setCod(rs.getInt(1));
                s.setEndereco(rs.getString(2));
                s.setEndereco2(rs.getString(3));
                s.setPreco(rs.getDouble(4));
                rc=0;
            }
        }catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        return rc;
    }
    
}
