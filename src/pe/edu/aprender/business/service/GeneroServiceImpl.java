package pe.edu.aprender.business.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import pe.edu.aprender.jpa.GeneroJPA;
import pe.edu.aprender.jpa.entity.TbGenero;

public class GeneroServiceImpl implements GeneroService{
	
	GeneroJPA generoJPA = new GeneroJPA();
	private EntityManager em;
	
	public GeneroServiceImpl(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}
	
	public void close(EntityManagerFactory emf) {
		// Cierra el EntityManager
		em.close();
		emf.close();
	}

	@Override
	public List<TbGenero> listarGeneros() throws Exception{
		List<TbGenero> lista = generoJPA.listarGeneros(em);

		return lista;
	}

}
