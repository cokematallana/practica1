package fp.musica;

import fp.utiles.Checkers;

public class ArtistaImpl implements Artista {
	// Propiedades
	private String id, nombre, genero, urlImagen;
	private Integer popularidad;
	private static final String R_ID = "La id debe tener 22 caracteres";
	private static final String R_POPULARIDAD = "La popularidad tiene que estar entre 1 y 100";
	private static final String R_URL = "La URL debe comenzar por http.";

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
		ArtistaImpl other = (ArtistaImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	// Constructor1
	private static final Integer String = null;

	public ArtistaImpl(String id, String nombre, String genero, String urlImagen, Integer popularidad) {
		// if (id.length() != 22) {
		// throw new IllegalArgumentException(R_ID);
		{
			// if (!(1 <= popularidad && popularidad<= 100)) {
			// throw new IllegalArgumentException(popularidad)

			// if(!(urlImagen.startsWith ("http")) {
			// throw new IllegalArgumentException(R_URL)

			// Checkers.check(R_ID, id.length(22) == 22);
			// Checkers.check(R_URL,
			Checkers.check(R_ID, restriccionId(id));
			Checkers.check(R_POPULARIDAD, restriccionPopularidad(popularidad));
			Checkers.check(R_URL, restriccionUrl(url));
			this.id = id;
			this.nombre = nombre;
			this.genero = genero;
			this.urlImagen = urlImagen;
			this.popularidad = popularidad;
		}
	}

	private Boolean restriccionId(java.lang.String id2) {
		// TODO Auto-generated method stub
		return null;
	}

	// Constructor 2
	public ArtistaImpl(String s) {
		// List<Sring> trozos = Ficheros.procesaLineaCSV(s, "#");
		String[] trozos = s.split("#");
		if (trozos.length != 5) {
			throw new IllegalArgumentException("La linea debe tener 5 elementos");
		}
		String id = trozos[0].trim();
		Integer popularidad = new Integer(trozos[2].trim());
		String urlImagen = trozos[4].trim();
		String nombre = trozos[1].trim();
		String genero = trozos[3].trim();

	}

	public String getid() {
		return id;
	}

	public String getnombre() {
		return nombre;
	}

	public String getGenero() {
		return genero;
	}

	public String geturlImagen() {
		return urlImagen;
	}

	public Integer getPopularidad() {
		return popularidad;
	}

	public void setPopularidad(Integer popularidad) {
		if (!(1 <= popularidad && popularidad <= 100)) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public int compareTo(Artista o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String getURLImagen() {
		return this.urlImagen;
	}

	@Override
	public void setURLImagen(String urlImagen) {
		Checkers.check(R_URL, restriccionId(id));
		this.urlImagen = urlImagen;
	}

	@Override
	public String toString() {
		return "ArtistaImpl [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", urlImagen=" + urlImagen
				+ ", popularidad=" + popularidad + "]";
	}
}
