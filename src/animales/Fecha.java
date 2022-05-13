package animales;

/**
 *
 * @author Pikiportatil
 */
public class Fecha {

    private int dia, mes, anyo;

    public Fecha(int dia, int mes, int anyo) {
        if (!esFechaCorrecta(dia, mes, anyo)) {
            throw new IllegalArgumentException();
        } else {
            this.dia = dia;
            this.mes = mes;
            this.anyo = anyo;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.dia;
        hash = 89 * hash + this.mes;
        hash = 89 * hash + this.anyo;
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
        final Fecha other = (Fecha) obj;
        if (this.dia != other.dia) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        if (this.anyo != other.anyo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fecha{"+getDiaDeLaSemana() + ", " + getDia() + " de " + getMesNombre() + " de " + getAnyo()+ '}';
    }

    

   
    
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnyo() {
        return anyo;
    }
    
    public String getDiaDeLaSemana() {
        String[] diasSemana = {"domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado"};
        return diasSemana[getNumeroDiaSemana()];
    }

    public boolean esAnioBisiesto() {
        return esAnioBisiesto(anyo);
    }

    public static boolean esAnioBisiesto(int anyo) {
        return anyo % 4 == 0 && (anyo % 100 != 0 || anyo % 400 == 0);
    }

    private boolean esFechaCorrecta(int dia, int mes, int anyo) {
        boolean esCorrecta = true;
        int[] numeroDiasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (anyo < 0) {
            esCorrecta = false;
        } else if (mes < 1 || mes > 12) {
            esCorrecta = false;
        } else if (dia < 1 || dia > numeroDiasMes[mes - 1]) {
            esCorrecta = esAnioBisiesto(anyo) && mes == 2 && dia == 29;
        }
        return esCorrecta;
    }

    public String getMesNombre() {
        String nombreMeses[] = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

        return (nombreMeses[this.mes - 1]);
    }
    
    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;
        this.anyo = fecha.anyo;
    }
    
    public Fecha(String fecha) {
        if (!fecha.matches("\\d{2}[-/]\\d{2}[-/]\\d{4}")) {
            throw new IllegalArgumentException();
        } else {
            dia = Integer.parseInt(fecha.substring(0, 2));
            mes = Integer.parseInt(fecha.substring(3, 5));
            anyo = Integer.parseInt(fecha.substring(6, 10));
            if (!esFechaCorrecta(dia, mes, anyo)) {
                throw new IllegalArgumentException();
            } else {
                this.dia = dia;
                this.mes = mes;
                this.anyo = anyo;
            }
        }
    }

    private int getNumeroDiaSemana() {
        int[] calcularMes = {6, 2, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};

        int siglo;
        int anio;
        int bisiesto;
        int mes = calcularMes[this.mes - 1];
        int dia = this.dia;

        int i;

        if (this.anyo >= 2000) {
            siglo = 0;
            i = this.anyo - 2000;
            while (i > 100) {
                i = i - 100;
                siglo = siglo - 2;
            }
        } else {

            siglo = 1;
            i = 2000 - this.anyo;
            while (i > 100) {
                i = i - 100;
                siglo = siglo + 2;
            }
        }

        int j;
        anio = Math.floorDiv(this.anyo, 100) * 100;
        anio = this.anyo - anio;
        j = Math.floorDiv(anio, 4);
        anio = anio + j;

        if (esAnioBisiesto(this.anyo) && (this.mes == 1 || this.mes == 2)) {
            bisiesto = -1;
        } else {
            bisiesto = 0;
        }

        int resultado = (siglo + anio + bisiesto + mes + dia) % 7;
        return resultado;
    }
    
    public int getDiaDelAnio(){
        int dias = this.dia;
        int[] nDias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (esAnioBisiesto(this.anyo)) {
            nDias[1] = 29;
        }
        for (int i = 0; i < mes - 1; i++) {
            dias += nDias[i];
        }
        
        return dias;
    }
    
    public int calcularDiasDiferenciaCon(Fecha otraFecha) {
        int diferenciaDeAnyos = 0;
        int diasDeDiferencia = 0;
        int i = 0;
        int bisiesto = 365;
        if (!isMayor(otraFecha)) {
           if (esAnioBisiesto(otraFecha.anyo)) {
                bisiesto = 366;
            }
            diferenciaDeAnyos = (this.anyo - otraFecha.anyo) - 1;
            while (diferenciaDeAnyos > 0) {
                diasDeDiferencia += 365;
                if (esAnioBisiesto(otraFecha.anyo + i)) {
                    diasDeDiferencia++;
                }
                i++;
                diferenciaDeAnyos--;
            }
            if (diferenciaDeAnyos == -1) {
                diasDeDiferencia +=(this.getDiaDelAnio() - otraFecha.getDiaDelAnio());
            } else {
                diasDeDiferencia +=((bisiesto - otraFecha.getDiaDelAnio()) + this.getDiaDelAnio());
                
            }
        } else {
            if (this.esAnioBisiesto()) {
                bisiesto = 366;
            }
            diferenciaDeAnyos = (otraFecha.anyo - this.anyo) - 1;
            while (diferenciaDeAnyos > 0) {
                diasDeDiferencia += 365;
                if (esAnioBisiesto(anyo + i)) {
                    diasDeDiferencia++;
                }
                i++;
                diferenciaDeAnyos--;
            }
            if (diferenciaDeAnyos == -1) {
                diasDeDiferencia += -1 * (otraFecha.getDiaDelAnio() - this.getDiaDelAnio());
            } else {
                diasDeDiferencia += -1 * ((bisiesto - this.getDiaDelAnio()) + otraFecha.getDiaDelAnio());
                
            }
        }

        return diasDeDiferencia;
    }
    
    private boolean isMayor(Fecha otraFecha) {
        if (otraFecha.getAnyo() == this.anyo) {
            if (otraFecha.getMes() == this.mes) {
                return !(otraFecha.getDia() == this.dia || otraFecha.getDia() < this.dia);
            } else return otraFecha.getMes() >= this.mes;
        } else if (otraFecha.getAnyo() < this.anyo) {
            return false;
        }
        return true;
    }
}

