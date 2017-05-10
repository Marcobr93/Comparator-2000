package org.company.Controller;

import org.company.Model.Menu;
import org.company.Model.Producto;

import java.util.Scanner;

/**
 * Created by marco on 10/5/17.
 */
public class ProductosApp {

    private Menu menu = new Menu();


    public void comienzoApp(){
        int opcion;

        while ((opcion = mostrarMenu() ) !=0){
            switch (opcion){
                case 1:
                    menu.añadirProducto(preguntarProductoInfo());
                    break;
                case 2:
                    menu.listaProducto();
                    break;
                case 3:
                    menu.ordenacionPorNombre();
                    break;
                case 4:
                    menu.ordenacionPorPrecio();
                    break;
                case 5:
                    menu.ordenacionPorPeso();
                    break;
                case 6:
                    menu.ordenacionPorVolumen();
                    break;
            }
        }
    }

    private Producto preguntarProductoInfo() {
        Scanner scanner = new Scanner(System.in);
        String nombreProducto;
        double precioProducto;
        double pesoProducto;
        double volumenProducto;

        do {
            System.out.println("Nombre del producto: ");
            nombreProducto = scanner.next().trim().replaceAll("\\s+", " ");
        } while (nombreProducto.equals(""));

        scanner.nextLine();

        do {
            System.out.println("Precio del producto: ");
            precioProducto = scanner.nextDouble();
        } while (precioProducto < 0.0);

        do {
            System.out.println("Peso del producto: ");
            pesoProducto = scanner.nextDouble();
        } while (pesoProducto < 0.0);

        do {
            System.out.println("Volúmen del producto: ");
            volumenProducto = scanner.nextDouble();
        } while (volumenProducto < 0.0);

        return new Producto(nombreProducto, precioProducto, pesoProducto, volumenProducto);

    }

    private int mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("*****************************");
        System.out.println("* 1 - Añadir producto       *");
        System.out.println("* 2 - Lista de productos    *");
        System.out.println("* 3 - Ordenados por nombre  *");
        System.out.println("* 4 - Ordenados por precio  *");
        System.out.println("* 5 - Ordenados por peso    *");
        System.out.println("* 6 - Ordenados por volúmen *");
        System.out.println("* 0 - Salir                 *");
        System.out.println("*****************************");
        System.out.println("Opción: ");

        opcion = scanner.nextInt();

        return opcion;
    }
}
