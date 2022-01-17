package br.com.covid.core.usecase;


import br.com.covid.core.data.input.HospitalInputPort;
import br.com.covid.core.ports.input.ManterHospitalInputPort;
import br.com.covid.core.ports.output.ManterHospitalOutputPort;
import org.springframework.stereotype.Service;

@Service
public class ManterHospitalUseCaseImpl implements ManterHospitalInputPort {


    private final ManterHospitalOutputPort manterHospitalOutputPort;

    public ManterHospitalUseCaseImpl(ManterHospitalOutputPort manterHospitalOutputPort) {
        this.manterHospitalOutputPort = manterHospitalOutputPort;
    }

    @Override
    public void salvarHospital(HospitalInputPort inputPort) {
        this.manterHospitalOutputPort.salvarHospital(inputPort.converteHospitalOutputPort(inputPort));
    }
}