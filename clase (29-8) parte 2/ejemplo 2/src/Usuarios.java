public class Usuarios {
    public String Correo;

    public String Password;

    public Usuarios(String correo, String password) {
        Correo = correo;
        Password = password;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "Correo='" + Correo + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
