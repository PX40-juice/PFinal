package PFinal;

import java.util.Random;
import java.util.Scanner;
public class Main {
    

    
    
    public static void main(String[] args) {
        Random random = new Random();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int jugador1 = 4000, jugador2 = 4000;
        int diferencia;
        
        Carta[] cartas = new Carta[10];
        Carta[] deck = new Carta[10];
        //Creacion de Cartas
        
        cartas[0] = new Carta(300, 200, "Piedra Blanca de la Leyenda");
        cartas[1]  = new Carta(500, 700, "Piedra Blanca de los Antiguos");
        cartas[2]  = new Carta(4000, 0, "Dragon Caos Maximo de Ojos Azules");
        cartas[3]  = new Carta(3000, 2500, "Dragon Blanco de Ojos Azules");
        cartas[4]  = new Carta(3000, 0, "Dragon Jet de Ojos Azules");
        cartas[5]  = new Carta(2800, 2500, "Dragon del Abismo de Ojos Azules");
        cartas[6]  = new Carta(2500, 2800, "Mago de la Cronica");
        cartas[7]  = new Carta(3000, 2500, "Dragon Blanco de Ojos Azules");
        // Separador de Decks
        deck[0] = new Carta(300, 200, "Magikuriboh");
        deck[1] = new Carta(400, 400, "Chica Maga Baya");
        deck[2] = new Carta(1600, 100, "Varita de Mago");
        deck[3] = new Carta(700, 2000, "Tunica del Mago");
        deck[4] = new Carta(2100, 2500, "Mago de la Ilusion Oscura");
        deck[5] = new Carta(2000, 1700, "Chica Maga Oscura");
        deck[6] = new Carta(2500, 2100, "Mago Oscuro");
        deck[7] = new Carta(2500, 2100, "Mago Oscuro");
        
    System.out.println("Buscar Carta: 1 || Simulacion de batalla: 2 ");
    int decision = scanner.nextInt();
    scanner.nextLine();
    if(decision == 1){
        System.out.print("Ingresa el nombre de la carta a buscar: ");
        String numeroABuscar = scanner.nextLine();
        
        int posicion;
        posicion = buscar(cartas, numeroABuscar);

        if (posicion != -1) {
            System.out.println("La carta se encuentra en la posicion: " + posicion+" del Deck");
            cartas[posicion].mostrarCarta();
        } else {
            System.out.println("La carta no fue encontrada. ");
        }
        
    }
    
    if(decision == 2){
        System.out.println("El duelo comienza");
        do{
            for(int i = 0; i <= 10; i++){
            System.out.println(" ----Nuevo Turno----");
            System.out.println(" ");
            System.out.println(" ----Mostrar Cartas----");
            int r = random.nextInt(8);
            int a = random.nextInt(8);
            System.out.println("Tu carta es: ");
            cartas[r].mostrarCarta();
            System.out.println(" ");
            System.out.println("La carta de tu oponente es: ");
            deck[a].mostrarCarta();
            System.out.println(" ");
            System.out.println("Atacar Oponente? [1]");
            System.out.println("Pasar Turno? [2]");
            int duelo = scanner.nextInt();                

            if(duelo == 1){
                //cartas[i].mostrarCarta();

                
                if(cartas[r].getAtaque() >= deck[a].getDefensa()){
                    diferencia = cartas[r].getAtaque() - deck[a].getDefensa();
                    jugador2 = jugador2 - diferencia;
                    
                    System.out.println("A tu oponente le quedan "+jugador2+" puntos de vida");
                    System.out.println("¿Continuar? [1]");
                    int cont = scanner.nextInt(); 
                    }
                    else{
                        System.out.println("Tu ataque no ha funcionado");
                        System.out.println("El monstruo de tu oponente resiste.");
                    }
                    if(jugador2 <= 0){
                        System.out.println("HAS GANADO EL COMBATE ");
                        System.exit(0);
                    }
                }
                if(duelo == 2){
                    System.out.println(" ");
                    System.out.println("Pierdes los mismos puntos de vida que el ataque del monstruo de tu adversario");
                    jugador1 = jugador1 - deck[a].getAtaque();
                    System.out.println(" ");
                    System.out.println("Te quedan "+jugador1+" puntos de vida");
                    System.out.println(" ");
                    System.out.println(" ");
                    if(jugador1 <= 0){
                    System.out.println(" ");
                    System.out.println("Has Perdido, Eres un perdedor que pierde jaja");
                    System.exit(0);
                    }
                }
                if(duelo == 3){
                    cartas[i].mostrarCarta();
            }
            
        }
        }while(jugador1 >= 0 && jugador2 >= 0);

    } 
         
    }
    
    public static int buscar(Carta[] cartas, String numeroABuscar) {
        for (int i = cartas.length - 1; i >= 0; i--) {
            if (cartas[i].getNombre().equals(numeroABuscar)) {
                System.out.println("Todo ok");
                //return cartas[i].mostrarCarta(); 
            }
        }
        return -1; 
    }
    
    
}