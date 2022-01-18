package br.com.covid.core.usecase;


import br.com.covid.core.data.input.HospitalInputPort;
import br.com.covid.core.ports.input.InputPort;
import br.com.covid.core.ports.output.OutputPort;
import org.springframework.stereotype.Service;

@Service
public class InputPortImpl implements InputPort {


    private final OutputPort outputPort;

    public InputPortImpl(OutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public void salvarHospital(HospitalInputPort inputPort) {
        this.outputPort.salvarHospital(inputPort.converteHospitalOutputPort(inputPort));
    }
}
