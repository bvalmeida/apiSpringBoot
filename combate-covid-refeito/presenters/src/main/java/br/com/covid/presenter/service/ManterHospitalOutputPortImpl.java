package br.com.covid.presenter.service;

import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.ports.output.ManterHospitalOutputPort;
import br.com.covid.presenter.entity.HospitalEntity;
import br.com.covid.presenter.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    }

    @Override
    public List<HospitalOutputPort> list() {

        return this.hospitalRepository.findAll()
                .stream()
                .map(HospitalEntity::converterHospitalOutputPort)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarHospital(Long id) {
        this.hospitalRepository.deleteById(id);
    }

    @Override
    public void atualizarPercentualDeOcupacao(Long hospitalId, Float percentual) {

        var hospitalEntity = this.hospitalRepository.getById(hospitalId);
        var hospitalAtualizacao = hospitalEntity.atualizaPercentualDeOcupacao(percentual);
        this.hospitalRepository.save(hospitalEntity);
    }


}
