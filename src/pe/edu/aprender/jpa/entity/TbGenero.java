package pe.edu.aprender.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tb_genero database table.
 * 
 */
@Entity
@Table(name="tb_genero")
public class TbGenero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GEN_COD")
	private int genCod;

	@Column(name="GEN_NOM")
	private String genNom;

	//bi-directional many-to-one association to TbPelicula
	@OneToMany(mappedBy="tbGenero")
	private Set<TbPelicula> tbPeliculas;

    public TbGenero() {
    }

	public int getGenCod() {
		return this.genCod;
	}

	public void setGenCod(int genCod) {
		this.genCod = genCod;
	}

	public String getGenNom() {
		return this.genNom;
	}

	public void setGenNom(String genNom) {
		this.genNom = genNom;
	}

	public Set<TbPelicula> getTbPeliculas() {
		return this.tbPeliculas;
	}

	public void setTbPeliculas(Set<TbPelicula> tbPeliculas) {
		this.tbPeliculas = tbPeliculas;
	}
	
}