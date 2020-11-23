import java.util.ArrayList;
import java.util.Arrays;
import java.math.*;

class GeneracionNumeros{
	
	public static int[] generarNumerosAleatorios(int cnt){
		int[] ret = new int[cnt];
		
		for (int i = 0; i < ret.length; i++) {
			ret[i]=(int)(Math.random()*cnt);
		}
		
	    return ret;
	    
	}

}//class GeneracionNumeros

class Menu{
	public static void mostrarMenu(String[] opciones) {
		for (int i = 0; i < opciones.length; i++) {
			System.out.println((i+1)+")"+opciones[i]);
		}
	}
	public static void mostrarMenu(String prefijo,String[] opciones) {
		for (int i = 0; i < opciones.length; i++) {
			System.out.println((i+1)+")"+prefijo+" "+opciones[i]);
		}
	}
}

class MetodosOrdenamiento{
	
	public static void impresionBenchmark(int [] numeros,int comparaciones,int intercambios,long ini,long fin) {
		System.out.println("numeros ordenados: "+Arrays.toString(numeros));
		System.out.println("cantidad de comparaciones: "+comparaciones);
		System.out.println("cantidad de intercambios: "+intercambios);
		System.out.println("tiempo de ejecucion en nanosegundos:"+(fin-ini));
	}//benchmark

	static class Burbuja {
		
		public static void ordenacionBurbuja1(int[] nums) {
			int[] numeros = nums.clone();
			System.out.println("======ordenacionBurbuja1======");
			System.out.println("numeros desordenados: "+Arrays.toString(numeros));
			int comparaciones=0;
			int intercambios=0;
			
			long ini = System.nanoTime();
			for (int i = 1; i < numeros.length; i++) {
				for (int j = 0; j <= numeros.length-i-1; j++) {
					comparaciones+=1;
					if(numeros[j]>numeros[j+1]) {
						intercambios+=1;
						int aux = numeros[j];
						numeros[j]=numeros[j+1];
						numeros[j+1]=aux;
					}
				}
			}
			long fin = System.nanoTime();
			
			impresionBenchmark(numeros, comparaciones, intercambios, ini, fin);
			
		}
		public static void ordenacionBurbuja2(int[] nums) {
			int[] numeros = nums.clone();
			System.out.println("======ordenacionBurbuja2======");
			System.out.println("numeros desordenados: "+Arrays.toString(numeros));
			int comparaciones=0;
			int intercambios=0;
			
			int i =1;
			boolean ordenado=false;
			long ini = System.nanoTime();
			while (i<numeros.length) {
				i+=1;
				ordenado=true;
				for (int j = 0; j < numeros.length-i-1; j++) {
					comparaciones+=1;
					if(numeros[j]>numeros[j+1]) {
						intercambios+=1;
						ordenado=false;
						int aux = numeros[j];
						numeros[j]=numeros[j+1];
						numeros[j+1]=aux;
					}
				}
			}
			long fin = System.nanoTime();
			
			impresionBenchmark(numeros, comparaciones, intercambios, ini, fin);
			
		}
		public static void ordenacionBurbuja3(int[] nums) {
			int[] numeros = nums.clone();
			System.out.println("======ordenacionBurbuja1======");
			System.out.println("numeros desordenados: "+Arrays.toString(numeros));
			int comparaciones=0;
			int intercambios=0;
			
			int i =1;
			long ini = System.nanoTime();
			do{
				i+=1;
				boolean ordenado=true;
				for (int j = 0; j < numeros.length-i; j++) {
					comparaciones+=1;
					if(numeros[j]>numeros[j+1]) {
						intercambios+=1;
						ordenado=false;
						int aux = numeros[j];
						numeros[j]=numeros[j+1];
						numeros[j+1]=aux;
					}
				}
			}while (i<numeros.length);
			long fin = System.nanoTime();
			
			impresionBenchmark(numeros, comparaciones, intercambios, ini, fin);
			
		}
		
		public static void mostrarVector(int [] numeros) {
			System.out.println(Arrays.toString(numeros));
		}
	
	}//class Burbuja
	
	
	static class Insercion {
		
		public static void ordenacionInsercion(int[] nums) {
			int[] numeros = nums.clone();
			System.out.println("======ordenarInsercion======");
			System.out.println("numeros desordenados: "+Arrays.toString(numeros));
			int comparaciones=0;
			int intercambios=0;
			int aux;
			
			long ini = System.nanoTime();
			for (int i = 1; i < numeros.length; i++) {
				aux=numeros[i];
				comparaciones+=1;
				for (int j=i-1; j>=0 && numeros[j]>aux ; j--) {
					comparaciones+=1;
					numeros[j+1]=numeros[j];
					numeros[j]=aux;
					intercambios+=1;
				}
				
			}
			long fin = System.nanoTime();
			
			impresionBenchmark(numeros, comparaciones, intercambios, ini, fin);
			
		}
		
		public static void mostrarVector(int [] numeros) {
			System.out.println(Arrays.toString(numeros));
		}
	}//class Insercion

	
}//class MetodosOrdenamiento

public class PruebaMetodosOrdenamiento{
	
	public static void main(String[] args) {
	
		int nums[]=GeneracionNumeros.generarNumerosAleatorios(2000);

		MetodosOrdenamiento.Burbuja.ordenacionBurbuja1(nums);
		MetodosOrdenamiento.Burbuja.ordenacionBurbuja2(nums);
		MetodosOrdenamiento.Burbuja.ordenacionBurbuja3(nums);
		MetodosOrdenamiento.Insercion.ordenacionInsercion(nums);

		String opciones[]= {"Burbuja","Insercion"};
		Menu.mostrarMenu("Mostrar por método de",opciones);
		
		
		
		
	}
	
}