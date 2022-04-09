
package Hilos;

import java.awt.Color;
import java.awt.Font;
import static java.lang.Thread.sleep;
import ServidorStart.GUI;

public class RelojDomingo extends Thread {
    
    String time, dayName, tempHours, tempMinutes, tempSeconds;
    int days= 6, hours=4, minutes=29, seconds=0; 
    
    public void run(){
        setTime();
    }
    

    public void setTime(){
        while(true){
            //Clock            
            minutes++;
                if(minutes == 60){
                    minutes = 0;
                    hours++;
                    if(hours == 24){
                        hours = 0;
                        days++;
                        if (days == 7){
                            days = 0;
                        }
                    }
                }
            //Day name
            switch (days) {
                case 0:
                    dayName = "Lunes ";
                    break;
                case 1:
                    dayName = "Martes ";
                    break;
                case 2:
                    dayName = "Miércoles ";
                    break;
                case 3:
                    dayName = "Jueves ";
                    break;
                case 4:
                    dayName = "Viernes ";
                    break;
                case 5:
                    dayName = "Sábado ";
                    break;
                case 6:
                    dayName = "Domingo ";
                    break;
                default:
                    break;
            }          
            //Time format
            if (hours < 10){
                tempHours = "0";
                tempHours = tempHours + hours + ":";
            } else {
                tempHours = Integer.toString(hours) + ":";
            }
            
            if (minutes < 10){
                tempMinutes = "0";
                tempMinutes = tempMinutes + minutes;
            } else {
                tempMinutes = Integer.toString(minutes);
            }            

            //Display
            time = tempHours+tempMinutes;
            String forGUI = dayName +"| "+time;
            GUI.reloj.setFont(new Font("Verdana", Font.BOLD, 30));
            if (hours>=5){
                GUI.reloj.setForeground(Color.green);
                GUI.reloj.setText(forGUI);
            } else {
                GUI.reloj.setForeground(Color.red);
                GUI.reloj.setText(forGUI);
            }
            if (forGUI.equals("Domingo | 19:00")){
                GUI.reloj.setForeground(Color.red);
                GUI.reloj.setText(forGUI);
                break;
            }
            if (forGUI.equals("Domingo | 05:00")){
                GUI.busThread1.start();
                GUI.busThread2.start();
                GUI.busThread3.start();
                GUI.busThread4.start();
                GUI.busThread5.start();
                GUI.busThread6.start();
                GUI.busThread7.start();
                GUI.busThread8.start();
                GUI.busThread9.start();
                GUI.busThread10.start();
            }
            
            
            //Refresh rate
            try {
                sleep(263); //Original: 192, //Ejecución rápida: (long) 74.5
            } catch (InterruptedException e){
                //TODO Auto-generated catch block
                e.printStackTrace();
            } 
        }
    }
   
}
