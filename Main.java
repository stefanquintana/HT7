import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner; 
/**
 * 
 * @author Stefan Quintana
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Se definen los nuevos árboles
		ArbolBinarioBusqueda arbolIngles = new ArbolBinarioBusqueda<String,Data>(new Comparador<String,Data>(), new KeyData<String,Data>());
		ArbolBinarioBusqueda arbolEsp = new ArbolBinarioBusqueda<String,Data>(new Comparador<String,Data>(), new KeyData<String,Data>());
		ArbolBinarioBusqueda arbolFrances = new ArbolBinarioBusqueda<String,Data>(new Comparador<String,Data>(), new KeyData<String,Data>());
		
		//Archivo diccionario
		String nombreUno = "Diccionario.txt";
		//Archivo de texto a traducir
		String nombreDos = "Texto.txt";
		
		ArrayList<String> diccionario = leerArchivo(nombreUno);
		
		for(String elemento : diccionario) {
			String nuevoString = quitarBasura(elemento);
			String[] lista = nuevoString.split(",");
			arbolIngles.Insert(lista[0], new Data(lista[0], lista[0], lista[1], lista[2]));
			arbolEsp.Insert(lista[1], new Data(lista[1], lista[0], lista[1], lista[2]));
			arbolFrances.Insert(lista[2], new Data(lista[2], lista[0], lista[1], lista[2]));
		}
		
		ArrayList<String> texto = leerArchivo(nombreDos);
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Escoja que quiere hacer");
		System.out.println("1. Traducir texto\n2. Imprimir un arbol en orden");
		String o = teclado.nextLine();
		
		if(o.equals("1")) {
			//Pedir el idioma origen 
			System.out.println("Escoja el idioma origen del texto");
			System.out.println("1. Inglés\n2. Español\n3. Francés");
			String opcion = teclado.nextLine();
			
			String nuevoTexto = "";
			
			if(opcion.equals("1")) {
				//Elegir el idioma objetivo
				System.out.println("Escoja el idioma objetivo al que se desea traducir");
				System.out.println("1. Español\n2. Francés");
				String op = teclado.nextLine();
				
				if(op.equals("1")) {
					//Empezar ciclo for para cada linea del texto
					for(String elemento : texto) {
						String nTexto = "";
						//Separar la linea por sus espacios
						String[] lista = elemento.split(" ");
						//Empezar ciclo para cada elemento de la lista
						for(String el : lista) {
							//Se busca la data en el arbol que tiene como raiz el inglés
							String min = quitarBasura(el);
							Data datosN = (Data)arbolIngles.Find(min, arbolIngles._raiz);
							//buscar si existe esta raiz en el arbol
							if(datosN != null) {
								//Buscar en los datos la traducción a español
								String n = datosN.getEsp();
								nTexto = nTexto + n + " ";
							}
							else {
								//En caso de no existir añadir Asteriscos para saber que no se puede traducir
								String n = "*" + el +"*";
								nTexto = nTexto + n + " ";
							}
							
						}
						//Agregar la linea al texto completo
						nuevoTexto = nuevoTexto + nTexto + "\n";
					}
				}
				else
					if(op.equals("2")) {
						//Empezar ciclo for para cada linea del texto
						for(String elemento : texto) {
							String nTexto = "";
							//Separar la linea por sus espacios
							String[] lista = elemento.split(" ");
							//Empezar ciclo para cada elemento de la lista
							for(String el : lista) {
								//Se busca la data en el arbol que tiene como raiz el inglés
								String min = quitarBasura(el);
								Data datosN = (Data)arbolIngles.Find(min, arbolIngles._raiz);
								//buscar si existe esta raiz en el arbol
								if(datosN != null) {
									//Buscar en los datos la traducción a Francés
									String n = datosN.getFrances();
									nTexto = nTexto + n + " ";
								}
								else {
									//En caso de no existir añadir Asteriscos para saber que no se puede traducir
									String n = "*" + el +"*";
									nTexto = nTexto + n + " ";
								}
								
							}
							//Agregar la linea al texto completo
							nuevoTexto = nuevoTexto + nTexto + "\n";
						}
					}
					else {
						System.out.println("Digite correctamente la opción");
					}
				
			}
			else
				if(opcion.equals("2")) {
					//Elegir el idioma objetivo
					System.out.println("Escoja el idioma objetivo al que se desea traducir");
					System.out.println("1. Inglés\n2. Francés");
					String op = teclado.nextLine();
					
					if(op.equals("1")) {
						//Empezar ciclo for para cada linea del texto
						for(String elemento : texto) {
							String nTexto = "";
							//Separar la linea por sus espacios
							String[] lista = elemento.split(" ");
							//Empezar ciclo para cada elemento de la lista
							for(String el : lista) {
								//Se busca la data en el arbol que tiene como raiz el Español
								String min = quitarBasura(el);
								Data datosN = (Data)arbolEsp.Find(min, arbolEsp._raiz);
								//buscar si existe esta raiz en el arbol
								if(datosN != null) {
									//Buscar en los datos la traducción a inglés
									String n = datosN.getIngles();
									nTexto = nTexto + n + " ";
								}
								else {
									//En caso de no existir añadir Asteriscos para saber que no se puede traducir
									String n = "*" + el +"*";
									nTexto = nTexto + n + " ";
								}
								
							}
							//Agregar la linea al texto completo
							nuevoTexto = nuevoTexto + nTexto + "\n";
						}
					}
					else
						if(op.equals("2")) {
							//Empezar ciclo for para cada linea del texto
							for(String elemento : texto) {
								String nTexto = "";
								//Separar la linea por sus espacios
								String[] lista = elemento.split(" ");
								//Empezar ciclo para cada elemento de la lista
								for(String el : lista) {
									//Se busca la data en el arbol que tiene como raiz el Español
									String min = quitarBasura(el);
									Data datosN = (Data)arbolEsp.Find(min, arbolEsp._raiz);
									//buscar si existe esta raiz en el arbol
									if(datosN != null) {
										//Buscar en los datos la traducción a Frances
										String n = datosN.getFrances();
										nTexto = nTexto + n + " ";
									}
									else {
										//En caso de no existir añadir Asteriscos para saber que no se puede traducir
										String n = "*" + el +"*";
										nTexto = nTexto + n + " ";
									}
									
								}
								//Agregar la linea al texto completo
								nuevoTexto = nuevoTexto + nTexto + "\n";
							}
						}
						else {
							System.out.println("Digite correctamente la opción");
						}
				}
				else
					if(opcion.equals("3")) {
						//Elegir el idioma objetivo
						System.out.println("Escoja el idioma objetivo al que se desea traducir");
						System.out.println("1. Inglés\n2. Español");
						String op = teclado.nextLine();
						
						if(op.equals("1")) {
							//Empezar ciclo for para cada linea del texto
							for(String elemento : texto) {
								String nTexto = "";
								//Separar la linea por sus espacios
								String[] lista = elemento.split(" ");
								//Empezar ciclo para cada elemento de la lista
								for(String el : lista) {
									//Se busca la data en el arbol que tiene como raiz el francés
									String min = quitarBasura(el);
									Data datosN = (Data)arbolFrances.Find(min, arbolFrances._raiz);
									//buscar si existe esta raiz en el arbol
									if(datosN != null) {
										//Buscar en los datos la traducción a ingles
										String n = datosN.getIngles();
										nTexto = nTexto + n + " ";
									}
									else {
										//En caso de no existir añadir Asteriscos para saber que no se puede traducir
										String n = "*" + el +"*";
										nTexto = nTexto + n + " ";
									}
									
								}
								//Agregar la linea al texto completo
								nuevoTexto = nuevoTexto + nTexto + "\n";
							}
						}
						else
							if(op.equals("2")) {
								//Empezar ciclo for para cada linea del texto
								for(String elemento : texto) {
									String nTexto = "";
									//Separar la linea por sus espacios
									String[] lista = elemento.split(" ");
									//Empezar ciclo para cada elemento de la lista
									for(String el : lista) {
										//Se busca la data en el arbol que tiene como raiz el frances
										String min = quitarBasura(el);
										Data datosN = (Data)arbolFrances.Find(min, arbolFrances._raiz);
										//buscar si existe esta raiz en el arbol
										if(datosN != null) {
											//Buscar en los datos la traducción a español
											String n = datosN.getEsp();
											nTexto = nTexto + n + " ";
										}
										else {
											//En caso de no existir añadir Asteriscos para saber que no se puede traducir
											String n = "*" + el +"*";
											nTexto = nTexto + n + " ";
										}
										
									}
									//Agregar la linea al texto completo
									nuevoTexto = nuevoTexto + nTexto + "\n";
								}
							}
							else {
								System.out.println("Digite correctamente la opción");
							}
					}
					else {
						System.out.println("Digite una opción correctamente");
					}
			
			System.out.println("Su texto traducido es: ");
			System.out.println(nuevoTexto);
		}
		else
			if(o.equals("2")) {
				System.out.println("Escoja el idioma que quiera que sea la base del ordenamiento");
				System.out.println("1. Ingles\n2. Español\n3. Frances");
				String opcion = teclado.nextLine();
				if(opcion.equals("1")) {
					arbolIngles.InOrder(new Visitar<String, Data>(), arbolIngles._raiz);
				}
				else
					if(opcion.equals("2")) {
						arbolEsp.InOrder(new Visitar<String, Data>(), arbolEsp._raiz);
					}
					else
						if(opcion.equals("3")) {
							arbolFrances.InOrder(new Visitar<String, Data>(), arbolFrances._raiz);
						}
						else {
							System.out.println("Digite correctamente la opción");
						}
				
			}
			else {
				System.out.println("Digite correctamente la opción");
			}		
		
	}
	
	

	public static ArrayList<String> leerArchivo(String nombre) {
		File archivo = null;
		FileReader fr = null;
	    BufferedReader br = null;
	    ArrayList<String> lista = new ArrayList<String>();

	    try {
	    	// Apertura del fichero y creacion de BufferedReader para poder
	        // hacer una lectura comoda (disponer del metodo readLine()).
	        archivo = new File (nombre);
	        fr = new FileReader (archivo);
	        br = new BufferedReader(fr);

	        // Lectura del fichero
	        String linea;
	        while((linea=br.readLine())!=null) {
	        	lista.add(linea);
	        }
	    }
	    
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    finally{
	    	// En el finally cerramos el fichero, para asegurarnos
	        // que se cierra tanto si todo va bien como si salta 
	        // una excepcion.
	    	try{                    
	    		if( null != fr ){   
	    			fr.close();     
	    		}                  
	    	}catch (Exception e2){
	    		e2.printStackTrace();
	    	}
	    }
		return lista;
	}
	
	public static String quitarBasura(String string) {
		char[] list = string.toCharArray(); 
		String nv = "";
		for(char c : list) {
			if(c == ' ') {
			
			}
			else {
				nv = nv + c;
			}
		}
		//Convertir a minusculas
		nv = nv.toLowerCase();
		
		return nv;
	}

}
