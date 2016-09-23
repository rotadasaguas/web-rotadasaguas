package br.com.dtech.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Locais")
@SequenceGenerator(name = "seq", sequenceName = "seq_local", allocationSize = 1, initialValue = 1)
public class Locais {
	
	@Id
    @GeneratedValue(generator="seq")
    private Long id;
	
	private String nome;
	private String descricao;
	private String tipo; // restaurante / boate ...
	
	private String faixaMenor; //faixa de preço mais baixa
	private String faixaMaior; //faixa de preço mais alta
	
	private String cidade;
	private String estado = "São Paulo";
	private String endereco;
	private int numero;
	private String bairro;
	private String CEP;
	
	private String infoExtra; //pode ser usado em todos os tipos de locais para inserir algo extra
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
    private Usuario user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFaixaMenor() {
		return faixaMenor;
	}
	public void setFaixaMenor(String faixaMenor) {
		this.faixaMenor = faixaMenor;
	}
	public String getFaixaMaior() {
		return faixaMaior;
	}
	public void setFaixaMaior(String faixaMaior) {
		this.faixaMaior = faixaMaior;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
	public String getInfoExtra() {
		return infoExtra;
	}
	public void setInfoExtra(String infoExtra) {
		this.infoExtra = infoExtra;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	
	

}
