package main;

//import com.formdev.flatlaf.intellijthemes.;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ventanas.Admin;

/**
 *
 * @author mesoi
 */
public class MainClase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainClase.class.getName()).log(Level.SEVERE, null, ex);
        }
        Admin a = new Admin();
        a.setVisible(true);
    }

}
