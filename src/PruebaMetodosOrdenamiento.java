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
	public static int[] generarNumerosAleatorios(int cnt,int lim){
		int[] ret = new int[cnt];
		for (int i = 0; i < ret.length; i++) {
			ret[i]=(int)(Math.random()*lim);
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
		System.out.println();
		for (int i = 0; i < opciones.length; i++) {
			System.out.println((i+1)+")"+opciones[i]);
		}
		System.out.println((opciones.length+1)+")Salir\n");
	}
	public static void mostrarMenu(String prefijo,String[] opciones) {
		System.out.println();
		for (int i = 0; i < opciones.length; i++) {
			System.out.println((i+1)+")"+prefijo+" "+opciones[i]);
		}
		System.out.println((opciones.length+1)+")Salir\n");
	}
	public static void mostrarMenu(String[] opciones1,String prefijo,String[] opciones2) {
		System.out.println();
		int j=0;
		for (int i = 0; i < opciones1.length; i++,j++) {
			System.out.println((i+1)+")"+opciones1[i]);
		}
		for (int i = 0; i < opciones2.length; i++,j++) {
			System.out.println((j+1)+")"+prefijo+" "+opciones2[i]);
		}
		System.out.println((j)+")Salir\n");
	}
	public static void mostrarMenu(String[] opciones,String prompt) {
		System.out.println("\n"+prompt);
		mostrarMenu(opciones);
	}
	public static void mostrarMenu(String prefijo,String[] opciones,String prompt) {
		System.out.println("\n"+prompt);
		mostrarMenu(prefijo,opciones);
	}
	public static void mostrarMenu(String[] opciones1,String prefijo,String[] opciones2,String prompt) {
		System.out.println("\n"+prompt);
		mostrarMenu(opciones1,prefijo,opciones2);
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
		
		public static void ordenacionBurbuja1(int nums[]) {
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
		public static void ordenacionBurbuja2(int nums[]) {
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
			}
			long fin = System.nanoTime();
			
			impresionBenchmark(numeros, comparaciones, intercambios, ini, fin);
			
		}
		public static void ordenacionBurbuja3(int nums[]) {
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
		
		public static void ordenacionInsercion(int nums[]) {
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
		
		public static void mostrarVector(int numeros[]) {
			System.out.println(Arrays.toString(numeros));
		}
	}//class Insercion

	
	static class Intercalacion{
		
		public static void complementoIntercalacion(int numeros[]){
			int aux;
			for (int i = 1; i < numeros.length; i++) {
				aux=numeros[i];
				for (int j=i-1; j>=0 && numeros[j]>aux ; j--) {
					numeros[j+1]=numeros[j];
					numeros[j]=aux;
				}
			}
		}
		
		public static void ordenacionIntercalacion(int nums[]) {
			int numeros[]=nums.clone();
			System.out.println("======ordenarIntercalacion======");
			int[] arregloA,arregloB;
			
			int comparaciones=0;
			int intercambios=0;
			
			if (numeros.length%2==0) {
				arregloA=new int[numeros.length/2];
				arregloB=new int[numeros.length/2];
			}else {
				arregloA=new int[numeros.length/2];
				arregloB=new int[(numeros.length/2)+1];
			}
			for (int i = 0; i < numeros.length; i++) {
				if (i<numeros.length/2) {
					arregloA[i]=numeros[i];
				}else {
					arregloB[i-arregloA.length]=numeros[i];
				}
			}
			complementoIntercalacion(arregloA);
			complementoIntercalacion(arregloB);

			System.out.println("primer vector: "+Arrays.toString(arregloA));
			System.out.println("primer vector: "+Arrays.toString(arregloB));
			
			long ini = System.nanoTime();
			
			int arregloC[] = new int[arregloA.length+arregloB.length];
			
			int i,k,j;
			for(i=j=k=0; i<arregloA.length && j<arregloB.length; k++){
				if(arregloA[i]<arregloB[j]) {
					arregloC[k] = arregloA[i];
					i++;
				}else {
					arregloC[k] = arregloB[j];
					j++;
				}
			}
			for(;i<arregloA.length; i++,k++) {
				arregloC[k] = arregloA[i];
			}
			for(;j<arregloB.length; j++,k++) {
				arregloC[k] = arregloB[j];
			}
			
			long fin = System.nanoTime();
			
			impresionBenchmark(arregloC, comparaciones, intercambios, ini, fin);
		}
		
		public static void mostrarVector(int numeros[]) {
			System.out.println(Arrays.toString(numeros));
		}
		
		
	}
	
	
	static class MezclaDirecto{
		static int comparaciones=0;
		static int intercambios=0;
		
		public static int [] ordenamientoMezclaDirecto(int arreglo[]) {
			int i,j,k;
			if(arreglo.length>1) {
				int numElementosIzq=arreglo.length/2;
				int numElmentosDer=arreglo.length-numElementosIzq;
				
				int arregloIzquierdo[]=new int[numElementosIzq];
				int arregloDerecha[]=new int[numElmentosDer];
				for(i=0;i<numElementosIzq;i++) {
					arregloIzquierdo[i]=arreglo[i];
					intercambios+=1;
				}
				i=0;
				for(i=numElementosIzq;i<numElementosIzq+numElmentosDer;i++) {
					arregloDerecha[i-numElementosIzq]=arreglo[i];
					intercambios+=1;
				}
				
				arregloIzquierdo=ordenamientoMezclaDirecto(arregloIzquierdo);
				arregloDerecha=ordenamientoMezclaDirecto(arregloDerecha);
				i=j=k=0;
				while(arregloIzquierdo.length!=j && arregloDerecha.length!=k) {
					comparaciones+=1;
					intercambios+=1;
					if(arregloIzquierdo[j]<arregloDerecha[k]) {
						arreglo[i]=arregloIzquierdo[j];
						i++;
						j++;
					}else {
						arreglo[i]=arregloDerecha[k];
						i++;
						k++;
					}
				}
				while(arregloIzquierdo.length!=j) {
					intercambios+=1;
					arreglo[i]=arregloIzquierdo[j];
					i++;
					j++;
				}
				while(arregloDerecha.length!=k) {
					intercambios+=1;
					arreglo[i]=arregloDerecha[k];
					i++;
					k++;
				}
			}
			
			return arreglo;
		}
		
		public static void llamadaOrdenamientoMezclaDirecto(int nums[]) {
			int numeros[]=nums.clone();
			System.out.println("======ordenarMezclaDirecto======");
			System.out.println("numeros desordenados: "+Arrays.toString(numeros));
			
			long ini = System.nanoTime();
			ordenamientoMezclaDirecto(numeros);
			long fin = System.nanoTime();
			
			impresionBenchmark(numeros, comparaciones, intercambios, ini, fin);
			comparaciones=intercambios=0;
		}

		public static void mostrarVector(int numeros[]) {
			System.out.println(Arrays.toString(numeros));
		}
		
	}
	
	
	static class Seleccion{
		
		public static void ordenacionSeleccion(int[] nums) {
			int numeros[]=nums.clone();
			System.out.println("======ordenarSeleccion======");
			System.out.println("numeros desordenados: "+Arrays.toString(numeros));
			int comparaciones=0;
			int intercambios=0;
			
			long ini = System.nanoTime();
			for(int i = 0; i < numeros.length - 1; i++) {
				for(int j = i + 1; j < numeros.length; j++) {
					comparaciones+=1;
					if(numeros[i] > numeros[j]) {
						intercambios+=1;
						int orden = numeros[i];
						numeros[i] = numeros[j];
						numeros[j] = orden;
					}
				}
			}
			long fin = System.nanoTime();
			impresionBenchmark(numeros, comparaciones, intercambios, ini, fin);
			
		}
		
		public static void mostrarVector(int numeros[]) {
			System.out.println(Arrays.toString(numeros));
		}
	
	}//class Seleccion
	
}//class MetodosOrdenamiento

public class PruebaMetodosOrdenamiento{
	
	public static void main(String[] args) {
	
		int nums[]=GeneracionNumeros.generarNumerosAleatorios(11);
		System.out.println("numeros: "+Arrays.toString(nums));
		
		boolean salir=false,salir1=false,salir3=false;
		String opcionespt1[]= {"Cambiar cantidad de numeros"};
		String opcionespt2[]= {"Burbuja","Insercion","Seleccion","Intercalacion","directo"};
		String opciones1[]= {"Burbuja1","Burbuja2","Burbuja3"};
		String opciones4[]= {"X cantidad de elementos con X limite","X cantidad de elementos con Y limite"};

		do {
			
			Menu.mostrarMenu(opcionespt1,"Mostrar por metodo de",opcionespt2,"======Menu Principal======");
			int opc=Menu.validacionNatural();
			if (opc==(opcionespt1.length+opcionespt2.length+1)) {
				salir=true;
			}else {
				switch (opc) {
				case 1:
					do {
						salir3=false;
						Menu.mostrarMenu(opciones4,"======Menu Numeros======");
						
						switch (Menu.validacionNatural()) {
						case 1:nums=GeneracionNumeros.generarNumerosAleatorios(Menu.validacionNatural("X:"));break;
						case 2:nums=GeneracionNumeros.generarNumerosAleatorios(Menu.validacionNatural("X:"),Menu.validacionNatural("Y:"));break;
						case 3:salir3=true;break;
						default:System.out.println("Opcion no valida");break;
						}//switch
						
					} while (!salir3);
					break;
				case 2:
					do {
						salir1=false;
						Menu.mostrarMenu("Mostrar por método de",opciones1,"======Menu Burbuja======");
						
						switch (Menu.validacionNatural()) {
						case 1:MetodosOrdenamiento.Burbuja.ordenacionBurbuja1(nums);break;
						case 2:MetodosOrdenamiento.Burbuja.ordenacionBurbuja2(nums);break;
						case 3:MetodosOrdenamiento.Burbuja.ordenacionBurbuja3(nums);break;
						case 4:salir1=true;break;
						default:System.out.println("Opcion no valida");break;
						}//switch
						
					} while (!salir1);
					break;
				case 3:
					MetodosOrdenamiento.Insercion.ordenacionInsercion(nums);break;
				case 4:
					MetodosOrdenamiento.Seleccion.ordenacionSeleccion(nums);break;
				case 5:
					MetodosOrdenamiento.Intercalacion.ordenacionIntercalacion(nums);break;
				case 6:
					MetodosOrdenamiento.MezclaDirecto.llamadaOrdenamientoMezclaDirecto(nums);break;
				default:
					System.out.println("Opcion no valida");break;
				}//switch
			}//else
		} while (!salir);
		System.out.println("Fin de ejecucion");
		
	}
	
}