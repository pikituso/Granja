package granja;

import java.util.Scanner;

public class Granja {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nAnimales;
        String codigo;
        char sexo;
        double peso;
        String fechaNacimiento;
        Animal animal;
        Animal animalAnterior = null;
        int animalV = 0;

        nAnimales = sc.nextInt();
        sc.nextLine();
        System.out.println("Procesando animales de la granja\n----------------------------------");

        for (int i = 0; i < nAnimales; i++) {
            codigo = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            sexo = sc.next().charAt(0);
            peso = sc.nextDouble();
            sc.nextLine();

            try {
                animal = new Animal(codigo, fechaNacimiento, sexo, peso);
                if (animalV > 0) {
                    if (animal.equals(animalAnterior)) {
                        System.out.println(animal.toString() + " y " + animalAnterior.toString() + " son el mismo");
                    } else {
                        System.out.println(animal.toString() + " y " + animalAnterior.toString() + " son distintos");
                    }
                }
                animalV++;
                animalAnterior = new Animal(codigo, fechaNacimiento, sexo, peso);
            } catch (IllegalArgumentException ex) {
                System.out.println("ERROR. Procesando siguiente animal");
            }
        }
    }
}
