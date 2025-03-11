package org.example;

public class Producto {
    private String codigo;
    private String nombre;
    private int precio;
    private int cantidad;

    public Producto() {
    }

    public Producto(String codigo, String nombre, int precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void datosProducto() {
        System.out.println("Codigo del producto: " + codigo);
        System.out.println("Nombre del producto: " + nombre);
        System.out.println("Precio del producto: " + precio);
        System.out.println("Cantidad del producto: " + cantidad);
    }
    
    public void venderProducto(Producto producto, int cantidadVenta) {
        if (producto.getCantidad() >= cantidadVenta) {
            System.out.println("Venta exitosa");
            cantidad -= cantidadVenta;
        }else {
            System.out.println("No hay suficiente cantidad de " + producto.getNombre());
        }
    }

    public void reponerStock(int cantidadReponer) {
        System.out.println("Cantidad anterior de " + this.nombre + ": " + this.cantidad);
        this.cantidad += cantidadReponer;
        System.out.println("Nueva cantidad de " + this.nombre + ": " + this.cantidad);
    }

    public void aplicarDescuento(int cantidadDescuento) {
        int temporal = this.precio*cantidadDescuento/100;
        this.precio -= temporal;
        System.out.println("Nuevo precio de " + this.nombre + ": " + this.precio);
    }

    public void incrementarPrecio(int cantidadIncrementado) {
        if (cantidadIncrementado > 0) {
            this.precio = (this.precio * (cantidadIncrementado + 100)) / 100;
            System.out.println("Nuevo precio de " + this.nombre + ": " + this.precio);
        }else {
            System.out.println("Valor no valido, fallo en la actualizacion de precio");
        }
    }

    public int valorInventario(Producto producto) {
        return producto.getCantidad()*producto.getPrecio();
    }

}
