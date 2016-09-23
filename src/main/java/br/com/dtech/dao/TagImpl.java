package br.com.dtech.dao;

import org.hibernate.Session;

import br.com.dtech.model.Tag;

public class TagImpl implements TagDao{

	private Session session;
	  
    public void setSession(Session session) {
        this.session = session;
    }
      
    public void save(Tag tag) {
        this.session.saveOrUpdate(tag);
    }
}
