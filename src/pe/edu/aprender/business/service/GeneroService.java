package pe.edu.aprender.business.service;

import java.util.List;

import pe.edu.aprender.jpa.entity.TbGenero;

public interface GeneroService {

	public List<TbGenero> listarGeneros() throws Exception;
	
}
