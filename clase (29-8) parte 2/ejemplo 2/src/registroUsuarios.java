import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registroUsuarios {
    private JTextField nombreUsuario;
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JTextField textField5;
    private JComboBox comboBox3;
    private JButton subirFotografiaButton;
    public  JPanel registroUsuario;
    private JLabel lblImagen;
    private JButton guardarButton;
    public static JFrame frame;


    public registroUsuarios() {
    subirFotografiaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String direcccion = "";
            JFileChooser jFileChooser = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, PNG, GIF","JPG","PNG","GIF");
            jFileChooser.setFileFilter(filtro);

            int respuesta = jFileChooser.showOpenDialog(null);
            if (respuesta == JFileChooser.APPROVE_OPTION){
                direcccion = jFileChooser.getSelectedFile().getPath();
                Image pImagen = new ImageIcon(direcccion).getImage();
                ImageIcon pIcono = new ImageIcon(pImagen.getScaledInstance(lblImagen.getWidth(),lblImagen.getHeight(),Image.SCALE_SMOOTH));
                lblImagen.setIcon(pIcono);
            }
        }

    });

}

}
