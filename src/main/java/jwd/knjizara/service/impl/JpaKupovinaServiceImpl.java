package jwd.knjizara.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.knjizara.model.Linija;

import jwd.knjizara.model.Kupovina;
import jwd.knjizara.repository.LinijaRepository;
import jwd.knjizara.repository.KupovinaRepository;
import jwd.knjizara.service.KupovinaService;

@Service
public class JpaKupovinaServiceImpl implements KupovinaService{
	
	@Autowired
	private KupovinaRepository kupovinaRepository;
	@Autowired
	private LinijaRepository linijaRepository;
	
	@Override
	public Kupovina buyABook(Long linijaId) {
		
		if(linijaId == null) {
			throw new IllegalArgumentException("Id of a book cannot be null!");
		}
		
		Linija linija = linijaRepository.findOne(linijaId);
		if(linija == null) {
			throw new IllegalArgumentException("There is no book with given id!");
		}
		
		//kupovina
		
		if(linija.getMesto() > 0) {
			
			Kupovina kupovina = new Kupovina();
			kupovina.setLinija(linija);
			
			linija.setMesto(linija.getMesto() - 1); //setKolicina
			
			kupovinaRepository.save(kupovina);
			linijaRepository.save(linija);
			
			return kupovina;
		}
		
		return null;
		
	}
}
