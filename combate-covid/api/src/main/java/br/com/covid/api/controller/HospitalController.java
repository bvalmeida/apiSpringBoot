package br.com.covid.api.controller;

import br.com.covid.api.request.HospitalRequest;
import br.com.covid.core.ports.input.InputPort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospitais")
public class HospitalController {

    private final InputPort inputPort;

    public HospitalController(InputPort inputPort) {

        this.inputPort = inputPort;
    }

    @PostMapping
    public void criarHospital(@RequestBody HospitalRequest request){
        this.inputPort.salvarHospital(request.convertHospitalInputPort(request));

    }


}
