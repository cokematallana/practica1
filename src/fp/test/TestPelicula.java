package fp.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fp.audiovisuales.MiembroStaff;
import fp.audiovisuales.MiembroStaffImpl;
import fp.audiovisuales.Pelicula;
import fp.utiles.Ficheros;

/** Pruebas sobre el tipo Pelicula. 
 * Es necesario previamente haber implementado el tipo MiembroStaff
 * y haberlo probado mediante TestMiembroStaff.
 */
public class TestPelicula {

	

	public static void main(String[] args) {
		System.out.println("Tests del tipo Pelicula\n");
				
		Map<Integer, MiembroStaff> miembros = cargaMiembros("datos/miembros.csv");
				
		test01();
		test02();
		test03();
		test04("84334;Buscando a Sugar Man;Searching for Sugar Man;en;2012-06-30;PT1H27M;Documental;Passion Pictures;Sweden;930708;1132085#1133582#1133583#1181323#1852402#1852410#1852405#1413203#115463#930708;930708;http://image.tmdb.org/t/p/w342/7Jr5J3pdgEnQymHNge20XUM3YlV.jpg", miembros);
		// Duración incorrecta, debe lanzar excepción
		test04("84334;Buscando a Sugar Man;Searching for Sugar Man;en;2012-06-30;PT0S;Documental;Passion Pictures;Sweden;930708;1132085#1133582#1133583#1181323#1852402#1852410#1852405#1413203#115463#930708;930708;http://image.tmdb.org/t/p/w342/7Jr5J3pdgEnQymHNge20XUM3YlV.jpg", miembros);
		// Fecha de estreno incorrecta, debe lanzar excepción
		test04("84334;Buscando a Sugar Man;Searching for Sugar Man;en;2029-06-30;PT1H27M;Documental;Passion Pictures;Sweden;930708;1132085#1133582#1133583#1181323#1852402#1852410#1852405#1413203#115463#930708;930708;http://image.tmdb.org/t/p/w342/7Jr5J3pdgEnQymHNge20XUM3YlV.jpg", miembros);
		test05();
		test06();
		test07();
		test08("84334;Buscando a Sugar Man;Searching for Sugar Man;en;2012-06-30;PT1H27M;Documental;Passion Pictures;Sweden;930708;1132085#1133582#1133583#1181323#1852402#1852410#1852405#1413203#115463#930708;930708;http://image.tmdb.org/t/p/w342/7Jr5J3pdgEnQymHNge20XUM3YlV.jpg", miembros);
		test09("84334;Buscando a Sugar Man;Searching for Sugar Man;en;2012-06-30;PT1H27M;Documental;Passion Pictures;Sweden;930708;1132085#1133582#1133583#1181323#1852402#1852410#1852405#1413203#115463#930708;930708;http://image.tmdb.org/t/p/w342/7Jr5J3pdgEnQymHNge20XUM3YlV.jpg", miembros);
	}

	private static void test01() {		
		System.out.println("*********** Prueba 1");
		
		/* TODO: 
		 * 1. Crea un objeto de tipo Pelicula con estos valores en sus propiedades:
		 * id: 84334
		 * título: Buscando a Sugar Man
		 * título original: Searching the Sugar Man
		 * idioma original: en
		 * fecha de estreno: 2012-06-30
		 * duracion: 5220 segundos
		 * genero: Documental
		 * productora: Passion Pictures
		 * nacionalidad: Sweden
		 * directores: null
		 * actores: null
		 * guionistas: null
		 * url de imagen del póster: http://image.tmdb.org/t/p/w342/7Jr5J3pdgEnQymHNge20XUM3YlV.jpg
		 *  
		 * 2. Múestralo en la consola.
		 * 
		 * 3. Muestra el tipo de metraje por la consola.
		 * 
		 * 4. 
		 */
		
		System.out.println();
	}

	private static void test02() {		
		System.out.println("*********** Prueba 2");
		
		/* TODO: 
		 * 1. Crea un objeto de tipo Pelicula con estos valores en sus propiedades:
		 * id: 84334
		 * título: Buscando a Sugar Man
		 * título original: Searching the Sugar Man
		 * idioma original: en
		 * fecha de estreno: 2012-06-30
		 * duracion: -10 segundos
		 * genero: Documental
		 * productora: Passion Pictures
		 * nacionalidad: Sweden
		 * directores: null
		 * actores: null
		 * guionistas: null
		 * url de imagen del póster: http://image.tmdb.org/t/p/w342/7Jr5J3pdgEnQymHNge20XUM3YlV.jpg
		 * 
		 * 2. Si se crea correctamente, muestra un mensaje indicando que hay un error en la implementación de la restricción sobre la duración.
		 * 
		 * 3. Si se captura la excepción, muestra un mensaje indicándolo. 
		 */
		
		System.out.println();
	}
	
	
	private static void test03() {		
		System.out.println("*********** Prueba 3");
		
		/* TODO: 
		 * 1. Crea un objeto de tipo Pelicula con estos valores en sus propiedades:
		 * id: 84334
		 * título: Buscando a Sugar Man
		 * título original: Searching the Sugar Man
		 * idioma original: en
		 * fecha de estreno: 2025-06-30
		 * duracion: 5220 segundos
		 * genero: Documental
		 * productora: Passion Pictures
		 * nacionalidad: Sweden
		 * directores: null
		 * actores: null
		 * guionistas: null
		 * url de imagen del póster: http://image.tmdb.org/t/p/w342/7Jr5J3pdgEnQymHNge20XUM3YlV.jpg
		 * 
		 * 2. Si se crea correctamente, muestra un mensaje indicando que hay un error en la implementación de la restricción sobre la fecha de estreno.
		 * 
		 * 3. Si se captura la excepción, muestra un mensaje indicándolo.  
		 */
		
		System.out.println();
	}
	
	private static void test04(String lineaCSV, Map<Integer,MiembroStaff> miembros) {		
		System.out.println("*********** Prueba 4");
		
		/* TODO: 
		 * 1. Crea un objeto de tipo Película con la lineaCSV y el diccionario "miembros"
		 * 
		 * 2. Muéstralo en pantalla.
		 * 
		 */
		
		System.out.println();
	}
	
	private static void test05() {		
		System.out.println("*********** Prueba 5");
		
		/* TODO: 
		 * 1. Crea un objeto de tipo Pelicula con estos valores en sus propiedades:
		 * id: 84334
		 * título: Buscando a Sugar Man
		 * título original: Searching the Sugar Man
		 * idioma original: en
		 * fecha de estreno: 2012-06-30
		 * duracion: 5220 segundos
		 * genero: Documental
		 * productora: Passion Pictures
		 * nacionalidad: Sweden
		 * directores: null
		 * actores: null
		 * guionistas: null
		 * url de imagen del póster: http://image.tmdb.org/t/p/w342/7Jr5J3pdgEnQymHNge20XUM3YlV.jpg
		 * 
		 * 2. Muéstralo en pantalla.
		 * 
		 * 3. Modifica las siguientes propiedadades:
		 * título original: título modificado
		 * idioma original: idioma modificado
		 * fecha de estreno: 2010-01-01
		 * duración: 4000 segundos
		 * género: género modificado
		 * nacionalidad: nacionalidad modificada
		 * url de imagen del póster: url modificada
		 *
		 * 4. Muestra de nuevo el objeto en la consola.		 
		 */
		
		System.out.println();
	}
	
	private static void test06() {		
		System.out.println("*********** Prueba 6");
		
		/* TODO: 
		 * 1. Crea un objeto de tipo Pelicula con estos valores en sus propiedades:
		 * id: 84334
		 * título: Buscando a Sugar Man
		 * título original: Searching the Sugar Man
		 * idioma original: en
		 * fecha de estreno: 2012-06-30
		 * duracion: 5220 segundos
		 * genero: Documental
		 * productora: Passion Pictures
		 * nacionalidad: Sweden
		 * directores: null
		 * actores: null
		 * guionistas: null
		 * url de imagen del póster: http://image.tmdb.org/t/p/w342/7Jr5J3pdgEnQymHNge20XUM3YlV.jpg
		 * 
		 * 2. Muéstralo en pantalla.
		 * 
		 * 3. Modifica la propiedad duración, para que ahora valga 0 segundos.
		 *
		 * 4. Si no se captura una excepción, muestra un mensaje indicando que hay un error en la implementación de la restricción sobre la duración.
		 * 
		 * 5. Si se captura la excepción, muestra un mensaje indicándolo. 
		 */
		
		System.out.println();
	}
	
	private static void test07() {		
		System.out.println("*********** Prueba 7");
		
		/* TODO: 
		 * 1. Crea un objeto de tipo Pelicula con estos valores en sus propiedades:
		 * id: 84334
		 * título: Buscando a Sugar Man
		 * título original: Searching the Sugar Man
		 * idioma original: en
		 * fecha de estreno: 2012-06-30
		 * duracion: 5220 segundos
		 * genero: Documental
		 * productora: Passion Pictures
		 * nacionalidad: Sweden
		 * directores: null
		 * actores: null
		 * guionistas: null
		 * url de imagen del póster: http://image.tmdb.org/t/p/w342/7Jr5J3pdgEnQymHNge20XUM3YlV.jpg
		 * 
		 * 2. Muéstralo en pantalla.
		 * 
		 * 3. Modifica la propiedad fecha de estreno, para que ahora valga 2029-01-01
		 *
		 * 4. Si no se captura una excepción, muestra un mensaje indicando que hay un error en la implementación de la fecha de estreno.
		 * 
		 * 5. Si se captura la excepción, muestra un mensaje indicándolo. 
		 */
		
		System.out.println();
	}
	
	private static void test08(String lineaCSV, Map<Integer,MiembroStaff> miembros) {		
		System.out.println("*********** Prueba 8");
		
		/* TODO: 
		 * 1. Crea un objeto de tipo Película con la lineaCSV y el diccionario "miembros"
		 * 
		 * 2. Escriba un mensaje indicando el título de la película y si tiene un director de nombre "Malik Bendjelloul"
		 * 
		 */
		
		System.out.println();
	}
	
	private static void test09(String lineaCSV, Map<Integer,MiembroStaff> miembros) {		
		System.out.println("*********** Prueba 9");
		
		/* TODO: 
		 * 1. Crea un objeto de tipo Película con la lineaCSV y el diccionario "miembros"
		 * 
		 * 2. Escriba un mensaje indicando el título de la película y si tiene un actor de nombre "Rodriguez"
		 * 
		 */
		
		System.out.println();
	}
	
	// Método auxiliar que carga los miembros de las películas en un diccionario indexado por la propiedad id
	private static Map<Integer, MiembroStaff> cargaMiembros(String fichero) {
		List<MiembroStaff> miembros = Ficheros.leeFichero(fichero, MiembroStaffImpl::new);
		Map<Integer,MiembroStaff> miembrosDict = new HashMap<>();
		for(MiembroStaff m:miembros) {
			miembrosDict.put(m.getId(), m);
		}
		return miembrosDict;
	}
}
