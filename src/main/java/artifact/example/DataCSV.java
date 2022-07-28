package artifact.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class DataCSV {

	@Id
	@Column(name = "id", unique = true)
	private long id;
	
	@Column(name = "identificador")
	private String identificador;

	@Column(name = "nombre_proyecto")
	private String nombreProyecto;

	@Column(name = "direccion")
	private String dirrecion;

	@Column(name = "altura")
	private String altura;

	@Column(name = "cantidad_hp")
	private String cantidadHp;

	@Column(name = "estado_stb")
	private String estadoStb;

	@Column(name = "agencia")
	private String agencia;

	@Column(name = "oecc_comuna")
	private String oeccComuna;

	@Column(name = "empresa_adjudicada")
	private String empresaAdjudicada;

	@Column(name = "empresa_colaboradora")
	private String empresaColaboradora;

	@Column(name = "semana")
	private String semana;

	@Column(name = "semana_real")
	private String semanaReal;
		
	@Column(name = "smell")
	private String smell;

	@Column(name = "target_real")
	private String targetReal;

	@Column(name = "target")
	private String target;
	
	@Column(name = "ano_cumplimiento")
	private String anoCumplimiento;
	
	@Column(name = "oficina_central_fttx")
	private String oficinaCentralFttx;
	
	@Column(name = "_16_liberado_a_ventas")
	private String _16LiberadoAVentas;

	@Column(name = "region")
	private String region;
	
	@Column(name = "tipo_proyecto")
	private String tipoProyecto;
	
	@Column(name = "pep2")
	private String pep2;
	
	@Column(name = "oecc_pep2")
	private String oeccPep2;
	
	@Column(name = "oeci")
	private String oeci;
	
	@Column(name = "related_oeci")
	private String relatedOeci;
	
	@Column(name = "oecc")
	private String oecc;
	
	@Column(name = "related_oecc")
	private String relatedOecc;
	
	@Column(name = "numero_cubicacion")
	private String numeroCubicacion;
	
	@Column(name = "oecc_cubicacion")
	private String oeccCubicacion;
	
	@Column(name = "estado_cruzado_logica")
	private String estadoCruzadoLogica;
	
	@Column(name = "estado_cruzado_fisica")
	private String estadoCruzadoFisica;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "estado_asignacion_recurso")
	private String estadoAsignacionRecurso;
	
	@Column(name = "estado_creacion_direcciones")
	private String estadoCreacionDirecciones;
	
	@Column(name = "nombre_pm")
	private String nombrePm;
	
	@Column(name = "hp_cargadas_osp")
	private String hpCargadasOsp;
	
	@Column(name = "osp_n_equipos")
	private String ospNEquipos;
	
	@Column(name = "osp_coberturas")
	private String ospCoberturas;
	
	@Column(name = "osp_cap_fo")
	private String ospCapFo;
	
	@Column(name = "osp_ocu")
	private String ospOcu;
	
	@Column(name = "osp_asi")
	private String ospAsi;
	
	@Column(name = "tipo_caja")
	private String tipoCaja;
	
	@Column(name = "oecc_actividad")
	private String oeccActividad;
	
	@Column(name = "oecc_resp_actividad")
	private String oeccRespActividad;
	
	public DataCSV() {
		
	}
	
}
