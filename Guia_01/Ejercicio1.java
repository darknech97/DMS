//1. Crear un programa en consola que me permita saber si dos números son divisibles entre sí,para saber si un número es divisible por otro se tiene que obtener el modulo y si este es cero entonces este número es divisible por el otro.

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner ScnrTeclado = new Scanner(System.in);
    int iNumero;
    int iDivisor;
    System.out.print("Ingrese numero:");
    iNumero = ScnrTeclado.nextInt();
    System.out.print("Ingrese divisor:");
    iDivisor = ScnrTeclado.nextInt();

    if(iNumero % iDivisor == 0){
      System.out.print("El numero " + iNumero + " SI es divisible por " + iDivisor);
    }
    else{
      System.out.print("El numero " + iNumero + " NO es divisible por " + iDivisor);
    }
    
  }
}