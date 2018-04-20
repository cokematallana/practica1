package fp.audiovisuales;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.event.ListSelectionEvent;

public class PeliculaImpl implements Pelicula {

	private Integer id;
	private String titulo, tituloOriginal, idioma, genero, productora, nacionalidad, urlPoster;
	private LocalDate fechaEstreno;
	private Duration duracion;
	private TipoMetraje tipoMetraje;
	private List<MiembroStaff> directores, actores, guionistas;

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

		// Checkers.check(R_DURACION, restriccionDuracion(duracion));
		// Checkers.check(R_FECHAESTRENO,
		// restriccionFechaEstreno(fechaEstreno));

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
		
	}

	@Override
	public int compareTo(Pelicula x) {
		int res = this.getId().compareTo(x.getId());
		return res;
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
		return this.idiomaOriginal;
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
		this.fechaEstreno = LocalDate.parse(fechaString);
	}

	@Override
	public void setDuracion(Integer duracionEnSegundos) {
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

		return null;
	}

}
