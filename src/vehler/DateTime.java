/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehler;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author user
 */
public class DateTime {
    public String getTime()
    {
      Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("HH:mm");
        String date=df.format(d);
        return date;
    }
    public String getDate()
    {
      Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        String date=df.format(d);
        return date;
    }
}
