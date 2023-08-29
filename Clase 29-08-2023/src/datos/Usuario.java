package datos;

public class Usuario {
    
    private int id;
    private String nombre;
    private int edad;
    private String Ciudad;
    private String ocupacion;

    public Usuario(int id, String nombre, int edad, String Ciudad, String ocupacion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.Ciudad = Ciudad;
        this.ocupacion = ocupacion;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }  

}
