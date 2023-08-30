import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Ingreso de Credenciales");
        frame.setContentPane(new Autenticacion().Autenticacion);
        //frame.setContentPane(new registroUsuarios().registroUsuario);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400,500);
        ArrayList<Usuarios> misUsuarios = new ArrayList<>();

        misUsuarios.add(new Usuarios("1","1"));
        System.out.println(misUsuarios);

        System.out.println("hola");
    }
}