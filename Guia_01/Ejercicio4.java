//4. Escribir un programa que pida ingresar coordenadas (x,y) que representan puntos en el plano. Informar cuántos puntos se han ingresado en el primer, segundo, tercer y cuarto cuadrante.Al comenzar el programa se pide que se ingrese la cantidad de puntos a procesar.

import java.io.*; 
import java.util.*; 

class Main {
  public static void main(String[] args) {
    Scanner ScnrTeclado = new Scanner(System.in);
    int iX = 0;
    int iY = 0;
    int[] iCuadrantes = new int[4];

    System.out.print("Ingrese numero de coordenadas a ingresar:");
    int iRepeticiones = ScnrTeclado.nextInt();

    for(int i=0; i < iRepeticiones; i++){
      System.out.print("Ingresar x:");
      iX = ScnrTeclado.nextInt();
      System.out.print("Ingresar y:");
      iY = ScnrTeclado.nextInt();

      if((iX >= 0) && (iY >= 0)){
        iCuadrantes[0]++;
      }
      else if((iX < 0) && (iY >= 0)){
        iCuadrantes[1]++;
      }
      else if((iX < 0) && (iY < 0)){
        iCuadrantes[2]++;
      }
      else if((iX >= 0) && (iY < 0)){
        iCuadrantes[3]++;
      }
      
    }

    System.out.print("De las coordenadas ingresadas hay " + iCuadrantes[0] + " en el primer cuadrante, " + iCuadrantes[1] + " en el segundo cuadrante, " + iCuadrantes[2] + " en el tercer cuadrante y " + iCuadrantes[3] + " en el cuarto cuadrante.");
  }
}