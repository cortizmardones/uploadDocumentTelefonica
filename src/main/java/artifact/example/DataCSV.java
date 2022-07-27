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

	public DataCSV() {
		
	}
	
	public DataCSV(long id, String identificador, String nombreProyecto, String dirrecion, String altura, String cantidadHp, String estadoStb,
			String agencia, String oeccComuna, String empresaAdjudicada, String empresaColaboradora, String semana,
			String semanaReal) {
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


	

}
