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
	
	public DataCSV() {
		
	}
	
}
