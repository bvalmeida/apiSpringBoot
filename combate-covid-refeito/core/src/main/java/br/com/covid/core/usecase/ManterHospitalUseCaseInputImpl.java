package br.com.covid.core.usecase;

import br.com.covid.core.data.input.HospitalInputPort;
import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.ports.input.ManterHospitalInputPort;
import br.com.covid.core.ports.output.ManterHospitalOutputPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManterHospitalUseCaseInputImpl implements ManterHospitalInputPort {

    private final ManterHospitalOutputPort manterHospitalOutputPort;

    public ManterHospitalUseCaseInputImpl(ManterHospitalOutputPort manterHospitalOutputPort){
        this.manterHospitalOutputPort = manterHospitalOutputPort;

    }
    @Override
    public HospitalOutputPort salvarHospital(HospitalInputPort inputPort) {
        return this.manterHospitalOutputPort.salvarHospital(HospitalOutputPort.converterInputToOutput(inputPort));
    }

    @Override
    public List<HospitalOutputPort> getAll() {
        return this.manterHospitalOutputPort.getAll();
    }


}
