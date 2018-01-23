package jwd.knjizara.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.knjizara.model.TakmicenjaGodina;
import jwd.knjizara.model.Trka;
import jwd.knjizara.model.Trkac;

@Repository
public interface TrkaRepository extends JpaRepository<Trka, Long> {

}

