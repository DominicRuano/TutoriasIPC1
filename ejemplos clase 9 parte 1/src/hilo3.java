
import java.awt.Image;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dominic
 */
public class hilo3 extends Thread{
    
    @Override
    public void run(){
        
        int index = frameHome.contador;
        frameHome.contador += 1;
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        LocalDateTime fechaHorainicio = LocalDateTime.now();
        frameHome.fechasinicio[index] = fechaHorainicio.format(formatter);
        frameHome.nombre[index] = "Moto3";
        frameHome.distancias[index] = String.valueOf(frameHome.distancia[2]);
        
        ImageIcon imagen4 = new ImageIcon(getClass().getResource("moto-removebg-rotated.png"));
        Image img4 = imagen4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
        ImageIcon imagen5 = new ImageIcon(getClass().getResource("moto-removebg-preview.png"));
        Image img6 = imagen5.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
        var ValorX = motos.jLabel3.getX();
        int ValorY = motos.jLabel3.getY();
        while (true) {            
            motos.jLabel3.setBounds(ValorX, ValorY, 100, 100);
            ValorX = ValorX + (5);
            motos.jLabel3.setIcon(new ImageIcon(img6));
            try {
                Thread.sleep(10*frameHome.distancia[2]);
            } catch (InterruptedException ex) {
                Logger.getLogger(hilos.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (ValorX > 700){
                break;
            }
        }
        
        motos.jLabel3.setIcon(new ImageIcon(img4));
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(hilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (true) {            
            motos.jLabel3.setBounds(ValorX, ValorY, 100, 100);
            ValorX = ValorX - (5);
            motos.jLabel3.setIcon(new ImageIcon(img4));
            try {
                Thread.sleep(10*frameHome.distancia[2]);
            } catch (InterruptedException ex) {
                Logger.getLogger(hilos.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (ValorX < 135){
                break;
            }
        }
        
        LocalDateTime fechaHorafinal = LocalDateTime.now();
        frameHome.fechasfinal[index] = fechaHorafinal.format(formatter);
        
        motos.jLabel3.setIcon(new ImageIcon(img6));
    }  
}
