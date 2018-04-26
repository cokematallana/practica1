package fp.audiovisuales;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.event.ListSelectionEvent;

import fp.utiles.Checkers;

public class PeliculaImpl implements Pelicula {

	private Integer id;
	private String titulo, tituloOriginal, idioma, genero, productora, nacionalidad, urlPoster;
	private LocalDate fechaEstreno;
	private Duration duracion;
	private TipoMetraje tipoMetraje;
	private List<MiembroStaff> directores, actores, guionistas;
	private static final String R_DURACION = "La duración debe ser un segundo como mínimo";
	private static final String R_FECHAESTRENO = "El estreno tiene que ser anterior al dia de hoy";

	private boolean RestriccionDuracion(Duration duracion) {
		Boolean res = false;
		if (duracion.getSeconds() >= 1) {
			res = true;
		}
		return res;
	}

	private boolean RestriccionFechaEstreno(LocalDate fechaEstreno) {
		Boolean res = true;
		if (fechaEstreno.isAfter(LocalDate.now())) {
			res = false;
		}
		return res;
	}

	public PeliculaImpl(Integer id, String titulo, String tituloOriginal, String idioma, String genero,
			String productora, String nacionalidad, String urlPoster, LocalDate fechaEstreno, Duration duracion,
			TipoMetraje tipoMetraje, List<MiembroStaff> directores, List<MiembroStaff> actores,
			List<MiembroStaff> guionistas) {
		Checkers.check(R_DURACION, RestriccionDuracion(duracion));
		Checkers.check(R_FECHAESTRENO, RestriccionFechaEstreno(fechaEstreno));

		this.id = id;
		this.titulo = titulo;
		this.tituloOriginal = tituloOriginal;
		this.idioma = idioma;
		this.fechaEstreno = fechaEstreno;
		this.duracion = duracion;
		this.tipoMetraje = null;
		this.genero = genero;
		this.productora = productora;
		this.nacionalidad = nacionalidad;
		this.actores = actores;
		this.directores = directores;
		this.guionistas = guionistas;
		this.urlPoster = urlPoster;
	}

	public PeliculaImpl(Integer id, String titulo) {
		this.id = id;
		this.titulo = titulo;
		this.tituloOriginal = null;
		this.idioma = null;
		this.genero = null;
		this.productora = null;
		this.nacionalidad = null;
		this.urlPoster = null;
		this.fechaEstreno = null;
		this.duracion = null;
		this.tipoMetraje = null;
		this.directores = null;
		this.actores = null;
		this.guionistas = null;
	}

	public PeliculaImpl(String s, Map<Integer, MiembroStaff> miembros) {
		String[] trozos = s.split(";");
		if (trozos.length != 13) {
			throw new IllegalArgumentException("La lista debe contener 12 elementos");
		}
		Integer id = new Integer(trozos[0].trim());
		String titulo = trozos[1].trim();
		String tituloOriginal = null;
		if (trozos[2] != null) {
			tituloOriginal = trozos[2].trim();
		}
		String idiomaOriginal = null;
		if (trozos[3] != null) {
			idiomaOriginal = trozos[3].trim();
		}
		LocalDate fechaestreno = null;
		if (trozos[4] != null) {
			fechaestreno = LocalDate.parse(trozos[4]);
		}
		Duration duracion = null;
		if (trozos[5] != null) {
			duracion = Duration.ofSeconds(new Integer(trozos[5]));
		}
		String genero = null;
		if (trozos[6] != null) {
			idiomaOriginal = trozos[6].trim();
		}
		String productora = null;
		if (trozos[7] != null) {
			idiomaOriginal = trozos[7].trim();
		}
		String nacionalidad = null;
		if (trozos[8] != null) {
			nacionalidad = trozos[8].trim();
		}
		String directores = null;
		if (trozos[9] != null) {
			idiomaOriginal = trozos[9].trim();
		}
		String actores = null;
		if (trozos[10] != null) {
			actores = trozos[10].trim();
		}
		String guionistas = null;
		if (trozos[11] != null) {
			guionistas = trozos[11].trim();

		}
		String url = null;
		if (trozos[12] != null) {
			urlPoster = trozos[12].trim();
		}

		Checkers.check(R_DURACION, RestriccionDuracion(duracion));
		Checkers.check(R_FECHAESTRENO, RestriccionFechaEstreno(fechaEstreno));

		this.id = id;
		this.titulo = titulo;
		this.tituloOriginal = tituloOriginal;
		this.idioma = idiomaOriginal;
		this.fechaEstreno = fechaestreno;
		this.duracion = duracion;
		this.tipoMetraje = null;
		this.genero = genero;
		this.productora = productora;
		this.nacionalidad = nacionalidad;
		rellenaMiembro(this.actores, actores, miembros);
		rellenaMiembro(this.directores, directores, miembros);
		rellenaMiembro(this.guionistas, guionistas, miembros);
		this.urlPoster = url;
	}

	private void rellenaMiembro(List<MiembroStaff> lista, String s, Map<Integer, MiembroStaff> miembros) {
		String[] keys = s.split("#");
		for (String word : keys) {
			Integer key = new Integer(word.trim());
			MiembroStaff value = miembros.get(key);
			lista.add(value);
		}
	}

	private void rellenaMetraje(TipoMetraje metraje, Duration duracion) {
		String res = "largometraje";
		if (duracion.getSeconds() < 1800) {
			res = "cortometraje";
		} else {
			res = "mediometraje";
		}

	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public String getTitulo() {
		return this.titulo;
	}

	@Override
	public String getTituloOriginal() {
		return this.tituloOriginal;
	}

	@Override
	public String getIdiomaOriginal() {
		return this.idioma;
	}

	@Override
	public LocalDate getFechaEstreno() {
		return this.fechaEstreno;
	}

	@Override
	public Duration getDuracion() {
		return this.duracion;
	}

	@Override
	public TipoMetraje getTipoMetraje() {
		return this.tipoMetraje;
	}

	@Override
	public String getGenero() {
		return this.genero;
	}

	@Override
	public String getProductora() {
		return this.productora;
	}

	@Override
	public String getNacionalidad() {
		return this.nacionalidad;
	}

	@Override
	public List<MiembroStaff> getDirectores() {
		return this.directores;
	}

	@Override
	public List<MiembroStaff> getActores() {
		return this.actores;
	}

	@Override
	public List<MiembroStaff> getGuionistas() {
		return this.guionistas;
	}

	@Override
	public String getURLPoster() {
		return this.urlPoster;
	}

	@Override
	public void setTituloOriginal(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public void setIdiomaOriginal(String idioma) {
		this.idioma = idioma;
	}

	@Override
	public void setFechaEstreno(String fechaString) {
		Checkers.check(R_FECHAESTRENO, RestriccionFechaEstreno(fechaEstreno));
		this.fechaEstreno = LocalDate.parse(fechaString);
	}

	@Override
	public void setDuracion(Integer duracionEnSegundos) {
		Checkers.check(R_DURACION, RestriccionDuracion(duracion));
		this.duracion = Duration.ofSeconds(duracionEnSegundos);
	}

	@Override
	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public void setProductora(String productora) {
		this.productora = productora;
	}

	@Override
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public void setDirectores(List<MiembroStaff> director) {
		this.directores = director;
	}

	@Override
	public void setActores(List<MiembroStaff> actores) {
		this.actores = actores;
	}

	@Override
	public void setGuionistas(List<MiembroStaff> guionistas) {
		this.guionistas = guionistas;
	}

	@Override
	public void setURLPoster(String poster) {
		this.urlPoster = poster;
	}

	@Override
	public Boolean esActor(String nombreActor) {
		Boolean res = false;
		int i;
		for (i = 0; i < getActores().size(); i++) {
			if (nombreActor == getActores().get(i).getNombre()) {
				res = true;
				break;
			}
		}
		return res;
	}

	@Override
	public Boolean esDirector(String nombreDirector) {
		Boolean res = false;
		int i;
		for (i = 0; i < getDirectores().size(); i++) {
			if (nombreDirector == getDirectores().get(i).getNombre()) {
				res = true;
				break;
			}
		}
		return res;
	}

	@Override
	public String toString() {
		return "PeliculaImpl [id=" + id + ", titulo=" + titulo + ", tituloOriginal=" + tituloOriginal + ", idioma="
				+ idioma + ", genero=" + genero + ", productora=" + productora + ", nacionalidad=" + nacionalidad
				+ ", urlPoster=" + urlPoster + ", fechaEstreno=" + fechaEstreno + ", duracion=" + duracion
				+ ", tipoMetraje=" + tipoMetraje + ", directores=" + directores + ", actores=" + actores
				+ ", guionistas=" + guionistas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actores == null) ? 0 : actores.hashCode());
		result = prime * result + ((directores == null) ? 0 : directores.hashCode());
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((fechaEstreno == null) ? 0 : fechaEstreno.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((guionistas == null) ? 0 : guionistas.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idioma == null) ? 0 : idioma.hashCode());
		result = prime * result + ((nacionalidad == null) ? 0 : nacionalidad.hashCode());
		result = prime * result + ((productora == null) ? 0 : productora.hashCode());
		result = prime * result + ((tipoMetraje == null) ? 0 : tipoMetraje.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((tituloOriginal == null) ? 0 : tituloOriginal.hashCode());
		result = prime * result + ((urlPoster == null) ? 0 : urlPoster.hashCode());
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
		PeliculaImpl other = (PeliculaImpl) obj;
		if (actores == null) {
			if (other.actores != null)
				return false;
		} else if (!actores.equals(other.actores))
			return false;
		if (directores == null) {
			if (other.directores != null)
				return false;
		} else if (!directores.equals(other.directores))
			return false;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (fechaEstreno == null) {
			if (other.fechaEstreno != null)
				return false;
		} else if (!fechaEstreno.equals(other.fechaEstreno))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (guionistas == null) {
			if (other.guionistas != null)
				return false;
		} else if (!guionistas.equals(other.guionistas))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idioma == null) {
			if (other.idioma != null)
				return false;
		} else if (!idioma.equals(other.idioma))
			return false;
		if (nacionalidad == null) {
			if (other.nacionalidad != null)
				return false;
		} else if (!nacionalidad.equals(other.nacionalidad))
			return false;
		if (productora == null) {
			if (other.productora != null)
				return false;
		} else if (!productora.equals(other.productora))
			return false;
		if (tipoMetraje != other.tipoMetraje)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (tituloOriginal == null) {
			if (other.tituloOriginal != null)
				return false;
		} else if (!tituloOriginal.equals(other.tituloOriginal))
			return false;
		if (urlPoster == null) {
			if (other.urlPoster != null)
				return false;
		} else if (!urlPoster.equals(other.urlPoster))
			return false;
		return true;
	}

	public int compareTo(Pelicula x) {
		int res = this.getId().compareTo(x.getId());
		return res;
	}

}
