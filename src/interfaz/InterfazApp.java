package interfaz;

import cosas.*;
import java.util.Scanner;
//import tdas.*;
import tdasLLI.*;

public class InterfazApp {

    private List lista;
    private Stack<Placa> pila;
    private Queue<Placa> cola;
    private Bag<Placa> maleta;
    private Scanner sc;
    
  
    public InterfazApp() {
        lista = new List <>();
        pila = new Stack<>();
        cola = new Queue<>();
        maleta = new Bag<>();
        sc = new Scanner(System.in);
    }
    
   
    public static void main(String[] args) {
        InterfazApp iApp = new InterfazApp();
        iApp.menuPrincipal();
    }

    
    void menuPrincipal() {
        int opcion;
        do {
            System.out.println("--- Menu Principal --- \n"
                    + "1. Operar con Lista\n"
                    + "2. Operar con Pila\n"
                    + "3. Operar con Cola\n"
                    + "4. Operar con Maleta\n"
                    + "5. Salir\n");
            opcion = leerOpcion(1, 5);
            switch (opcion) {
                case 1 -> menuLista();
                case 2 -> menuPilas();
                case 3 -> menuColas();
                case 4 -> menuMaleta();
                case 5 -> System.out.println("Hasta luego!");
            }
        } while (true);
    }

    void menuLista() {
        int opcion;
        do {
            System.out.println("--- Menu Lista --- \n"
                    + "1. Insertar elemento\n"
                    + "2. Buscar elemento\n"
                    + "3. Modificar elemento\n"
                    + "4. Eliminar elemento\n"
                    + "5. Mostrar elementos registrados\n"
                    + "6. Regresar\n");
            opcion = leerOpcion(1, 6);

            switch (opcion) {
                case 1 -> submenuInsertarLista();
                case 2 -> buscarPlaca();
                case 3 -> submenuModificarLista();
                case 4 -> submenuEliminarLista();
                case 5 -> mostrarPlacas();
                case 6 -> { return; }
            }
        } while (true);
    }
    
    
    void submenuInsertarLista() {
        Placa placa = seleccionarPlaca();

        System.out.println("--- Submen� Insertar --- \n"
                + "1. Insertar al inicio\n"
                + "2. Insertar en posicisi�n espec�fica\n"
                + "3. Insertar al final\n"
                + "4. Regresar\n");
        int opcion = leerOpcion(1, 4);

        switch (opcion) {
            case 1 -> lista.addFirst(placa);
            case 2 -> {
                int posicion = solicitarPosicion(true);
                if (posicion != -1) lista.add(posicion, placa);
            }
            case 3 -> lista.addLast(placa);
            case 4 -> { return; }
        }
        System.out.println("Operaci�n completada.\n");
    }
    
     
    void submenuEliminarLista() {
        System.out.println("--- Submen� Eliminar --- \n"
                + "1. Eliminar al inicio\n"
                + "2. Eliminar al final\n"
                + "3. Eliminar en posici�n espec�fica\n"
                + "4. Eliminar por nombre de placa\n"
                + "5. Regresar\n");
        int opcion = leerOpcion(1, 5);

        switch (opcion) {
            case 1 -> eliminarInicioLista();
            case 2 -> eliminarFinalLista();
            case 3 -> eliminarPosicionLista();
            case 4 -> eliminarPorNombreLista();
            case 5 -> { return; }
        }
        System.out.println("Operaci�n completada.\n");
    }
    
   
    void eliminarInicioLista() {
        if (!lista.isEmpty()) {
            lista.removeFirst();
            System.out.println("Elemento eliminado del inicio.");
        } else System.out.println("La lista est� vac�a.");
    }
    
    
    void eliminarFinalLista() {
        if (!lista.isEmpty()) {
            lista.removeLast();
            System.out.println("Elemento eliminado del final.");
        } else System.out.println("La lista est� vacia.");
    }
    
   
    void eliminarPosicionLista() {
        int posicion = solicitarPosicion(false);
        if (posicion != -1) {
            lista.remove(posicion);
            System.out.println("Elemento eliminado en la posici�n " + posicion);
        }
    }
    
    void eliminarPorNombreLista() {
        System.out.print("Ingrese el elemento a eliminar: ");
        String placaNombre = sc.nextLine();
        if (lista.remove(placaNombre)) {
            System.out.println("Elemento eliminado exitosamente.");
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }
    
   
    void submenuModificarLista() {
        System.out.println("--- Submen� Modificar --- \n"
                + "1. Modificar por nombre\n"
                + "2. Modificar por posici�n\n"
                + "3. Regresar\n");
        int opcion = leerOpcion(1, 3);

        switch (opcion) {
            case 1 -> modificarPorNombre();
            case 2 -> modificarPorPosicion();
            case 3 -> { return; }
        }
    }
    
    
    void modificarPorNombre() {
        System.out.print("Ingrese el elemento a modificar: ");
        String placaBuscar = sc.nextLine();
        int pos = lista.indexOf(placaBuscar);
        if (pos != -1) {
            lista.set(pos, seleccionarPlaca());
            System.out.println("Elemento modificado exitosamente.");
        } else System.out.println("Elemento no encontrado.");
    }
    
    
    void modificarPorPosicion() {
        int posicion = solicitarPosicion(false);
        if (posicion != -1) {
            lista.set(posicion, seleccionarPlaca());
            System.out.println("Elemento modificado exitosamente.");
        }
    }
    
    
    void buscarPlaca() {
        System.out.print("Ingrese el elemento a busca: ");
        String placaBuscar = sc.nextLine();
        int pos = lista.indexOf(placaBuscar);
        if (pos != -1) {
            System.out.println("Elemento encontrado en la posici�n: " + pos);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }
    
    
    void mostrarPlacas() {
        if (lista.isEmpty()) System.out.println("La lista est� vacia.");
        else lista.forEach(System.out::println);
    }

    
    void menuPilas() {
        int opcion;
        do {
            System.out.println("--- Menu Pilas --- \n"
                    + "1. Apilar elemento\n"
                    + "2. Desapilar elemento\n"
                    + "3. �Est� vac�a?\n"
                    + "4. Tama�o\n"
                    + "5. Mostrar elementos\n"
                    + "6. Regresar\n");
            opcion = leerOpcion(1, 6);

            switch (opcion) {
                case 1 -> pila.push(seleccionarPlaca());
                case 2 -> {
                    if (!pila.isEmpty()) System.out.println("Elemento retirado: " + pila.pop());
                    else System.out.println("La pila est� vacia.");
                }
                case 3 -> System.out.println(pila.isEmpty() ? "Est� vac�a" : "No est� vac�a.");
                case 4 -> System.out.println("Tama�o de la pila: " + pila.size());
                case 5 -> pila.forEach(System.out::println);
                case 6 -> { return; }
            }
        } while (true);
    }

   
    void menuColas() {
        int opcion;
        do {
            System.out.println("--- Men� Colas --- \n"
                    + "1. Encolar elemento\n"
                    + "2. Desencolar elemento\n"
                    + "3. �Est� vac�a?\n"
                    + "4. Tama�o\n"
                    + "5. Mostrar elementos\n"
                    + "6. Regresar\n");
            opcion = leerOpcion(1, 6);

            switch (opcion) {
                case 1 -> cola.enqueue(seleccionarPlaca());
                case 2 -> {
                    if (!cola.isEmpty()) System.out.println("Elemento retirado: " + cola.dequeue());
                    else System.out.println("La cola est� vac�a.");
                }
                case 3 -> System.out.println(cola.isEmpty() ? "Est� vac�a." : "No esta vacia.");
                case 4 -> System.out.println("Tama�o de la cola: " + cola.size());
                case 5 -> cola.forEach(System.out::println);
                case 6 -> { return; }
            }
        } while (true);
    }

    
    void menuMaleta() {
        int opcion;
        do {
            System.out.println("--- Men� Maleta --- \n"
                    + "1. Agregar elemento\n"
                    + "2. �Est� vac�a?\n"
                    + "3. Tama�o\n"
                    + "4. Mostrar elementos\n"
                    + "5. Regresar\n");
            opcion = leerOpcion(1, 5);

            switch (opcion) {
                case 1 -> maleta.add(seleccionarPlaca());
                case 2 -> System.out.println(maleta.isEmpty() ? "Est� vac�a." : "No est� vac�a.");
                case 3 -> System.out.println("Tama�o de la maleta: " + maleta.size());
                case 4 -> maleta.forEach(System.out::println);
                case 5 -> { return; }
            }
        } while (true);
    }

    
    Placa seleccionarPlaca() {
        System.out.println("1. Placa aleatoria\n"
                + "2. Placa ingresada por el usuario\n");
        int opcion = leerOpcion(1, 2);
        return (opcion == 1) ? Placa.generarAleatoria() : Placa.crearDesdeUsuario(sc);
    }

    
    int solicitarPosicion(boolean insertar) {
        while (true) {
            System.out.print("Ingrese la posici�n: ");
            int posicion = leerNumero();
            if ((insertar && posicion >= 0 && posicion <= lista.size())
                    || (!insertar && posicion >= 0 && posicion < lista.size())) {
                return posicion;
            } else {
                System.out.println("Posici�n inv�lida. La lista tiene actualmente " + lista.size() + " elementos. Intente nuevamente.");
            }
        }
    }
    
   
    int leerOpcion(int min, int max) {
        int opcion;
        while (true) {
            System.out.print("Seleccione una opci�n: ");
            opcion = leerNumero();
            if (opcion >= min && opcion <= max) {
                return opcion;
            }
            System.out.println("Opci�n inv�lida. Intente de nuevo.");
        }
    }
    
    
    int leerNumero() {
        while (!sc.hasNextInt()) {
            System.out.print("Entrada no v�lida. Ingrese un n�mero: ");
            sc.next();
        }
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }
}