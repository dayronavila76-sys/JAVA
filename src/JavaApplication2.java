import java.util.Arrays;
import java.util.Scanner;

/**
 * Colección de ejercicios de práctica en Java: entrada por teclado, condicionales,
 * switch (Java 21), bucles, arreglos y formato de texto en consola.
 * <p>
 * Al ejecutar el programa se muestra un menú numerado para elegir el ejercicio.
 */
public class JavaApplication2 {

    /** Una sola instancia para menú y ejercicios; varios {@code Scanner(System.in)} suelen fallar. */
    private static final Scanner ENTRADA = new Scanner(System.in);

    // region Punto de entrada
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            while (!ENTRADA.hasNextInt()) {
                ENTRADA.nextLine();
                System.out.print("Introduce un numero entero valido: ");
            }
            opcion = ENTRADA.nextInt();
            ENTRADA.nextLine();

            switch (opcion) {
                case 1 -> ejercicio1();
                case 2 -> ejercicio2();
                case 3 -> ejercicio3();
                case 4 -> ejercicio4();
                case 5 -> ejercicio5();
                case 6 -> ejercicio6();
                case 7 -> ejercicio7();
                case 8 -> ejercicio8();
                case 9 -> ejercicio9();
                case 10 -> ejercicio10();
                case 11 -> ejercicio11();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida. Elige un número entre 0 y 11.");
            }
            if (opcion != 0) {
                System.out.println();
                System.out.println("--- Pulsa Enter para volver al menu ---");
                ENTRADA.nextLine();
            }
        } while (opcion != 0);
    }

    /**
     * Lista numerada de ejercicios con título que describe qué hace cada uno.
     */
    private static void mostrarMenu() {
        System.out.println();
        System.out.println("==============================================================");
        System.out.println("     MENU DE EJERCICIOS - JavaApplication2");
        System.out.println("==============================================================");
        System.out.println("  1 - Par o impar (numero entero)");
        System.out.println("  2 - Mayor de tres numeros enteros");
        System.out.println("  3 - Aprobado / desaprobado segun nota (umbral 11)");
        System.out.println("  4 - Clasificacion de calificacion con switch (rangos)");
        System.out.println("  5 - Es ano bisiesto?");
        System.out.println("  6 - Imprimir del 1 al 10 con while");
        System.out.println("  7 - Validar contrasena (bucle do-while)");
        System.out.println("  8 - Columnas alineadas con printf");
        System.out.println("  9 - Interseccion de dos arreglos (conjuntos)");
        System.out.println(" 10 - Tabla de nombres y edades (StringBuilder)");
        System.out.println(" 11 - Reporte de notas: PC1-PC3, parcial y promedio");
        System.out.println("--------------------------------------------------------------");
        System.out.println("  0 - Salir");
        System.out.println("==============================================================");
        System.out.print("Elige una opcion: ");
    }

    // endregion
    // region Condicionales básicos (if / else)
    // -------------------------------------------------------------------------

    /**
     * Pide un entero y dice si es par o impar (divisible entre 2 o no).
     */
    public static void ejercicio1() {
        Scanner lector = ENTRADA;
        System.out.println("Ingrese un numero entero");
        int numero = lector.nextInt();

        if (numero % 2 == 0) {
            System.out.println("Su numero es par");
        } else {
            System.out.println("Su numero es impar");
        }
    }

    /**
     * Lee tres números y muestra cuál es el mayor (comparaciones anidadas).
     */
    public static void ejercicio2() {
        Scanner lector = ENTRADA;

        System.out.println("Ingrese 3 numeros enteros");
        System.out.println("Ingrese el primer numero");
        int a = lector.nextInt();
        System.out.println("Ingrese el segundo numero");
        int b = lector.nextInt();
        System.out.println("Ingrese el tercer numero");
        int c = lector.nextInt();

        if (a > b && a > c) {
            System.out.println("El mayor numero es " + a);
        } else {
            if (b > a && b > c) {
                System.out.println("El mayor numero es " + b);
            } else {
                System.out.println("El mayor numero es " + c);
            }
        }
    }

    /**
     * Nota de examen: si es 11 o más aprueba; si no, desaprueba (umbral simple).
     */
    public static void ejercicio3() {
        Scanner lector = ENTRADA;
        System.out.println("Ingrese la nota de su examen:");
        int nota = lector.nextInt();

        if (nota >= 11) {
            System.out.println("APROBO");
        } else {
            System.out.println("DESAPROBO");
        }
    }

    // endregion
    // region Switch moderno (pattern matching con rangos)
    // -------------------------------------------------------------------------

    /**
     * Clasifica una calificación (0–20) en categorías usando {@code switch} con
     * patrones {@code Integer c when (...)} (característica de Java reciente).
     */
    public static void ejercicio4() {
        Scanner lector = ENTRADA;
        System.out.println("Ingrese la nota del alumno");
        Integer calificacion = lector.nextInt();

        String resultado = switch (calificacion) {
            case Integer c when (c > 18 && c <= 20) -> {
                yield "Excelente";
            }
            case Integer c when (c > 15 && c <= 18) -> {
                yield "Bueno";
            }
            case Integer c when (c > 13 && c <= 15) -> {
                yield "Regular";
            }
            case Integer c when (c > 0 && c <= 13) -> {
                yield "Deficiente";
            }
            default -> throw new IllegalArgumentException("Calificación no válida");
        };
        System.out.println(resultado);
    }

    /**
     * Determina si un año es bisiesto: divisible entre 4, excepto años seculares,
     * salvo que sea divisible entre 400.
     */
    public static void ejercicio5() {
        Scanner lector = ENTRADA;
        System.out.println("Ingrese el año");
        Integer año = lector.nextInt();

        String tipo = switch (año) {
            case Integer c when (c % 4 == 0 && !(c % 100 == 0)) -> {
                yield "Es año bisciesto";
            }
            case Integer c when (c % 400 == 0) -> {
                yield "Es año bisciesto";
            }
            default -> "No es año bisiesto";
        };
        System.out.println(tipo);
    }

    // endregion
    // region Bucles (while / do-while)
    // -------------------------------------------------------------------------

    /**
     * Imprime los números del 1 al 10 con un {@code while}.
     */
    public static void ejercicio6() {
        int contador = 1;
        while (contador <= 10) {
            System.out.println("Numero: " + contador);
            contador += 1;
        }
    }

    /**
     * Pide contraseña hasta que coincida con la guardada ({@code do-while}).
     */
    public static void ejercicio7() {
        Scanner lector = ENTRADA;
        String contraseña = "java123";
        String intentos;
        do {
            System.out.println("Ingrese la contraseña");
            intentos = lector.nextLine();
            if (!intentos.equals(contraseña)) {
                System.out.println("contraseña incorrecta, intente de nuevo");
            }
        } while (!intentos.equals(contraseña));
        System.out.println("Acceso concedido");
    }

    // endregion
    // region Formato de salida (printf)
    // -------------------------------------------------------------------------

    /**
     * Muestra columnas alineadas con {@code printf} y una línea decorativa con {@code repeat}.
     */
    public static void ejercicio8() {
        String a = "pedro";
        String e = "juan";
        String i = "manuel";
        String o = "pepita";
        String u = "mango";
        String r = "votame";
        String j = "tu";
        String t = "grrr";
        System.out.printf("%-16s, %4s, %4s, %3s, %3s, %3s, %2s, %6s%n", a, e, i, o, u, r, j, t);
        System.out.printf("%s REPORTE DE NOTAS %s%n", "#".repeat(16), "#".repeat(16));
    }

    // endregion
    // region Arreglos y conjuntos
    // -------------------------------------------------------------------------

    /**
     * Lee dos arreglos de enteros por teclado y muestra la intersección (valores
     * que aparecen en ambos), sin repetir por elemento de {@code a} gracias al {@code break}.
     */
    public static void ejercicio9() {
        Scanner lector = ENTRADA;
        System.out.println("Ingrese la cantidad de  elementos del primero conjunto");
        int n = lector.nextInt();

        System.out.println("Ingrese la cantidad de elementos del segundo conjunto");
        int m = lector.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        System.out.println("Ingrese los elementos del primero conjunto");
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el elemento " + (i + 1) + ":");
            a[i] = lector.nextInt();
        }
        System.out.println("Ingrese los elementos del segundo conjunto");
        for (int i = 0; i < m; i++) {
            System.out.println("Ingrese el elemento " + (i + 1) + ":");
            b[i] = lector.nextInt();
        }

        // Tamaño máximo posible de intersección: el menor de los dos tamaños
        int[] interseccion = new int[Math.min(a.length, b.length)];
        int contador = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    interseccion[contador] = a[i];
                    contador++;
                    break; // evita duplicar el mismo a[i] con más coincidencias en b
                }
            }
        }

        int[] resultado = Arrays.copyOf(interseccion, contador);
        System.out.println("Elementos en común almacenados en el arreglo:");
        System.out.println(Arrays.toString(resultado));
    }

    /**
     * Tabla de nombres y edades usando {@link StringBuilder} y líneas de {@code =}.
     */
    public static void ejercicio10() {
        String[] nombres = {"juana", "pepe", "pedro", "felipe", "Bri"};
        int[] edad = {18, 19, 15, 17, 20};
        StringBuilder reporte = new StringBuilder();
        reporte.append(String.format("%s%n", "=".repeat(50)));
        reporte.append(String.format("%27s%n", "INTEGRANTES"));
        reporte.append(String.format("%s%n", "=".repeat(50)));
        reporte.append(String.format("%-20s EDAD %n", "NOMBRES"));
        reporte.append(String.format("%s%n", "=".repeat(50)));
        for (int i = 0; i < nombres.length; i++) {
            reporte.append(String.format("%-20s %4s%n", nombres[i], edad[i]));
        }
        reporte.append(String.format("%s%n", "=".repeat(50)));
        System.out.println(reporte);
    }

    // endregion
    // region Reporte de notas (varias prácticas y promedio)
    // -------------------------------------------------------------------------

    /**
     * Tabla de estudiantes con notas PC1, PC2, PC3, parcial y promedio (media aritmética).
     */
    public static void ejercicio11() {
        String[] nom = {"juan", "pedro", "soto", "lucas", "pepe"};
        int[] pc1 = {13, 14, 15, 16, 17};
        int[] pc2 = {10, 16, 17, 11, 12};
        int[] pc3 = {15, 15, 12, 10, 8};
        int[] parcial = {11, 9, 7, 11, 13};
        double[] prom = new double[5];
        StringBuilder texto = new StringBuilder();
        texto.append(String.format("%s%n", "#".repeat(50)));
        texto.append(String.format("%30s%n", "Estudiantes"));
        texto.append(String.format("%s%n", "#".repeat(50)));
        texto.append(String.format("%-15s %4s %3s %3s %3s %3s %n ", "Nombres", "PC1", "PC2", "PC3", "PARCIAL", "PROMEDIO"));
        for (int i = 0; i < nom.length; i++) {
            prom[i] = (double) ((pc1[i] + pc2[i] + pc3[i] + parcial[i]) / 4);
            texto.append(String.format("%-15s %3s %2s %2s %8s %8s %n", nom[i], pc1[i], pc2[i], pc3[i], parcial[i], prom[i]));
        }
        texto.append(String.format("%s%n", "#".repeat(50)));
        System.out.println(texto);
    }

    // endregion
}
