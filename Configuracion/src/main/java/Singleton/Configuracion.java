package Singleton;

public class Configuracion {
    private static Configuracion instancia;  // variable estática con la única instancia
    private String url;
    private String usuario;
    private String password;

    // Constructor privado,  nadie puede hacer "new Configuracion()"
    private Configuracion() {
        this.url = "jdbc:mysql://localhost:3306/default";
        this.usuario = "root";
        this.password = "123456789";
    }

    // Método estático público que devuelve la única instancia
    public static Configuracion getInstancia() {
        if (instancia == null) {   // si no existe aún, la crea
            instancia = new Configuracion();
        }
        return instancia;  // siempre devuelve la misma
    }

    // Getters y Setters para modificar datos
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Método para mostrar la configuración actual
    public void mostrarConfiguracion(){
        System.out.println("URL: " + this.url);
        System.out.println("Usuario: " + this.usuario);
        System.out.println("Password: " + this.password);
    }
}
