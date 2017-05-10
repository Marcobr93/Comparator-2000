package org.company.Model;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by marco on 10/5/17.
 */
public class Producto implements Comparable<Producto>, Comparator<Producto>{
    private String nombreProducto;
    private double precioProducto;
    private double pesoProducto;
    private double volumenProducto;

    // Constructores

    public Producto() {
    }

    public Producto(String nombreProducto, double precioProducto, double pesoProducto, double volumenProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.pesoProducto = pesoProducto;
        this.volumenProducto = volumenProducto;
    }

    // Accesores

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        if (nombreProducto.equals("")){
            this.nombreProducto = "Sin nombre";
        }else{
            this.nombreProducto = nombreProducto;
        }
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        if(precioProducto < 0){
            precioProducto = 0.0;
        }else{
            this.precioProducto = precioProducto;
        }
    }

    public double getPesoProducto() {
        return pesoProducto;
    }

    public void setPesoProducto(double pesoProducto) {
        if(pesoProducto < 0){
            pesoProducto = 0.0;
        }else{
            this.pesoProducto = pesoProducto;
        }
    }

    public double getVolumenProducto() {
        return volumenProducto;
    }

    public void setVolumenProducto(double volumenProducto) {
        if(volumenProducto < 0){
            volumenProducto = 0.0;
        }else {
            this.volumenProducto = volumenProducto;
        }
    }

    @Override
    public String toString() {
        return "Producto:'" + nombreProducto + '\'' +
                ", precio producto: " + precioProducto +
                ", peso producto: " + pesoProducto +
                ", volumen producto: " + volumenProducto;
    }

    // Comparadores

    @Override
    public int compareTo(Producto producto) {
        return Double.compare(this.getPrecioProducto(), producto.getPrecioProducto());
    }


    @Override
    public int compare(Producto o1, Producto o2) {
        int res;

        res = o1.getNombreProducto().compareToIgnoreCase(o2.getNombreProducto());
        if(res != 0){
            return res;
        }
        return Double.compare(o1.getPrecioProducto(), o2.getPrecioProducto());
    }

    public static Comparator<Producto> comparadorPorPrecio = new Comparator<Producto>() {
        @Override
        public int compare(Producto o1, Producto o2) {
            return (int)(o2.getPrecioProducto() - o1.getPrecioProducto());
        }
    };

    public static Comparator<Producto> comparadorPorPeso = new Comparator<Producto>() {
        @Override
        public int compare(Producto o1, Producto o2) {
            return (int)(o2.getPesoProducto() - o1.getPesoProducto());
        }
    };

    public static Comparator<Producto> comparadorPorVolumen = new Comparator<Producto>() {
        @Override
        public int compare(Producto o1, Producto o2) {
            return (int)(o2.getVolumenProducto() - o1.getVolumenProducto());
        }
    };

    @Override
    public boolean equals(Object obj) {
        if( this == obj ) { return true; }

        if ( obj == null ) { return false; }

        if ( this.getClass() != obj.getClass() ) { return false; }

        Producto p = (Producto) obj;

        // Se consideran dos productos iguales si tienen el mismo nombre del producto
        return Objects.equals(this.getNombreProducto(), p.getNombreProducto());
    }


}
