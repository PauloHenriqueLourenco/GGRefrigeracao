/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author semuso
 */
public class Conexao {
    public static String status = "";

  public static Connection getConnection(){
      
      Connection con = null;
      try{        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        //String url = "jdbc:mysql://bdserv/equipamentos?user=aluno&password=aluno"; 
        //String url = "jdbc:mysql://127.0.0.1/equipamentos?user=aluno&password=aluno";
        String url = "jdbc:mysql://127.0.0.1/ggrefrigeracao?user=root&password=";
        con = DriverManager.getConnection(url);
        status = "Conexão Aberta!";
        System.out.println(status);
      }catch(SQLException e){                    
          status = e.getMessage();
          System.out.println(status);
      }catch (ClassNotFoundException e){
          status =e.getMessage();
          System.out.println(status);
      }catch (Exception e){
          status = e.getMessage();
          System.out.println(status);
      }
    return con;
  }
}
