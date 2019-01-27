/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehler;

/**
 *
 * @author user
 */import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Passenger {

    /**
     * @param args the command line arguments
     */
    DbConnection conn = new DbConnection();
    PreparedStatement pst = null;
    ResultSet rst = null;
    
    private String name,fName,age,gender,sec,user,pass,cnic,contactNo,dob;
    Passenger()
    {
        
    }
    Passenger(String name,String fName,String age, String gender,String sec,String user,String pass,String cnic,String contactNo,String dob)
    {
        this.name=name;
        this.fName=fName;
        this.age=age;
        this.gender=gender;
        this.sec=sec;
        this.user=user;
        this.pass=pass;
        this.cnic=cnic;
        this.contactNo=contactNo;
        this.dob=dob;
        
    }
    public boolean verifySecurityQ(String username,String securityQuestion)
            
    {
        boolean flag = false;
        
        try{
            conn.OpenConnection();
            String sql="Select PID,PSec from PassengerT where PID = '" + username + "' and PSec = '" + securityQuestion + "'";
            
            rst= conn.GetData(sql);
            if(rst.next())
            {
                flag=true;
            }
            

            else
            flag=false;
            conn.CloseConnection();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e+"\n Verify SecurityQ Passenger Error");
        }
       return flag;
    }
     public void changePassword(String username,String newPassword)
    {
        int flag;
        
         try{
        conn.OpenConnection();
        String sql = "UPDATE PassengerT SET PPass = '"+ newPassword +"' where PID = '"+username+ "'";
       
        flag = conn.InsertUpdateDelete(sql);
           if(flag == 1){
               JOptionPane.showMessageDialog(null, "YOUR PASSWORD HAS BEEN CHANGED  ");
           }
           else{
                JOptionPane.showMessageDialog(null, "YOUR PASSWORD COULDn't BE CHANGED" );
           }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "UpdatePassword Query Failed");
        }
        
    }
    public boolean chkPassPass(String id, String pass){
        boolean flag = false;
        
        try{
            conn.OpenConnection();
            String sql = "Select PID,PPass from PassengerT where PID = '" + id + "' and PPass = '" + pass + "'";
            rst= conn.GetData(sql);
            if(rst.next()){
                flag= true;
                              
            }
            else 
                flag=  false;
            conn.CloseConnection();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e+"\nCheckLogin ChkAdminPass Error");
        }
       return flag; 
    }
     public void addPassPass()
    {
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Insert into PassengerT (PID, PPass, PName,PFName,PAge, PGender, PSec,CNIC,ContactNo,DOB) values '"
                + getUser()+ "','"
                    + getPass()+ "','"
                    + getPname()+ "','"
                    + getFname()+ "','"
                    + getPAge()+ "','"
                    + getPGender()+ "','"
                    + getPSec()+ "','"
                    + getCnic()+ "','"
                    + getContactno()+ "','"
                    + getDob()+ "'";
        
       
        int flag=conn.InsertUpdateDelete(sql);
                 
           if(flag==1){
               JOptionPane.showMessageDialog(null, "You Are Now Successfully Registered As Passenger");
           }
           else{
               JOptionPane.showMessageDialog(null, "Insertion Failed");
           }
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
    }
    public String getCnic()
    {
        return cnic;
    }
    public String getContactno()
    {
        return contactNo;
    }
    public String getDob()
    {
        return dob;
    }
     public String getUser()
     {
         return user;
     }
     public String getPass()
     {
         return pass;
     }
    public String getPname()
    {
        return name;
    }
    public String getFname()
    {
        return fName;
    }
    public String getPAge()
    {
        return age;
    }
    public String getPGender()
    {
        return gender;
    }
    public String getPSec()
    {
        return sec;
    }
    public String getRPassengerName(String username)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select PName from PassengerT where PID = '"+ username + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("PName");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\n getRPassengerName  Error");  
        }
        return ass;
    }
  
   public ResultSet PassengerRide(String pu)
    {
        ResultSet rst1=null;
    
        
        try{
            conn.OpenConnection();
            String sql = "Select Datee,Username,DriverName,DriverContactNo,VehiclePlate,VehicleName,Fromm,Too,StartTime,EndTime,RideStatus,BillStatus,Bill from RideRealtime where PUsername = '"+pu+"'";
            rst1= conn.GetData(sql);
                   do{
                return rst1;
            } 
            while(rst1.next());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e+"\nSelect DriverCarRT Error");
        }
          
        conn.CloseConnection();
        return null;
    }
   public ResultSet PassengerBusRide(String pu)
    {
        ResultSet rst1=null;
    
        
        try{
            conn.OpenConnection();
            String sql = "Select Username,DriverName,VehiclePlate,VehicleName,Fromm,Too from PassengerBusRides where PUsername = '"+pu+"'";
            rst1= conn.GetData(sql);
                   do{
                return rst1;
            } 
            while(rst1.next());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e+"\nSelect DriverCarRT Error");
        }
          
        conn.CloseConnection();
        return null;
    }
}
