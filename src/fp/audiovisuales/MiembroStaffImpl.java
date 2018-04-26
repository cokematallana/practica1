package fp.audiovisuales;

import java.time.LocalDate;

import fp.utiles.Checkers;

import java.time.temporal.ChronoUnit;

public class MiembroStaffImpl {

	private Integer id;
	private String nombre, lugarNacimiento, alias;
	private LocalDate fechaNacimiento, fechaFuncion;
	private static final String R_FECHAFUNCION = "No puede morir antes que nacer";

	// getter y setter si son modificable y observables
	public String getLugarNacimiento() {
		return this.lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {

		this.lugarNacimiento = lugarNacimiento;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		Checkers.check(R_FECHAFUNCION, RestriccionfechaFuncionn(fechaNacimiento, this.fechaFuncion));
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaFuncion() {
		return this.fechaFuncion;
	}

	public void setFechaFuncion(LocalDate fechaFuncion) {

		Checkers.check(R_FECHAFUNCION, RestriccionfechaFuncionn(this.fechaNacimiento, fechaFuncion));
		this.fechaFuncion = fechaFuncion;
	}

	public Integer getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Integer getEdad() {
		Integer res = 0;
		if (fechaFuncion == null) {
			res = (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());

		} else {
			res = (int) ChronoUnit.YEARS.between(fechaNacimiento, fechaFuncion);
		}
		return res;
	}

	// Constructor1
	public MiembroStaffImpl(Integer id, String nombre, LocalDate fechaNacimiento, LocalDate fechaFuncion,
			String lugarNacimiento, String alias) {
		Checkers.check(R_FECHAFUNCION, RestriccionfechaFuncionn(fechaNacimiento, fechaFuncion));
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaFuncion = fechaFuncion;
		this.lugarNacimiento = lugarNacimiento;
		this.alias = alias;
	}

	// Constructor2
	public MiembroStaffImpl(Integer id, String nombre, LocalDate fechaNacimiento, String lugarNacimiento,
			String alias) {
		Checkers.check(R_FECHAFUNCION, RestriccionfechaFuncionn(fechaNacimiento, fechaFuncion));
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaFuncion = null;
		this.lugarNacimiento = lugarNacimiento;
		this.alias = alias;
	}

	// Constructor3
	public MiembroStaffImpl(Integer id, String nombre) {
		Checkers.check(R_FECHAFUNCION, RestriccionfechaFuncionn(fechaNacimiento, fechaFuncion));
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = null;
		this.fechaFuncion = null;
		this.lugarNacimiento = null;
		this.alias = null;
	}

	// Constructor4
	public MiembroStaffImpl(String s) {
		String[] trozos = s.split(" ; ");
		if (trozos.length != 6) {
			throw new IllegalArgumentException("La cadena debe tener 6 elementos");
		}
		Integer id = new Integer(trozos[0].trim());

		String nombre = trozos[1].trim();

		LocalDate fechaNacimiento = null;
		if (trozos[2] != null) {
			fechaNacimiento = LocalDate.parse(trozos[2].trim());
		}

		LocalDate fechaFuncion = null;
		if (trozos[3] != null) {
			fechaFuncion = LocalDate.parse(trozos[3].trim());
		}

		String lugarNacimiento = null;
		if (trozos[4] != null) {
			lugarNacimiento = trozos[4].trim();
		}

		String alias = null;
		if (trozos[5] != null) {
			alias = trozos[5].trim();
		}
		Checkers.check(R_FECHAFUNCION, RestriccionfechaFuncionn(fechaNacimiento, fechaFuncion));
		
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaFuncion = fechaFuncion;
		this.lugarNacimiento = lugarNacimiento;
		this.alias = alias;

	}

	// restriccion
	private boolean RestriccionfechaFuncionn(LocalDate fechaNacimiento, LocalDate fechaFuncion) {
		boolean res = true;
		if (fechaFuncion != null) {
			fechaFuncion.isAfter(fechaNacimiento);
			res = false;
		}
		return res;
	}

	// respresentacion como cadena
	@Override
	public String toString() {
		return "MiembroStaffImpl [id=" + id + ", nombre=" + nombre + ", lugarNacimiento=" + lugarNacimiento + ", alias="
				+ alias + ", fechaNacimiento=" + fechaNacimiento + ", fechaFuncion=" + fechaFuncion + "]";
	}

	// Criterio de igualdad por id
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
		MiembroStaffImpl other = (MiembroStaffImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	// Criterio de orden natural por id(tiene que ser a manoooooo)
	public int compareTo(MiembroStaff x) {
		int res = this.getId().compareTo(x.getId());
		return res;
	}
}