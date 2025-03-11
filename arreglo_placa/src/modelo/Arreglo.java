package modelo;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Leonardo
 */
public class Arreglo {
    private static Scanner scan = new Scanner(System.in);
    private String[] licensePlate_Place;
    
    public Arreglo() {
        this.scan = new Scanner(System.in);
        licensePlate_Place = new String[tam];
        this.counter = 0;
        this.tam = tam;
    }

    private int counter;
    private int tam;
    
    public String[] getPlates() {
        return licensePlate_Place;
    }

    public int getCounter() {
        return counter;
    }
    
     public void define_NumbSpaces(){
        tam = scan.nextInt(); // Asignar el valor al campo de la clase
        this.licensePlate_Place = new String[this.tam]; // Inicializar el arreglo con el nuevo tamañ
     }
    
    public void add_Thing(){
        String plate;
        System.out.println("Prefer put yourself the license plate or create a random plate?");
        System.out.println("1. Put yourself");
        System.out.println("2. Generate random plate");
        int option = scan.nextInt();
        if(option == 1){
            System.out.println("Put the license plate that you need to add:");
            plate =scan.nextLine();
            for(int i = 0; i<= counter;i++){ //we confirm if exist free space
                if (licensePlate_Place[i] == null){
                    licensePlate_Place [i] = plate;
                }else{
                    i++;
                    counter = i;
                }          
            }
        }
        if(option == 2){ //ramdom
            for(int i = 0; i<= tam;i++){
                String letras = "";
                String numeros = "";
                if (licensePlate_Place[i] == null){
                    Random random =  new Random();
                    for (int j = 0; i < 3; i++) {
                        char letra = (char) ('A' + random.nextInt(26));  // Obtener una letra aleatoria entre 'A' y 'Z'
                        letras += letra;
                    }
            
                    // Generar tres números aleatorios
                    for (int k = 0; i < 3; i++) {
                        int numero = random.nextInt(10);  // Obtener un número aleatorio entre 0 y 9
                        numeros += numero;
                    }
                    licensePlate_Place[i] = letras + numeros;
                }
            }
        }
        if(counter > tam){
             System.out.println("No available space to add the plate.");
        }
    }

    

    public void delete_Plate (){
        int option2;
        System.out.print("put the plate that you like delete: ");
        System.out.print("1. search by license plat ");
        System.out.print("2. delete by position ");
        option2 = scan.nextInt();
        if(option2 == 1){
            String plateToDelete = scan.nextLine();
            for (int i = 0; i < licensePlate_Place.length; i++) {
                if (plateToDelete.equals(licensePlate_Place[i])) {
                    licensePlate_Place[i] = null;
                    System.out.println("Plate '" + plateToDelete + "' deleted successfully.");
                    break;
                }
            }
        }
        if(option2 == 2){
            System.out.print("put the position of the plate that you like delete: ");
            int delete_Plate = scan.nextInt();
            scan.nextLine();
            licensePlate_Place [delete_Plate] = null;
        }
    }
    
    public void change_PlatePlance (){
        System.out.print("put the plate that you like change: ");
        String find_Plate = scan.nextLine();
        scan.nextLine();
        
        int flag = -1;
        for (int i = 0; i < licensePlate_Place.length; i++) {
            if (find_Plate.equals(licensePlate_Place[i])) {
                flag = i; 
                break; 
            }
        }
        if (flag != -1) {
            // Pedir la nueva placa
            System.out.print("Insert the new plate: ");
            String newPlate = scan.nextLine();
            scan.nextLine();
            licensePlate_Place[flag] = newPlate;
            System.out.println("plate has been changed succesfully.");
        } else {
            System.out.println("Plate not found.");
        }
    }

    public void view_TablePlate() {
        for (String license : licensePlate_Place) {
            System.out.println(license);
        }
    }
    
    public void viewMenu() {
        define_NumbSpaces();
        int option;
        do{
            System.out.println("Hi! Select a option that you need:");
            System.out.println("1. Insert license plate");
            System.out.println("2. Find and chance a word");
            System.out.println("3. Find and Delete word");
            option = scan.nextInt();
            scan.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    add_Thing();
                    System.out.println("Changes Saved:");
                    break;
                case 2:
                    change_PlatePlance();
                    System.out.println("Changes Saved:");
                    break;
                case 3:
                    delete_Plate();
                    System.out.println("Changes Saved:");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }while(option == 4);
    }
}
