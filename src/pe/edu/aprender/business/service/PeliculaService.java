package pe.edu.aprender.business.service;

import java.util.List;

import pe.edu.aprender.jpa.entity.TbPelicula;

public interface PeliculaService {
	
	public List<TbPelicula> listarPeliculas() throws Exception;
	public List<TbPelicula> buscarPeliculaXNombre(TbPelicula pelicula) throws Exception;
	public void	registrarPelicula(TbPelicula pelicula) throws Exception;
	public void	actualizarPelicula(TbPelicula pelicula) throws Exception;
	public void eliminarPelicula(TbPelicula pelicula) throws Exception;
	
}
