package fp.audiovisuales;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

    public interface Pelicula extends Comparable<Pelicula> {
	Integer getId(); 
	String getTitulo();
	String getTituloOriginal();
	String getIdiomaOriginal();
	LocalDate getFechaEstreno();
	Duration getDuracion();
	TipoMetraje getTipoMetraje();
	String getGenero(); 
	String getProductora(); 
	String getNacionalidad(); 
	List<MiembroStaff> getDirectores();
	List<MiembroStaff> getActores(); 
	List<MiembroStaff> getGuionistas(); 
	String getURLPoster(); 

	void setTituloOriginal(String titulo);
	void setIdiomaOriginal(String idioma);
	void setFechaEstreno(String fechaString);
	void setDuracion(Integer duracionEnSegundos);
	void setGenero(String genero); 
	void setProductora(String productora); 
	void setNacionalidad(String nacionalidad);
	void setDirectores(List<MiembroStaff> director); 
	void setActores(List<MiembroStaff> actores);
	void setGuionistas(List<MiembroStaff> guionistas);
	void setURLPoster(String poster);
	
	/**
	 * @param actor Nombre de actor
	 * @return True si el actor con el nombre dado como parámetro participa en la pelicula
	 */
	Boolean esActor (String nombreActor);
	/**
	 * @param director Nombre de director.
	 * @return True si el director con el nombre dado como parámetro participa en la película.
	 */
	Boolean esDirector(String nombreDirector);
	
}
