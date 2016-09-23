package br.com.dtech.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NaturalId;
  
@Entity
@Table(name="user_rota")
@SequenceGenerator(name = "seq", sequenceName = "seq_user", allocationSize = 1, initialValue = 1)
public class Usuario{
	
	public Usuario(){
		locais = new ArrayList<Locais>();
	}
      
    @Id
    @GeneratedValue(generator="seq")
    private Long id;
    @NaturalId
    private String login;
    private String password;    
      
    @ElementCollection(targetClass = String.class)
    @JoinTable(name = "user_permission",
               uniqueConstraints = { @UniqueConstraint (columnNames = {"id", "permission" })},
               joinColumns = @JoinColumn(name = "id"))
    @Column(name = "permission", length = 40)
    @Cascade(CascadeType.DELETE)
    private Set<String> permissions = new HashSet<String>(); 
    
    @OneToMany(mappedBy="user")
	private List<Locais> locais;
  
    public String getLogin() {
        return login;
    }
  
    public void setLogin(String login) {
        this.login = login;
    }
  
    public String getPassword() {
        return password;
    }
  
    public void setPassword(String password) {
        this.password = password;
    }  
  
    public Set<String> getPermissions() {
        return permissions;
    }
  
    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
     
    public Long getId() {
        return id;
    }
  
    public void setId(Long id) {
        this.id = id;
    }

	public List<Locais> getLocais() {
		return locais;
	}

	public void setLocais(List<Locais> locais) {
		this.locais = locais;
	} 
    
}