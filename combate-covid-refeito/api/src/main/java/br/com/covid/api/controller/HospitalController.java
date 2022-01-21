package br.com.covid.api.controller;

import br.com.covid.api.request.HospitalRequest;
import br.com.covid.core.ports.input.ManterHospitalInputPort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospitais")
public class HospitalController {

   private final ManterHospitalInputPort manterHospital;

   public HospitalController(ManterHospitalInputPort manterHospital) {
      this.manterHospital = manterHospital;
   }

   @PostMapping
   public void criarHospital(@RequestBody HospitalRequest hospitalRequest){
      this.manterHospital.salvarHospital(HospitalRequest.converterRequestToInputPort(hospitalRequest));

   }

}
