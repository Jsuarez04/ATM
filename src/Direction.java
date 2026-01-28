public class Direction {
private String calle;
private String ciudad;
private String estado;
private String codigoPostal;

    public Direction(String calle, String ciudad, String estado, String codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    public void showDirection(){
        System.out.println("Calle: " + calle);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Estado: " + estado);
        System.out.println("Código Postal: " + codigoPostal);
    }

}
