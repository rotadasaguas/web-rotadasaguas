package br.com.dtech.dao;

import java.util.List;

import br.com.dtech.model.Locais;

public interface LocaisDao {

	public void save(Locais locais);
    public Locais buscarLocais(Long id);
    public List all();
}
