package jwd.knjizara.web.dto;

import javax.persistence.Column;

public class LinijaDTO {
	private Long id;
	private int broj_mesta; //naziv;
	private String cena_karte;//vrsta;
	private String vreme_polaska;//IBU;
	private String destinacija; //kolicina;
	
	private String prevoznikNaziv;
	private Long prevoznikId;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getMesto() {
		return broj_mesta;
	}
	public void setMesto(int broj_mesta) {
		this.broj_mesta = broj_mesta;
	}
	public String getCena_karte() {
		return cena_karte;
	}
	public void setCena_karte(String cena_karte) {
		this.cena_karte = cena_karte;
	}
	public String getVreme_polaska() {
		return vreme_polaska;
	}
	public void setVreme_polaska(String vreme_polaska) {
		this.vreme_polaska= vreme_polaska;
	}
	public String getDestinacija() {
		return destinacija;
	}
	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}
	public String getPrevoznikNaziv() {
		return prevoznikNaziv;
	}
	public void setPrevoznikNaziv(String prevoznikNaziv) {
		this.prevoznikNaziv = prevoznikNaziv;
	}
	public Long getPrevoznikId() {
		return prevoznikId;
	}
	public void setPrevoznikId(Long prevoznikId) {
		this.prevoznikId = prevoznikId;
	}
}