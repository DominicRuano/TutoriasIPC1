package datos;

public class ctrlUsuarios {

    static int size = 50;
    private static Usuario[] usuarios_t = new Usuario[size]; // null
    static int contador = 0;
    static int id = 1;

    public static Usuario[] getAllUsers() {
        return usuarios_t;
    }

    public static int getSizeArray() {
        return contador;
    }

    public static boolean verificarID(int id) {
        for (int i = 0; i < usuarios_t.length; i++) {

            Usuario d = usuarios_t[i];

            if (d == null) {
                continue;
            }
            if (d.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static boolean agregarUsuario(String nombre, int Edad, String ciudad, String ocupacion) {
        if (verificarID(id)) {
            System.out.println("La id ingresada ya esta siendo usada");
            return false;
        }
        Usuario nuevoUsuario = new Usuario(id, nombre, Edad, ciudad, ocupacion);
        usuarios_t[contador] = nuevoUsuario;
        contador++;
        id++;
        return true;
    }

    public static boolean agregarUsuario(int idI, String nombre, int Edad, String ciudad, String ocupacion) {
        if (verificarID(idI)) {
            System.out.println("La id ingresada ya esta siendo usada");
            return false;
        }
        Usuario nuevoUsuario = new Usuario(idI, nombre, Edad, ciudad, ocupacion);
        usuarios_t[contador] = nuevoUsuario;
        contador++;
        id++;
        return true;
    }

    public static Usuario buscarUsuario(int id) {
        Usuario usuarioBuscado = null;
        for (Usuario usuario : usuarios_t) {
            if (usuario.getId() == id) {
                usuarioBuscado = usuario;
            }
        }
        return usuarioBuscado;
    }

    public static boolean eliminarUsuario(int id) {
        //Usuario usuarioBuscado = null;
        for (int i = 0; i < usuarios_t.length; i++) {
            if (usuarios_t[i].getId() == id && usuarios_t[i] != null) {
                usuarios_t[i] = usuarios_t[i + 1];
                for (int j = i + 1; j < usuarios_t.length-1; j++) {
                    usuarios_t[j] = usuarios_t[j + 1];
                }
                return true;
            }
        }
        return false;
    }

    public static boolean actualizarUsuario(int id, String nombre, int edad, String ciudad, String ocupacion) {
        Usuario usuario_actualizar = new Usuario(id, nombre, edad, ciudad, ocupacion);
        for (int i = 0; i < usuarios_t.length; i++) {
            if (usuarios_t[i].getId() == id) {
                usuarios_t[i] = usuario_actualizar;
                return true;
            }
        }
        return false;
    }

    public static void imprimirUsuarios() {
        for (Usuario usuario : usuarios_t) {
            if (usuario == null) {
                continue;
            }
            System.out.print(usuario.getNombre() + " " + usuario.getEdad() + " " + usuario.getCiudad() + " " + usuario.getOcupacion());
            System.out.println(" ");
        }
    }

    public static Usuario[] getOcupaciones() {
        if (usuarios_t.length == 0) {
            return null;
        }
        Usuario[] oc = new Usuario[3];
        int cantidadE = 0;
        int cantiodadEm = 0;
        int cantidadD = 0;
        for (Usuario usuario : usuarios_t) {
            if (usuario == null) {
                continue;
            }
            if (usuario.getOcupacion().equals("Estudiante")) {
                cantidadE++;
                oc[0] = new Usuario(0, "", 0, "", cantidadE + "");
            } else if (usuario.getOcupacion().equals("Empleado/a")) {
                cantiodadEm++;
                oc[1] = new Usuario(0, "", 0, "", cantiodadEm + "");
            } else if (usuario.getOcupacion().equals("Desempleado/a")) {
                cantidadD++;
                oc[2] = new Usuario(0, "", 0, "", cantidadD + "");
            }

        }
        return oc;
    }
}
