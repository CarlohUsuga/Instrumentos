abstract class Instrumentos {
    private String instrumento, marca, color;
    private double precio;
    private int cantidad;

    //Constructor
    public Instrumentos(String instrumento, String marca, String color, double precio, int cantidad) {
        this.instrumento = instrumento;
        this.marca = marca;
        this.color = color;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //Metodos get y set
    public String getInstrumento() {
        return instrumento;
    }
    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //metodo abstracto para calcular el precio total de los instrumentos
    abstract double calcularTotal();
    
    //metodo toString
    public abstract String toString();
}
