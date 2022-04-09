
package cliente;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Cliente extends Thread {

    public static JLabel clientLabel;
    private boolean continuar = true;
    private Socket cliente; 
    private ObjectInputStream lecturaDatos; 
    private ObjectOutputStream escrituraDatos; 

    int counter;

    public Cliente () {
       
        /*El constructor inicializa el socket para la conexión de cliente servidor, e inicializa 
          el objeto JFrame para desplegar el GUI. */
        
        try {
            cliente = new Socket(InetAddress.getByName("127.0.0.1"), 7000);
            inicializarFlujosDatos();
            JFrame jf = new JFrame();
            jf.setLayout(null);
            jf.setBounds(2240,20,1150,300);
            jf.setResizable(false);
            jf.setVisible(true);
            
            jf.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    try {
                        escrituraDatos.writeUTF("Closing");
                        escrituraDatos.flush();
                    } catch (IOException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    System.exit(0);
                }
            });
            
            clientLabel = new JLabel("Seleccionar bus en consola.");
            clientLabel.setBounds(80, 50, 1500,100);
            clientLabel.setFont(new Font("Verdana", 1, 36));
            
            clientLabel.setAlignmentX(SwingConstants.CENTER);
            clientLabel.setAlignmentY(SwingConstants.CENTER);
            jf.add(clientLabel);
            
            
            
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
    
    /*Se inicializan los flujos de datos de entrada y salida para el cliente.*/
    private void inicializarFlujosDatos(){
        try {
            escrituraDatos = new ObjectOutputStream(cliente.getOutputStream());
            lecturaDatos = new ObjectInputStream(cliente.getInputStream());
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
    
    /*Método se enfoca en enviar datos constantemente al servidor.*/
    public void enviarDatos(){
            try {
            System.out.println("Seleccione el número del bus al que desea rastrear: ");
            System.out.println("1 - Bus 1");
            System.out.println("2 - Bus 2");
            System.out.println("3 - Bus 3");
            System.out.println("4 - Bus 4");
            System.out.println("5 - Bus 5");
            System.out.println("6 - Bus 6");
            System.out.println("7 - Bus 7");
            System.out.println("8 - Bus 8");
            System.out.println("9 - Bus 9");
            System.out.println("10 - Bus 10");
            System.out.println("En caso de tener bus activo: -1 para detener.");

            Scanner leer = new Scanner(System.in);
            
            String mensaje = leer.nextLine();
            escrituraDatos.writeUTF(mensaje);
            escrituraDatos.flush(); 
            } catch (IOException ioex){
                ioex.printStackTrace();
            }
        
    }
    
    /*Método se enfoca en recibir activamente datos desde del servidor.*/
    public void recibirDatos(){

            try {
            
            String info = lecturaDatos.readUTF(); 
            while (info.startsWith("Próxima Parada")) {  
                clientLabel.setText(info);
                return;
            }
            
            while (info.startsWith("Bus")){
                clientLabel.setText(info);
                return;
            }
            
            if (info.equals("Detenido")){
                clientLabel.setText("Seleccionar Bus.");
            }
            
            if (info.startsWith("El servidor")){
                clientLabel.setText(info);
            }
            
            if (info.startsWith("Ejecución")){
                clientLabel.setText(info);
            }
                  
            } catch (IOException ioex) {
                ioex.printStackTrace();
            }
        
        
    }
    
    /*El método run corre cuando se le llama por medio de .start(), ya que es un hilo que extiende la
      clase Thread*/
    public void run(){
        while (continuar){
            recibirDatos();
        }
    }
}
