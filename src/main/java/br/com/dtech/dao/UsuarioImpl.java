package br.com.dtech.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.dtech.model.Profile;
import br.com.dtech.model.Usuario;
 

public class UsuarioImpl implements UsuarioDao {

	private Session session;
	 
    public void setSession(Session session) {
        this.session = session;
    }
  
	public void salvar(Usuario usuario) {
		session.saveOrUpdate(usuario);			
	}

	public Usuario login(String login, String senha) {
		Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("login", login));
        criteria.add(Restrictions.eq("password", senha));
        return (Usuario) criteria.uniqueResult();
	}

}
