package pe.edu.aprender.jsf.managed;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pe.edu.aprender.business.delegate.ApplicationBusinessDelegate;
import pe.edu.aprender.business.service.GeneroService;
import pe.edu.aprender.business.service.PeliculaService;
import pe.edu.aprender.jpa.entity.TbGenero;
import pe.edu.aprender.jpa.entity.TbPelicula;

@ManagedBean(name = "formulario")
@SessionScoped
public class SesionBean {
	
	// Business Layer
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	private static PeliculaService pelService;
	private static GeneroService genService;
	
	private List<TbPelicula> pelList;
	private List<TbGenero> genList;
	
	private TbPelicula item = new TbPelicula();

	private boolean edit;

	public List<TbPelicula> getPelList() {
		return pelList;
	}
	public void setPelList(List<TbPelicula> pelList) {
		this.pelList = pelList;
	}
	public List<TbGenero> getGenList() {
		return genList;
	}
	public void setGenList(List<TbGenero> genList) {
		this.genList = genList;
	}
	
	public void setItem(TbPelicula item) {
		this.item = item;
	}
	public TbPelicula getItem() {
		return item;
	}
	
	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}


	public String inicializar() throws Exception {
		System.out.println("Estoy en inicializar() - Ini");
		pelService = abd.getPeliculaService();
		pelList = pelService.listarPeliculas();
		genService = abd.getGeneroService();
		genList = genService.listarGeneros();
		System.out.println("Estoy en inicializar() - Fin");
		return "mantPelicula";
	}

	public String buscar() throws Exception{
		System.out.println("Estoy en buscar() - Ini");
		pelService = abd.getPeliculaService();
		pelList = pelService.buscarPeliculaXNombre(item);
		item = new TbPelicula(); // Limpiar los datos del bean Pelicula
		System.out.println("Estoy en buscar() - Fin");
		return "mantPelicula";
	}
	
	public String edit(TbPelicula item) throws Exception{
		System.out.println("Estoy en edit() - Ini");
        this.item = item;
        edit = true;
        System.out.println("Estoy en edit() - Fin");
		return "mantPelicula";
	}
	
	public String add() throws Exception{
		System.out.println("Estoy en add() - Ini");
		pelService = abd.getPeliculaService();
		pelService.registrarPelicula(item);
		pelList = pelService.listarPeliculas();
		item = new TbPelicula(); // Limpiamos los datos del bean Pelicula
		System.out.println("Estoy en add() - Fin");
		return "mantPelicula";
	}

	public String save() throws Exception{
		System.out.println("Estoy en save() - Ini");
		pelService = abd.getPeliculaService();
		pelService.actualizarPelicula(item);
		pelList = pelService.listarPeliculas();
		item = new TbPelicula(); // Limpiamos los datos del bean Pelicula
        edit = false;
        System.out.println("Estoy en save() - Fin");
        return "mantPelicula";
	}
	
	public String delete(TbPelicula item)  throws Exception{
		System.out.println("Estoy en delete() - Ini");
		pelService = abd.getPeliculaService();
		pelService.eliminarPelicula(item);
		pelList = pelService.listarPeliculas();
		item = new TbPelicula(); // Lmpiamos los datos del bean Pelicula
		System.out.println("Estoy en delete() - Fin");
		return "mantPelicula";

	}

}
