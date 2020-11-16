package pe.edu.aprender.business.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import pe.edu.aprender.jpa.PeliculaJPA;
import pe.edu.aprender.jpa.entity.TbPelicula;

public class PeliculaServiceImpl implements PeliculaService{
	
	PeliculaJPA peliculaJPA = new PeliculaJPA();
	private EntityManager em;

	public PeliculaServiceImpl(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	public void close(EntityManagerFactory emf) {
		// Cierra el EntityManager
		em.close();
		emf.close();
	}

	@Override
	public List<TbPelicula> listarPeliculas() throws Exception {
		List<TbPelicula> lista = peliculaJPA.listarPeliculas(em);
		return lista;
	}
	
	@Override
	public List<TbPelicula> buscarPeliculaXNombre(TbPelicula pelicula) throws Exception {
		List<TbPelicula> lista = peliculaJPA.buscarPeliculaXNombre(em, pelicula);
		return lista;
	}
	
	@Override
	public void registrarPelicula(TbPelicula pelicula) throws Exception {
		peliculaJPA.registrarPelicula(em, pelicula);		
	}
	
	@Override
	public void actualizarPelicula(TbPelicula pelicula) throws Exception {
		peliculaJPA.actualizarPelicula(em, pelicula);
	}

	@Override
	public void eliminarPelicula(TbPelicula pelicula) throws Exception {
		peliculaJPA.eliminarPelicula(em, pelicula);
	}
	
}
