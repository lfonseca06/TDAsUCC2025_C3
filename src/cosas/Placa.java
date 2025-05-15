package cosas;

import java.util.Scanner;

public class Placa {
    private final String placa;

    private Placa(String placa) {
        this.placa = placa;
    }
    
 
    public static Placa generarAleatoria() {
        StringBuilder placa = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int letra = (int) (Math.random() * (90 - 65 + 1) + 65);
            placa.append((char) letra);
        }
        for (int i = 0; i < 3; i++) {
            placa.append((int) (Math.random() * 10));
        }
        System.out.println("Placa aleatoria generada: " + placa);
        return new Placa(placa.toString());
    }

    
    public static Placa crearDesdeUsuario(Scanner sc) {
        String placaTexto;
        while (true) {
            System.out.print("Ingrese la placa (3 letras y 3 números): ");
            placaTexto = sc.nextLine().toUpperCase();
            if (validarPlaca(placaTexto)) break;
            else System.out.println("Formato incorrecto. Intente de nuevo.");
        }
        return new Placa(placaTexto);
    }

    private static boolean validarPlaca(String placa) {
        return placa.matches("[A-Z]{3}[0-9]{3}");
    }
    
    
    public String getPlaca() {
        return placa;
    }
    
   
    @Override
    public String toString() {
        return "placa = " + placa;
    }
   @Override
    public boolean equals(Object obj) {
       String otra2=(String) obj;
               
    return placa != null && placa.equalsIgnoreCase(otra2); 
}
}
