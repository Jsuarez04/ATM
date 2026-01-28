public class User {
    private String fullName;
    private String ID;
    private String password;
    private Direction direction;
    private String email;
    private String tlf;


    public User(String fullName, String ID,String password, Direction direction, String email, String tlf) {
        this.fullName = fullName;
        this.ID = ID;
        this.password = password;
        this.direction = direction;
        this.email = email;
        this.tlf = tlf;
    }


    //Solo se podra acceder a informacion basica
    public String getID() {
        return ID;
    }
    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getEmail() {
        return email;
    }

    public String getTlf() {
        return tlf;
    }

    //Y se podran cambiar datos no sensibles
    public void setEmail(String email) {
        this.email = email;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    //Funcion para mostrar datos personales

    public void showInfo(){
        System.out.println("Nombre: " + fullName);
        System.out.println("ID: " + ID);
        System.out.println("Email: " + email);
        System.out.println("Teléfono: " + tlf);
        direction.showDirection() ;
    }
}
