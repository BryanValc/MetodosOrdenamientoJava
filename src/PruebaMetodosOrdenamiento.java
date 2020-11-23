import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
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
	static Scanner input = new Scanner(System.in);
	public static int validacionNatural() {
		int ret = 0;
		boolean err = false;
		do {
			try {
				ret = input.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("entrada no valida, intente de nuevo:");
				input.nextLine();
				err=true;
			}
			if (ret>0) {
				err=false;
			}else {
				System.out.println("solo números naturales");
				err=true;
			}
		}while(err);
		return ret;
	}
	public static int validacionNatural(String prompt) {
		System.out.println(prompt);
		return validacionNatural();
	}
	public static void mostrarMenu(String[] opciones) {
		for (int i = 0; i < opciones.length; i++) {
			System.out.println((i+1)+")"+opciones[i]);
		}
		System.out.println((opciones.length+1)+")Salir");
	}
	public static void mostrarMenu(String prefijo,String[] opciones) {
		for (int i = 0; i < opciones.length; i++) {
			System.out.println((i+1)+")"+prefijo+" "+opciones[i]);
		}
		System.out.println((opciones.length+1)+")Salir");
	}
	public static void mostrarMenu(String[] opciones,String prompt) {
		System.out.println(prompt);
		mostrarMenu(opciones);
	}
	public static void mostrarMenu(String prefijo,String[] opciones,String prompt) {
		System.out.println(prompt);
		mostrarMenu(prefijo,opciones);
	}
}//class Menu

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
				i+=1;
			}
			long fin = System.nanoTime();
			
			impresionBenchmark(numeros, comparaciones, intercambios, ini, fin);
			
		}
		public static void ordenacionBurbuja3(int[] nums) {
			int[] numeros = nums.clone();
			System.out.println("======ordenacionBurbuja3======");
			System.out.println("numeros desordenados: "+Arrays.toString(numeros));
			int comparaciones=0;
			int intercambios=0;
			
			int i =1;
			long ini = System.nanoTime();
			do{
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
				i+=1;
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
	
		int nums[]=GeneracionNumeros.generarNumerosAleatorios(10);
		
		int opc=0,opc1=0;
		boolean salir=false,salir1=false;
		String opciones[]= {"Mostrar por método de Burbuja","Mostrar por método de Insercion","Cambiar cantidad de números"};
		String opciones1[]= {"Burbuja1","Burbuja2","Burbuja3"};

		
		
		do {
			Menu.mostrarMenu(opciones,"======Menu Principal======");
			opc=Menu.validacionNatural();
			
			switch (opc) {
			case 1:
				do {
					salir1=false;
					Menu.mostrarMenu("Mostrar por método de",opciones1,"======Menu Burbuja======");
					opc1=Menu.validacionNatural();
					
					switch (opc1) {
					case 1:MetodosOrdenamiento.Burbuja.ordenacionBurbuja1(nums);break;
					case 2:MetodosOrdenamiento.Burbuja.ordenacionBurbuja2(nums);break;
					case 3:MetodosOrdenamiento.Burbuja.ordenacionBurbuja3(nums);break;
					case 4:salir1=true;break;
					default:System.out.println("Opcion no valida");break;
					}//switch
					
				} while (!salir1);
				break;
			case 2:
				MetodosOrdenamiento.Insercion.ordenacionInsercion(nums);break;
			case 3:
				int cnt = Menu.validacionNatural("Cantidad de elementos:");
				nums=GeneracionNumeros.generarNumerosAleatorios(cnt);
				break;
			case 4:
				salir=true;break;
			default:
				System.out.println("Opcion no valida");break;
			}//switch
			
		} while (!salir);
		System.out.println("Fin de ejecucion");
		
		
		
	}
	
}