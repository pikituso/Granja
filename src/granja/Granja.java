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
        Perro perro = null;
        String raza;
        
        nAnimales = sc.nextInt();
        sc.nextLine();
        System.out.println("Procesando animales de la granja\n----------------------------------");
        
        for (int i = 0; i < nAnimales; i++) {
            codigo = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            sexo = sc.next().charAt(0);
            peso = sc.nextDouble();
            sc.nextLine();
            raza = sc.nextLine();
            
            try {
                perro = new Perro(codigo, fechaNacimiento, sexo, peso, raza);
                System.out.println("Procesado: " + perro.getCodigo()
                        + " " + perro.getRaza()
                        + " " + perro.getSexo()
                        + " de " + perro.getPeso()
                + " kilos, nacido el " + perro.getFechaNacimiento().getDia()
                        + " de " + perro.getFechaNacimiento().getMesNombre()
                        + " de " + perro.getFechaNacimiento().getAnyo());
                System.out.println(perro.queSoy());
                System.out.println(perro.pasear());
                System.out.println("Cuando estoy alegre " + perro.alegrarse());
                System.out.println("Cuando me enfado " + perro.enfadarse());
            } catch (IllegalArgumentException ex) {
                System.out.println("ERROR. Procesando siguiente animal");
            }
        }
        
        System.out.println("Cambiando datos del ultimo animal\n----------------------------------");
            
            boolean esCorrecto = false;
            while (!esCorrecto) {
                codigo = sc.nextLine();
                try {
                    perro.setCodigo(codigo);
                    esCorrecto = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Dato erroneo. No se hace el cambio");
                }
            }
            
            perro.setRaza(perro.getRaza());
            
            
            esCorrecto = false;
            while (!esCorrecto) {
                fechaNacimiento = sc.nextLine();
                try {
                    perro.setFechaNacimiento(fechaNacimiento);
                    esCorrecto = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Dato erroneo. No se hace el cambio");
                }
            }
            
            esCorrecto = false;
            while (!esCorrecto) {
                sexo = sc.nextLine().charAt(0);
                try {
                    perro.setSexo(sexo);
                    esCorrecto = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Dato erroneo. No se hace el cambio");
                }
            }
            
            esCorrecto = false;
            while (!esCorrecto) {
                peso = sc.nextDouble();
                try {
                    perro.setPeso(peso);
                    esCorrecto = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Dato erroneo. No se hace el cambio");
                }
            }
            
            
            System.out.println("Procesado: " + perro.getCodigo()
                        + " " + perro.getRaza()
                        + " " + perro.getSexo()
                        + " de " + perro.getPeso()
                + " kilos, nacido el " + perro.getFechaNacimiento().getDia()
                        + " de " + perro.getFechaNacimiento().getMesNombre()
                        + " de " + perro.getFechaNacimiento().getAnyo());
    }
}
