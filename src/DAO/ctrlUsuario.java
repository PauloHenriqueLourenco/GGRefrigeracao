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
import modelo.Usuario;
import modelo.Conexao;

/**
 *
 * @author semuso
 */
public class ctrlUsuario {
    
    public int inserirUsuario(Usuario u){        
        int rc=0;
        String sql = "INSERT INTO usuario VALUES('"+u.getLogin()+"','"+u.getNome()+"',"+u.getTipo();
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
    
    public int alterarUsuario(Usuario u){
        int rc=0;
        String sql = "UPDATE usuario SET nome='"+u.getNome()+"', tipo="+u.getTipo()+" WHERE login="+u.getLogin();
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
    
    public int excluirUsuario(Usuario u){
        int rc=0;
        String sql = "DELETE FROM usuario WHERE login="+u.getLogin();
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
   
    public int consultar(int login, Usuario u){        
        int rc=111;
        String sql = "SELECT login,nome,tipo FROM usuario WHERE login="+login;
        Connection cn = Conexao.getConnection();
        System.out.println(sql);
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                u.setLogin(rs.getString(1));
                u.setNome(rs.getString(2));
                u.setTipo(rs.getInt(3));
                rc=0;
            }
        }catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        return rc;
    }
    
}
