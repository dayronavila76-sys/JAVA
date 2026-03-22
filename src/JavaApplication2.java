import java.util.Scanner;
import java.util.Arrays;
public class JavaApplication2 {
    

public static void main(String[] args){
   ejercicio11();
}

public static void ejercicio1() {
Scanner lector = new Scanner (System.in);
 System.out.println("Ingrese un numero entero");
int numero = lector.nextInt();

if (numero%2 == 0){
System.out.println("Su numero es par");


}else {
    System.out.println("Su numero es impar");
}
}
public static void ejercicio2(){
 Scanner lector = new Scanner(System.in);

  System.out.println("Ingrese 3 numeros enteros");
  System.out.println("Ingrese el primer numero");
  int a = lector.nextInt();
  System.out.println("Ingrese el segundo numero");
  int b = lector.nextInt();
  System.out.println("Ingrese el tercer numero");
  int c = lector.nextInt();
  if ( a > b && a > c ){
      System.out.println("El mayor numero es "+ a);
      
      
  }else {
      if(b>a && b>c){
      System.out.println("El mayor numero es "+ b);
      
      }else {
      System.out.println("El mayor numero es "+ c);
      }
              }
}
public static void ejercicio3(){ 
    
    Scanner lector = new Scanner(System.in);
    System.out.println("Ingrese la nota de su examen:");
    int nota = lector.nextInt();
    
    if (nota >= 11){
     System.out.println("APROBO");
    }else {
    System.out.println("DESAPROBO");
    }
        }
    
public static void ejercicio4(){
    Scanner lector = new Scanner (System.in);
    System.out.println("Ingrese la nota del alumno");
    Integer calificacion = lector.nextInt();
String resultado = switch (calificacion) {
case Integer c when (c > 18 && c <=20) ->{
yield "Excelente";
} 
case Integer c when (c > 15 && c <=18) ->{
yield "Bueno";
}
case Integer c when (c >13 && c <=15) -> {
yield "Regular";
}
case Integer c when (c > 0 && c <=13) -> {
yield "Deficiente";
}
default -> throw new IllegalArgumentException("Caificación no válida");
};
System.out.println(resultado);
}

public static void ejercicio5(){
Scanner lector = new Scanner (System.in);
System.out.println("Ingrese el año");
Integer año = lector.nextInt();
String tipo = switch(año){
    case Integer c when (c%4==0 && !(c%100 == 0) ) -> {
        yield "Es año bisciesto";
    }
    case Integer c when (c%400==0)-> {
        yield "Es año bisciesto";
    }
    default -> "No es año bisiesto";

};
System.out.println(tipo);
}
public static void ejercicio6(){
Scanner lector =  new Scanner (System.in);
int contador= 1;
while (contador <= 10){
System.out.println("Numero: "+ contador);
contador+=1;
}
}
public static void ejercicio7(){
Scanner lector = new Scanner (System.in); 
String contraseña = "java123";
String intentos;
do{
System.out.println("Ingrese la contraseña");
intentos = lector.nextLine();
if(!intentos.equals(contraseña)){
   System.out.println("contraseña incorrecta, intente de nuevo");
    
}
} while( !intentos.equals(contraseña));
System.out.println("Acceso concedido");


}

public static void ejercicio8(){
    Scanner lector = new Scanner(System.in);   
    String a = "pedro";
    String e = "juan";
    String i = "manuel";
    String o = "pepita";
    String u = "mango";
    String r = "votame";
    String j = "tu";
    String t = "grrr";
    System.out.printf("%-16s, %4s, %4s, %3s, %3s, %3s, %2s, %6s\n", a, e, i, o, u, r, j, t);
    System.out.printf("%s REPORTE DE NOTAS %s\n", "#".repeat(16), "#".repeat(16));

}
public static void ejercicio9(){
// Pero si quieres que el usario ingrese los datos seria asi. 
  Scanner lector = new Scanner(System.in);
System.out.println("Ingrese la cantidad de  elementos del primero conjunto");  
int n = lector.nextInt();

System.out.println("Ingrese la cantidad de elementos del segundo conjunto");        
int m = lector.nextInt();  

int[] a = new int[n];
int[] b = new int[m];

System.out.println("Ingrese los elementos del primero conjunto");
for(int i = 0; i< n; i++){
System.out.println("Ingrese el elemento "+ (i+1)+ ":");
a[i]= lector.nextInt();

}
System.out.println("Ingrese los elementos del segundo conjunto");
for(int i = 0; i< m; i++){
System.out.println("Ingrese el elemento "+ (i+1)+ ":");
b[i]= lector.nextInt();
}
// Codigo para econtrar la interseccion de dos conjuntos 
int[] interseccion = new int[Math.min(a.length,a.length)];  
int contador = 0; 
for(int i = 0; i < a.length; i++){
    for(int j = 0; j < b.length; j++){
    if(a[i] == b[j]){
        interseccion[contador] = a[i];
        contador++; 
        break;
    
    }
    }

}
 int[] resultado = Arrays.copyOf(interseccion, contador);
        System.out.println("Elementos en común almacenados en el arreglo:");
        System.out.println(Arrays.toString(resultado));
}

public static void ejercicio10(){

 String[] nombres = {"juana", "pepe", "pedro", "felipe", "Bri"};
 int [] edad = {18,19,15,17,20};
 StringBuilder reporte = new StringBuilder();
 reporte.append(String.format("%s\n", "=".repeat(50)));
 reporte.append(String.format("%27s\n", "INTEGRANTES"));
 reporte.append(String.format("%s\n", "=".repeat(50)));
 reporte.append(String.format("%-20s EDAD \n", "NOMBRES"));
 reporte.append(String.format("%s\n", "=".repeat(50)));
 for(int i = 0; i< nombres.length; i++){
 reporte.append(String.format("%-20s %4s\n", nombres[i], edad[i]));
 }
 reporte.append(String.format("%s\n", "=".repeat(50)));
 System.out.println(reporte);
} 

public static void ejercicio11(){
    String [] nom ={"juan", "pedro", "soto", "lucas", "pepe"};
    int [] pc1 = {13,14,15,16,17};
    int [] pc2 ={10,16,17,11,12};    
    int [] pc3 ={15,15,12,10,8};
    int [] parcial ={11,9,7,11,13};
    double [] prom = new double[5];
    StringBuilder texto = new StringBuilder();
    texto.append(String.format("%s\n", "#".repeat(50)));
    texto.append(String.format("%30s\n", "Estudiantes"));
    texto.append(String.format("%s\n", "#".repeat(50)));
    texto.append(String.format("%-15s %4s %3s %3s %3s %3s \n ", "Nombres", "PC1", "PC2","PC3","PARCIAL", "PROMEDIO"));
    for(int i = 0; i< nom.length; i++ ){
      prom[i]= (double)((pc1[i] + pc2[i] + pc3[i] + parcial[i])/4);
      texto.append(String.format("%-15s %3s %2s %2s %8s %8s \n",nom[i],pc1[i],pc2[i],pc3[i],parcial[i],prom[i]));
    
    
    }
    texto.append(String.format("%s\n", "#".repeat(50)));
    System.out.println(texto);
}
}