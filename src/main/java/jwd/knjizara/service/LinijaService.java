package jwd.knjizara.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;


import jwd.knjizara.model.Linija;

public interface LinijaService {
	Page<Linija> findAll(int pageNum);
	Linija findOne(Long id);
	void save(Linija linija);
	void remove(Long id);
	
	Page<Linija> findByPrevoznikId(int pageNum, Long prevoznikId);
	
	Page<Linija> pretraga(
			@Param("destinacija") String destinacija, 
			@Param("maxMesta") Integer maxMesta,
			@Param("prevoznikNaziv") String prevoznikNaziv,
			int page);
	
//	Page<Knjiga> findByIzdvacId(int pageNum, Long izdavacId);
//	Page<Knjiga> pretraga(
//			@Param("naziv") String naziv, 
//			@Param("pisac") String pisac, 
//			@Param("maxKolicina") Integer maxKolicina,
//			int page);
}
