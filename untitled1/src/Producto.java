public class Producto {
    private String nombre;
    private Float precio;
    private int stock;

    public Producto(String nombre, int stock, Float precio){
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "...............\n Nombre = " + nombre + "\n Cantidad = " + stock + "\n Precio = " + precio;
    }
}
