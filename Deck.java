package PFinal;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Carta> cartas;

    public Deck() {
        cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public void mostrarCartas() {
        for (Carta carta : cartas) {
            carta.mostrarInfo();
            System.out.println(); // Línea en blanco para separar cada carta
        }
    }

    // Método para realizar una batalla entre dos cartas
    public void batallar(int index1, int index2) {
        if (index1 < 0 || index1 >= cartas.size() || index2 < 0 || index2 >= cartas.size()) {
            System.out.println("Índices inválidos para la batalla.");
            return;
        }

        Carta atacante = cartas.get(index1);
        Carta defensor = cartas.get(index2);

        System.out.println(atacante.getNombre() + " está atacando a " + defensor.getNombre() + ":");
        String resultado = atacante.atacar(defensor);
        System.out.println(resultado);
    }

    public static void main(String[] args) {
        Deck deck = new Deck();

        Carta Castel = new Carta(2000, 1500, "Castel, the skyblaster musketeer");
        Carta Vepartu = new Carta(2000, 2000, "Magikey spirit - Vepartu");

        deck.agregarCarta(Castel);
        deck.agregarCarta(Vepartu);

        deck.mostrarCartas();

        // Realizar una batalla entre la primera y segunda carta en el deck
        deck.batallar(0, 1);
    }
}