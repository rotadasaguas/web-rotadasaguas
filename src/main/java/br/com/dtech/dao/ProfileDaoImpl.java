package br.com.dtech.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.dtech.model.Profile;
import br.com.dtech.model.Usuario;
  
public class ProfileDaoImpl implements ProfileDao {
  
    private Session session;
  
    public void setSession(Session session) {
        this.session = session;
    }
      
    public void save(Profile profile) {
        this.session.saveOrUpdate(profile);
    }

	public Profile buscarPerfil(Long id) {		
		Criteria criteria = session.createCriteria(Profile.class);
		criteria.add(Restrictions.eq("id", id));
		return (Profile) criteria.uniqueResult();
	}
    
}