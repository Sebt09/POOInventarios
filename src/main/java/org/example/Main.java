package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    boolean salir = true;
    int opcion = 0;

    //Variables para crear un nuevo producto
    String codigoTemporal = "";
    String nombreTemporal = "";
    int precioTemporal = 0;
    int cantidadTemporal = 0;

    //Variables
    String codigo = "";
    int cantidadVenta = 0;
    int stockReponer = 0;
    int descuento = 0;
    int aumento = 0;
    int valorInventario = 0;

    List<Producto> listaProductos = new ArrayList<>();

    do{
        boolean productoExiste = false;
        System.out.println("------------------------------------------");
        System.out.println("\t BIENVENIDO AL SISTEMA DE INVENTARIOS" +
                "\n1. Crear Producto" +
                "\n2. Vender Producto" +
                "\n3. Reponer Stock de producto" +
                "\n4. Aplicar descuento a un producto" +
                "\n5. Ver informacion de un producto" +
                "\n6. Aumentar precio de un producto" +
                "\n7. Calcular el valor total en inventario" +
                "\n8. Eliminar productos por codigo" +
                "\n9. Salir");
        opcion = sc.nextInt();

        switch(opcion){
            case 1:
                System.out.println("Ingrese el codigo del producto");
                codigoTemporal = sc.next();
                System.out.println("Ingrese el nombre del producto");
                nombreTemporal = sc.next();
                System.out.println("Ingrese el precio del producto");
                precioTemporal = sc.nextInt();
                System.out.println("Ingrese el cantidad del producto");
                cantidadTemporal = sc.nextInt();

                for (int i = 0; i < listaProductos.size(); i++){
                    if (listaProductos.get(i).getCodigo().equals(codigoTemporal)){
                        System.out.println("Codigo de producto: " + codigoTemporal + " ya existe");
                        productoExiste = true;
                    }
                }
                if (!productoExiste){
                    Producto productoTemporal = new Producto(codigoTemporal, nombreTemporal, precioTemporal, cantidadTemporal);
                    listaProductos.add(productoTemporal);
                    System.out.println("Producto creado exitosamente");
                    productoTemporal.datosProducto();
                }
                break;

            case 2:
                System.out.println("Ingrese el codigo del producto");
                codigo = sc.next();
                for (int i = 0; i < listaProductos.size(); i++){
                    if (codigo.equals(listaProductos.get(i).getCodigo())){
                        System.out.println("Ingrese la cantidad de " + listaProductos.get(i).getNombre() + " que desea comprar: ");
                        cantidadVenta = sc.nextInt();
                        listaProductos.get(i).venderProducto(listaProductos.get(i), cantidadVenta);
                        productoExiste = true;
                    }
                }
                if (!productoExiste){
                    System.out.println("Producto no encontrado");
                }
                break;

            case 3:
                System.out.println("Ingrese el codigo del producto");
                codigo = sc.next();
                for (int i = 0; i < listaProductos.size(); i++) {
                    if (codigo.equals(listaProductos.get(i).getCodigo())) {
                        System.out.println("Ingrese la cantidad de " + listaProductos.get(i).getNombre() + " que va a adicionar al stock");
                        stockReponer = sc.nextInt();
                        listaProductos.get(i).reponerStock(stockReponer);
                        productoExiste = true;
                        System.out.println("****************************");
                        System.out.println("DATOS ACTUALIZADOS");
                        listaProductos.get(i).datosProducto();
                    }
                }
                if (!productoExiste){
                    System.out.println("Producto no encontrado");
                }
                break;

            case 4:
                System.out.println("Ingrese el codigo del producto");
                codigo = sc.next();
                for (int i = 0; i < listaProductos.size(); i++) {
                    if (codigo.equals(listaProductos.get(i).getCodigo())) {
                        System.out.println("Ingrese el descuento del producto (SOLO EL NUMERO)");
                        descuento = sc.nextInt();
                        listaProductos.get(i).aplicarDescuento(descuento);
                        System.out.println("****************************");
                        System.out.println("DATOS ACTUALIZADOS");
                        listaProductos.get(i).datosProducto();
                        productoExiste = true;
                    }
                }
                if (!productoExiste){
                    System.out.println("Producto no encontrado");
                }
                break;

            case 5:
                System.out.println("Ingrese el codigo del producto");
                codigo = sc.next();
                for (int i = 0; i < listaProductos.size(); i++) {
                    if (codigo.equals(listaProductos.get(i).getCodigo())) {
                        listaProductos.get(i).datosProducto();
                        productoExiste = true;
                    }
                }
                if (!productoExiste){
                    System.out.println("Producto no encontrado");
                }
                break;

            case 6:
                System.out.println("Ingrese el codigo del producto");
                codigo = sc.next();
                for (int i = 0; i < listaProductos.size(); i++) {
                    if (codigo.equals(listaProductos.get(i).getCodigo())) {
                        System.out.println("Ingrese el porcentaje de aumento para " + listaProductos.get(i).getNombre());
                        aumento = sc.nextInt();
                        listaProductos.get(i).incrementarPrecio(aumento);
                        System.out.println("****************************");
                        System.out.println("DATOS ACTUALIZADOS");
                        listaProductos.get(i).datosProducto();
                        productoExiste = true;
                    }
                }
                if (!productoExiste){
                    System.out.println("Producto no encontrado");
                }
                break;

            case 7:
                for (int i = 0; i < listaProductos.size(); i++) {
                    valorInventario += listaProductos.get(i).valorInventario(listaProductos.get(i));
                }
                System.out.println("Valor en inventario: $" + valorInventario);
                valorInventario = 0;
                break;

            case 8:
                System.out.println("Ingrese el codigo del producto");
                codigo = sc.next();
                for (int i = 0; i < listaProductos.size(); i++) {
                    if (codigo.equals(listaProductos.get(i).getCodigo())) {
                        listaProductos.remove(i);
                        System.out.println("Producto eliminado");
                        productoExiste = true;
                    }
                }
                if (!productoExiste){
                    System.out.println("Producto no encontrado");
                }
                break;

            case 9:
                System.out.println("Saliendo...");
                salir = false;
                break;

            default:
                System.out.println("Opcion no valida");
                break;
        }
    }while(salir);
    }
}