package br.com.covid.core.ports.output;

import br.com.covid.core.data.output.HospitalOutputPort;

public interface ManterHospitalOutputPort {

    HospitalOutputPort salvarHospital(HospitalOutputPort hospitalOutputPort);

}
