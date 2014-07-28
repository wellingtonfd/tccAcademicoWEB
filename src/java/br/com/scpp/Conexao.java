package br.com.scpp;


/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */


import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
    
    private static String dbUrl = "jdbc:postgresql://localhost:5432/academico";  
    private static Connection con = null; 
    
  public static Connection conectar(String usuario, String senha)
  {    
   try {  
    Class.forName("org.postgresql.Driver");
    con = DriverManager.getConnection(dbUrl, usuario, senha);
   } catch(Exception erro)
   {
     con = null;
   }
    return con;
  }
  
  public static void encerrarSessao()
  {
     try{
      con.commit();
      con.close();
      con = null;
     } catch(Exception erro)
     {
         System.err.println("Houve um erro -> "+erro.getMessage());
     }finally
     {
         con = null;
     }
      
  }    
    
}
