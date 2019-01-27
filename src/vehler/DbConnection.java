/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehler;

/**
 *
 * @author user
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muaaz
 */

public class DbConnection {
     
    private static Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    public Connection OpenConnection (){
        
            String dataSourceName = "DataBase/try2.accdb";
            String dir = System.getProperty("user.dir");
            String url = "jdbc:ucanaccess://" + dir + "/" + dataSourceName;
     
     connection = null;
      try{
          connection =   DriverManager.getConnection(url);
      }catch(Exception e){
          System.out.println(e);
      }
      return connection;
    }
    
    public  ResultSet GetData(String Sql)// this method is used for Select Statement
    {
        try {
            pst = connection.prepareStatement(Sql);
             rst = pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "\nDbConnection GetData Error");
        }
        return rst;
    }
    
    public int InsertUpdateDelete(String Sql)// this method is used for InsertUpdateDelete Statement
    {
        int flag=0;
        try {
            pst = connection.prepareStatement(Sql);
            flag = pst.executeUpdate();
        } catch (SQLException ex) {
            
        }
         return flag ;
    }
    
    public void CloseConnection(){
        
    if (rst != null) {
        try {
            rst.close();
        } catch (SQLException e) { /* ignored */}
    }
    if (pst != null) {
        try {
            pst.close();
        } catch (SQLException e) { /* ignored */}
    }
    if (connection != null) {
        try {
            connection.close();
        } catch (SQLException e) { /* ignored */}
    }

    }
}

