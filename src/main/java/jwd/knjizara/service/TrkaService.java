
package jwd.knjizara.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import jwd.knjizara.model.Manifestacija;
import jwd.knjizara.model.Trka;

//	Page<Trka> findAll();
//	Trka findOne(Long id);
//	void save(Trka trka);
//	void remove(Long id);
//	Page<Trka> findByManifestacijaId(int pageNum, Long manifestacijaId);//pivaraID
//
//	Page<Trka> pretraga(
//			@Param("duzinaStaze") String duzinaStaze,  
//			@Param("kategorija") String kategorija, 
//			int page);
//	//Page<Manifestacija> pretraga(String naziv, Date datumOdrzavanja, String mestoOdrzavanja, int page);
//	

//@Service
//@Transactional
public interface TrkaService {
	Page<Trka> findAll(int pageNum);
	//List<Trka> findAll();
	Trka findOne(Long id);
	void save(Trka trka);
	void remove(Long id);
	Page<Trka> findByTrkaId(int pageNum, Long trkaId);// pivaraID
	Page<Trka> findByManifestacijaId(int pageNum, Long manifestacijaId);
	
	Page<Trka> pretraga(@Param("duzinaStaze") String duzinaStaze, 
					@Param("kategorija") String kategorija, 
					int page);
	// Page<Manifestacija> pretraga(String naziv, Date datumOdrzavanja, String
	// mestoOdrzavanja, int page);
	
		
	//Page<Trka> findByTrkaId(int pageNum, Long trkaId);

}

