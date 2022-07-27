package artifact.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
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
	
	public DataCSV(long id, String identificador, String nombreProyecto, String dirrecion, String altura,
			String cantidadHp, String estadoStb, String agencia, String oeccComuna, String empresaAdjudicada,
			String empresaColaboradora, String semana, String semanaReal, String smell, String targetReal,
			String target, String anoCumplimiento, String oficinaCentralFttx, String _16LiberadoAVentas, String region,
			String tipoProyecto, String pep2, String oeccPep2) {
		this.id = id;
		this.identificador = identificador;
		this.nombreProyecto = nombreProyecto;
		this.dirrecion = dirrecion;
		this.altura = altura;
		this.cantidadHp = cantidadHp;
		this.estadoStb = estadoStb;
		this.agencia = agencia;
		this.oeccComuna = oeccComuna;
		this.empresaAdjudicada = empresaAdjudicada;
		this.empresaColaboradora = empresaColaboradora;
		this.semana = semana;
		this.semanaReal = semanaReal;
		this.smell = smell;
		this.targetReal = targetReal;
		this.target = target;
		this.anoCumplimiento = anoCumplimiento;
		this.oficinaCentralFttx = oficinaCentralFttx;
		this._16LiberadoAVentas = _16LiberadoAVentas;
		this.region = region;
		this.tipoProyecto = tipoProyecto;
		this.pep2 = pep2;
		this.oeccPep2 = oeccPep2;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getIdentificador() {
		return identificador;
	}


	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


	public String getNombreProyecto() {
		return nombreProyecto;
	}


	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}


	public String getDirrecion() {
		return dirrecion;
	}


	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}


	public String getAltura() {
		return altura;
	}


	public void setAltura(String altura) {
		this.altura = altura;
	}


	public String getCantidadHp() {
		return cantidadHp;
	}


	public void setCantidadHp(String cantidadHp) {
		this.cantidadHp = cantidadHp;
	}


	public String getEstadoStb() {
		return estadoStb;
	}


	public void setEstadoStb(String estadoStb) {
		this.estadoStb = estadoStb;
	}


	public String getAgencia() {
		return agencia;
	}


	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}


	public String getOeccComuna() {
		return oeccComuna;
	}


	public void setOeccComuna(String oeccComuna) {
		this.oeccComuna = oeccComuna;
	}


	public String getEmpresaAdjudicada() {
		return empresaAdjudicada;
	}


	public void setEmpresaAdjudicada(String empresaAdjudicada) {
		this.empresaAdjudicada = empresaAdjudicada;
	}


	public String getEmpresaColaboradora() {
		return empresaColaboradora;
	}


	public void setEmpresaColaboradora(String empresaColaboradora) {
		this.empresaColaboradora = empresaColaboradora;
	}


	public String getSemana() {
		return semana;
	}


	public void setSemana(String semana) {
		this.semana = semana;
	}


	public String getSemanaReal() {
		return semanaReal;
	}


	public void setSemanaReal(String semanaReal) {
		this.semanaReal = semanaReal;
	}


	public String getSmell() {
		return smell;
	}


	public void setSmell(String smell) {
		this.smell = smell;
	}


	public String getTargetReal() {
		return targetReal;
	}


	public void setTargetReal(String targetReal) {
		this.targetReal = targetReal;
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}


	public String getAnoCumplimiento() {
		return anoCumplimiento;
	}


	public void setAnoCumplimiento(String anoCumplimiento) {
		this.anoCumplimiento = anoCumplimiento;
	}


	public String getOficinaCentralFttx() {
		return oficinaCentralFttx;
	}


	public void setOficinaCentralFttx(String oficinaCentralFttx) {
		this.oficinaCentralFttx = oficinaCentralFttx;
	}


	public String get_16LiberadoAVentas() {
		return _16LiberadoAVentas;
	}


	public void set_16LiberadoAVentas(String _16LiberadoAVentas) {
		this._16LiberadoAVentas = _16LiberadoAVentas;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getTipoProyecto() {
		return tipoProyecto;
	}


	public void setTipoProyecto(String tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}


	public String getPep2() {
		return pep2;
	}


	public void setPep2(String pep2) {
		this.pep2 = pep2;
	}


	public String getOeccPep2() {
		return oeccPep2;
	}


	public void setOeccPep2(String oeccPep2) {
		this.oeccPep2 = oeccPep2;
	}
	
	
	
	}
