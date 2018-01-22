
package jwd.knjizara.service;

import java.util.List;


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
	public interface TrkaService {
		
		List<Trka> findAll();
		Trka findOne(Long id);
		void save(Trka trka);
		void remove(Long id);

}
		




//public interface TrkaService {
//
//	Page<Trka> findAll(int pageNum);
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
//
//}


