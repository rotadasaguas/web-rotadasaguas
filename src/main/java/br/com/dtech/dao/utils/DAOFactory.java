package br.com.dtech.dao.utils;

import br.com.dtech.dao.LocaisDao;
import br.com.dtech.dao.LocaisImpl;
import br.com.dtech.dao.ProfileDao;
import br.com.dtech.dao.ProfileDaoImpl;
import br.com.dtech.dao.TagDao;
import br.com.dtech.dao.TagImpl;
import br.com.dtech.dao.UsuarioDao;
import br.com.dtech.dao.UsuarioImpl;


public class DAOFactory {
	
	public static ProfileDao criarProfile(){
        ProfileDaoImpl profileDaoImpl = new ProfileDaoImpl();
        profileDaoImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return profileDaoImpl;
    }
    
    public static UsuarioDao criarUsuario(){
        UsuarioImpl userImpl = new UsuarioImpl();
        userImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return userImpl;
    }
    
    public static LocaisDao criarLocal(){
    	LocaisImpl locaisImpl = new LocaisImpl();
        locaisImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return locaisImpl;
    }
    
    public static TagDao criarTag(){
    	TagImpl tagImpl = new TagImpl();
    	tagImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return tagImpl;
    }


}
