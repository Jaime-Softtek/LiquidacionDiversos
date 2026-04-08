package Utils;

import java.util.Scanner;

public class Utilidades {


    private static final Scanner SC = new Scanner(System.in);


    public static String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje + ": ");
            texto = SC.nextLine().trim();
            if (texto.isEmpty())
                System.out.println("Error: el texto no puede estar vacío. Inténtalo de nuevo.");
        } while (texto.isEmpty());
        return texto;
    }


    public static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            try {
                return Integer.parseInt(SC.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un número válido.");
            }
        }
    }

    public static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            try {
                return Double.parseDouble(SC.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un número decimal válido.");
            }
        }
    }


    public static void cerrar() {
        SC.close();
    }
}