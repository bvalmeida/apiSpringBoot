package br.com.covid.core.ports.input;

import br.com.covid.core.data.input.HospitalInputPort;

public interface InputPort {

    void salvarHospital(HospitalInputPort inputPort);
}
