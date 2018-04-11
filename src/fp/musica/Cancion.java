package fp.musica;

import java.time.Duration;

//BLOQUE 2

public interface Cancion extends Comparable<Cancion> {
	/**
	 * @return Una cadena que se usará como identificador único de una canción.
	 *         La cadena está formada por 22 carácteres en base 62.
	 */
	String getId();

	/**
	 * @return El artista que interpreta la canción.
	 */
	Artista getInterprete();

	/**
	 * @return La duración de la canción. Debe ser mayor que cero.
	 */
	Duration getDuracion();

	/**
	 * @return La duración de la canción, en formato mm:ss. 
	 */
	String getDuracionString();
	
	/**
	 * @return El nombre de la canción.
	 */
	String getNombre();

	/**
	 * @return Un número entero entre 1 y 100 que representa la popularidad de
	 *         la canción.
	 */
	Integer getPopularidad();

	/**
	 * @param popularidad
	 *            Nueva popularidad de la canción. Debe estar entre 1 y 100.
	 * @throws IllegalArgumentException,
	 *             si el parámetro popularidad no está entre 1 y 100.
	 */
	void setPopularidad(Integer popularidad);

	/**
	 * @return Dirección web en formato URL para poder hacer una preescucha de
	 *         la canción. Comienza por http.
	 */
	String getURLPreescucha();
	
	/**
	 * Devuelve un resumen en texto de la canción, formado por el título, el nombre del artista y la duración en formato mm:ss. 
	 * Por ejemplo: "Dressed In Black - Depeche Mode (04:09)"
	 * @return Un resumen en texto de la canción
	 */
	String getResumenCancion();
}
