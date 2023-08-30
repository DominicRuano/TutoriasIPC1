import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Autenticacion{
    public JPanel Autenticacion;
    private JTextField txtCorreo;
    private JPasswordField txtContrasena;
    private JLabel correoLabel;
    private JLabel contrasenaLabel;
    private JButton iniciarSesionButton;
    private JButton crearUnUsuarioButton;
    public String correo = "11", pass = "11";
    public static JFrame frame;
    public static ArrayList<Usuarios> misUsuarios = new ArrayList<>();
    public int autenticar(){
        for (int i = 0; i < misUsuarios.size() ; i++){
            String val2 = misUsuarios.get(i).toString();
            if (val2.contains(txtCorreo.getText())){
                if (val2.contains(txtContrasena.getText())) {
                    return 1;
                }
            }
        }
        return 0;
    }
    public Autenticacion() {
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCorreo.getText().equals(correo) && txtContrasena.getText().equals(pass)){
                    System.out.println("Inicio con usuario Master");
                    Main.frame.setContentPane(new menuAdmin().menuAdmin);
                    Main.frame.pack();
                    Main.frame.setSize(400,500);
                } else if (1 == autenticar()){
                    //System.out.println(misUsuarios.indexOf("12"));
                    System.out.println("Inicio con Usuario generico no admin");
                } else {
                    System.out.println("Credenciales incorrectas");
                    txtContrasena.setText("");
                    JOptionPane.showMessageDialog(frame,"Credenciales incorrectas");
                }
            }
        });
        crearUnUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setContentPane(new registroUsuarios().registroUsuario);
                Main.frame.pack();
                Main.frame.setSize(500,600);
            }
        });
    }
}
