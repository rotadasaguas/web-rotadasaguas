package br.com.dtech.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Tags")
@SequenceGenerator(name = "seq", sequenceName = "seq_tags", allocationSize = 1, initialValue = 1)
public class Tag {
	
	@Id
    @GeneratedValue(generator="seq")
	private Long id;
	private String descricao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="local_id")
	private Locais locais;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Locais getLocais() {
		return locais;
	}
	public void setLocais(Locais locais) {
		this.locais = locais;
	}
	
	
	
	

}
