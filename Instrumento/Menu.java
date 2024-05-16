
//Se importan las librerias necesarias
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    List<Flautas> listaflautas = new ArrayList<>();

    /**
 * Generador de identificadores únicos cortos (UUID).
 * Este Supplier genera un identificador único corto de longitud 4.
 */
Supplier<String> shortUuidGenerator = () -> {
    // Inicialización de un StringBuilder para construir el identificador
    StringBuilder sb = new StringBuilder();
    // Bucle para generar los dígitos del identificador
    for (int i = 0; i < 4; i++) {
        // Genera un dígito aleatorio entre 0 y 9
        int digit = (int) (Math.random() * 10);
        // Añade el dígito al StringBuilder
        sb.append(digit);
    }
    // Devuelve el identificador único corto como una cadena de texto
    return sb.toString();
};

    /**
 * Enumeración que representa los tipos de flauta disponibles.
 * Puede ser TRAVESERA o DULCE.
 */
public enum TipoFlauta {
    TRAVESERA, // Tipo de flauta travesera
    DULCE      // Tipo de flauta dulce
}

/**
 * Enumeración que representa los tipos de embocadura disponibles para la flauta.
 * Puede ser RECTA u OVALADA.
 */
public enum TipoEmbocadura {
    RECTA,    // Tipo de embocadura recta
    OVALADA   // Tipo de embocadura ovalada
}

/**
 * Enumeración que representa los tipos de llaves disponibles para la flauta.
 * Puede ser ABIERTAS o BARROCAS.
 */
public enum TipoLlaves {
    ABIERTAS,   // Tipo de llaves abiertas
    BARROCAS    // Tipo de llaves barrocas
}

/**
 * Enumeración que representa los tipos de cabeza disponibles para la flauta.
 * Puede ser ESTANDAR o CURVADA.
 */
public enum TipoCabeza {
    ESTANDAR,  // Tipo de cabeza estándar
    CURVADA    // Tipo de cabeza curvada
}

/**
 * Enumeración que representa los tamaños disponibles para la flauta.
 * Puede ser ESTANDAR o GRANDE.
 */
public enum Tamano {
    ESTANDAR,  // Tamaño estándar
    GRANDE     // Tamaño grande
}

    public void menu(){ //Menu principal del programa 
    int op = 0;
    do {
        System.out.println("----MENU----");
        System.out.println("¿Qué instrumento desea comprar?");
        System.out.println("1. Flautas");
        System.out.println("2. Saxofon");
        System.out.println("3. Monitorear ventas");
        try { // Utilizar try-catch para manejar la excepción de entrada inválida
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    flauta();
                    break;
                case 2:
                    saxofon();
                    break;
                case 3:
                    ventas();
                    break;
                default:
                    System.out.println("Escoja una opción válida.");
            }
        } catch (InputMismatchException e) { // Capturar la excepción de entrada inválida
            System.out.println("Ingrese un número entero");
            scanner.next(); 
        }
        
    } while (op != 0);
}
    
    public void flauta() {
        /**
        * Método para registrar la venta de flautas.
        * Permite al usuario seleccionar las características de la flauta a comprar, como el tipo,
        * color, marca, tipo de embocadura, tipo de llave, tipo de cabeza y tamaño, y luego registra
        * la venta generando un código único para la flauta y calculando el precio total de la compra.
        * Utiliza enumeraciones para representar las opciones de tipo de flauta, tipo de embocadura,
        * tipo de llave, tipo de cabeza y tamaño.
        */
        boolean si = true;
        String color = "";
        while (si) {
            System.out.println("Ingrese el tipo de flauta que desea. Travesera o Dulce");
            String instrumentoStr = scanner.next().toUpperCase(); // Convertir a mayúsculas para evitar problemas de comparación
            scanner.nextLine();
            TipoFlauta instrumento;
            try {
                instrumento = TipoFlauta.valueOf(instrumentoStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Escriba el instrumento justo como está en el texto de arriba");
                continue;
            }
            double precio = 0;
            switch (instrumento) { //Para todos los instrumentos hay casos para el tipo de pieza para el instrumento, dependiendo de la pieza se modifica el precio, en flautas para las piezas usamos enumeraciones
                case TRAVESERA: //Uso de enumeraciones
                    precio =  500000;
                    break;
                case DULCE: //Uso de enumeraciones
                    precio=  100000;
                    break;
            }
   
            while (si) {
                System.out.println("Escriba el color deseado (solo letras y espacios):");
                color = scanner.nextLine();

                // Dividir la entrada en palabras individuales
                String[] colores = color.split("\\s+");
        
                // Verificar si cada palabra es válida (solo letras)
                boolean colorValido = true;
                for (String palabra : colores) {
                    if (!Pattern.matches("^[a-zA-Z]+$", palabra)) {
                        colorValido = false;
                        break;
                    }
                }
        
                if (!colorValido) {
                    System.out.println("El formato del color es inválido. Por favor, ingrese solo letras y espacios.");
                    continue;
                } else {
                    // Unir las palabras en un solo string con un espacio como separador
                    color = String.join(" ", colores);
                    si = false; // Cambiamos el valor de si para salir del bucle
                }
            }

            System.out.println("Escriba la marca deseada");
            String marca = scanner.nextLine();

            System.out.println("Ingrese el tipo de embocadura que desea. Recta o Ovalada");
            String embocaduraStr = scanner.next().toUpperCase();
            TipoEmbocadura embocadura;
            try{
                embocadura = TipoEmbocadura.valueOf(embocaduraStr);
            }catch (IllegalArgumentException e){
                System.out.println("Escriba el instrumento justo como está en el texto de arriba");
                continue;
            }
            switch (embocadura) {
                case RECTA: //Uso de enumeraciones
                    precio= precio + 300000;
                    break;
                case OVALADA: //Uso de enumeraciones
                    precio= precio + 100000;
                    break;
            }

            System.out.println("Ingrese el tipo de llave que desea. Abiertas o Barrocas");
            String llaveStr = scanner.next().toUpperCase();
            TipoLlaves llave;
            try{
                llave = TipoLlaves.valueOf(llaveStr);
            }catch (IllegalArgumentException e){
                System.out.println("Escriba el dato justo como está en el texto de arriba");
                continue;
            }
            switch (llave) {
                case ABIERTAS: //Uso de enumeraciones
                    precio= precio + 30000;
                    break;
                case BARROCAS: //Uso de enumeraciones
                    precio= precio + 80000;
                    break;
            }

            System.out.println("Ingrese el tipo de cabeza que desea. Estándar o Curvada");
            String cabezaStr = scanner.next().toUpperCase();
            TipoCabeza cabeza;
            try{ //se usa el try catch para controlar mejor posibles errores
                cabeza = TipoCabeza.valueOf(cabezaStr);
            }catch (IllegalArgumentException e){
                System.out.println("Ingrese el dato justo como está en la parte de arriba");
                continue;
            }
            switch (cabeza) {
                case ESTANDAR: //Uso de enumeraciones
                    precio= precio + 50000;
                    break;
                case CURVADA: //Uso de enumeraciones
                    precio= precio + 65000;
            }
            System.out.println("Ingrese el tamaño que desea. Estándar o Grande");
            String tamañoStr = scanner.next().toUpperCase();
            Tamano tamaño;
            try{
                tamaño = Tamano.valueOf(tamañoStr);
            }catch (IllegalArgumentException e){ //Excepcion 
                System.out.println("Ingrese el dato justo como está en la parte de arriba");
                continue;
            }
            switch (tamaño) {
                case ESTANDAR: //Uso de enumeraciones
                    precio = precio + 100000;
                    break;
            
                case GRANDE: //Uso de enumeraciones
                    precio = precio + 200000;
                    break;
            }
            String codigoUnico = shortUuidGenerator.get(); //generar codigo 
            Flautas flauta = new Flautas(instrumentoStr, marca, color, precio, 0, embocaduraStr, llaveStr, cabezaStr, tamañoStr, codigoUnico);

            System.out.println("Escriba la cantidad de flautas que va a comprar");
            int cantidad = scanner.nextInt();
            flauta.setCantidad(cantidad);

            listaflautas.add(flauta); //añadimos la venta a la coleccion
            System.out.println("El total de la compra es de: " + flauta.calcularTotal());
            System.out.println("");
            System.out.println(flauta.toString());

            System.out.println("¿Desea tocar la flauta?");
            String tocar = scanner.next();
            if (tocar.equals("si")){
                flauta.tocarFlauta();
            }else if(tocar.equals("no")){
                System.out.println("Está bien, ¡disfrute su compra!");
            }
            break;
        }  
    }

    public void saxofon(){
        // Se crea una instancia de la clase Saxofon con parámetros genéricos y se inicializa como saxo
        Saxofon<?, ?, ?, ?> saxo = new Saxofon<String, String ,String ,String>(null, null, null, 0, 0, 
        null, null, null, null);
        
        // Bucle que permite al usuario ingresar información sobre saxofones y realizar compras
        while (true){
            // Se solicita al usuario ingresar el tipo de piano que desea (de cola o vertical)
            System.out.println("Ingrese el tipo de Saxofon que desea. Alto o Tenor");
            String instrumento = scanner.next();
            
            // Se inicializa el precio en 0
            double precio = 0;
            
            // Se determina el precio base según el tipo de saxofon seleccionado por el usuario
            if (instrumento.equals("Alto")){
                precio = 1500000;
            } else if (instrumento.equals("Tenor")) {
                precio = 1800000;
            } else {
                // Si el tipo de saxofon no es válido, se muestra un mensaje y se reinicia el bucle
                System.out.println("Escriba el instrumento justo como está en el texto de arriba");
                continue;
            }
            
            // Se solicita al usuario ingresar el color del saxofon
            System.out.println("Escriba el color deseado");
            String color = scanner.next();
            
            // Se establece el color en la instancia saxo
            saxo.setColor(color);
            
            // Se solicita al usuario ingresar la marca del saxofon
            System.out.println("Escriba la marca deseada");
            String marca=scanner.next();
            
            // Se establece la marca en la instancia saxo
            saxo.setMarca(marca);
    
            // Se solicita al usuario ingresar el tipo de boquilla que desea (ebonita o metal)
            System.out.println("Ingrese el tipo de boquilla que desea. Ebonita o Metal");
            String boquilla = scanner.next();
            
            // Se ajusta el precio según el tipo de teclado seleccionado por el usuario
            if(boquilla.equals("Ebonita")){
                precio += 100000;
            } else if (boquilla.equals("Metal")) {
                precio += 200000;
            } else {
                // Si el tipo de boquilla no es válido, se muestra un mensaje y se reinicia el bucle
                System.out.println("Escriba el tipo de teclado como se muestra en la parte de arriba");
                continue;
            }
            
            // Se establece el tipo de boquilla en la instancia saxo
            saxo.setAtributo(1, boquilla);
    
            // Se solicita al usuario ingresar el tipo de tudel que desea (estandar o metal)
            System.out.println("Ingrese el tipo de tudel que desea. Estandar o Metal");
            String tudel = scanner.next();
            
            // Se ajusta el precio según el tipo de tudel seleccionado por el usuario
            if(tudel.equals("Estandar")){
                precio += 200000;
            } else if (tudel.equals("Metal")) {
                precio += 300000;
            } else {
                // Si el tipo de tudel no es válido, se muestra un mensaje y se reinicia el bucle
                System.out.println("Escriba el tipo de tudel como se muestra en la parte de arriba");
                continue;
            }
            
            // Se establece el tipo de cuerda en la instancia saxo
            saxo.setAtributo(2, tudel);
    
            // Se solicita al usuario ingresar el tipo de caña que desea (madera o plastico)
            System.out.println("Ingrese el tipo de caña que desea. Madera o Plastico");
            String caña = scanner.next();
            
            // Se ajusta el precio según el tipo de caña seleccionado por el usuario
            if(caña.equals("Madera")){
                precio += 50000;
            } else if (caña.equals("Plastico")) {
                precio += 30000;
            } else {
                // Si el tipo de caña no es válido, se muestra un mensaje y se reinicia el bucle
                System.out.println("Escriba el tipo de marco como se muestra en la parte de arriba");
                continue;
            }
            
            // Se establece el tipo de caña en la instancia saxo
            saxo.setAtributo(3, caña);
    
            // Se solicita al usuario ingresar el tipo de abrazadera desea (tela o ligadura)
            System.out.println("Ingrese el tipo de abrazadera que desea. Tela o Ligadura");
            String abrazadera = scanner.next();
            
            // Se ajusta el precio según el tipo de abrazadera seleccionado por el usuario
            if(abrazadera.equals("Tela")){
                precio += 50000;
            } else if (abrazadera.equals("Ligadura")) {
                precio += 80000;
            } else {
                // Si el tipo de abrazadera no es válido, se muestra un mensaje y se reinicia el bucle
                System.out.println("Escriba el tipo de abrazadera como se muestra en la parte de arriba");
                continue;
            }
            
            // Se establece el tipo de abrazadera en la instancia saxo
            saxo.setAtributo(4, abrazadera);
            
            // Se muestra la información del saxofon ingresado por el usuario
            System.out.println(saxo.toString());
    
            // Se muestra el precio total del saxofon
            System.out.println("El precio del saofon es de: " + precio);
            
            // Se solicita al usuario ingresar la cantidad de saxofones que desea comprar
            System.out.println("Escriba la cantidad de saxofones que va a comprar");
            int cantidad = scanner.nextInt();
            
            // Se establece la cantidad y el precio total en la instancia saxo
            saxo.setCantidad(cantidad);
            saxo.setPrecio(precio);
    
            
            // Se muestra el precio total de la compra del saxofon
            System.out.println("El total de la compra es de: " + saxo.calcularTotal());
            System.out.println("");
            System.out.println("¿Desea afinar el saxofon?");
            String afinar = scanner.next();
            if (afinar.equals("si")){
                saxo.afinarSaxofon();
            }else if (afinar.equals("no")){
                System.out.println("Está bien, ¡disfrute su compra!");
            }
            
            // Se sale del bucle
            break;
        }
    }

    /**
 * Método para mostrar todas las ventas de flautas almacenadas en la lista.
 * Imprime un encabezado indicando que se mostrará la lista de ventas.
 * Luego, itera sobre cada venta de flauta en la lista y la imprime en la consola.
 */
public void mostrarVentas() {
    // Imprime un encabezado indicando que se mostrará la lista de ventas
    System.out.println("Lista de ventas:");
    System.out.println("");

    // Itera sobre cada venta de flauta en la lista y la imprime en la consola
    for (Flautas s : listaflautas) {
        System.out.println(s);
    }
}

    /**
 * Método para filtrar y mostrar las ventas de flautas con embocadura RECTA.
 * Se crea un stream de flautas a partir de la lista "listaflautas".
 * Las flautas en el stream se ordenan según el instrumento.
 * Se filtran las ventas de flautas con embocadura RECTA.
 * Se mapean las ventas filtradas para obtener solo los códigos de venta.
 * Los códigos de venta se recopilan en una lista.
 * Se imprimen las ventas filtradas.
 */
public void filtrarVentas() {
    // Se crea un stream de flautas a partir de la lista "listaflautas"
    Stream<Flautas> streamFlautas = listaflautas.stream();
    // Se ordenan las ventas de flautas en el stream según el instrumento
    Stream<Flautas> ventasOrdenadas = streamFlautas.sorted(Comparator.comparing(Flautas::getInstrumento));

    // Se filtran las ventas de flautas con embocadura RECTA
    List<String> ventasFiltradas = ventasOrdenadas.filter(e -> e.getTipoEmbocadura().equals("RECTA"))
            // Se mapean las ventas filtradas para obtener solo los códigos de venta
            .map(e -> String.format("Codigo: %s", e.getCodigo()))
            // Los códigos de venta se recopilan en una lista
            .collect(Collectors.toList());

    // Se imprimen las ventas filtradas
    ventasFiltradas.forEach(System.out::println);
}

    /**
 * Método para eliminar una venta de la colección de flautas a través del código de la venta.
 * Solicita al usuario que ingrese el código vinculado a la venta que desea eliminar.
 * Luego, busca en la lista de flautas existentes y elimina la venta si se encuentra.
 * Muestra un mensaje indicando que la venta ha sido eliminada si se encontró y eliminó correctamente.
 * Si no se encuentra ninguna venta con el código proporcionado, muestra un mensaje indicando que el documento no se encontró.
 */
public void eliminarVenta() {
    // Solicita al usuario que ingrese el código vinculado a la venta que desea eliminar
    System.out.println("Ingrese código vinculado a la venta:");
    String codigo = scanner.next();

    // Variable para indicar si se encontró la venta con el código proporcionado
    boolean encontrado = false;

    // Itera sobre la lista de flautas
    for (Flautas flautas : listaflautas) {
        // Verifica si el código de la venta actual coincide con el código proporcionado por el usuario
        if (flautas.getCodigo().equals(codigo)) {
            // Elimina la venta de la colección de flautas
            listaflautas.remove(flautas);
            // Indica que se ha encontrado y eliminado la venta
            encontrado = true;
            System.out.println("Venta eliminada");
            // Sale del bucle for
            break;
        }
    }

    // Si no se encontró ninguna venta con el código proporcionado, muestra un mensaje
    if (!encontrado) {
        System.out.println("Documento no encontrado");
    }
}

    /**
 * Método para buscar una venta específica a través de su código.
 * Solicita al usuario que ingrese el código vinculado a la venta que desea ver.
 * Luego, busca en la lista de flautas existentes y muestra los detalles de la venta si se encuentra.
 * Si no se encuentra ninguna venta con el código proporcionado, muestra un mensaje indicando que el documento no se encontró.
 */
public void buscarVenta() {
    // Solicita al usuario que ingrese el código vinculado a la venta que desea ver
    System.out.println("Ingrese el código vinculado a la venta que desea ver:");
    String codigo = scanner.next();

    // Variable para indicar si se encontró la venta con el código proporcionado
    boolean encontrado = false;

    // Itera sobre la lista de flautas
    for (Flautas flautas : listaflautas) {
        // Verifica si el código de la venta actual coincide con el código proporcionado por el usuario
        if (flautas.getCodigo().equals(codigo)) {
            // Muestra un mensaje indicando que se encontró la venta y muestra los detalles de la misma
            System.out.println("VENTA ENCONTRADA");
            System.out.println(flautas.toString());
            System.out.println("");
            // Indica que se ha encontrado la venta
            encontrado = true;
            // Sale del bucle for
            break;
        }
    }

    // Si no se encontró ninguna venta con el código proporcionado, muestra un mensaje
    if (!encontrado) {
        System.out.println("Documento no encontrado.");
    }
}

    /**
 * Método para modificar los detalles de una flauta existente.
 * Solicita al usuario un código único asignado a la venta que desea modificar.
 * Luego, busca en la lista de flautas existentes y permite al usuario actualizar
 * el color, tipo de embocadura, tipo de llaves, tipo de cabeza y tamaño de la flauta.
 */
public void modificarFlautas() {
    // Solicita al usuario ingresar el código único asignado a la venta que desea modificar
    System.out.println("Ingrese código único asignado a la venta que desea modificar:");
    String codigo = scanner.next();
    // Variable para indicar si se encontró la flauta con el código proporcionado
    boolean encontrado = false;
    // Itera sobre la lista de flautas
    for (Flautas flautas : listaflautas) {
        // Verifica si el código de la flauta actual coincide con el código proporcionado por el usuario
        if (flautas.getCodigo().equals(codigo)) {
            // Solicita al usuario ingresar los nuevos detalles de la flauta
            System.out.println("Ingrese el nuevo color:");
            String color = scanner.nextLine();
            System.out.println("Ingrese nuevo tipo de embocadura. RECTA; OVALADA");
            String embo = scanner.nextLine();
            System.out.println("Ingrese nuevo tipo de llaves. ABIERTAS; BARROCAS");
            String llaves = scanner.nextLine();
            System.out.println("Ingrese nuevo tipo de cabeza. ESTANDAR; CURVADA");
            String cabeza = scanner.nextLine();
            System.out.println("Ingrese nuevo tamaño. ESTANDAR; GRANDE");
            String tamaño = scanner.nextLine();

            // Actualiza los detalles de la flauta con los valores ingresados por el usuario
            flautas.setColor(color);
            flautas.setTipoEmbocadura(embo);
            flautas.setTipoDeLlaves(llaves);
            flautas.setTipodeCabeza(cabeza);
            flautas.setTamaño(tamaño);
            // Indica que se ha encontrado la flauta
            encontrado = true;
            System.out.println("Flauta modificada.");
            // Sale del bucle for
            break;
        }
    }
    // Si no se encontró la flauta con el código proporcionado, muestra un mensaje
    if (!encontrado) {
        System.out.println("Código no encontrado");
    }
}

    public void ventas(){ //menu para las ventas de la coleccion
        int op = 0;
        do {
            System.out.println("----MENU----");
            System.out.println("1. Mostrar ventas");
            System.out.println("2. Filtrar ventas de flautas con embocadura estandar");
            System.out.println("3. Buscar venta");
            System.out.println("4. Eliminar venta");
            System.out.println("5. Modificar flauta");
            System.out.println("6. Volver al menu anterior");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    mostrarVentas();
                    break;
                case 2:
                    filtrarVentas();  
                    break;
                case 3:
                    buscarVenta();
                    break;
                case 4:
                    eliminarVenta();
                    break;
                case 5: 
                    modificarFlautas();
                case 6:
                    System.out.println("Volviendo al menú anterior");
                    return;
                default:
                    System.out.println("Escoja una opción valida");
            } 
        } while (op != 0);
    }
}

