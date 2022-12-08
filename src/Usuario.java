public class Usuario {
    private String nombre;
    private int cod_usuario;
    private String email;
    private String pass;

    public Usuario(String nombre, String email, String pass){
        this.nombre=nombre;
        this.email=email;
        this.pass=pass;
    
    }
    public Usuario(int cod ,String nombre, String email, String pass){
        this.nombre=nombre;
        this.email=email;
        this.pass=pass;
        this.cod_usuario=cod;
    
    }
    public String getEmail() {
        return email;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCod_usuario() {
        return cod_usuario;
    }
    public String getPass() {
        return pass;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}