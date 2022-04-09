
package ServidorStart;

import Hilos.Bus1;
import Hilos.Bus10;
import Hilos.Bus2;
import Hilos.Bus3;
import Hilos.Bus4;
import Hilos.Bus5;
import Hilos.Bus6;
import Hilos.Bus7;
import Hilos.Bus8;
import Hilos.Bus9;
import Hilos.Reloj;
import Hilos.RelojDomingo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GUI extends JFrame implements Runnable{
    
    public static ObjectInputStream lecturaDatos;
    public static ObjectOutputStream escrituraDatos;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    public static boolean ejecucionActiva = false;
    
    
    public boolean continuar = true;
    
    
    public void run(){
        while (continuar){
            try {
                recibirDatos();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            realizarConexion();
            run();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void recibirDatos() throws IOException{
        String info = lecturaDatos.readUTF();
        if (ejecucionActiva==false){
            escrituraDatos.writeUTF("El servidor aún no está en ejecución");
            escrituraDatos.flush();
        } else {
        
            switch(info){
        
            case "1":
                Bus1.sending = true;
                
                Bus2.sending = false; 
                Bus3.sending = false; 
                Bus4.sending = false; 
                Bus5.sending = false; 
                Bus6.sending = false; 
                Bus7.sending = false; 
                Bus8.sending = false; 
                Bus9.sending = false; 
                Bus10.sending = false; 
                
                Bus2.sendDet = false;
                Bus3.sendDet = false;
                Bus5.sendDet = false;
                Bus7.sendDet = false;
                Bus9.sendDet = false;
                
                break;
            case "2":
                Bus2.sending = true;
                Bus2.sendDet = true;
                
                Bus1.sending = false; 
                Bus3.sending = false; 
                Bus4.sending = false; 
                Bus5.sending = false; 
                Bus6.sending = false; 
                Bus7.sending = false; 
                Bus8.sending = false; 
                Bus9.sending = false; 
                Bus10.sending = false; 
                
                Bus3.sendDet = false;
                Bus5.sendDet = false;
                Bus7.sendDet = false;
                Bus9.sendDet = false;
                
                break;
            case "3":
                Bus3.sending = true;
                Bus3.sendDet = true;
                
                Bus1.sending = false; 
                Bus2.sending = false;
                Bus4.sending = false; 
                Bus5.sending = false; 
                Bus6.sending = false; 
                Bus7.sending = false; 
                Bus8.sending = false; 
                Bus9.sending = false; 
                Bus10.sending = false; 
                
                Bus2.sendDet = false;
                Bus5.sendDet = false;
                Bus7.sendDet = false;
                Bus9.sendDet = false;
                
                break; 
            case "4":
                Bus4.sending = true;
                
                Bus1.sending = false; 
                Bus2.sending = false;
                Bus3.sending = false; 
                Bus5.sending = false; 
                Bus6.sending = false; 
                Bus7.sending = false; 
                Bus8.sending = false; 
                Bus9.sending = false; 
                Bus10.sending = false; 
                
                Bus2.sendDet = false;
                Bus3.sendDet = false;
                Bus5.sendDet = false;
                Bus7.sendDet = false;
                Bus9.sendDet = false;
                
                break;
            case "5":
                Bus5.sending = true;
                Bus5.sendDet = true;
                
                Bus1.sending = false; 
                Bus2.sending = false;
                Bus3.sending = false; 
                Bus4.sending = false; 
                Bus6.sending = false; 
                Bus7.sending = false; 
                Bus8.sending = false; 
                Bus9.sending = false; 
                Bus10.sending = false;
                
                Bus2.sendDet = false;
                Bus3.sendDet = false;
                Bus7.sendDet = false;
                Bus9.sendDet = false;
                
                break; 
            case "6":
                Bus6.sending = true;
                
                Bus1.sending = false; 
                Bus2.sending = false;
                Bus3.sending = false; 
                Bus4.sending = false; 
                Bus5.sending = false; 
                Bus7.sending = false; 
                Bus8.sending = false; 
                Bus9.sending = false; 
                Bus10.sending = false;
                
                Bus2.sendDet = false;
                Bus3.sendDet = false;
                Bus5.sendDet = false;
                Bus7.sendDet = false;
                Bus9.sendDet = false;
                break; 
            case "7":
                Bus7.sending = true;
                Bus7.sendDet = true;
                
                Bus1.sending = false; 
                Bus2.sending = false;
                Bus3.sending = false; 
                Bus4.sending = false; 
                Bus5.sending = false; 
                Bus6.sending = false; 
                Bus8.sending = false; 
                Bus9.sending = false; 
                Bus10.sending = false;
                
                Bus2.sendDet = false;
                Bus3.sendDet = false;
                Bus5.sendDet = false;
                Bus9.sendDet = false;
                break; 
            case "8":
                Bus8.sending = true;
                
                Bus1.sending = false; 
                Bus2.sending = false;
                Bus3.sending = false; 
                Bus4.sending = false; 
                Bus5.sending = false; 
                Bus6.sending = false; 
                Bus7.sending = false; 
                Bus9.sending = false; 
                Bus10.sending = false;
                
                Bus2.sendDet = false;
                Bus3.sendDet = false;
                Bus5.sendDet = false;
                Bus7.sendDet = false;
                Bus9.sendDet = false;
                break; 
            case "9":
                Bus9.sending = true;
                Bus9.sendDet = true;
                
                Bus1.sending = false; 
                Bus2.sending = false;
                Bus3.sending = false; 
                Bus4.sending = false; 
                Bus5.sending = false; 
                Bus6.sending = false; 
                Bus7.sending = false; 
                Bus8.sending = false; 
                Bus10.sending = false;
                
                Bus2.sendDet = false;
                Bus3.sendDet = false;
                Bus5.sendDet = false;
                Bus7.sendDet = false;
                
                break; 
            case "10":
                Bus10.sending = true;
                
                Bus1.sending = false; 
                Bus2.sending = false;
                Bus3.sending = false; 
                Bus4.sending = false; 
                Bus5.sending = false; 
                Bus6.sending = false; 
                Bus7.sending = false; 
                Bus8.sending = false; 
                Bus9.sending = false; 
                
                Bus2.sendDet = false;
                Bus3.sendDet = false;
                Bus5.sendDet = false;
                Bus7.sendDet = false;
                Bus9.sendDet = false;
                break;
            case "-1":
                Bus1.sending = false; 
                Bus2.sending = false; 
                Bus3.sending = false; 
                Bus4.sending = false; 
                Bus5.sending = false; 
                Bus6.sending = false; 
                Bus7.sending = false; 
                Bus8.sending = false; 
                Bus9.sending = false; 
                Bus10.sending = false; 
                escrituraDatos.writeUTF("Detenido");
                escrituraDatos.flush();
                break;
            case "Closing":
                Bus1.sending = false; 
                Bus2.sending = false; 
                Bus3.sending = false; 
                Bus4.sending = false; 
                Bus5.sending = false; 
                Bus6.sending = false; 
                Bus7.sending = false; 
                Bus8.sending = false; 
                Bus9.sending = false; 
                Bus10.sending = false; 
                continuar = false;
                break;
        }
        
        }

        
    }
    
    public void enviarDatos(String dato) throws IOException{
        escrituraDatos.writeUTF(dato);
        escrituraDatos.flush();
    }
    
    /*Labels de paradas*/
    
    JLabel ciudadDeportiva;
    JLabel superLian;
    JLabel plasticosTosso;
    JLabel parqueoYamuni;
    JLabel colegioMA;
    JLabel escuelaSanRafael;
    JLabel hotelCaribbean;
    JLabel parqueSanFra;
    JLabel liceoJoaquinJimenez;
    JLabel acueductosGuada;
    JLabel rotondaBetania;
    JLabel colegioSalesianoDB;
    JLabel abastecedorSauces;
    JLabel parqueMonteAzul;
    JLabel cevicheriaCostaAzul;
    JLabel tallerGernon;
    JLabel plazaAmerica;
    JLabel restLaFortuna;
    JLabel terminalHatillo;
    
    /*Labels de nombres de paradas*/
    
    JLabel rotondaBetaniaText; 
    JLabel acueductosGuadaText; 
    JLabel licJoaquinJimenezText;
    JLabel hotelCaribbeanText;
    JLabel escuelaJuanRafaelText;
    JLabel colegioMAText;
    JLabel parqueoYamuniText;
    JLabel plasticosTossoText;
    JLabel superLianText;
    JLabel ciudadDeportivaText;
    JLabel terminalHatilloText;
    JLabel restLaFortunaText;
    JLabel plazaAmericaText;
    JLabel tallerGernonText;
    JLabel cevicheraCostaAzulText;
    JLabel parqueMonteAzulText;
    JLabel abastecedorSaucesText;
    JLabel parqueSanFraText;
    JLabel colegioSalesianoText;
    
    /*Label del reloj*/
    
    public static JLabel reloj;
    
    
    Scanner entry;
    JLabel map;
    
    /*labels de los buses*/
    public static JLabel bus1;
    public static JLabel bus2;
    public static JLabel bus3;
    public static JLabel bus4;
    public static JLabel bus5;
    public static JLabel bus6;
    public static JLabel bus7;
    public static JLabel bus8;
    public static JLabel bus9;
    public static JLabel bus10;
    //public static JLabel test; Pruebas.
    
    public static boolean pauseBool = false;
    
    String[] vector;
    int counter = 0;
    JButton button;
    public static JButton iniciar;
    public static JButton iniciarDomingo;
    
    JButton pause; 
    
    public static Bus1 busThread1;
    public static Bus2 busThread2;
    public static Bus3 busThread3;
    public static Bus4 busThread4;
    public static Bus5 busThread5;
    public static Bus6 busThread6;
    public static Bus7 busThread7;
    public static Bus8 busThread8;
    public static Bus9 busThread9;
    public static Bus10 busThread10;
    
    public GUI() throws IOException{
        setLayout(null); 
        map = new JLabel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        pause = new JButton("Pause");
        pause.setBounds(400+800,0,100,20);
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (pauseBool == false){
                    pauseBool = true;
                } else {
                    pauseBool = false;
                }
            }
        });
        //add(pause);
        
        /*Programación buses GUI*/
        bus1 = new JLabel();
        bus1.setIcon(new ImageIcon("Buses/RESIZED/bus1.png"));
        bus1.setBounds(1426,267-20,45,45);
        add(bus1);
        
        bus2 = new JLabel(); 
        bus2.setIcon(new ImageIcon("Buses/RESIZED/bus2.png"));
        bus2.setBounds(1155-15,289-15,45,45);
        add(bus2);
        
        bus3 = new JLabel();
        bus3.setIcon(new ImageIcon("Buses/RESIZED/bus3.png"));
        bus3.setBounds(922-15,403-15,45,45);
        add(bus3);
        
        bus4 = new JLabel(); 
        bus4.setIcon(new ImageIcon("Buses/RESIZED/bus4.png"));
        bus4.setBounds(902-15,580-15,45,45);
        add(bus4);
        
        bus5 = new JLabel(); 
        bus5.setIcon(new ImageIcon("Buses/RESIZED/bus5.png"));
        bus5.setBounds(677-15,681-15, 45,45);
        add(bus5); 
        
        bus6 = new JLabel(); 
        bus6.setIcon(new ImageIcon("Buses/RESIZED/bus6.png"));
        bus6.setBounds(767-15, 851-15, 45,45);
        add(bus6); 
        
        bus7 = new JLabel(); 
        bus7.setIcon(new ImageIcon("Buses/RESIZED/bus7.png"));
        bus7.setBounds(1256-15, 859-15, 45, 45);
        add(bus7); 
        
        bus8 = new JLabel(); 
        bus8.setIcon(new ImageIcon("Buses/RESIZED/bus8.png"));
        bus8.setBounds(1555-15, 848-15, 45, 45);
        add(bus8); 
        
        bus9 = new JLabel(); 
        bus9.setIcon(new ImageIcon("Buses/RESIZED/bus9.png"));
        bus9.setBounds(1597-15, 552-15, 45, 45);
        add(bus9); 
        
        bus10 = new JLabel(); 
        bus10.setIcon(new ImageIcon("Buses/RESIZED/bus10.png"));
        bus10.setBounds(1635-15, 319-15, 45, 45);
        add(bus10); 
        
        /*test = new JLabel(); 
        test.setIcon(new ImageIcon("Buses/RESIZED/bus1.png"));
        test.setBounds(1741-15, 397-15, 45, 45);
        add(test);*/
        
        ciudadDeportivaText= new JLabel("Ciudad Deportiva", SwingConstants.CENTER); 
        ciudadDeportivaText.setFont(new Font("Times New Roman", 1, 16));
        ciudadDeportivaText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        ciudadDeportivaText.setBounds(625,590, 125, 20);
        ciudadDeportivaText.setBackground(Color.white);
        ciudadDeportivaText.setOpaque(true);
        add(ciudadDeportivaText);
               
        ciudadDeportiva = new JLabel();
        ciudadDeportiva.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        ciudadDeportiva.setBounds(678-8, 680-65, 40, 71);
        add(ciudadDeportiva);
        
        superLianText = new JLabel("Super Lian", SwingConstants.CENTER); 
        superLianText.setFont(new Font("Times New Roman", 1, 16));
        superLianText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        superLianText.setBounds(760, 595, 80, 20);
        superLianText.setBackground(Color.white);
        superLianText.setOpaque(true);
        add(superLianText);
        
        superLian = new JLabel();
        superLian.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        superLian.setBounds(792-8, 688-65, 40, 71);
        add(superLian);
        
        plasticosTossoText = new JLabel("Plásticos Tosso", SwingConstants.CENTER); 
        plasticosTossoText.setFont(new Font("Times New Roman", 1, 16));
        plasticosTossoText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        plasticosTossoText.setBounds(920, 510, 110, 20);
        plasticosTossoText.setBackground(Color.white);
        plasticosTossoText.setOpaque(true);
        add(plasticosTossoText);
        
        plasticosTosso = new JLabel();
        plasticosTosso.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        plasticosTosso.setBounds(905-8, 591-65, 40, 71);
        
        add(plasticosTosso);
        
        parqueoYamuniText = new JLabel("Parqueo Yamuni", SwingConstants.CENTER); 
        parqueoYamuniText.setFont(new Font("Times New Roman", 1, 16));
        parqueoYamuniText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        parqueoYamuniText.setBounds(665, 363, 125, 20);
        parqueoYamuniText.setBackground(Color.white);
        parqueoYamuniText.setOpaque(true);
        add(parqueoYamuniText);

        parqueoYamuni = new JLabel();
        parqueoYamuni.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        parqueoYamuni.setBounds(803-8, 428-65, 40, 71);
        add(parqueoYamuni);
        
        colegioMAText = new JLabel("Colegio María Auxiliadora", SwingConstants.CENTER); 
        colegioMAText.setFont(new Font("Times New Roman", 1, 16));
        colegioMAText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        colegioMAText.setBounds(740, 310, 190, 20);
        colegioMAText.setBackground(Color.white);
        colegioMAText.setOpaque(true);
        add(colegioMAText);
        
        colegioMA = new JLabel();
        colegioMA.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        colegioMA.setBounds(831-8, 399-65, 40, 71);
        add(colegioMA);
        
        escuelaJuanRafaelText = new JLabel("Escuela Juan Rafael", SwingConstants.CENTER); 
        escuelaJuanRafaelText.setFont(new Font("Times New Roman", 1, 16));
        escuelaJuanRafaelText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        escuelaJuanRafaelText.setBounds(955, 390, 150, 20);
        escuelaJuanRafaelText.setBackground(Color.white);
        escuelaJuanRafaelText.setOpaque(true);
        add(escuelaJuanRafaelText);
        
        escuelaSanRafael = new JLabel();
        escuelaSanRafael.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        escuelaSanRafael.setBounds(917-8, 404-65, 40, 71);
        add(escuelaSanRafael);
        
        hotelCaribbeanText = new JLabel("H. Caribbean", SwingConstants.CENTER); 
        hotelCaribbeanText.setFont(new Font("Times New Roman", 1, 16));
        hotelCaribbeanText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        hotelCaribbeanText.setBounds(1100, 225, 100, 20);
        hotelCaribbeanText.setBackground(Color.white);
        hotelCaribbeanText.setOpaque(true);
        add(hotelCaribbeanText);
        
        hotelCaribbean = new JLabel();
        hotelCaribbean.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        hotelCaribbean.setBounds(1147-8, 314-65, 40, 71);
        add(hotelCaribbean);
        
        parqueSanFraText = new JLabel("Parque San Fra", SwingConstants.CENTER); 
        parqueSanFraText.setFont(new Font("Times New Roman", 1, 16));
        parqueSanFraText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        parqueSanFraText.setBounds(1460, 770, 115, 20);
        parqueSanFraText.setBackground(Color.white);
        parqueSanFraText.setOpaque(true);
        add(parqueSanFraText);
        
        parqueSanFra = new JLabel();
        parqueSanFra.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        parqueSanFra.setBounds(1552-8, 858-65, 40, 71);      
        add(parqueSanFra);
        
        licJoaquinJimenezText = new JLabel("Liceo Joaquín Jiménez", SwingConstants.CENTER); 
        licJoaquinJimenezText.setFont(new Font("Times New Roman", 1, 16));
        licJoaquinJimenezText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        licJoaquinJimenezText.setBounds(1350, 175, 170, 20);
        licJoaquinJimenezText.setBackground(Color.white);
        licJoaquinJimenezText.setOpaque(true);
        add(licJoaquinJimenezText);
        
        liceoJoaquinJimenez = new JLabel();
        liceoJoaquinJimenez.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        liceoJoaquinJimenez.setBounds(1441-8, 262-65, 40, 71);        
        add(liceoJoaquinJimenez);
        
        acueductosGuadaText = new JLabel("Acueductos Guadalupe", SwingConstants.CENTER); 
        acueductosGuadaText.setFont(new Font("Times New Roman", 1, 16));
        acueductosGuadaText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        acueductosGuadaText.setBounds(1470, 145, 170, 20);
        acueductosGuadaText.setBackground(Color.white);
        acueductosGuadaText.setOpaque(true);
        add(acueductosGuadaText);
        
        acueductosGuada = new JLabel();
        acueductosGuada.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        acueductosGuada.setBounds(1558-8, 233-65, 40, 71);
        add(acueductosGuada);
        
        rotondaBetaniaText = new JLabel("Betania", SwingConstants.CENTER); 
        rotondaBetaniaText.setFont(new Font("Times New Roman", 1, 16));
        rotondaBetaniaText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        rotondaBetaniaText.setBounds(1670, 275, 70, 20);
        rotondaBetaniaText.setBackground(Color.white);
        rotondaBetaniaText.setOpaque(true);
        add(rotondaBetaniaText);
        
        rotondaBetania = new JLabel();
        rotondaBetania.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        rotondaBetania.setBounds(1636-8, 322-65, 40, 71);
        add(rotondaBetania);
        
        colegioSalesianoText = new JLabel("Salesiano", SwingConstants.CENTER); 
        colegioSalesianoText.setFont(new Font("Times New Roman", 1, 16));
        colegioSalesianoText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        colegioSalesianoText.setBounds(1630, 480, 75, 20);
        colegioSalesianoText.setBackground(Color.white);
        colegioSalesianoText.setOpaque(true);
        add(colegioSalesianoText);
        
        colegioSalesianoDB = new JLabel();
        colegioSalesianoDB.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        colegioSalesianoDB.setBounds(1600-8, 549-65, 40, 71);
        add(colegioSalesianoDB);
        
        abastecedorSaucesText = new JLabel("Abast. Sauces", SwingConstants.CENTER); 
        abastecedorSaucesText.setFont(new Font("Times New Roman", 1, 16));
        abastecedorSaucesText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        abastecedorSaucesText.setBounds(1320, 810, 110, 20);
        abastecedorSaucesText.setBackground(Color.white);
        abastecedorSaucesText.setOpaque(true);
        add(abastecedorSaucesText);
        
        abastecedorSauces = new JLabel();
        abastecedorSauces.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        abastecedorSauces.setBounds(1355-8, 902-65, 40, 71);
        add(abastecedorSauces);
        
        parqueMonteAzulText = new JLabel("Monte Azul", SwingConstants.CENTER); 
        parqueMonteAzulText.setFont(new Font("Times New Roman", 1, 16));
        parqueMonteAzulText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        parqueMonteAzulText.setBounds(1220, 775, 90, 20);
        parqueMonteAzulText.setBackground(Color.white);
        parqueMonteAzulText.setOpaque(true);
        add(parqueMonteAzulText);
        
        parqueMonteAzul = new JLabel();
        parqueMonteAzul.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        parqueMonteAzul.setBounds(1255-8, 865-65, 40, 71);
        add(parqueMonteAzul);
        
        cevicheraCostaAzulText = new JLabel("Costa Azul", SwingConstants.CENTER); 
        cevicheraCostaAzulText.setFont(new Font("Times New Roman", 1, 16));
        cevicheraCostaAzulText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        cevicheraCostaAzulText.setBounds(1120, 770, 95, 20);
        cevicheraCostaAzulText.setBackground(Color.white);
        cevicheraCostaAzulText.setOpaque(true);
        add(cevicheraCostaAzulText);
        
        cevicheriaCostaAzul = new JLabel();
        cevicheriaCostaAzul.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        cevicheriaCostaAzul.setBounds(1152-8, 857-65, 40, 71);
        add(cevicheriaCostaAzul);
        
        tallerGernonText = new JLabel("Taller Gernón", SwingConstants.CENTER); 
        tallerGernonText.setFont(new Font("Times New Roman", 1, 16));
        tallerGernonText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        tallerGernonText.setBounds(1000, 780, 110, 20);
        tallerGernonText.setBackground(Color.white);
        tallerGernonText.setOpaque(true);
        add(tallerGernonText);
        
        tallerGernon = new JLabel();
        tallerGernon.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        tallerGernon.setBounds(1069-8, 870-65, 40, 71);
        add(tallerGernon);
        
        plazaAmericaText = new JLabel("Plaza América", SwingConstants.CENTER); 
        plazaAmericaText.setFont(new Font("Times New Roman", 1, 16));
        plazaAmericaText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        plazaAmericaText.setBounds(790, 820, 110, 20);
        plazaAmericaText.setBackground(Color.white);
        plazaAmericaText.setOpaque(true);
        add(plazaAmericaText);
        
        plazaAmerica = new JLabel();
        plazaAmerica.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        plazaAmerica.setBounds(766-8, 846-65, 40, 71);
        add(plazaAmerica);
        
        restLaFortunaText = new JLabel("Rest. La Fortuna", SwingConstants.CENTER); 
        restLaFortunaText.setFont(new Font("Times New Roman", 1, 16));
        restLaFortunaText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        restLaFortunaText.setBounds(730, 725, 120, 20);
        restLaFortunaText.setBackground(Color.white);
        restLaFortunaText.setOpaque(true);
        add(restLaFortunaText);
        
        restLaFortuna = new JLabel();
        restLaFortuna.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        restLaFortuna.setBounds(713-8, 764-65, 40, 71);

        add(restLaFortuna);
        
        terminalHatilloText = new JLabel("Terminal Hatillo", SwingConstants.CENTER); 
        terminalHatilloText.setFont(new Font("Times New Roman", 1, 16));
        terminalHatilloText.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.black));
        terminalHatilloText.setBounds(610, 830, 120, 20);
        terminalHatilloText.setBackground(Color.white);
        terminalHatilloText.setOpaque(true);
        add(terminalHatilloText);
        
        terminalHatillo = new JLabel();
        terminalHatillo.setIcon(new ImageIcon("Paradas/paradaResize.png"));
        terminalHatillo.setBounds(661-8, 804-65, 40, 71);
        add(terminalHatillo);
        
        reloj = new JLabel("Día | 00:00");
        reloj.setFont(new Font("Verdana", Font.BOLD, 46));
        reloj.setForeground(Color.black);
        reloj.setBounds(100,900, 500,110);
        add(reloj);
        
        iniciar = new JButton("Simulación L-S.");
        
        iniciar.setBounds(50,100,300,75);
        iniciar.setFont(new Font("Times New Roman", 1, 25));
        iniciar.addActionListener(e -> {
            iniciar.setEnabled(false);
                iniciarDomingo.setEnabled(false);
                ejecucionActiva = true; 
                try {
                    escrituraDatos.writeUTF("EjTRUE");
                    escrituraDatos.flush();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                busThread1 = new Bus1();

                busThread2 = new Bus2();

                busThread3 = new Bus3();

                busThread4 = new Bus4();

                busThread5 = new Bus5();
 
                busThread6 = new Bus6(); 

                busThread7 = new Bus7();

                busThread8 = new Bus8(); 

                busThread9 = new Bus9(); 

                busThread10 = new Bus10();

                
                Reloj relojThread = new Reloj();
                relojThread.start();
        });
        /*iniciar.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                iniciar.setEnabled(false);
                iniciarDomingo.setEnabled(false);
                ejecucionActiva = true; 
                try {
                    escrituraDatos.writeUTF("EjTRUE");
                    escrituraDatos.flush();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                busThread1 = new Bus1();

                busThread2 = new Bus2();

                busThread3 = new Bus3();

                busThread4 = new Bus4();

                busThread5 = new Bus5();
 
                busThread6 = new Bus6(); 

                busThread7 = new Bus7();

                busThread8 = new Bus8(); 

                busThread9 = new Bus9(); 

                busThread10 = new Bus10();

                
                Reloj relojThread = new Reloj();
                relojThread.start();
                
            }
        });*/
        add(iniciar);
        
        iniciarDomingo = new JButton("Simulación Domingo.");
        iniciarDomingo.setFont(new Font("Times New Roman", 1, 25));
        iniciarDomingo.setBounds(50,180,300,75);
        iniciarDomingo.addActionListener(e -> {
            iniciarDomingo.setEnabled(false);
                iniciar.setEnabled(false);
                ejecucionActiva = true; 
                try {
                    escrituraDatos.writeUTF("EjTRUE");
                    escrituraDatos.flush();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                busThread1 = new Bus1();

                busThread2 = new Bus2();

                busThread3 = new Bus3();

                busThread4 = new Bus4();

                busThread5 = new Bus5();

                busThread6 = new Bus6(); 

                busThread7 = new Bus7();

                busThread8 = new Bus8(); 

                busThread9 = new Bus9(); 

                busThread10 = new Bus10();
                
                RelojDomingo relojDThread = new RelojDomingo();
                relojDThread.start();
        });
        /*iniciarDomingo.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                iniciarDomingo.setEnabled(false);
                iniciar.setEnabled(false);
                ejecucionActiva = true; 
                try {
                    escrituraDatos.writeUTF("EjTRUE");
                    escrituraDatos.flush();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                busThread1 = new Bus1();

                busThread2 = new Bus2();

                busThread3 = new Bus3();

                busThread4 = new Bus4();

                busThread5 = new Bus5();

                busThread6 = new Bus6(); 

                busThread7 = new Bus7();

                busThread8 = new Bus8(); 

                busThread9 = new Bus9(); 

                busThread10 = new Bus10();
                
                RelojDomingo relojDThread = new RelojDomingo();
                relojDThread.start();

            }
        
        });*/
        
        add(iniciarDomingo);
        
        JLabel sim = new JLabel("Simulaciones: ");
        sim.setFont(new Font("Times New Roman", 1, 32));
        sim.setBounds(110, 50, 200, 30);
        add(sim);
        
        
        map.setIcon(new ImageIcon("MapTests/latestMapForReal.png")); // "Mapa.jpg"
        map.setBounds(0,0,2164,1074);
        add(map);
        
        
        
        
        
        
        this.setBounds(45,178,2185,1120); //2164, 1074
        this.setResizable(false);
        this.setVisible(true); 
        
        /*Inicialización de elementos de conexión*/
        
        serverSocket = new ServerSocket(7000);
        realizarConexion();
        System.out.println("Server Ready!");
    }
    
    public void realizarConexion() throws IOException{
        clientSocket = serverSocket.accept();
        continuar = true;
        lecturaDatos = new ObjectInputStream(clientSocket.getInputStream());
        escrituraDatos = new ObjectOutputStream(clientSocket.getOutputStream());
    } 
}
