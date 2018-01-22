package jwd.knjizara;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import jwd.knjizara.model.Linija;
import jwd.knjizara.model.Manifestacija;
import jwd.knjizara.model.Pivara;
import jwd.knjizara.model.Pivo;
import jwd.knjizara.model.Prevoznik;
import jwd.knjizara.model.TakmicenjaGodina;
import jwd.knjizara.service.LinijaService;
import jwd.knjizara.service.ManifestacijaService;
import jwd.knjizara.service.PivaraService;
import jwd.knjizara.service.PivoService;
import jwd.knjizara.service.PrevoznikService;
import jwd.knjizara.service.TakmicenjaGodinaService;

@Component
public class TestData {

	@Autowired
	private PivaraService pivaraService;
	@Autowired
	private PivoService pivoService;
	@Autowired
	private LinijaService linijaService;
	@Autowired
	private PrevoznikService prevoznikService;
	@Autowired
	private TakmicenjaGodinaService takmicenjaGodinaService;
	@Autowired
	private ManifestacijaService manifestacijaService;
	
	@PostConstruct
	public void init() {
		
		Prevoznik pr1 = new Prevoznik();
		pr1.setNaziv("Polet");
		pr1.setPIB("123165465211");
		pr1.setAdresa("Adresa1");
		prevoznikService.save(pr1);
		
		Prevoznik pr2 = new Prevoznik();
		pr2.setNaziv("Delfi");
		pr2.setPIB("123123546456");
		pr2.setAdresa("Adresa2");
		prevoznikService.save(pr2);
		
		Linija k1 = new Linija();
		k1.setMesto(23);
		k1.setCena_karte("2321");
		k1.setVreme_polaska("12:20");
		k1.setDestinacija("destinacija 1");
		k1.setPrevoznik(pr1);
		linijaService.save(k1);
		
		Linija k2 = new Linija();
		k2.setMesto(34);
		k2.setCena_karte("5466");
		k2.setVreme_polaska("13:20");
		k2.setDestinacija("destinacija 2");
		k2.setPrevoznik(pr2);
		linijaService.save(k2);

		
		Pivara p1 = new Pivara();
		p1.setNaziv("Polet");
		p1.setPIB("2334334");
		p1.setDrzava("Srbija");
		pivaraService.save(p1);
		
		Pivara p2 = new Pivara();
		p2.setNaziv("Delfi");
		p2.setPIB("12344");
		p2.setDrzava("Rusija");
		pivaraService.save(p2);
		
		Pivo pi1 = new Pivo();
		pi1.setIBU(3.0);
		pi1.setNaziv("Faust");
		pi1.setKolicina(10);
		pi1.setVrsta("Johan Volfgang Gete");
		pi1.setProcenat_alkohola(4.5);
		pi1.setPivara(p1);
		pivoService.save(pi1);
		
		Pivo pi2 = new Pivo();
		pi2.setIBU(4.0);
		pi2.setNaziv("Tako je govorio Zaratustra");
		pi2.setKolicina(15);
		pi2.setVrsta("Fridrih");
		pi2.setProcenat_alkohola(3.7);
		pi2.setPivara(p2);
		pivoService.save(pi2);
		
		TakmicenjaGodina tg1 = new TakmicenjaGodina();
		//tg1.setNazivTrke("Polet1");
		takmicenjaGodinaService.save(tg1);
		
		TakmicenjaGodina tg2 = new TakmicenjaGodina();
		//tg2.setNazivTrke("Polet2");
		takmicenjaGodinaService.save(tg2);
		
		
		Manifestacija m1 = new Manifestacija();
		m1.setNaziv("1100110011");
		Date da = null;
		try {
			da = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2012-05-20T09:00:00.000Z");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m1.setTakmicenjaGodina(tg1);
		m1.setDatumOdrzavanja(da); //new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2012-05-20T09:00:00.000Z")
		m1.setMestoOdrzavanja("mesto odrzavanja 1");
		manifestacijaService.save(m1);
		
		Manifestacija m2 = new Manifestacija();
		m2.setNaziv("12312312");
		Date daa = null;
		try {
			daa = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2013-05-20T09:00:00.000Z");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m2.setTakmicenjaGodina(tg2);
		m2.setDatumOdrzavanja(daa);
		m2.setMestoOdrzavanja("mesto odrzavanja 2");
		manifestacijaService.save(m2);
	}
}