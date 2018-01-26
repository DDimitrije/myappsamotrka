package jwd.knjizara.service.impl;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jwd.knjizara.model.Manifestacija;
import jwd.knjizara.model.TakmicenjaGodina;
import jwd.knjizara.model.Trka;
import jwd.knjizara.model.Trkac;
import jwd.knjizara.repository.ManifestacijaRepository;
import jwd.knjizara.repository.TakmicenjaGodinaRepository;
import jwd.knjizara.repository.TrkaRepository;
import jwd.knjizara.service.TakmicenjaGodinaService;
import jwd.knjizara.service.TrkaService;


@Service
@Transactional
public class JpaTrkaServiceImpl implements TrkaService {
	@Autowired
	private TrkaRepository trkaRepository;
	

//	@Override
//	public List<Trka> findAll() {
//		return trkaRepository.findAll();
//	}
	@Override
	public Page<Trka> findAll(int pageNum) {
		return trkaRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Trka findOne(Long id) {
		return trkaRepository.findOne(id);
	}

	@Override
	public void save(Trka trka) {
		trkaRepository.save(trka);
	}

	@Override
	public void remove(Long id) {
		trkaRepository.delete(id);
	}
	
	@Override
	public Page<Trka> findByTrkaId(int pageNum, Long trkaId) {
		return trkaRepository.findByTrkaId(trkaId, new PageRequest(pageNum, 5));	
	}	
	
	@Override
	public Page<Trka> findByManifestacijaId(int pageNum, Long manifestacijaId) {

		return trkaRepository.findByManifestacijaId(manifestacijaId, new PageRequest(pageNum, 5));
	}

	@Override
	public Page<Trka> pretraga(String duzinaStaze, String kategorija,  int page) {	
		return trkaRepository.pretraga(duzinaStaze, kategorija,  new PageRequest(page, 5));
	}


	
	
	

//	@Override
//	public Page<Manifestacija> pretraga(String naziv, String datumOdrzavanja, String mestoOdrzavanja,  int page) {
//																										
//		if (naziv != null) {
//			naziv = "%" + naziv + "%";
//		}
//		return manifestacijaRepository.pretraga(naziv, datumOdrzavanja, mestoOdrzavanja,  new PageRequest(page, 5));	
//	}
	
}
