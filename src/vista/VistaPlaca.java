package vista;
import java.util.Scanner;

/**
 *
 * @author Leonardo
 */
public class VistaPlaca {
    private Scanner scanner = new Scanner(System.in);
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String solicitarEntrada(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    public int solicitarNumero(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextInt();
    }
}