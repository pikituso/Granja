package granja;

import animales.Fecha;

/**
 *
 * @author Pikiportatil
 */
public class Animal {

    protected String codigo;
    private Fecha fechaNacimiento;
    private char sexo;
    private double peso;

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if (sexo != 'M' && sexo != 'H') {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) throws IllegalArgumentException {
        Fecha fecha = new Fecha(fechaNacimiento);

        this.fechaNacimiento = fecha;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }

    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) throws IllegalArgumentException {
        Fecha fecha;

        if (!codigo.matches("[0-9a-z]{5}") || (sexo != 'M' && sexo != 'H') || peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            fecha = new Fecha(fechaNacimiento);
            this.codigo = codigo;
            this.fechaNacimiento = fecha;
            this.peso = peso;
            this.sexo = sexo;
        }
    }

}
