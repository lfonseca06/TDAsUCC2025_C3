package modelo;

import java.util.Scanner;
import java.util.Random;


public class Arreglo {
    private static Scanner scan = new Scanner(System.in);
    private String[] licensePlate_Place;
    
    public Arreglo() {
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
        System.out.println("Define the size that you like for the array");
        tam = scan.nextInt(); // Asignar el valor al campo de la clase
        this.licensePlate_Place = new String[this.tam]; // Inicializar el arreglo con el nuevo tamañ
     }
    
    public void add_Thing(){
        String plate;
        System.out.println("Prefer put yourself the license plate or create a random plate?");
        System.out.println("1. Put yourself");
        System.out.println("2. Generate random plate");
        int option = scan.nextInt();
        scan.nextLine();
        if(option == 1){
            System.out.println("Put the license plate that you need to add:");
            plate =scan.nextLine();
            for(int i = 0; i< tam;i++){ //we confirm if exist free space
                if (licensePlate_Place[i] == null){
                    licensePlate_Place [i] = plate;
                    break;
                }       
            }
        }
        if(option == 2){ //ramdom
            for(int i = 0; i< tam;i++){
                String letras = "";
                String numeros = "";
                if (licensePlate_Place[i] == null){
                    Random random =  new Random();
                    for (int j = 0; j < 3; j++) {
                        char letra = (char) ('A' + random.nextInt(26));  // Obtener una letra aleatoria entre 'A' y 'Z'
                        letras += letra;
                    }
            
                    // Generar tres números aleatorios
                    for (int k = 0; k < 3; k++) {
                        int numero = random.nextInt(10);  // Obtener un número aleatorio entre 0 y 9
                        numeros += numero;
                        System.out.println("added correctly the new plate 3");
                    }
                    licensePlate_Place[i] = letras + numeros;
                    System.out.println("added correctly the new plate:" + licensePlate_Place[i]);
                    break;
                }
            }
        }
        if(counter > tam){
             System.out.println("No available space to add the plate.");
        }
    }

    

    public void delete_Plate (){
        int option2;
        String plateToDelete;
        System.out.print("put the plate that you like delete:\n ");
        System.out.print("1. search by license plat\n ");
        System.out.print("2. delete by position ");
        option2 = scan.nextInt();
        scan.nextLine();
        if(option2 == 1){
            System.out.print("put the plate that you like delete: ");
            plateToDelete = scan.nextLine();
            scan.nextLine();
            for (int i = 0; i < tam; i++) {
                if (plateToDelete.equals(licensePlate_Place[i])) {
                    licensePlate_Place[i] = null;
                    System.out.println("Plate " + plateToDelete + " deleted successfully.");
                    break;
                }
            }
        }
        if(option2 == 2){
            System.out.print("put the position of the plate that you like delete: ");
            int delete_Plate = scan.nextInt();
            scan.nextLine();
            licensePlate_Place [delete_Plate - 1] = null;
        }
    }
    
    public void change_PlatePlance (){
        System.out.print("put the plate that you like change: ");
        String find_Plate = scan.nextLine();
        scan.nextLine();
        for (int i = 0; i < tam; i++) {
            if (find_Plate.equals(licensePlate_Place[i])) {
                // Pedir la nueva placa
                System.out.print("Insert the new plate: ");
                String newPlate = scan.nextLine();
                scan.nextLine();
                licensePlate_Place[i] = newPlate;
                System.out.println("plate has been changed succesfully.");
                break;
            } else {
                System.out.println("Plate not found.");
            }
               
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
            System.out.println("4. view table");
            System.out.println("5. exit");
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
                case 4:
                    view_TablePlate();
                default:
                    System.out.println("Opción no válida.");
            }
        }while(option != 5);
    }
}