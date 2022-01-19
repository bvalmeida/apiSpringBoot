package br.com.covid.presenters;

import br.com.covid.ports.interfaces.output.Output;
import br.com.covid.ports.output.OutputPort;
import br.com.covid.presenters.entity.HospitalEntity;
import br.com.covid.presenters.repository.HospitalRepository;
import org.springframework.stereotype.Component;

@Component
public class OutputImpl implements Output {

    private final HospitalRepository hospitalRepository;

    public OutputImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public void save(OutputPort output){
        this.hospitalRepository.save(new HospitalEntity());
    }
}
