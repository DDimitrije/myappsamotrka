package jwd.knjizara.web.dto;

public class PrevoznikDTO {

	private Long id;
	private String naziv;
	private String PIB;
	private String adresa;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getPIB() {
		return PIB;
	}
	public void setPIB (String PIB) {
		this.PIB = PIB;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
}
