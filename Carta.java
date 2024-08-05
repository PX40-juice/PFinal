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

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
    }

    // Método para atacar a otra carta y determinar el resultado
    public String atacar(Carta objetivo) {
        if (this.ataque > objetivo.defensa) {
            return this.nombre + " ha ganado el ataque contra " + objetivo.nombre + "!";
        } else if (this.ataque < objetivo.defensa) {
            return objetivo.nombre + " ha ganado el ataque contra " + this.nombre + "!";
        } else {
            return "El ataque entre " + this.nombre + " y " + objetivo.nombre + " No ha pasado nada!";
        }
    }
}