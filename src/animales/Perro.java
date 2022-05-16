package animales;

import java.util.Objects;

public class Perro extends Animal {

    private String raza;

    public Perro(String codigo, String fechaNacimiento, char sexo, double peso, String raza) throws IllegalArgumentException {
        super(codigo, fechaNacimiento, sexo, peso);
        if (!codigo.matches("p.*") || "".equals(raza)) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
            this.raza = raza;
        }
    }

    public String pasear() {
        return "Me encanta que me saquen a pasear";
    }

    @Override
    public String hacerSonido() {
        return "Guau";
    }

    @Override
    public String alegrarse() {
        return "Salto de alegria y muevo la cola";
    }

    @Override
    public String enfadarse() {
        return "Grunio y ensenio los dientes";
    }

    @Override
    public String queSoy() {
        return "Soy un perro";
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(String codigo) {
        if (!codigo.matches("p.*")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        if ("".equals(raza)) {
            throw new IllegalArgumentException();
        } else {
            this.raza = raza;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Perro other = (Perro) obj;
        return Objects.equals(this.raza, other.raza) && super.equals(obj);
    }

    @Override
    public String toString() {
        return "Perro{" + super.toString() + "raza=" + this.getRaza() + "}";
    }

    @Override
    public int hashCode() {
        return super.hashCode(); 
    }
    
    
}
