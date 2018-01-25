package jwd.knjizara.service;

import java.util.Date;

//import java.util.Date;

//import javax.persistence.Column;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import jwd.knjizara.model.Manifestacija;
import jwd.knjizara.model.Trka;


public interface ManifestacijaService {
	Page<Manifestacija> findAll(int pageNum);
	Manifestacija findOne(Long id);
	void save(Manifestacija manifestacija);
	void remove(Long id);
	Page<Manifestacija> findByTakmicenjaGodinaId(int pageNum, Long takmicenjaGodinaId);//pivaraID
	//Page<Trka> findByManifestacijaId(int pageNum, Long manifestacijaId);

	//Page<Manifestacija> findByTakmicenjaGodinaId(Long mestoId, Pageable pageRequest);
	//Page<Trka> findByManifestacijaId(int pageNum, Long manifestacijaId);
	
	
	Page<Manifestacija> pretraga(
			@Param("naziv") String naziv, 
			@Param("datumOdrzavanja") String datumOdrzavanja, 
			@Param("mestoOdrzavanja") String mestoOdrzavanja, 
			int page);
	//Page<Manifestacija> pretraga(String naziv, String datumOdrzavanja, String mestoOdrzavanja, int page);
	


}
