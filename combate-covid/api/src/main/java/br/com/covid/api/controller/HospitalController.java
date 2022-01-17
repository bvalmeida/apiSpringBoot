package br.com.covid.api.controller;

import br.com.covid.api.request.HospitalRequest;
import br.com.covid.core.ports.input.ManterHospitalInputPort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hospitais")
public class HospitalController {

    private final ManterHospitalInputPort ManterHospital;

    public HospitalController(ManterHospitalInputPort manterHospital) {

        this.ManterHospital = manterHospital;
    }

    @PostMapping
    public void criarHospital(@RequestBody HospitalRequest request){
        this.ManterHospital.salvarHospital(request.convertHospitalInputPort(request));

    }

}
