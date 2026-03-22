
import java.util.Scanner;

public class newvclass {
    enum Desempeno { Excelente, MuyBien, Satisfactorio, Suficiente, Insatisfactorio }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la nota del alumno (0 - 20): ");
        int nota = sc.nextInt();

        Desempeno resultado;

        if (nota >= 18) {
            resultado = Desempeno.Excelente;
        } else if (nota >= 15) {
            resultado = Desempeno.MuyBien;
        } else if (nota >= 12) {
            resultado = Desempeno.Satisfactorio;
        } else if (nota >= 10) {
            resultado = Desempeno.Suficiente;
        } else {
            resultado = Desempeno.Insatisfactorio;
        }

        // Ahora mostramos con switch
        switch (resultado) {
            case Excelente -> System.out.println("¡Felicitaciones! Desempeño Excelente 🎉");
            case MuyBien -> System.out.println("Muy bien, sigue esforzándote 👍");
            case Satisfactorio -> System.out.println("Satisfactorio, puedes mejorar 📘");
            case Suficiente -> System.out.println("Suficiente, casi no apruebas ⚠");
            case Insatisfactorio -> System.out.println("Desempeño insuficiente, necesitas estudiar más ❌");
        }
    }
}
