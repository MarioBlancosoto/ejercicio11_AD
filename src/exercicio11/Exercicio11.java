/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio11;

/**
 *
 * @author mblancosoto
 */
public class Exercicio11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Metodos  metodos = new Metodos();
      
      metodos.lecturaEscritura();
      metodos.ler();
      Product producto = new Product();
      producto=metodos.cargarProducto(producto);
        System.out.println(producto.toString());
    }
    
    
    
}
