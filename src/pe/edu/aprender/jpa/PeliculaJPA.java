package pe.edu.aprender.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.edu.aprender.jpa.entity.TbPelicula;

public class PeliculaJPA {
	
	public List<TbPelicula> listarPeliculas(EntityManager em) throws Exception{
		// 1.Definimos JPQL
		String query = "SELECT o FROM TbPelicula o ORDER BY o.pelCod";
		// 2.Ejecutamos el query
		Query emquery = em.createQuery(query);
		List<TbPelicula> listaEntidad = emquery.getResultList();
		return listaEntidad;
	}
		
	public List<TbPelicula> buscarPeliculaXNombre(EntityManager em, TbPelicula pelicula) throws Exception {
		// 1.Definimos JPQL
		String query = "SELECT o FROM TbPelicula o WHERE o.pelNom like '%" + pelicula.getPelNom() + "%' ORDER BY o.pelCod";
		Query emquery = em.createQuery(query);
		// 2.Ejecutamos el query
		List<TbPelicula> listaEntidad = emquery.getResultList();
		return listaEntidad;
	}
	
	public void	registrarPelicula(EntityManager em, TbPelicula pelicula) throws Exception{
		// 1.Inicia la transacción
		em.getTransaction().begin();
		// 2.Prepara operacion INSERT
		em.persist(pelicula);
		// 3.Ejecuta operación.
		em.flush(); // De no usar este método, las operaciones se ejecutarán al invocar método commit()
		// 4.Ejecuta commit a la transacción
		em.getTransaction().commit();
	}
	
	public void	actualizarPelicula(EntityManager em, TbPelicula pelicula) throws Exception{
		// 1.Inicia la transacción
		em.getTransaction().begin();
		// 2 Prepara operación UPDATE
		em.merge(pelicula);
		// 3.Ejecuta operación.
		em.flush(); // De no usar este método, las operaciones se ejecutarán al invocar método commit()
		// 4.Ejecuta commit a la transacción
		em.getTransaction().commit();
	}
	
	public void eliminarPelicula(EntityManager em, TbPelicula pelicula) throws Exception{
		// 1.Inicia la transacción
		em.getTransaction().begin();
		// 2.Prepara las operaciones
		// 2.1 Busca Empleado por llave primaria
		TbPelicula entidad = (TbPelicula) em.find(TbPelicula.class, pelicula.getPelCod());
		// 2.2 Elimina Empleado
		em.remove(entidad);
		// 3.Ejecuta operación. 
		em.flush(); // De no usar este método, las operaciones se ejecutarán al invocar método commit()
		// 4.Ejecuta commit a la transacción
		em.getTransaction().commit();
	}

}
