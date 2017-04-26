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
import modelo.Ar;
import modelo.Conexao;

/**
 *
 * @author semuso
 */
public class ctrlAr {
        
    public int inserirAr(Ar a){        
        int rc=0;
        String sql = "INSERT INTO ar VALUES('"+a.getFabricante()+"',"+a.getBtu()+")";
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
    
    public int alterarAr(Ar a){
        int rc=0;
        String sql = "UPDATE ar SET fabricante='"+a.getFabricante()+"', btu="+a.getBtu()+" WHERE codigo="+a.getCod();
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
    
    public int excluirAr(Ar a){
        int rc=0;
        String sql = "DELETE FROM ar WHERE codigo="+a.getCod();
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
   
    public int consultar(int cod, Ar a){        
        int rc=111;
        String sql = "SELECT * FROM ar WHERE codigo="+cod;
        Connection cn = Conexao.getConnection();
        System.out.println(sql);
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                a.setCod(rs.getInt(1));
                a.setFabricante(rs.getString(2));
                a.setBtu(rs.getInt(3));
                rc=0;
            }
        }catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        return rc;
    }
    
}
