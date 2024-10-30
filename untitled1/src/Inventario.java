import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Inventario implements Interfaz{
    private final List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }
    @Override
    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        } else {
            System.out.println("Error: No se puede agregar un producto nulo.");
        }
    }
    @Override
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Productos:");
            for (Producto producto : productos) {
                System.out.println(producto.toString());
            }
        }
    }
    @Override
    public void actualizarProducto(String nombre) {
        Scanner scanner = new Scanner(System.in);
        for (Producto producto : productos) {
            int opc = 0;
            do {
                if (producto.getNombre().equals(nombre)) {
                    System.out.println("Actualizar Producto:\n 1 => Cantidad\n 2 => Precio\n 3 => Cantidad y Precio\n 4 => Salir");
                    try {
                        opc = Validador.validarOpcion3(scanner.nextInt());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        scanner.nextLine();
                    }catch (InputMismatchException e){
                        opc=0;
                        scanner.nextLine();
                    }
                    if (opc == 1) {
                        int nstock = 0;
                        scanner.nextLine();
                        while (nstock == 0){
                            System.out.println("Ingrese la nueva cantidad del producto:");
                            try {
                                nstock = Validador.validarStock(scanner.nextInt());
                            }catch (IllegalArgumentException e){
                                System.out.println(e.getMessage());
                            }catch (InputMismatchException e){
                                System.out.println("Opcion Invalida. Se espera un numero");
                                scanner.nextLine();
                            }
                        }
                        producto.setStock(nstock);
                        System.out.println("Producto actualizado correctamente.");
                        return;
                    } else if (opc == 2) {
                        float nprecio = 0f;
                        while (nprecio <= 0f) {
                            System.out.println("Ingrese el nuevo precio del producto:");
                            try {
                                nprecio = Validador.validarPrecio(scanner.nextFloat());
                            }catch (IllegalArgumentException e){
                                System.out.println(e.getMessage());
                            }catch (InputMismatchException e) {
                                System.out.println("El decimal debe identificarse con una coma (,)");
                                scanner.next();
                            }
                        }
                        producto.setPrecio(nprecio);
                        System.out.println("Producto actualizado correctamente.");
                        return;
                    } else if (opc == 3) {
                        int nstock = 0;
                        scanner.nextLine();
                        while (nstock == 0){
                            System.out.println("Ingrese la nueva cantidad del producto:");
                            try {
                                nstock = Validador.validarStock(scanner.nextInt());
                            }catch (IllegalArgumentException e){
                                System.out.println(e.getMessage());
                            }catch (InputMismatchException e){
                                System.out.println("Opcion Invalida. Se espera un numero");
                                scanner.nextLine();
                            }
                        }
                        float nprecio = 0f;
                        while (nprecio <= 0f) {
                            System.out.println("Ingrese el nuevo precio del producto:");
                            try {
                                nprecio = Validador.validarPrecio(scanner.nextFloat());
                            }catch (IllegalArgumentException e){
                                System.out.println(e.getMessage());
                            }catch (InputMismatchException e) {
                                System.out.println("El decimal debe identificarse con una coma (,)");
                                scanner.next();
                            }
                        }
                        producto.setStock(nstock);
                        producto.setPrecio(nprecio);
                        System.out.println("Producto actualizado correctamente.");
                        return;
                    } else {
                        int opcion = 0;
                        while (opcion == 0){
                            System.out.println("Estas seguro que deseas salir? 1-Si / 2-No");
                            try {
                                opcion = Validador.validarOpcion2(scanner.nextInt());
                                if (opcion == 1){
                                    System.out.println("Saliendo...");
                                    return;
                                }else {
                                    opc = 0;
                                }
                            }catch (IllegalArgumentException e){
                                System.out.println(e.getMessage());
                            }catch (InputMismatchException e){
                                System.out.println("Ingrese lo pedido 1-2");
                                scanner.nextLine();
                                return;
                            }
                        }

                    }

                } else {
                    System.out.println("Error: El producto no existe en el inventario.");
                    break;
                }
            }while (opc != 4);

        }

    }
    @Override
    public void eliminarProducto(String nombre) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(nombre)) {
                productos.remove(i);
                System.out.println("Producto eliminado correctamente.");
                return;
            }
        }
        System.out.println("Error: El producto no existe en el inventario.");
    }
}