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
public interface Driver {
   
    public abstract boolean ConfirmCurrentRide(String username);
    public abstract boolean verifySecurityQ(String username,String securityQuestion);
    public abstract void addDriver();
    public abstract boolean chkDriverPass(String id, String pass);
    public abstract String getRDriverName(String username);
    public abstract int assignDriver(String pusername,String pname,String currentLocation,String finalLocation);
    
}
