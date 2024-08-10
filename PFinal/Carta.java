package PFinal;

public class Carta {
    
    private int ataque;
    private int defensa;
    private String nombre;
    
    
    public Carta(int ataque, int defensa, String nombre) {
        
        this.ataque = ataque;
        this.defensa = defensa;
        this.nombre = nombre;
    }

    
    public String getNombre() {
        return nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    
    public void mostrarCarta() {
        System.out.println("Carta: " + nombre + " | Ataque: " + ataque + " | Defensa: " + defensa);
    }
}