package br.com.covid.presenters.repository;

import br.com.covid.presenters.entity.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<HospitalEntity, Long> {
}
