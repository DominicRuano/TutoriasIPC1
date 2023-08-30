public class kioscos {
    public String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String nombre;
    public String region;

    @Override
    public String toString() {
        return this.getNombre();
    }

    public kioscos(String codigo, String nombre, String region) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.region = region;
    }
}
