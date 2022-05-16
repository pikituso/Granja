package animales;

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
}
