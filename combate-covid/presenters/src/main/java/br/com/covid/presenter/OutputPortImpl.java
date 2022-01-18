package br.com.covid.presenter;

import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.ports.output.OutputPort;
import br.com.covid.presenter.entity.HospitalEntity;
import br.com.covid.presenter.repository.HospitalRepository;
import org.springframework.stereotype.Component;

@Component
public class OutputPortImpl implements OutputPort {

    private final HospitalRepository hospitalRepository;

    public OutputPortImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public void salvarHospital(HospitalOutputPort outputPort) {
        this.hospitalRepository.save(HospitalEntity.converteHospitalEntity(outputPort));
    }
}
