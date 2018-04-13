package fp.audiovisuales;

import java.time.LocalDate;
import java.util.List;

public interface MiembroStaff extends Comparable<MiembroStaff> {

	/**
	 * @return El identificador del miembro del equipo.
	 */
	Integer getId();

	/**
	 * @return El nombre de la persona.
	 */
	String getNombre();

	/**
	 * @return La fecha de nacimiento de la persona.
	 */
	LocalDate getFechaNacimiento();

	/**
	 * @return La fecha de defunción de la persona, o null, si aún no ha fallecido.
	 */
	LocalDate getFechaDefuncion();

	/**
	 * @return El sitio de nacimiento de la persona.
	 */
	String getLugarNacimiento();

	/**
	 * @return La edad de la persona
	 */
	Integer getEdad();

	/**
	 * @return El alias con el que se conoce al miembro del equipo
	 */
	String getAlias(); 

	/**
	 * @param nombre El nuevo nombre del miembro del equipo.
	 * @throws IllegalArgumentException si el nombre es nulo.
	 */
	void setNombre(String nombre);

	/**
	 * @param lugarNacimiento El lugar de nacimiento del miembro del equipo.
	 */
	void setLugarNacimiento(String lugarNacimiento);

	/**
	 * @param fechaNacimiento La nueva fecha de nacimiento del miembro del equipo, en formato "yyyy-mm-dd".
	 * @throws  IllegalArgumentException si la fecha de nacimiento es posterior a la fecha de defunción.
	 */
	void setFechaNacimiento(String fechaNacimientoString);

	/**
	 * @param fechaNacimiento La nueva fecha de defunción del miembro del equipo, en formato "yyyy-mm-dd".
	 * @throws  IllegalArgumentException si la fecha de nacimiento es posterior a la fecha de defunción.
	 */
	void setFechaDefuncion(String fechaDefuncionString);

	/**
	 * @param alias El nuevo alias del miembro del staff
	 */
	void setAlias(String alias); 
}
