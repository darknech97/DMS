//3. Desarrollar un programa que permita cargar n números enteros y luego nos informe cuántos valores fueron pares y cuántos impares.

import java.io.*; 
import java.util.*; 

class Main {
  public static void main(String[] args) {
    Scanner ScnrTeclado = new Scanner(System.in);
    int iNumero = 0;
    int iPar = 0;
    int iImpar = 0;

    System.out.print("Ingrese numero de numeros a ingresar:");
    int iRepeticiones = ScnrTeclado.nextInt();
    int[] iNumeros = new int[iRepeticiones];

    for(int i=0; i < iRepeticiones; i++){
      System.out.print("Ingresar numero:");
      iNumero = ScnrTeclado.nextInt();
      iNumeros[i] = iNumero;

      if(iNumero % 2 == 0){
        iPar++;
      }
      else{
        iImpar++;
      }
    }

    System.out.print("De los numeros " + Arrays.toString(iNumeros) + " hay " + iPar + " numero(s) par(es)  y " + iImpar + " numero(s) impar(es).");
  }
}