import controlador.ControladorPlacas;
import vista.VistaPlaca;
import java.util.Scanner;
/**
 *
 * @author Leonardo
 */
public class TallerPlacas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VistaPlaca vista = new VistaPlaca();
        
        int tamaño = vista.solicitarNumero("Ingrese el tamaño del arreglo de placas:");
        ControladorPlacas controlador = new ControladorPlacas(tamaño, vista);
        
        int opcion;
        do {
            vista.mostrarMensaje("\nMenú Principal:\n1. Insertar Placa\n2. Buscar Placa\n3. Modificar Placa\n4. Eliminar Placa\n5. Mostrar Placas\n6. Salir");
            opcion = vista.solicitarNumero("Seleccione una opción:");
            
            switch (opcion) {
                case 1 -> {
                    int pos = vista.solicitarNumero("Ingrese la posición donde desea insertar la placa (0 - " + tamaño + "):");
                    String placa = vista.solicitarEntrada("Ingrese la placa (3 letras seguidas de 3 números):");
                    controlador.insertarPlaca(pos, placa);
                }
                case 2 -> {
                    String placa = vista.solicitarEntrada("Ingrese la placa a buscar:");
                    controlador.buscarPlaca(placa);
                }
                case 3 -> {
                    String vieja = vista.solicitarEntrada("Ingrese la placa a modificar:");
                    String nueva = vista.solicitarEntrada("Ingrese la nueva placa:");
                    controlador.modificarPlacaPorNombre(vieja, nueva);
                }
                case 4 -> {
                    int pos = vista.solicitarNumero("Ingrese la posición de la placa a eliminar:");
                    controlador.eliminarPlaca(pos);
                }
                case 5 -> controlador.mostrarPlacas();
                case 6 -> vista.mostrarMensaje("Saliendo del sistema...");
                default -> vista.mostrarMensaje("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 6);
    }
}