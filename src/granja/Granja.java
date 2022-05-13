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
        Animal animal = null;
        
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
                System.out.println("Procesado: " + animal.getCodigo()
                        + " " + animal.getSexo()
                        + " de " + animal.getPeso()
                + " kilos, nacido el " + animal.getFechaNacimiento().getDia()
                        + " de " + animal.getFechaNacimiento().getMesNombre()
                        + " de " + animal.getFechaNacimiento().getAnyo());
            } catch (IllegalArgumentException ex) {
                System.out.println("ERROR. Procesando siguiente animal");
            }
        }
        
        System.out.println("Cambiando datos del ultimo animal\n----------------------------------");
            
            boolean esCorrecto = false;
            while (!esCorrecto) {
                codigo = sc.nextLine();
                try {
                    animal.setCodigo(codigo);
                    esCorrecto = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Dato erroneo. No se hace el cambio");
                }
            }
            
            esCorrecto = false;
            while (!esCorrecto) {
                fechaNacimiento = sc.nextLine();
                try {
                    animal.setFechaNacimiento(fechaNacimiento);
                    esCorrecto = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Dato erroneo. No se hace el cambio");
                }
            }
            
            esCorrecto = false;
            while (!esCorrecto) {
                sexo = sc.nextLine().charAt(0);
                try {
                    animal.setSexo(sexo);
                    esCorrecto = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Dato erroneo. No se hace el cambio");
                }
            }
            
            esCorrecto = false;
            while (!esCorrecto) {
                peso = sc.nextDouble();
                try {
                    animal.setPeso(peso);
                    esCorrecto = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Dato erroneo. No se hace el cambio");
                }
            }
            
            
            System.out.println("Procesado: " + animal.getCodigo()
                        + " " + animal.getSexo()
                        + " de " + animal.getPeso()
                + " kilos, nacido el " + animal.getFechaNacimiento().getDia()
                        + " de " + animal.getFechaNacimiento().getMesNombre()
                        + " de " + animal.getFechaNacimiento().getAnyo());
    }
    
}
