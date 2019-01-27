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
public class Bus extends Vehicle{
    private String busName,fromm,too;
    PreparedStatement pst = null;
    ResultSet rst = null;
    Bus()
    {
        
    }
    Bus(String Model,String Version,String Color,String plateNo,String registrationDate,String expirationDate, String busName,String fromm,String too)
    {
        super(Model,Version,Color,plateNo,registrationDate,expirationDate);
        this.busName=busName;
        this.fromm=fromm;
        this.too=too;
    }
  public String getFromm()
  {
      return fromm;
  }
   public String getToo()
  {
      return too;
  }
    public void addBus()
    {
        
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Insert into BusT (Model,Version,Color,PlateNo,RegistrationDate,ExpirationDate,BusName,Fromm,Too) values ' "
                    + super.getModel()+ "','"
                    + super.getVersion()+ "','"
                    + super.getColor()+ "','"
                    + super.getPlateNo()+ "','"
                    + super.getregistrationDate()+ "','"
                    + super.getExpirationDate()+ "','"
                    + getBusName()+ "','"
                    + getFromm()+"','"
                    +getToo()+"'";
        int flag=conn.InsertUpdateDelete(sql);
                 
           if(flag==1){
               JOptionPane.showMessageDialog(null, "You Have Successfully Added "+getBusName()+" "+super.getModel());
           }
           else{
               JOptionPane.showMessageDialog(null, "Bus Insertion Failed");
           }
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
    }
    public int assignBus()
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
        String sql="SELECT TOP 1 BusId FROM BusT ORDER BY BusId DESC"; 
        rst= conn.GetData(sql);      
          
         while(rst.next()){
           total=rst.getInt("BusId");
           
                }
       
        
//           conn.CloseConnection();
        
        
            conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nNo Buses Available");  
        }
        total=total+1;

        while(i<total)
        { 
            
               try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select Assigned from BusT where BusId = '"+ i + "'"; 
        rst= conn.GetData(sql);      
          
         while(rst.next()){
           ass=rst.getInt("Assigned");
           
                }
       
        
//           conn.CloseConnection();
        
        
            conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nNo Buses Available");  
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
        String sql = "UPDATE BusT SET Assigned = '"+ newAss +"' where BusId = '"+i+ "'";
       
        flag = conn.InsertUpdateDelete(sql);
           if(flag == 1){
               JOptionPane.showMessageDialog(null, "Bus's Availablity Updated  ");
           }
           else{
                JOptionPane.showMessageDialog(null, "Bus's Availablity Couldn't Updated " );
           }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "Update Bus's Availability Query Failed");
        }
        return i;
               
    }
    
    public String getBusName()
    {
        return busName;
    }
    public String getRModel(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select Model from BusT where BusId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("Model");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nNo Model Available For This BusId");  
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
        String sql="Select Version from BusT where BusId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("Version");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nNo Version Available For This BusId");  
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
        String sql="Select Color from BusT where BusId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("Color");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nNo Color Available For This BusId");  
        }
        return ass;
    }
    public String getRFromm(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select Fromm from BusT where BusId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("Fromm");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nNo FromLocation Available For  This Bus");  
        }
        return ass;
    }
    public String getRToo(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select Too from BusT where BusId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("Too");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nNo Too Location Available For This Bus");  
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
        String sql="Select PlateNo from BusT where BusId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("PlateNo");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nNo PlateNo Avail For This Bus");  
        }
        return ass;
    }
     public String getDPlateNo(String  dusername)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select BusPlate from DriverBusT where DriverUsername = '"+ dusername + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("BusPlate");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Bus ID Error");  
        }
        return ass;
    }
      public int getDCarId(String  dusername)
    {
        int ass=0;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select BusID from DriverBusT where DriverUsername = '"+ dusername + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getInt("BusID");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Bus ID Error");  
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
        String sql="Select RegistrationDate from BusT where BusId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("RegistrationDate");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Bus ID Error");  
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
        String sql="Select ExpirationDate from BusT where BusId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("ExpirationDate");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Bus ID Error");  
        }
        return ass;
    }
    public String getBusName(int id)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select BusName from BusT where BusId = '"+ id + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            ass=rst.getString("BusName");
           
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Bus ID Error");  
        }
        return ass;
    }
    public void deleteBus(int id )
     {
     
    
     
     try
        {
        DbConnection con = new DbConnection();
        con.OpenConnection();
        String sql = "DELETE from BusT WHERE BusId = '"+id+"'";
        
         
        int flagg=con.InsertUpdateDelete(sql);
                 
           if(flagg==1){
               JOptionPane.showMessageDialog(null, "Bus Deleted");
           }
           else{
               JOptionPane.showMessageDialog(null, "Please Enter A Valid BusId");
           }
           con.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
     }
     public ResultSet getBusData()
     {
         DbConnection conn = new DbConnection();
        try{
            conn.OpenConnection();
            String select_sql = "Select BusId,Model,PlateNo,BusName from BusT ";
            rst=conn.GetData(select_sql);
            do{
                return rst;
            } while(rst.next());
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "GetBusData Query Failed");
        }
        conn.CloseConnection();
        return null;
         
     }
     
     public ResultSet getAvailableBuses()
     {
         int i=1;
         DbConnection conn = new DbConnection();
        try{
            conn.OpenConnection();
            String select_sql = "Select ID,BusName,Fromm,Too from DriverBusRT  where DriverAvail = '"+ i + "'"; 
            rst=conn.GetData(select_sql);
            do{
                return rst;
            } while(rst.next());
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "GetAvailableBuses Query Failed");
        }
        conn.CloseConnection();
        return null;
         
     }
     public void BookBus(String pusername,String pname,int RideId,String dusername,String dname,String plateNo,int busId,String busName,String fromm,String too)
     {
         int noOfPassengers=0;
         DbConnection conn = new DbConnection();
        int flag;
               try
        {
        
        conn.OpenConnection();
        String sql="Select NoOfPassengers from RideRealtime where iD = '"+ RideId + "'"; 
        rst= conn.GetData(sql);      
          
         while(rst.next()){
           noOfPassengers=rst.getInt("NoOfPassengers");
           
                }

        
        
            conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\nCheck Bus ID Error");  
        }
               noOfPassengers=noOfPassengers+1;
        try{
        conn.OpenConnection();
        String sql = "UPDATE RideRealtime SET NoOfPassengers = '"+noOfPassengers +"' where iD = '"+RideId+ "'";
       
        flag = conn.InsertUpdateDelete(sql);
           if(flag == 1){
               JOptionPane.showMessageDialog(null, "NoOfPassengers Updated  ");
           }
           else{
                JOptionPane.showMessageDialog(null, "Bus's Availablity Couldn't Updatedr " );
           }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "Update Query Failed");
        }
        try
        {
        
        conn.OpenConnection();
        String sql="Insert into PassengerBusRides (Username,DriverName,VehiclePlate,VehicleId,VehicleName,PUsername,PName,Fromm,Too) values ' "
                    + dusername+ "','"
                    + dname+ "','"
                    + plateNo+ "','"
                    + busId+ "','"
                    + busName+ "','"
                    + pusername+ "','"
                    + pname+ "','"
                    + fromm+"','"
                    + too+"'";
        flag=conn.InsertUpdateDelete(sql);
                 
           if(flag==1){
             
           }
           else{
               JOptionPane.showMessageDialog(null, "PassengerBusRides Insertion Failed");
           }
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
     }
     
    
}
