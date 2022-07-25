package artifact.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Data2 {
	
	@Id
	@Column(name = "id" , precision = 1 , unique = true)
	private long id;
	
	@Column(name = "area_administrativa")
	private String areaAdministrativa;
	
	@Column(name = "situacion")
	private String situacion;
	
	@Column(name = "id_tramo_cable_optico")
	private String iDTramoCableOptico;
	
	@Column(name = "codigo_tramo_cable_optico")
	private String codigoTramoCableOptico;
	
	@Column(name = "cantidad_fibras")
	private String cantidadFibras;
	
	@Column(name = "longitud_estimada_total")
	private String longitudEstimadaTotal;
	
	@Column(name = "propiedad")
	private String propiedad;
	
	@Column(name = "propietario")
	private String propietario;
	
	@Column(name = "trfo_ot_actual")
	private String trfoOtActual;
	
	@Column(name = "trfo_ot_original")
	private String trfoOtOriginal;
	
	@Column(name = "orden_trabajo")
	private String ordenDeTrabajo;
	
	@Column(name = "ot_fecha_implantacion")
	private String oTFechaImplantacion;
	
	@Column(name = "ot_estado_actual")
	private String oTEstadoActual;
	
	@Column(name = "ruta")
	private String ruta;
	
	@Column(name = "usuario")
	private String usuario;
	
	public Data2() {
	}

	public Data2(long id , String areaAdministrativa, String situacion, String iDTramoCableOptico, String codigoTramoCableOptico, String cantidadFibras, String longitudEstimadaTotal, String propiedad, String propietario, String trfoOtActual, String trfoOtOriginal, String ordenDeTrabajo, String oTFechaImplantacion, String oTEstadoActual, String ruta, String usuario) {
		this.id = id;
		this.areaAdministrativa = areaAdministrativa;
		this.situacion = situacion;
		this.iDTramoCableOptico = iDTramoCableOptico;
		this.codigoTramoCableOptico = codigoTramoCableOptico;
		this.cantidadFibras = cantidadFibras;
		this.longitudEstimadaTotal = longitudEstimadaTotal;
		this.propiedad = propiedad;
		this.propietario = propietario;
		this.trfoOtActual = trfoOtActual;
		this.trfoOtOriginal = trfoOtOriginal;
		this.ordenDeTrabajo = ordenDeTrabajo;
		this.oTFechaImplantacion = oTFechaImplantacion;
		this.oTEstadoActual = oTEstadoActual;
		this.ruta = ruta;
		this.usuario = usuario;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAreaAdministrativa() {
		return areaAdministrativa;
	}

	public void setAreaAdministrativa(String areaAdministrativa) {
		this.areaAdministrativa = areaAdministrativa;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getiDTramoCableOptico() {
		return iDTramoCableOptico;
	}

	public void setiDTramoCableOptico(String iDTramoCableOptico) {
		this.iDTramoCableOptico = iDTramoCableOptico;
	}

	public String getCodigoTramoCableOptico() {
		return codigoTramoCableOptico;
	}

	public void setCodigoTramoCableOptico(String codigoTramoCableOptico) {
		this.codigoTramoCableOptico = codigoTramoCableOptico;
	}

	public String getCantidadFibras() {
		return cantidadFibras;
	}

	public void setCantidadFibras(String cantidadFibras) {
		this.cantidadFibras = cantidadFibras;
	}

	public String getLongitudEstimadaTotal() {
		return longitudEstimadaTotal;
	}

	public void setLongitudEstimadaTotal(String longitudEstimadaTotal) {
		this.longitudEstimadaTotal = longitudEstimadaTotal;
	}

	public String getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getTrfoOtActual() {
		return trfoOtActual;
	}

	public void setTrfoOtActual(String trfoOtActual) {
		this.trfoOtActual = trfoOtActual;
	}

	public String getTrfoOtOriginal() {
		return trfoOtOriginal;
	}

	public void setTrfoOtOriginal(String trfoOtOriginal) {
		this.trfoOtOriginal = trfoOtOriginal;
	}

	public String getOrdenDeTrabajo() {
		return ordenDeTrabajo;
	}

	public void setOrdenDeTrabajo(String ordenDeTrabajo) {
		this.ordenDeTrabajo = ordenDeTrabajo;
	}

	public String getoTFechaImplantacion() {
		return oTFechaImplantacion;
	}

	public void setoTFechaImplantacion(String oTFechaImplantacion) {
		this.oTFechaImplantacion = oTFechaImplantacion;
	}

	public String getoTEstadoActual() {
		return oTEstadoActual;
	}

	public void setoTEstadoActual(String oTEstadoActual) {
		this.oTEstadoActual = oTEstadoActual;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	

}
