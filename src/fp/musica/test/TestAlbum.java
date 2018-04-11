package fp.musica.test;

import fp.musica.Album;
import fp.musica.AlbumImpl;
import fp.musica.TipoAlbum;
import fp.utiles.Imagenes;

/* Este test únicamente prueba la carga de las canciones del álbum desde un fichero csv */

public class TestAlbum {

	private static final String cancionesCSV = "datos/album.csv";
	
	public static void main(String[] args) {
		System.out.println("Tests del tipo Álbum\n");
		
		test01();
		test02();
		test03();
		test04();
			
	}

	private static void test01() {		
		System.out.println("*********** Prueba 1");
		
		/* TODO: 
		 * 1. Crea un álbum con las siguientes propiedades:
		 * id: 762310PdDnwsDxAQxzQkfX
		 * nombre: Muse & Radiohead Collection
		 * tipo: TipoAlbum.COMPILATION
		 * url de imagen: https://i.scdn.co/image/0b3c04473aa6a2db8235e5092ec3413f35752b8d
		 * popularidad: 68
		 * año de publicación: 2017
		 * precio: 9.90
		 * canciones: las contenidas en el fichero cancionesCSV
		 * 
		 * 2. Múestralo en la consola.
		 * 
		 * 3. Muestra el número de canciones que contiene el álbum.
		 * 
		 * 4. Muestra la portada del álbum, usando el método Imagenes.show
		 * 
		 * 5. Muestre en la consola los nombres de los artistas que participan en el álbum.
		 * 
		 * 6. Muestre en la consola los géneros que aparecen en el álbum.
		 */
	}
	
	private static void test02() {		
		System.out.println("*********** Prueba 2");
		
		/* TODO: 
		 * 1. Crea un álbum con las siguientes propiedades:
		 * id: 7623
		 * nombre: Muse & Radiohead  Collection
		 * tipo: TipoAlbum.COMPILATION
		 * url de imagen: https://i.scdn.co/image/0b3c04473aa6a2db8235e5092ec3413f35752b8d
		 * popularidad: 68
		 * año de publicación: 2017
		 * precio: 9.90
		 * canciones: las contenidas en el fichero cancionesCSV
		 * 
		 * 2. Si se crea correctamente, muestra un mensaje indicando que hay un error en la implementación de la restricción sobre el id.
		 * 
		 * 3. Si se captura la excepción, muestra un mensaje indicándolo. 
		 */
		
		System.out.println();
	}
	
	private static void test03() {		
		System.out.println("*********** Prueba 3");
		
		/* TODO: 
		 * 1. Crea un álbum con las siguientes propiedades:
		 * id: 762310PdDnwsDxAQxzQkfX
		 * nombre: Muse & Radiohead  Collection
		 * tipo: TipoAlbum.COMPILATION
		 * url de imagen: https://i.scdn.co/image/0b3c04473aa6a2db8235e5092ec3413f35752b8d
		 * popularidad: -8
		 * año de publicación: 2017
		 * precio: 9.90
		 * canciones: las contenidas en el fichero cancionesCSV
		 * 
		 * 2. Si se crea correctamente, muestra un mensaje indicando que hay un error en la implementación de la restricción sobre la popularidad.
		 * 
		 * 3. Si se captura la excepción, muestra un mensaje indicándolo. 
		 */
		
		System.out.println();
	}
	
	private static void test04() {		
		System.out.println("*********** Prueba 4");
		
		/* TODO: 
		 * 1. Crea un álbum con las siguientes propiedades:
		 * id: 762310PdDnwsDxAQxzQkfX
		 * nombre: Muse & Radiohead  Collection
		 * tipo: TipoAlbum.COMPILATION
		 * url de imagen: 13f35752b8d
		 * popularidad: 68
		 * año de publicación: 2017
		 * precio: 9.90
		 * canciones: las contenidas en el fichero cancionesCSV
		 * 
		 * 2. Si se crea correctamente, muestra un mensaje indicando que hay un error en la implementación de la restricción sobre la URL de imagen.
		 * 
		 * 3. Si se captura la excepción, muestra un mensaje indicándolo. 
		 */
		
		System.out.println();
	}
	
}