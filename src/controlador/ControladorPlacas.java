package controlador;
import modelo.Placa;
import vista.VistaPlaca;
import java.util.Random;

/**
 *
 * @author Leonardo
 */
public class ControladorPlacas {
    private Placa[] placas;
    private int contador;
    private VistaPlaca vista;

    public ControladorPlacas(int tamaño, VistaPlaca vista) {
        placas = new Placa[tamaño];
        this.vista = vista;
        contador = 0;
    }

    private boolean validarPlaca(String placa) {
        return placa.matches("[A-Z]{3}[0-9]{3}");
    }
    
    private String generarPlacaAleatoria() {
        Random rand = new Random();
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder placa = new StringBuilder();
        
        for (int i = 0; i < 3; i++) {
            placa.append(letras.charAt(rand.nextInt(letras.length())));
        }
        for (int i = 0; i < 3; i++) {
            int numero = (int) (Math.random() * 81 + 100); // Escalamiento: 81, Corrimiento: 100
            placa.append(numero % 10); // Tomar solo un dígito para cumplir el formato XXX999
        }
        return placa.toString();
    }
    
    public void insertarPlaca(int posicion, String placa) {
        if (!validarPlaca(placa)) {
            vista.mostrarMensaje("Placa inválida. Debe tener 3 letras seguidas de 3 números.");
            return;
        }
        if (posicion < 0 || posicion > contador || contador >= placas.length) {
            vista.mostrarMensaje("Posición inválida.");
            return;
        }
        
        for (int i = contador; i > posicion; i--) {
            placas[i] = placas[i - 1];
        }
        placas[posicion] = new Placa(placa);
        contador++;
    }
    
    public void buscarPlaca(String placa) {
        for (int i = 0; i < contador; i++) {
            if (placas[i].getValor().equals(placa)) {
                vista.mostrarMensaje("Placa encontrada en la posición " + i);
                return;
            }
        }
        vista.mostrarMensaje("Placa no encontrada.");
    }
    
    public void modificarPlacaPorNombre(String placaVieja, String placaNueva) {
        for (int i = 0; i < contador; i++) {
            if (placas[i].getValor().equals(placaVieja)) {
                placas[i].setValor(placaNueva);
                vista.mostrarMensaje("Placa modificada con éxito.");
                return;
            }
        }
        vista.mostrarMensaje("Placa no encontrada.");
    }
    
    public void eliminarPlaca(int posicion) {
        if (posicion < 0 || posicion >= contador) {
            vista.mostrarMensaje("Posición inválida.");
            return;
        }
        
        for (int i = posicion; i < contador - 1; i++) {
            placas[i] = placas[i + 1];
        }
        placas[contador - 1] = null;
        contador--;
        vista.mostrarMensaje("Placa eliminada correctamente.");
    }
    
    public void mostrarPlacas() {
        for (int i = 0; i < contador; i++) {
            vista.mostrarMensaje("Posición " + i + ": " + placas[i].getValor());
        }
    }
}