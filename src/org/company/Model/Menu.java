package org.company.Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by marco on 10/5/17.
 */
public class Menu {

    private ArrayList<Producto> productos;

    public Menu(){
        productos = new ArrayList<>();
    }

    public void añadirProducto(Producto producto){
        if(producto != null){
            productos.add(producto);
        }
    }

    public void listaProducto(){
        for (Producto producto: productos){
            System.out.println(producto);
        }
    }
    public void ordenacionPorNombre(){
        Collections.sort(productos, new Producto());

        listaProducto();
    }

    public void ordenacionPorPrecio(){
        Collections.sort(productos, Producto.comparadorPorPrecio);

        listaProducto();
    }

    public void ordenacionPorPeso(){
        Collections.sort(productos, Producto.comparadorPorPeso);

        listaProducto();
    }

    public void ordenacionPorVolumen(){
        Collections.sort(productos, Producto.comparadorPorVolumen);

        listaProducto();
    }
}
