public class Rol {
    private int cod_rol;
    private String nombre;
    public Rol(int cod_rol, String nombre) {
        this.cod_rol = cod_rol;
        this.nombre = nombre;
    }
    public int getCod_rol() {
        return cod_rol;
    }
    public void setCod_rol(int cod_rol) {
        this.cod_rol = cod_rol;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
