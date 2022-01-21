package br.com.covid.presenters.repository;

import br.com.covid.presenters.entity.HospitalEntityLoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface HospitalLocRepository extends JpaRepository<HospitalEntityLoc,Long> {
}
