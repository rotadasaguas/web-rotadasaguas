package br.com.dtech.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.NaturalId;
 
@Entity
public class Profile {
 
    @Id
    private Long id;
    private String nome;

    @NaturalId
    private String email;
    private String cpf;
    private String celular;
    
 
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Usuario user;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public Usuario getUser() {
        return user;
    }
 
    public void setUser(Usuario user) {
        this.user = user;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
    
    
 
}