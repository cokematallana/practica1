package fp.musica;

import java.util.List;

// BLOQUE 3

public interface Album extends Comparable<Album> {
	/**
	 * @return El tipo de album: ALBUM, SINGLE o COMPILATION
	 */
	TipoAlbum getTipo();

	
	/**
	 * @return Una lista con los intérpretes de las canciones del álbum.
	 */
	List<Artista> getInterpretes();

	
	/**
	 * @return Una lista con los géneros de lso artistas que participan en el álbum.
	 */
	List<String> getGeneros();

	/**
	 * @return El nombre del album.
	 */
	String getNombre();

	/**
	 * @return Un entero entre 1 y 100 que representa la popularidad del album. 
	 */
	Integer getPopularidad();

	/**
	 * @return Una cadena de 22 caracteres que sirve para identificar de forma única al álbum.
	 */
	String getId();

	/**
	 * @return El año en el que se publicó el álbum.
	 */
	Integer getAñoPublicacion();
	
	/**
	 * @return El precio del álbum en el momento en que se añadió a esta base de datos.
	 */
	Double getPrecio();

	/**
	 * @return La lista con las canciones que están incluidas en el álbum.
	 */
	List<Cancion> getCanciones();

	/**
	 * @return El número de canciones que contiene el álbum.
	 */
	Integer getNumeroCanciones();
	
	
	/**
	 * @return URL de imágen del álbum. Debe comenzar por http
	 */
	String getURLImagen();
}
