
package ServidorStart;

import java.io.IOException;

public class ServidorMain {
    
    /*Se instancia el objeto GUI que configura el servidor, y se utiliza una
      ciclo infinito para que el servidor envíe datos continuamente.*/
    
    public static void main(String[]args) throws IOException{
        GUI gui = new GUI();
        gui.setResizable(false);
        gui.run();
        while (true){
            gui.enviarDatos("Servidor Listo");
        }
    }
}
