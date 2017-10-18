
package exercicio11;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import static java.lang.String.format;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Metodos {
    
     Product producto = new Product();
     String[] codes={"p1","p2","p3"};
     String[] descricion ={"parafusos","cravos ","tachas"};
     int[] prices ={3,4,5};
     RandomAccessFile fichero = null;
     
     public void lecturaEscritura(){
         
         try {    
             fichero =  new RandomAccessFile("Produto.txt","rw");
            
            for(int i=0;i<3;i++){
            String formateoCodes =    String.format("%-"+3+"s",codes[i]);    
                System.out.print(formateoCodes);
                fichero.writeChars(formateoCodes);
            
           
              String formateoDes =    String.format("%-"+10+"s",descricion[i]);  
              fichero.writeChars(formateoDes);
                System.out.print(formateoDes);
            
              fichero.writeInt(prices[i]);
                System.out.println(prices[i]);
            }
         
             
             //fichero.close();
            
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
     
     public void ler(){
         String cod = "";
         String desc = "";
         int pre =0;
         
         try {
             fichero.seek(0);
                      for(int i=0;i<3;i++){
             
             cod +=fichero.readChar();
             
                      }
                      
         for(int i=0;i<10;i++){
             
             desc +=fichero.readChar();
         }    
             
         pre = fichero.readInt();
         
             
             
             
             
         } catch (IOException ex) {
             Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        
     }
     
     public Product cargarProducto(Product prod){
          String cod = "";
         String desc = "";
         int pre =0;
         try {
             fichero.seek(30);
             for(int i =0;i<3;i++){
                cod +=fichero.readChar();
                
             }
             producto.setCodigo(cod.trim());
             for(int i=0;i<10;i++){
                
               desc +=  fichero.readChar();
               
                 
             }
             producto.setDescripcion(desc.trim());
             pre =fichero.readInt();
             producto.setPrezo(pre);
             
             
         } catch (IOException ex) {
             Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
  
         return producto;
     }
}
