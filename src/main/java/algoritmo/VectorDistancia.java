/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package algoritmo;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class VectorDistancia {

 public  int distancia[] = new int[10];
 public  int costo[][] = new int[10][10];
 
 public void calc(int n,int origen)
 {
  int flag[] = new int[n+1];
  int i,k,c,minimo;
  int minpos=1;
  for(i=1;i<=n;i++)
  {  
      flag[i]=0; 
      this.distancia[i]=this.costo[origen][i]; 
  }
  c=2;
  while(c<=n)
  {
    minimo=99;
    for(k=1;k<=n;k++)
    { 
       if(this.distancia[k]<minimo && flag[k]!=1)
       {
        minimo=this.distancia[i];
        minpos=k;
       }
    } 
    flag[minpos]=1;
    c++;
    for(k=1;k<=n;k++){
       if(this.distancia[minpos]+this.costo[minpos][k] <  this.distancia[k] && flag[k]!=1 ){
       this.distancia[k]=this.distancia[minpos]+this.costo[minpos][k];
       }
    }   
  } 
 }
 public static void main(String args[]){
     int nodos,origen,i,j,destino;
  Scanner in = new Scanner(System.in);
  System.out.println("Ingrese el numero de nodos: \n");
  nodos = in.nextInt();
  VectorDistancia d = new VectorDistancia();
  System.out.println("\nIngrese el costo de los pesos de la matriz: \n");
        for(i=1;i<=nodos;i++){
          for(j=1;j<=nodos;j++)
          {
            d.costo[i][j]=in.nextInt();
            if(d.costo[i][j]==0){
              d.costo[i][j]=999;
            }
          }
        }
  System.out.println("\nIngrese el nodo de origen: \n");
  origen=in.nextInt();
  
  System.out.println("\nIngrese el nodo de destino: \n");
  destino=in.nextInt();
  
  d.calc(nodos,origen);
  System.out.println("\nLa ruta mas corta desde el nodo \t"+origen+"\t hacia el nodo de destino es: \n");
 
     if(destino!=origen){
             System.out.println("Origen : "+origen+"\t Destino : "+destino+"\t Costo mínimo es: "+d.distancia[destino]+"\t");
          } 
 }
    
}


//Valores de costo de cada nodo en matriz

/* A B C D E F

0 2 1 999 1 4 999
2 0 3 999 999 999 999
1 3 0 5 999 999 999
999 999 5 0 999 999 8
1 999 999 999 0 999 999
4 999 999 999 999 0 6
999 999 999 8 999 6 0


*/