package jwd.knjizara.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table
public class Linija {	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private int broj_mesta;// naziv;
	@Column
	private String cena_karte;// vrsta;
	@Column
	private String vreme_polaska;//IBU;
	@Column
	private String destinacija; //kolicina;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Prevoznik prevoznik;
	
	@OneToMany(mappedBy="linija",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Kupovina> kupovine = new ArrayList<>();
	
//	@ManyToOne(fetch=FetchType.EAGER)
//	private Pivara pivara;
//	
//	@OneToMany(mappedBy="pivo",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//	private List<KupovinaPivo> kupovine = new ArrayList<>();
	
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
	public String  getVreme_polaska() {
		return vreme_polaska;
	}
	public void setVreme_polaska(String vreme_polaska) {
		this.vreme_polaska = vreme_polaska;
	}	
	public String getDestinacija() {
		return destinacija;
	}
	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}			 
	public Prevoznik getPrevoznik() {
		return prevoznik;
	}
	public void setPrevoznik(Prevoznik prevoznik) {
		this.prevoznik = prevoznik;
		if(prevoznik!=null && !prevoznik.getLinije().contains(this)){
			prevoznik.getLinije().add(this);
		}
	}	
	public List<Kupovina> getKupovine() {
		return kupovine;
	}
	public void setKupovine(List<Kupovina> kupovine) {
		this.kupovine = kupovine;
	}
	public void addKupovina(Kupovina kupovina){
		this.kupovine.add(kupovina);
		
		if(!this.equals(kupovina.getLinija())){
			kupovina.setLinija(this);
		}
	}
	public void setKolicina(int i) {
		// TODO Auto-generated method stub
		
	}
}