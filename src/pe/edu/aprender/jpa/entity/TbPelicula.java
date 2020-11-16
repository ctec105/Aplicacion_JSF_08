package pe.edu.aprender.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_pelicula database table.
 * 
 */
@Entity
@Table(name="tb_pelicula")
public class TbPelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PEL_COD")
	private int pelCod;

	@Column(name="PEL_HINI")
	private int pelHini;

	@Column(name="PEL_NOM")
	private String pelNom;

	//bi-directional many-to-one association to TbGenero
    @ManyToOne
	@JoinColumn(name="GEN_COD")
	private TbGenero tbGenero;

    public TbPelicula() {
    	// --- rz ---
    	tbGenero = new TbGenero();
    	// --- rz ---
    }

	public int getPelCod() {
		return this.pelCod;
	}

	public void setPelCod(int pelCod) {
		this.pelCod = pelCod;
	}

	public int getPelHini() {
		return this.pelHini;
	}

	public void setPelHini(int pelHini) {
		this.pelHini = pelHini;
	}

	public String getPelNom() {
		return this.pelNom;
	}

	public void setPelNom(String pelNom) {
		this.pelNom = pelNom;
	}

	public TbGenero getTbGenero() {
		return this.tbGenero;
	}

	public void setTbGenero(TbGenero tbGenero) {
		this.tbGenero = tbGenero;
	}
	
}