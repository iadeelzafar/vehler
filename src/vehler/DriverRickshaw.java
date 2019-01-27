
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
public class DriverRickshaw implements Driver {
    DbConnection conn = new DbConnection();
    PreparedStatement pst = null;
    ResultSet rst = null;
    
    private String name;
    private String fatherName;
    private String age;
    private String gender;
    private String securityQ;
    private String username;
    private String password,type,cnic,contactNo,dob;
    DriverRickshaw()
    {
        
    }
    DriverRickshaw(String name,String fatherName,String age,String gender, String securityQ, String username,String password,String type,String cnic,String contactNo,String dob)
    {
        this.name=name;
        this.fatherName=fatherName;
        this.age=age;
        this.gender=gender;
        this.securityQ=securityQ;
        this.username=username;
        this.password=password;
        this.type=type;
          this.cnic=cnic;
      this.contactNo=contactNo;
      this.dob=dob;
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
    public boolean ConfirmCurrentRide(String username)
    {
    
   

        String matching=null;
//        "SELECT TOP 1 ID FROM DriverCarRT ORDER BY ID DESC"; 
         boolean flag = false;
//        String sqlBill = "Select MAX(BillNumber) AS BillNumber FROM BillT where PID = '" + PID + "'"  ;
        try{
            conn.OpenConnection();
            String sql="Select MAX(RideStatus) AS RideStatus FROM DriverRickshawRT where Username = '" + username + "'";
            
            rst= conn.GetData(sql);
            while(rst.next())
            {
           matching=rst.getString("RideStatus");
           
                }
       
        
//           conn.CloseConnection();
        
        
            conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCouldn't Select Last DriverCarId");  
        }
        String j=matching;
        if(matching.equals("Running")||matching.equals("Built")||matching.equals("AtPickUp"))
        {
            flag=true;
         
            
        }
 
        return flag;
        
    }
    public String getName()
    {
        return name;
    }
    public String getfName()
    {
        return fatherName;
    }
    public String getAge()
    {
        return age;
    }
    public String getGender()
    {
        return gender;
    }
    public String getSecurityQ()
    {
        return securityQ;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public boolean verifySecurityQ(String username,String securityQuestion)
            
    {
        boolean flag = false;
        
        try{
            conn.OpenConnection();
            String sql="Select ID,SecurityQuestion from Driver where ID = '" + username + "' and SecurityQuestion = '" + securityQuestion + "'";
            
            rst= conn.GetData(sql);
            if(rst.next())
            {
                flag=true;
            }
            
//             String answer=rst.getString("SecurityQuestion");
//            
//            if(answer==securityQuestion)
//            {
//                flag=true;
//            }
            else
            flag=false;
            conn.CloseConnection();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e+"\n Error");
        }
       return flag;
    }
        
     public String getType()
     {
         return type;
     }
    
    
    public void addDriver()
    {
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Insert into Driver (ID, Password, Name,FatherName,Age, Gender, SecurityQuestion, Type,CNIC,ContactNo,DOB) values '"
                + getUsername()+ "','"
                    + getPassword()+ "','"
                    + getName()+ "','"
                    + getfName()+ "','"
                    + getAge()+ "','"
                    + getGender()+ "','"
                    + getSecurityQ()+ "','"
                    + getType()+ "','"
                    +getCnic()+ "','"
                    +getContactno()+ "','"
                  + getDob()+"'";
        
       
        int flag=conn.InsertUpdateDelete(sql);
                 
           if(flag==1){
               JOptionPane.showMessageDialog(null, "You Are Now Registered As Rickshaw Driver");
           }
           else{
               JOptionPane.showMessageDialog(null, "Couldn't Add Rickshaw Driver");
           }
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
    }
    public boolean chkDriverPass(String id, String pass){
        boolean flag = false;
        
        try{
            conn.OpenConnection();
            String sql = "Select ID,Password from Driver where ID = '" + id + "' and Password = '" + pass + "'";
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
    public void insertDriverRickshawData(String driverUsername,String driverName, String type,String rickshawPlate, int RickshawId, String RickshawName)
    {
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Insert into DriverRickshawT (DriverUsername, DriverName,VehicleType,RickshawPlate, RickshawID, RickshawName) values '"
                    + driverUsername+ "','"
                    + driverName+ "','"
                      + type + "','"
                + rickshawPlate+ "','"
                    + RickshawId+ "','"
                    + RickshawName+ "'";
        
         
        int flag=conn.InsertUpdateDelete(sql);
                 
           if(flag==1){
               
           }
           else{
               JOptionPane.showMessageDialog(null, "0 Insertion Failed");
           }
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
    }
    public String getRDriverName(String username)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select DriverName from DriverRickshawT where DriverUsername = '"+ username + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("DriverName");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\n getRDriverName  Error");  
        }
        return ass;
    }
    public String getRRDriverName(int Id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select DriverName from DriverRickshawRT where ID = '"+ Id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("DriverName");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\n getRRDriverName  Error");  
        }
        return ass;
    }
    public int getRRickshawId(String username)
    {
        int ass=0;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select RickshawID from DriverRickshawT where DriverUsername = '"+ username + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getInt("RickshawID");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Driver Error");  
        }
        return ass;
    }
     public String getRRickshawPlate(String username)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select RickshawPlate from DriverRickshawT where DriverUsername = '"+ username + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("RickshawPlate");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Driver Error");  
        }
        return ass;
    }
    public String getRRickshawName(String username)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select RickshawName from DriverRickshawT where DriverUsername = '"+ username + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("RickshawName");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\n getRRickshawName Error");  
        }
        return ass;
    }
     public String getRRRickshawName(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select RickshawName from DriverRickshawRT where ID = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("RickshawName");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\n getRRRickshawName Error");  
        }
        return ass;
    }
    public void insertAvailablity(String driverUsername,String driverName,String plateNo, int RickshawId, String RickshawName,int avail)
    {
        String contact=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Insert into DriverRickshawRT (Username, DriverName,RickshawPlate, RickshawId, RickshawName,DriverAvail) values '"
                    + driverUsername+ "','"
                    + driverName+ "','"
                + plateNo+ "','"
                    + RickshawId+ "','"
                     + RickshawName+ "','"
                    + avail+ "'";
        
         
        int flag=conn.InsertUpdateDelete(sql);
                 
           if(flag==1){
               
           }
           else{
               JOptionPane.showMessageDialog(null, "12 Insertion Failed");
           }
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
         int no=0;
           try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="SELECT ID FROM DriverRickshawRT where Username = '"+ driverUsername + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
           no=rst.getInt("ID");
           
                }
       
        
//           conn.CloseConnection();
        
        
            conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCouldn't Select Last DriverCarId");  
        }
            try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select ContactNo from Driver where ID = '"+ driverUsername + "'"; 
        rst= conn.GetData(sql);      
          
         while(rst.next()){
           contact=rst.getString("ContactNo");
           
                }
       
        
//           conn.CloseConnection();
        
        
            conn.CloseConnection();
          }
               catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\n getDriverContact  Error");  
        }
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Insert into RideRealtime (ID,Username, DriverName,VehiclePlate, VehicleId, VehicleName,DriverContactNo) values '"
                + no+ "','"
                    + driverUsername+ "','"
                    + driverName+ "','"
                + plateNo+ "','"
                    + RickshawId+ "','"
                     + RickshawName+  "','"
        + contact+ "'";
                   
        
         
        int flag=conn.InsertUpdateDelete(sql);
                 
           if(flag==1){
               
           }
           else{
               JOptionPane.showMessageDialog(null, "11 Insertion Failed");
           }
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
    }
     public int assignDriver(String pusername,String pname,String currentLocation,String finalLocation)
    {
         
        int newAss=0;
        int ass=5;
        int i=1;
        
 int total=0;
               try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="SELECT TOP 1 ID FROM DriverRickshawRT ORDER BY ID DESC"; 
        rst= conn.GetData(sql);      
          
         while(rst.next()){
           total=rst.getInt("ID");
           
                }
       
        
//           conn.CloseConnection();
        
        
            conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCouldn't Select Last DriverRickshawId");  
        }
        total=total+1;
        while(i<total)
        { 
            
               try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select DriverAvail from DriverRickshawRT where ID = '"+ i + "'"; 
        rst= conn.GetData(sql);      
          
         while(rst.next()){
           ass=rst.getInt("DriverAvail");
           
                }
       
        
//           conn.CloseConnection();
        
        
            conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\n 1");  
        }
    
               
        
               
               
               if(ass==1)
               {
                   break;
               }
           
               i++;
        }
        DbConnection conn = new DbConnection();
        int flag;
        try{
        conn.OpenConnection();
        String sql = "UPDATE DriverRickshawRT SET DriverAvail = '"+ newAss +"' where ID = '"+i+ "'";
       
        flag = conn.InsertUpdateDelete(sql);
           if(flag == 1){
               JOptionPane.showMessageDialog(null, "YOU HAVE BEEN ASSIGNED DRIVER. HIS DRIVER ID IS :  "+i);
           }
           else{
                JOptionPane.showMessageDialog(null, " 2 : Sorry, No Rickshaw Available " );
           }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "3 : UpdateBill Query Failed");
        }
         try
        {
        DbConnection comm = new DbConnection();
        conn.OpenConnection();
        String sql = "UPDATE DriverRickshawRT SET PUsername = '"+ pusername +"',Fromm ='"+currentLocation+"',Too='"+finalLocation+"' where ID = '"+i+ "'";
        
        
         
        int flagg=comm.InsertUpdateDelete(sql);
                 
           if(flagg==1){
              
           }
           else{
               JOptionPane.showMessageDialog(null, "4: Insertion Failed");
           }
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
         String contact=null;
          try
        {
        DbConnection conn2 = new DbConnection();
        conn2.OpenConnection();
        String sql="Select ContactNo from PassengerT where PID = '"+ pusername + "'"; 
        rst= conn2.GetData(sql);      
          
         while(rst.next()){
           contact=rst.getString("ContactNo");
           
                }
       
        
//           conn.CloseConnection();
        
        
            conn2.CloseConnection();
          }
               catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\n getPassengerContact  Error");  
        }
         try
        {
        DbConnection comm = new DbConnection();
        conn.OpenConnection();
        String sql = "UPDATE RideRealtime SET PUsername = '"+ pusername +"',Fromm ='"+currentLocation+"',Too='"+finalLocation+"',PassengerContactNo='"+contact+"' where ID = '"+i+ "'";
         int flagg=comm.InsertUpdateDelete(sql);
                 
           if(flagg==1){
              
           }
           else{
               
           }
         
         
          
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
         try
        {
        DbConnection comm = new DbConnection();
        conn.OpenConnection();
        String sql = "UPDATE DriverRickshawRT SET PName = '"+ pname +"' where ID = '"+i+ "'";
        
         
        int flagg=comm.InsertUpdateDelete(sql);
                 
           if(flagg==1){
              
           }
           else{
               JOptionPane.showMessageDialog(null, "5: Insertion Failed");
           }
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
          try
        {
        DbConnection comm = new DbConnection();
        conn.OpenConnection();
        String sql = "UPDATE RideRealtime SET PName = '"+ pname +"' where ID = '"+i+ "'";
         int flagg=comm.InsertUpdateDelete(sql);
                 
           if(flagg==1){
               
           }
           else{
               
           }
      
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
        return i;
    }
    public String getRType(String username)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select VehicleType from DriverRickshawT where DriverUsername = '"+ username + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("VehicleType");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\n getVehicleType  Error");  
        }
        return ass;
        
    }
    
}
