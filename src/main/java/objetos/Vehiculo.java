package objetos;

public class Vehiculo {
    private String placa;
    private String marca;
    private int anio;

    public Vehiculo(String placa, String marca, int anio) {
        this.placa = placa;
        this.marca = marca;
        this.anio = anio;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vehiculo vehiculo = (Vehiculo) obj;
        return placa.equals(vehiculo.placa);
    }

    @Override
    public int hashCode() {
        return placa.hashCode();
    }
}
