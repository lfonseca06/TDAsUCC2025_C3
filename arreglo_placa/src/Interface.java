

import modelo.Arreglo;
import controlador.Placa;


/**
 *
 * @author Leonardo
 */
public class Interface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          // Crear el modelo
          Arreglo arreglo= new Arreglo();

          // Crear el controlador y pasarle el modelo
          Placa placa = new Placa(arreglo);
          placa.executeMenu();
          
    }
    
}
