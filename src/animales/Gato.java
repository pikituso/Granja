/*
 * Yepa k pasa gente yo soy lolito
 * Y hoy estamos aqui programando
 */
package animales;

import java.util.Objects;

/**
 *
 * @author Pikiportatil
 */
public class Gato extends Animal {
    
    private String raza;

    public Gato(String codigo, String fechaNacimiento, char sexo, double peso, String raza) throws IllegalArgumentException {
        super(codigo, fechaNacimiento, sexo, peso);
        if (!codigo.matches("g.*") || "".equals(raza)) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
            this.raza = raza;
        }
    }

    @Override
    public String hacerSonido() {
        return "Miau";
    }

    @Override
    public String alegrarse() {
        return "Ronroneo y me froto contra tus piernas";
    }

    @Override
    public String enfadarse() {
        return "Me bufo y saco las uñas";
    }

    @Override
    public String queSoy() {
        return "Soy un gato";
    }
    
    public String cazar() {
        return "Me encanta cazar bichejos";
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    public String getRaza() {
        return raza;
    }
    
    @Override
    public void setCodigo(String codigo) {
        if (!codigo.matches("g.*")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }
    
    public void setRaza(String raza) {
        if ("".equals(raza)) {
            throw new IllegalArgumentException();
        } else {
            this.raza = raza;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.raza);
        return hash;
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
        final Gato other = (Gato) obj;
        return Objects.equals(this.raza, other.raza) && super.equals(obj);
    }

    @Override
    public String toString() {
        return "Gato{" + super.toString() + "raza=" + this.getRaza() + '}';
    }
}
