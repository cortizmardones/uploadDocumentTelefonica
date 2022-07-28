package artifact.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class DataExcel {
	
	@Id
	@Column(name = "id" , precision = 1 , unique = true)
	private long id;
	
	@Column(name = "area_administrativa")
	private String areaAdministrativa;
	
	@Column(name = "situacion")
	private String situacion;
	
	@Column(name = "id_tramo_cable_optico")
	private String idTramoCableOptico;
	
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
	private String otFechaImplantacion;
	
	@Column(name = "ot_estado_actual")
	private String otEstadoActual;
	
	@Column(name = "ruta")
	private String ruta;
	
	@Column(name = "usuario")
	private String usuario;
	
	public DataExcel() {
		
	}
	
	
	
}
