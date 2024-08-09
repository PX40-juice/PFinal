package P4;

public class Cuenta {
    private String nombre;
    private double saldo;
    private String pin;

    public Cuenta(String nombre, double saldo, String pin) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.pin = pin;
    }

    public boolean verificarPin(String pin) {
        return this.pin.equals(pin);
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            return true;
        } else {
            System.out.println("Saldo insuficiente o monto inválido.");
            return false;
        }
    }

    public double obtenerSaldo() {
        return saldo;
    }

    public String getNombre() {
        return nombre;
    }
}