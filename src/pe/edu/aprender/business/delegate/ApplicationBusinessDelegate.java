package pe.edu.aprender.business.delegate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pe.edu.aprender.business.service.GeneroService;
import pe.edu.aprender.business.service.GeneroServiceImpl;
import pe.edu.aprender.business.service.PeliculaService;
import pe.edu.aprender.business.service.PeliculaServiceImpl;

public class ApplicationBusinessDelegate {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Aplicacion_JSF_08");
	
	public PeliculaService getPeliculaService() {
		return new PeliculaServiceImpl(emf);
	}
	
	public GeneroService getGeneroService() {
		return new GeneroServiceImpl(emf);
	}
	
}
