package br.com.dtech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.dtech.model.Locais;

public class LocaisImpl implements LocaisDao {

	 private Session session;
	  
	    public void setSession(Session session) {
	        this.session = session;
	    }
	      
	    public void save(Locais locais) {
	        this.session.saveOrUpdate(locais);
	    }

		public Locais buscarLocais(Long id) {		
			Criteria criteria = session.createCriteria(Locais.class);
			criteria.add(Restrictions.eq("id", id));
			return (Locais) criteria.uniqueResult();
		}
		public List all() {
			Criteria criteria = session.createCriteria(Locais.class);
	        List<Locais> lista = (List<Locais>) criteria.list(); 
	        
	        return lista;
		}

}
