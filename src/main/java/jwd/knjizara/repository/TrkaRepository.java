package jwd.knjizara.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.knjizara.model.Manifestacija;
import jwd.knjizara.model.TakmicenjaGodina;
import jwd.knjizara.model.Trka;
import jwd.knjizara.model.Trkac;

@Repository
public interface TrkaRepository extends JpaRepository<Trka, Long> {

	Page<Trka> findByManifestacijaId(Long mestoId, Pageable pageRequest);
	//Page<Trka> findByTrkaId(Long mestoId, Pageable pageRequest);
	Page<Trka> findByTrkaId(Long trkaId, Pageable pageRequest);
	//trkaRepository.findByTrkaId(trkaId, new PageRequest(pageNum, 5));
	
	//Page<Manifestacija> findByTakmicenjaGodinaId(int pageNum, Long takmicenjaGodinaId);//pivaraID

	@Query("SELECT k FROM Trka k WHERE "
	+ "(:duzinaStaze IS NULL or k.duzinaStaze like :duzinaStaze ) AND "
	+ "(:kategorija IS NULL OR k.kategorija  like :kategorija ) "
	)
	
	
	Page<Trka> pretraga(
			@Param("duzinaStaze") String duzinaStaze, 
			@Param("kategorija") String kategorija, 
			Pageable pageRequest);

	
	
	
//	Page<Manifestacija> findByTakmicenjaGodinaId(Long mestoId, Pageable pageRequest);
//	Page<Trka> findByManifestacijaId(Long mestoId, Pageable pageRequest);
//	
//	@Query("SELECT k FROM Manifestacija k WHERE "
//			+ "(:naziv IS NULL or k.naziv like :naziv ) AND "
//			+ "(:datumOdrzavanja IS NULL OR k.datumOdrzavanja  like :datumOdrzavanja ) AND "
//			+ "(:mestoOdrzavanja IS NULL OR k.mestoOdrzavanja like :mestoOdrzavanja) "
//			)
//
//	Page<Manifestacija> pretraga(
//			@Param("naziv") String naziv, 
//			@Param("datumOdrzavanja") String datumOdrzavanja,
//			@Param("mestoOdrzavanja") String mestoOdrzavanja,
//			Pageable pageRequest);
}

