package es.altair.bean;

public class TipoReceta {

	private int idTipoReceta;
	private String tiporeceta;

	public TipoReceta(int idTipoReceta, String tiporeceta) {
		super();
		this.idTipoReceta = idTipoReceta;
		this.tiporeceta = tiporeceta;
	}

	public int getIdTipoReceta() {
		return idTipoReceta;
	}

	public void setIdTipoReceta(int idTipoReceta) {
		this.idTipoReceta = idTipoReceta;
	}

	public String getTiporeceta() {
		return tiporeceta;
	}

	public void setTiporeceta(String tiporeceta) {
		this.tiporeceta = tiporeceta;
	}

	@Override
	public String toString() {
		return "TipoReceta [idTipoReceta=" + idTipoReceta + ", tiporeceta=" + tiporeceta + "]";
	}

}