package br.com.covid.presenters.service;

import br.com.covid.ports.interfaces.output.Output;
import br.com.covid.ports.output.OutputPort;
import br.com.covid.presenters.entity.HospitalEntity;
import br.com.covid.presenters.entity.HospitalEntityLoc;
import br.com.covid.presenters.repository.HospitalRepository;
import org.springframework.stereotype.Service;

@Service
public class OutputImpl implements Output {


    private HospitalRepository hospitalRepository;
    private HospitalEntityLoc hospitalEntityLoc;

    public OutputImpl(HospitalRepository hospitalRepository, HospitalEntityLoc hospitalEntityLoc) {
        super();
        this.hospitalRepository = hospitalRepository;
        this.hospitalEntityLoc = hospitalEntityLoc;
    }

    @Override
    public void save(OutputPort outputPort){
        var toSave = HospitalEntity.converteHospitalEntity(outputPort);
        this.hospitalRepository.save(toSave);


    }
}
