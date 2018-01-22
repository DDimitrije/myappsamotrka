package jwd.knjizara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jwd.knjizara.model.Kupovina;

public interface KupovinaRepository extends JpaRepository<Kupovina, Long> {

}
