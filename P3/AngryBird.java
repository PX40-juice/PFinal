package P3;

import java.util.Random;

public class AngryBird {
    private Pajaro[] pajaros;
    private Puerco[] puercos;
    private Random random;

    public AngryBird(Pajaro[] pajaros, Puerco[] puercos) {
        this.pajaros = pajaros;
        this.puercos = puercos;
        this.random = new Random();
    }

    public void ataqueAleatorio() {
        // Selección aleatoria de un pájaro
        Pajaro pajaroAtacante = pajaros[random.nextInt(pajaros.length)];
        
        // Selección aleatoria de un puerco
        Puerco puercoObjetivo = puercos[random.nextInt(puercos.length)];

        // Determinación aleatoria del ganador del ataque
        boolean pajaroGana = random.nextBoolean();
        
        // Mostrar el resultado del ataque
        System.out.println("Pájaro " + pajaroAtacante + " ataca a Puerco " + puercoObjetivo + ".");
        if (pajaroGana) {
            System.out.println("El pájaro " + pajaroAtacante + " acerto el ataque");
        } else {
            System.out.println("¡El pájaro " + pajaroAtacante + " fallo el ataque contra " + puercoObjetivo);
        }
    }

    public static void main(String[] args) {
        // Crear pájaros
        Pajaro[] pajaros = {
            new Pajaro("Red"),
            new Pajaro("Blue"),
            new Pajaro("Yellow")
        };

        // Crear puercos
        Puerco[] puercos = {
            new Puerco("Paggy"),
            new Puerco("Peggy"),
            new Puerco("Piggy"),
            new Puerco("Poggy"),
            new Puerco("Ronco")
        };

        // Crear la instancia de AngryBirds
        AngryBird angryBirds = new AngryBird(pajaros, puercos);

        // Realizar un ataque aleatorio
        angryBirds.ataqueAleatorio();
    }
}