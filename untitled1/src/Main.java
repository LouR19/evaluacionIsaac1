import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion = 0;
        do {
            System.out.println(".....Inventario.....\n1. => Agregar.\n2. => Mostrar.\n3. => Actualizar.\n4. => Borrar.\n5. => Salir\nElija una opción:");
                try {
                    opcion = Validador.validarOpcion(scanner.nextInt());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    opcion = 0;
                    scanner.nextLine();
                }catch (InputMismatchException e){
                    System.out.println(e.getMessage());
                    opcion = 0;
                    scanner.nextLine();
                }
            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    String nombre = null;
                    while (nombre == null){
                        System.out.println("Ingrese nombre del producto:");
                        try {
                            nombre = Validador.validarNombre(scanner.nextLine());
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    int stock = 0;
                    //scanner.nextLine();
                    while (stock == 0){
                        System.out.println("Ingrese cantidad del producto:");
                        try {
                            stock = Validador.validarStock(scanner.nextInt());
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }catch (InputMismatchException e){
                            System.out.println("Opcion Invalida. Se espera un numero");
                            scanner.nextLine();
                        }
                    }
                    float precio = 0f;
                    while (precio <= 0f) {
                        System.out.println("Ingrese precio del producto:");
                        try {
                            precio = Validador.validarPrecio(scanner.nextFloat());
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }catch (InputMismatchException e) {
                            System.out.println("El decimal debe identificarse con una coma (,)");
                            scanner.next();
                        }
                    }
                    Producto nuevoProducto = new Producto(nombre, stock, precio);
                    inventario.agregarProducto(nuevoProducto);
                    break;
                case 2:
                    inventario.mostrarProductos();
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del producto a actualizar:");
                    String Actualizar = scanner.next();
                    inventario.actualizarProducto(Actualizar);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del producto a borrar:");
                    String Borrar = scanner.next();
                    inventario.eliminarProducto(Borrar);
                    break;
                case 5:
                    int opc = 0;
                    while (opc == 0){
                        System.out.println("Estas seguro que deseas salir? 1-Si / 2-No");
                        try {
                            opc = Validador.validarOpcion2(scanner.nextInt());
                            if (opc == 1){
                                System.out.println("Saliendo...");
                                return;
                            }else if (opc == 2){
                                opcion = 0;
                            }
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }catch (InputMismatchException e){
                            System.out.println("Ingrese lo pedido 1-2");
                            scanner.nextLine();
                        }
                    }
                    break;
                default:
                    break;
            }
        } while (opcion != 5);
    }
}