package br.com.covid.presenter.repository;

import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.presenter.entity.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, Long> {

}
