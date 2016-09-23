package br.com.dtech.dao;
 
import br.com.dtech.model.Profile;
import br.com.dtech.model.Usuario;
 
public interface ProfileDao {
     
    public void save(Profile profile);
    public Profile buscarPerfil(Long id);
}