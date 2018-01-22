package jwd.knjizara.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import jwd.knjizara.model.Linija;
import jwd.knjizara.repository.LinijaRepository;
import jwd.knjizara.service.LinijaService;

@Service
@Transactional
public class JpaLinijaServiceImpl implements LinijaService {
	
	@Autowired
	private LinijaRepository linijaRepository;

	@Override
	public Page<Linija> findAll(int pageNum) {
		return linijaRepository.findAll(
				new PageRequest(pageNum, 5));
	}

	@Override
	public Linija findOne(Long id) {
		return linijaRepository.findOne(id);
	}

	@Override
	public void save(Linija linija) {
		linijaRepository.save(linija);
	}

	@Override
	public void remove(Long id) {
		linijaRepository.delete(id);
	}

	@Override
	public Page<Linija> findByPrevoznikId(int pageNum, Long mestoId) {
		
		return linijaRepository.findByPrevoznikId(mestoId, new PageRequest(pageNum, 5));
	}

	@Override
	public Page<Linija> pretraga(String destinacija, Integer maxMesta, String prevoznikNaziv , int page) {
		if(destinacija != null ){
			destinacija = "%" + destinacija + "%";
		}
		return linijaRepository.pretraga(destinacija, prevoznikNaziv,  maxMesta, new PageRequest(page, 5));
	}
	



}
