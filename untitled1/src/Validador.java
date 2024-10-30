import java.util.InputMismatchException;

public class Validador {
    public static int validarOpcion(int opcion) throws IllegalArgumentException {
        try {
            if (opcion < 1 || opcion > 5) {
                throw new IllegalArgumentException("Opción inválida. Debe ingresar un número entre 1 y 5.");
            }
            return opcion;
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Error: Debe ingresar un número entero.");
        }
    }
    public static float validarPrecio(float precio) throws IllegalArgumentException {
        try{
            if (precio <= 0f) {
                throw new IllegalArgumentException("El precio debe ser mayor a cero.");
            }
            return precio;
        } catch (InputMismatchException e){
            throw new IllegalArgumentException("Error: Debe ingresar un número decimal.");
        }
    }
    public static String validarNombre(String nombre) throws IllegalArgumentException{

        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑäëïöüÄËÏÖÜ]+")){
            throw new IllegalArgumentException("Opcion invalida. Se espera letras Aa-Zz");
        }
        return nombre;
    }
    public static int validarStock(int stock) throws IllegalArgumentException{

        try {
            if (stock < 1) {
                throw new IllegalArgumentException("Opción inválida. Debe ingresar un número entero");
            }
            return stock;
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Error: Debe ingresar un número entero.");
        }

    }
    public static int validarOpcion2(int opcion) throws IllegalArgumentException {
        try {
            if (opcion < 1 || opcion > 2) {
                throw new IllegalArgumentException("Opción inválida. Debe ingresar un número entre 1 y 2.");
            }
            return opcion;
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Error: Debe ingresar un número entero.");
        }
    }
    public static int validarOpcion3(int opc) throws IllegalArgumentException {
        try {
            if (opc < 1 || opc > 4) {
                throw new IllegalArgumentException("Opción inválida. Debe ingresar un número entre 1 y 4.");
            }
            return opc;
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Error: Debe ingresar un número entero.");
        }
    }

}