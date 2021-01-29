//2. Escribir un programa que solicite ingresar 10 notas de alumnos y nos informe cuántos tienen notas mayores o iguales a 7 y cuántos menores.

import java.io.*; 
import java.util.*; 

class Main {
  public static void main(String[] args) {
    Scanner ScnrTeclado = new Scanner(System.in);
    int iNota = 0;
    int[] iNotas = new int[10];
    int iMayor = 0;
    int iMenor = 0;

    for(int i=0; i < 10; i++){
      System.out.print("Ingresar nota:");
      iNota = ScnrTeclado.nextInt();
      iNotas[i] = iNota;

      if(iNota >= 7){
        iMayor++;
      }
      else{
        iMenor++;
      }
    }

    System.out.print("De las notas " + Arrays.toString(iNotas) + " hay " + iMayor + " nota(s) mayor(es) o iguale(s) a 7 y " + iMenor + " nota(s) menor(es) a 7.");
  }
}