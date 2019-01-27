/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author user
 */
public class Vehicle {
    private String Model,Version,Color,plateNo,registrationDate,expirationDate;
    
    
    Vehicle()
    {
        
    }
    Vehicle(String Model,String Version,String Color,String plateNo,String registrationDate,String expirationDate)
    {
        this.Model=Model;
        this.Version=Version;
        this.Color=Color;
        this.plateNo=plateNo;
        this.registrationDate=registrationDate;
        this.expirationDate=expirationDate;
    }
//    public String getAssigned()
//    {
//        return assigned;
//    }
   public String getModel()
    {
        return Model;
    }
   public String getVersion()
    {
        return Version;
    }
   public String getColor()
    {
        return Color;
    }
   public String getPlateNo()
    {
        return plateNo;
    }
   public String getregistrationDate()
    {
        return registrationDate;
    }
   public String getExpirationDate()
    {
        return expirationDate;
    }
//   public void updateAssign(String assign)
//    {
//        this.assigned=assign;
//    }
    
}
