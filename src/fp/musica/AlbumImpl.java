
package fp.musica;

import java.util.ArrayList;
import java.util.List;


import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class AlbumImpl implements Album {

	private TipoAlbum tipo;
	private List<Cancion> canciones;
	private String id;
	private String nombre;
	private Integer añoPublicacion;
	private Integer popularidad;
	// private Integer numeroCanciones; porque no es una propiedad basica, se saca
	// de list<cancion>.size
	// la lista de interprete es deducible de la lista de cancion,de sus interpretes
	// de la lista de interpretes puedes deducir el genero
	private Double precio;
	private String urlimagen;

	private static final String R_ID = "El id debe ser de 22 caracteres";
	private static final String R_POPULARIDAD = "La popularidad debe estra entre 1 y 100";
	private static final String R_PRECIO = "EL precio debe ser mayor o igual a 0";
	private static final String R_URLIMAGEN = "La url debe empezar por http";

	// Constructor 1
	public AlbumImpl(TipoAlbum tipo, List<Cancion> canciones, String id, String nombre, Integer añoPublicacion,
			Integer popularidad, Double precio, String urlimagen) {
		Checkers.check(R_ID, id.length() == 22);
		Checkers.check(R_POPULARIDAD, 1 <= popularidad && popularidad <= 100);
		Checkers.check(R_PRECIO, precio >= 0);
		Checkers.check(R_URLIMAGEN, urlimagen.startsWith("http"));

		this.tipo = tipo;
		this.canciones = canciones;
		this.id = id;
		this.nombre = nombre;
		this.añoPublicacion = añoPublicacion;
		this.popularidad = popularidad;
		this.precio = precio;
		this.urlimagen = urlimagen;
	}

	// Constructor 2
	public AlbumImpl(TipoAlbum tipo, String id, String nombre, Integer añoPublicacion, Integer popularidad,
			Double precio, String urlimagen, String FicheroCanciones) {
		Checkers.check(R_ID, id.length() == 22);
		Checkers.check(R_POPULARIDAD, 1 <= popularidad && popularidad <= 100);
		Checkers.check(R_PRECIO, precio >= 0);
		Checkers.check(R_URLIMAGEN, urlimagen.startsWith("http"));

		this.tipo = tipo;
		this.id = id;
		this.nombre = nombre;
		this.añoPublicacion = añoPublicacion;
		this.popularidad = popularidad;
		this.precio = precio;
		this.urlimagen = urlimagen;
		this.canciones = Ficheros.leeFichero(FicheroCanciones, CancionImpl::new);// no sabemos porque saberlo (lo de ::)
	}

	// getters
	public TipoAlbum getTipo() {
		return this.tipo;
	}

	public List<Cancion> getCanciones() {
		return this.canciones;
	}

	public String getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Integer getAñoPublicacion() {
		return this.añoPublicacion;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public String getURLImagen() {
		return this.urlimagen;
	}

	public Integer getPopularidad() {
		return this.popularidad;
	}

	// toString
	@Override
	public String toString() {
		return "AlbumImpl [tipo=" + tipo + ", canciones=" + canciones + ", id=" + id + ", nombre=" + nombre
				+ ", añoPublicacion=" + añoPublicacion + ", popularidad=" + popularidad + ", precio=" + precio
				+ ", urlimagen=" + urlimagen + "]";
	}

	// Hashcode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlbumImpl other = (AlbumImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Artista> getInterpretes() {
		List<Artista> res = new ArrayList<>();
		int i;
		for (i = 0; i < res.size(); i++) {
			res.add(getCanciones().get(i).getInterprete());
		}
		return res;
	}

	public List<String> getGeneros() {
		List<String> res = new ArrayList<>();
		for (Cancion c : getCanciones()) {
			res.add(c.getInterprete().getGenero());
		}
		return res;
	}

	// public List<String> getGeneros2(){
	// List<String> res= getCanciones().stream().map(x ->
	// x.getInterprete().getGenero()).collect(Collectors.toList());
	// return res;
	// }

	public Integer getNumeroCanciones() {
		Integer res = getCanciones().size();
		return res;
	}

	// Compare to (hecho todo a mano)
	public int compareTo(Album album) {
		int res = this.getId().compareTo(album.getId());
		return res;
	}
}
