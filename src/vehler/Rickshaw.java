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
public class Rickshaw extends Vehicle{
    private String RickshawName;
    private int totalRickshaws;
    PreparedStatement pst = null;
    ResultSet rst = null;
    Rickshaw()
    {
        
    }
    Rickshaw(String Model,String Version,String Color,String plateNo,String registrationDate,String expirationDate, String RickshawName)
    {
        super(Model,Version,Color,plateNo,registrationDate,expirationDate);
        this.RickshawName=RickshawName;
        
    }
    Rickshaw(int totalRickshaws)
    {
        this.totalRickshaws=totalRickshaws;
    }
    public void addRickshaw()
    {
        
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Insert into RickshawT (Model,Version,Color,PlateNo,RegistrationDate,ExpirationDate,RickshawName) values ' "
                    + super.getModel()+ "','"
                    + super.getVersion()+ "','"
                    + super.getColor()+ "','"
                    + super.getPlateNo()+ "','"
                    + super.getregistrationDate()+ "','"
                    + super.getExpirationDate()+ "','"
                    + getRickshawName()+ "'";
        int flag=conn.InsertUpdateDelete(sql);
                 
           if(flag==1){
               JOptionPane.showMessageDialog(null, "You Have Successfully Added "+getRickshawName()+" "+super.getModel());
           }
           else{
               JOptionPane.showMessageDialog(null, "Rickshaw Insertion Failed");
           }
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
    }
    public int assignRickshaw()
    {
        
        
        int newAss=1;
        int ass=5;
        int total=0;
        int i=1;
        
//        for( i=1;i<2;i++)
        
                        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="SELECT TOP 1 RickshawId FROM RickshawT ORDER BY RickshawId DESC"; 
        rst= conn.GetData(sql);      
          
         while(rst.next()){
           total=rst.getInt("RickshawId");
           
                }
       
        
//           conn.CloseConnection();
        
        
            conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCouldn't Select Last RickshawId");  
        }
        total=total+1;

        while(i<total)
        { 
            
               try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select Assigned from RickshawT where RickshawId = '"+ i + "'"; 
        rst= conn.GetData(sql);      
          
         while(rst.next()){
           ass=rst.getInt("Assigned");
           
                }
       
        
//           conn.CloseConnection();
        
        
            conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Rickshaw ID Error");  
        }
    
               
        
               
               
               if(ass==0)
               {
                   break;
               }
           
               i++;
        }
        DbConnection conn = new DbConnection();
        int flag;
        try{
        conn.OpenConnection();
        String sql = "UPDATE RickshawT SET Assigned = '"+ newAss +"' where RickshawId = '"+i+ "'";
       
        flag = conn.InsertUpdateDelete(sql);
           if(flag == 1){
               JOptionPane.showMessageDialog(null, "Rickshaw's Availablity Updated  ");
           }
           else{
                JOptionPane.showMessageDialog(null, "Rickshaw's Availablity Couldn't Updatedr " );
           }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "Update Query Failed");
        }
        return i;
               
    }
    
    public String getRickshawName()
    {
        return RickshawName;
    }
    public String getRModel(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select Model from RickshawT where RickshawId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("Model");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Rickshaw ID Error");  
        }
        return ass;
    }
    public String getRVersion(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select Version from RickshawT where RickshawId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("Version");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Rickshaw ID Error");  
        }
        return ass;
    }
    public String getRColor(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select Color from RickshawT where RickshawId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("Color");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Rickshaw ID Error");  
        }
        return ass;
    }
    public String getRPlateNo(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select PlateNo from RickshawT where RickshawId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("PlateNo");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Rickshaw ID Error");  
        }
        return ass;
    }
    public String getRRDate(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select RegistrationDate from RickshawT where RickshawId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("RegistrationDate");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Rickshaw ID Error");  
        }
        return ass;
    }
    public String getEDate(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select ExpirationDate from RickshawT where RickshawId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("ExpirationDate");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Rickshaw ID Error");  
        }
        return ass;
    }
    public String getRickshawName(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select RickshawName from RickshawT where RickshawId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("RickshawName");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Rickshaw ID Error");  
        }
        return ass;
    }
    public void deleteRickshaw(int id )
     {
     
    
     
     try
        {
        DbConnection con = new DbConnection();
        con.OpenConnection();
        String sql = "DELETE from RickshawT WHERE RickshawId = '"+id+"'";
        
         
        int flagg=con.InsertUpdateDelete(sql);
                 
           if(flagg==1){
               JOptionPane.showMessageDialog(null, "Rickshaw Deleted");
           }
           else{
               JOptionPane.showMessageDialog(null, "Please Enter A Valid RickshawId");
           }
           con.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
     }
     public ResultSet getRickshawData()
     {
         DbConnection conn = new DbConnection();
        try{
            conn.OpenConnection();
            String select_sql = "Select RickshawId,Model,PlateNo,RickshawName from RickshawT ";
            rst=conn.GetData(select_sql);
            do{
                return rst;
            } while(rst.next());
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "GetRickshawData Query Failed");
        }
        conn.CloseConnection();
        return null;
         
     }
}
