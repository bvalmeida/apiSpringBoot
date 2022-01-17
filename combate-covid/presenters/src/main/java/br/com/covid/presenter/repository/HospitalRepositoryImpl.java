package br.com.covid.presenter.repository;

import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.ports.output.ManterHospitalOutputPort;
import br.com.covid.presenter.entity.HospitalEntity;
import org.springframework.stereotype.Component;

@Component
public class HospitalRepositoryImpl implements ManterHospitalOutputPort {

    private final HospitalRepository hospitalRepository;

    public HospitalRepositoryImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public void salvarHospital(HospitalOutputPort outputPort) {
        this.hospitalRepository.save(HospitalEntity.converteHospitalEntity(outputPort));
    }
}
