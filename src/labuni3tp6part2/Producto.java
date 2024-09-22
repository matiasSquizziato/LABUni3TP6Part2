/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labuni3tp6part2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author matiSqui
 */
public class Producto implements Comparable<Producto> {

    private Categoria categoria;
    private int codigo;
    private String descrip;
    private double precio;
    private int stock;
    

    // Constructo
    public Producto(Categoria categoria, int codigo, String descrip, double precio, int stock) {
        this.categoria = categoria;
        this.codigo = codigo;
        this.descrip = descrip;
        this.precio = precio;
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
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
        return "Producto{" + "categoria=" + categoria + ", codigo=" + codigo + ", descrip=" + descrip + ", precio=" + precio + ", stock=" + stock + '}';
    }


    
    
    public static TreeSet<Producto> listaProductos = new TreeSet<>();

    @Override
    public int compareTo(Producto o) {

        return Integer.compare(this.codigo, o.codigo);

    }
    
    
    //cargo los elementos
    public void cargarElementos(Producto nProducto){
        if (listaProductos.add(nProducto) == true ) {
            JOptionPane.showMessageDialog(null,"Producto: " + nProducto.getDescrip() + " cargado");
            System.out.println("Producto: " + nProducto.getDescrip()+ " cargado");
        } else {
            JOptionPane.showMessageDialog(null,"Producto código: " + nProducto.codigo+" ya existente");

        }
    }

    //busco el producto por el codigo
    public static Producto buscarProducto(int codigo) {
        if (listaProductos == null || listaProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista de productos está vacía.");
            return null;
        }

        for (Producto producto : listaProductos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null; // Si no se encuentra el producto, devuelve null
    }
    
 
    //Ordeno la lista por categoria
    public static void ordenarPorCategoria() {
        // Crear un TreeSet ordenado por categoría
        TreeSet<Producto> productosPorCategoria = new TreeSet<>(new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return p1.getCategoria().compareTo(p2.getCategoria());
            }
        });

        // Añadir todos los productos al nuevo TreeSet
        productosPorCategoria.addAll(listaProductos);

        // Mostrar los productos ordenados por categoría
//        for (Producto producto : productosPorCategoria) {
//            System.out.println(producto);
//        }
    }

    
    
    
}


