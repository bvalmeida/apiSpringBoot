package br.com.covid.presenter.service;

import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.ports.output.ManterHospitalOutputPort;
import br.com.covid.presenter.entity.HospitalEntity;
import br.com.covid.presenter.repository.HospitalRepository;
import org.springframework.stereotype.Service;


@Service
public class ManterHospitalOutputPortImpl implements ManterHospitalOutputPort {

    private HospitalRepository hospitalRepository;

    public ManterHospitalOutputPortImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public HospitalOutputPort salvarHospital(HospitalOutputPort hospitalOutputPort) {
        var entity = this.hospitalRepository.save(HospitalEntity.converterOutputPortToEntity(hospitalOutputPort));
        return HospitalEntity.converterHospitalOutputPort(entity);

        //return this.hospitalRepository.save(HospitalEntity.converterOutputPortToEntity(hospitalOutputPort));
    }

}
