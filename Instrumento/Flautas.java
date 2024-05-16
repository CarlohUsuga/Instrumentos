/**
 * La clase Flautas extiende de la clase Instrumentos y representa un tipo de instrumento musical.
 * Almacena información específica sobre las flautas, como el tipo de embocadura, tipo de llaves,
 * tipo de cabeza, tamaño y código de venta.
 */
public class Flautas extends Instrumentos{
    private String tipoEmbocadura, tipoDeLlaves, tipodeCabeza, Tamaño, Codigo;
    
    public Flautas(String instrumento, String marca, String color, double precio, int cantidad, String tipoEmbocadura,
            String tipoDeLlaves, String tipodeCabeza, String tamaño, String codigo) {
        super(instrumento, marca, color, precio, cantidad);
        this.tipoEmbocadura = tipoEmbocadura;
        this.tipoDeLlaves = tipoDeLlaves;
        this.tipodeCabeza = tipodeCabeza;
        Tamaño = tamaño;
        Codigo = codigo;
    }

    //Metodos get y set
    public String getTipoEmbocadura() {
        return tipoEmbocadura;
    }

    public void setTipoEmbocadura(String tipoEmbocadura) {
        this.tipoEmbocadura = tipoEmbocadura;
    }

    public String getTipoDeLlaves() {
        return tipoDeLlaves;
    }

    public void setTipoDeLlaves(String tipoDeLlaves) {
        this.tipoDeLlaves = tipoDeLlaves;
    }

    public String getTipodeCabeza() {
        return tipodeCabeza;
    }

    public void setTipodeCabeza(String tipodeCabeza) {
        this.tipodeCabeza = tipodeCabeza;
    }

    public String getTamaño() {
        return Tamaño;
    }

    public void setTamaño(String tamaño) {
        Tamaño = tamaño;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }
    
    //Metodo para calcula el total de la venta
    public double calcularTotal(){
        double total = getPrecio() * getCantidad();
        return total;
    }

    public void tocarFlauta() {
        System.out.println("¡Estás tocando la flauta!");
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Su flauta:"+ "\n"+
               "Color: " + getColor()+ "\n"+
               "Tipo de embocadura: " + tipoEmbocadura+"\n"+
               "Tipo de llaves: " + tipoDeLlaves +"\n"+
               "tipo de cabeza: "+ tipodeCabeza +"\n"+
               "Tamaño: " + Tamaño +"\n"+
               "Codigo de venta: " + Codigo +"\n";
               
    } 
}
