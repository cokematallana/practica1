package fp.musica;

import java.time.Duration;

import fp.utiles.Checkers;

public class CancionImpl implements Cancion {
	// Propiedades
	private String id, url, nombre;
	private Integer popularidad;
	private Artista interprete;
	private Duration duracion;

	private static final String R_ID = "El id debe ser de 22 caracteres";
	private static final String R_POPULARIDAD = "La popularidad debe estra entre 1 y 100";
	private static final String R_DURATION = "La duracion tiene que ser positiva";
	private static final String R_URLIMAGEN = "La url debe empezar por http";

	// Constructor1
	public CancionImpl(String id, String nombre, String url, Integer popularidad, Artista interprete,
			Duration duracion) {
		Checkers.check(R_ID, restriccionId(id));
		Checkers.check(R_DURATION, restriccionDuracion(duracion));
		Checkers.check(R_URLIMAGEN, restriccionUrl(url));
		Checkers.check(R_POPULARIDAD, restriccionPopularidad(popularidad));

		this.id = id;
		this.duracion = duracion;
		this.url = url;
		this.popularidad = popularidad;
		this.interprete = interprete;
		this.nombre = nombre;
	}

	// Contructor 2
	public CancionImpl(String s) {
		String[] trozos = s.split(";");
		Checkers.check("Formato no valido", trozos.length == 6);
		String id = trozos[0].trim();
		String interprete = trozos[1].trim();// este
		Duration duracion = Duration.ofSeconds(new Integer(trozos[2]));
		String nombre = trozos[3].trim();
		Integer popularidad = new Integer(trozos[4].trim());
		String url = trozos[5].trim();

		Checkers.check(R_ID, restriccionId(id));
		Checkers.check(R_DURATION, restriccionDuracion(duracion));
		Checkers.check(R_URLIMAGEN, restriccionUrl(url));
		Checkers.check(R_POPULARIDAD, restriccionPopularidad(popularidad));

		this.id = id;
		this.duracion = duracion;
		this.url = url;
		this.popularidad = popularidad;
		this.interprete = new ArtistaImpl(interprete);
		this.nombre = nombre;

	}

	public String getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

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
		CancionImpl other = (CancionImpl) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Artista getInterprete() {
		return this.interprete;
	}

	public Duration getDuracion() {
		return this.duracion;
	}

	public String getDuracionString() {
		long segundos = getDuracion().getSeconds();
		String res = String.format("&02d:%02d", segundos / 6, segundos % 60);
		return res;
	}

	public String getResumenCancion() {
		String res = this.getNombre() + " - " + this.getInterprete().getNombre() + " (" + this.getDuracionString()
				+ ")";
		return res;
	}

	@Override
	public int compareTo(Cancion cancion) {
		int res = this.getId().compareTo(cancion.getId());
		return res;
	}

	@Override
	public Integer getPopularidad() {
		return this.popularidad;
	}

	@Override
	public void setPopularidad(Integer popularidad) {
		Checkers.check(R_POPULARIDAD, restriccionPopularidad(popularidad));
		this.popularidad = popularidad;
	}

	@Override
	public String getURLPreescucha() {
		return this.url;

	}

	// Restricciones
	private boolean restriccionId(String id) {
		if (id.length() != 22) {
			return false;
		} else {
			return true;
		}
	}

	private boolean restriccionPopularidad(Integer popularidad) {
		boolean res = false;
		if (popularidad > 1 && popularidad < 100) {
			res = true;
		}
		return res;
	}

	private boolean restriccionUrl(String url) {
		boolean res = false;
		if (url.startsWith("http")) {
			res = true;
		}
		return res;
	}

	private boolean restriccionDuracion(Duration duracion) {
		boolean res = true;
		if (duracion.getNano() <= 0) {
			res = false;
		}
		return res;
	}

}
