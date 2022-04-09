
package Hilos;

import static Hilos.Bus1.sending;
import static Hilos.Bus2.sendDet;
import static Hilos.Bus5.posX;
import static Hilos.Bus5.posY;
import static Hilos.Bus5.sending;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Scanner;
import ServidorStart.GUI;

public class Bus7 extends Thread{
    Scanner entry;
    String[] array;
    public static int posX; 
    public static int posY;
    public static boolean sending = false;
    public static boolean sendDet = false;
    public boolean skip = false;
    String stop;
    
    public Bus7() {
        
    }
    
    public void run(){
        int counter = 0;
        while (counter<3){
            try {
            File file = new File("Buses/Coordenadas/Bus7Fluid.txt");
            entry = new Scanner(file);
            
            if (counter == 0){
                stop = "2104";
            } else if (counter == 1){
                stop = "1660";
            } else {
                stop = "3457";
            }
            
            
            while (entry.hasNext()){
                String tempstr = entry.nextLine(); //0%1630%197
                array = tempstr.split("%",5); //[0, 1630, 197]
                if (array[0].equals(stop)){
                    skip = true;
                }
                posX = Integer.parseInt(array[1]);
                posY = Integer.parseInt(array[2]);
                if (skip==true){
                    if (sendDet){
                        sendDetenido();
                    }
                    if (Bus6.array[0].equals(stop)){
                        System.out.println("Concurrencia resuelta -- Bus 7 retornado a su lugar.");
                        skip = false;
                        sendDet = false;
                        GUI.bus7.setLocation(posX-15, posY-15);
                    }
                    sleep(16); //Original: 16 //Rápida: 6
                } else {
                    GUI.bus7.setLocation(posX-15, posY-15);
                    sleep(16);
                    if (sending==true){
                        enviarCoordenadasBus7();
                    }
                }
            }
            counter++;
            
        } catch (Exception e){}
        }
        
        sending = false;
        
    }
    
    public void sendDetenido() throws IOException{
        GUI.escrituraDatos.writeUTF("Bus 7 - Detenido.");
        GUI.escrituraDatos.flush();
    }
    
    public void enviarCoordenadasBus7() throws IOException{
        
        String parada = "Próxima Parada - Bus 7: ";
        if ((Integer.parseInt(array[0])>0 && Integer.parseInt(array[0])<196)||(Integer.parseInt(array[0])>4250 && Integer.parseInt(array[0])<=4490)){
            parada += "Rotonda Betania";
        } else if (Integer.parseInt(array[0])>196 && Integer.parseInt(array[0])<484){
            parada += "Acueductos Guada";
        } else if (Integer.parseInt(array[0])>484 && Integer.parseInt(array[0])<625){
            parada += "Liceo Joaquín Jiménez";
        } else if (Integer.parseInt(array[0])>625 && Integer.parseInt(array[0])<1027){
            parada += "Hotel Caribbean";
        } else if (Integer.parseInt(array[0])>1027 && Integer.parseInt(array[0])<1563){
            parada += "Escuela Juan Rafael";
        } else if (Integer.parseInt(array[0])>1563 && Integer.parseInt(array[0])<1660){
            parada += "Colegio María Auxiliadora"; 
        } else if (Integer.parseInt(array[0])>1660 && Integer.parseInt(array[0])<1775){
            parada += "Parqueo Yamuni";
        } else if (Integer.parseInt(array[0])>1775 && Integer.parseInt(array[0])<2104){
            parada += "Plásticos Tosso";
        } else if (Integer.parseInt(array[0])>2104 && Integer.parseInt(array[0])<2344){
            parada += "Súper Lian";
        } else if (Integer.parseInt(array[0])>2344 && Integer.parseInt(array[0])<2569){
            parada += "Ciudad Deportiva"; 
        } else if (Integer.parseInt(array[0])>2569 && Integer.parseInt(array[0])<2779){
            parada += "Terminal Hatillo";
        } else if (Integer.parseInt(array[0])>2779 && Integer.parseInt(array[0])<2860){
            parada += "Rest. La Fortuna";
        } else if (Integer.parseInt(array[0])>2860 && Integer.parseInt(array[0])<3108){
            parada += "Plaza América";
        } else if (Integer.parseInt(array[0])>3108 && Integer.parseInt(array[0])<3385){
            parada += "Taller Gernón";
        } else if (Integer.parseInt(array[0])>3385 && Integer.parseInt(array[0])<3457){
            parada += "Cevichería Costa Azul";
        } else if (Integer.parseInt(array[0])>3457 && Integer.parseInt(array[0])<3557){
            parada += "Parque Monte Azul";
        } else if (Integer.parseInt(array[0])>3557 && Integer.parseInt(array[0])<3729){
            parada += "Abastecedor Sauces";
        } else if (Integer.parseInt(array[0])>3729 && Integer.parseInt(array[0])<3971){
            parada += "Parque San Francisco";
        } else if (Integer.parseInt(array[0])>3971 && Integer.parseInt(array[0])<4250){
            parada += "Colegio Salesiano";
        }
        GUI.escrituraDatos.writeUTF(parada);
        GUI.escrituraDatos.flush();
    }

}