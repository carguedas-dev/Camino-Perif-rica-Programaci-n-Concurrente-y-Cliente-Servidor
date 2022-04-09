
package cliente;

public class ClienteMain {
   
    /*Se instancia un objeto cliente que inicializa el hilo del cliente, 
      y se utiliza un bucle infinito para recibir enviar constamente información
      al servidor.*/
    
    public static void main(String[]args){
        Cliente cliente = new Cliente();
        cliente.start();
        while (true){
            cliente.enviarDatos();
        }
    }
}

