package granja;

import animales.Perro;
import java.util.Scanner;

public class Granja {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nAnimales;
        String codigo;
        char sexo;
        double peso;
        String fechaNacimiento;
        Perro perro;
        String raza;
        int perroV = 0;
        Perro perroAnterior = null;

        nAnimales = sc.nextInt();
        sc.nextLine();
        System.out.println("Procesando perros de la granja\n----------------------------------");

        for (int i = 0; i < nAnimales; i++) {
            codigo = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            sexo = sc.next().charAt(0);
            peso = sc.nextDouble();
            sc.nextLine();
            raza = sc.nextLine();

            try {
                perro = new Perro(codigo, fechaNacimiento, sexo, peso, raza);
                if (perroV > 0) {
                    if (perro.equals(perroAnterior)) {
                        System.out.println(perro.toString() + " y " + perroAnterior.toString() + " son el mismo");
                    } else {
                        System.out.println(perro.toString() + " y " + perroAnterior.toString() + " son distintos");
                    }
                }
                perroV++;
                perroAnterior = new Perro(codigo, fechaNacimiento, sexo, peso, raza);
            } catch (IllegalArgumentException ex) {
                System.out.println("ERROR. Procesando siguiente perro");
            }
            
        }

    }
}
