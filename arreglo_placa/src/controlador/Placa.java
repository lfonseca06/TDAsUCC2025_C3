package controlador;

import modelo.Arreglo;

/**
 *
 * @author Leonardo
 */
public class Placa {
    private Arreglo arreglo;

    public Placa (Arreglo arreglo) {
        this.arreglo = arreglo;
    }

    public void executeMenu(){
        arreglo.viewMenu();
    }

}
