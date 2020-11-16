package pe.edu.aprender.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.edu.aprender.jpa.entity.TbGenero;

public class GeneroJPA {

	public List<TbGenero> listarGeneros(EntityManager em) throws Exception{
		// 1.Definimos JPQL
		String query = "SELECT o FROM TbGenero o ORDER BY o.genCod";
		Query emquery = em.createQuery(query);
		// 2.Ejecutamos query
		List<TbGenero> listaEntidad = emquery.getResultList();
		return listaEntidad;
	}
	
}
