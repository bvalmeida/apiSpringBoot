package br.com.covid.core.ports.output;

import br.com.covid.core.data.output.HospitalOutputPort;

import java.util.List;

public interface ManterHospitalOutputPort {

    HospitalOutputPort salvarHospital(HospitalOutputPort hospitalOutputPort);
    public List<HospitalOutputPort> getAll();
}
