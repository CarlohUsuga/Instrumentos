/**
 * La clase Saxofon es una subclase de Instrumentos y contiene atributos específicos para saxofones,
 * como tipo de boquilla, tipo de tudel, tipo de caña y tipo de abrazadera.
 * <T> Tipo genérico para el tipo de boquilla y tipo de boquilla.
 * <U> Tipo genérico para el tipo de tudel.
 * <V> Tipo genérico para el tipo de caña.
 * <K> Tipo genérico para el tipo de abrazadera.
 */

public class Saxofon <T, U, V, K> extends Instrumentos{
    private T TipoBoquilla; // Tipo de boquilla
    private U TipoTudel; // Tipo de tudel
    private V TipoCaña; // Tipo de caña
    private K TipoAbrazadera; // Tipo de abrazadera

    //Constructor
    public Saxofon(String instrumento, String marca, String color, double precio, int cantidad, T tipotBoquilla,
            U tipoTudel, V tipoCaña, K tipoAbrazadera) {
        super(instrumento, marca, color, precio, cantidad);
        TipoBoquilla = tipotBoquilla;
        TipoTudel = tipoTudel;
        TipoCaña = tipoCaña;
        TipoAbrazadera = tipoAbrazadera;
    }

    //Metodos get y set
    public T getTipotBoquilla() {
        return TipoBoquilla;
    }

    public void setTipotBoquilla(T tipotBoquilla) {
        TipoBoquilla = tipotBoquilla;
    }

    public U getTipoTudel() {
        return TipoTudel;
    }

    public void setTipoTudel(U tipoTudel) {
        TipoTudel = tipoTudel;
    }

    public V getTipoCaña() {
        return TipoCaña;
    }

    public void setTipoCaña(V tipoCaña) {
        TipoCaña = tipoCaña;
    }

    public K getTipoAbrazadera() {
        return TipoAbrazadera;
    }

    public void setTipoAbrazadera(K tipoAbrazadera) {
        TipoAbrazadera = tipoAbrazadera;
    }

    @SuppressWarnings("unchecked")
    public <X> void setAtributo(int indice, X valor) {
        switch (indice) {
            // Caso 1: Establecer el atributo TipoBoquilla
            case 1:
                this.TipoBoquilla = (T) valor;
                break;
            // Caso 2: Establecer el atributo TipoTudel
            case 2:
                this.TipoTudel = (U) valor;
                break;
            // Caso 3: Establecer el atributo TipoCaña
            case 3:
                this.TipoCaña = (V) valor;
                break;
            // Caso 4: Establecer el atributo TipoAbrazadera
            case 4:
                this.TipoAbrazadera = (K) valor;
                break;
            // Caso predeterminado: Índice de atributo no válido
            default:
                throw new IllegalArgumentException("Índice de atributo no válido: " + indice);
        }
    }

    //Metodo para calcular el total del instrumento
    @Override
    double calcularTotal() {
        double total = getPrecio() * getCantidad();
        return total;
    }

    //Metodo para afinar
    public void afinarSaxofon() {
        System.out.println("¡Saxofon afinado!");
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Su saxofon: "+ "\n"+
               "Tipo de boquilla: " + TipoBoquilla +"\n"+
               "Tipo de tudel: " + TipoTudel +"\n"+ 
               "Tipo de caña: " + TipoCaña +"\n"+
               "Tipo de abrazadera: " + TipoAbrazadera + "\n";
    }   
}
