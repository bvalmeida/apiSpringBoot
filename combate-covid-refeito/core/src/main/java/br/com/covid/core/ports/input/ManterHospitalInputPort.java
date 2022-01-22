package br.com.covid.core.ports.input;

import br.com.covid.core.data.input.HospitalInputPort;
import br.com.covid.core.data.output.HospitalOutputPort;

import java.util.List;

public interface ManterHospitalInputPort {

    HospitalOutputPort salvarHospital(HospitalInputPort inputPort);
    public List<HospitalOutputPort> getAll();

}
