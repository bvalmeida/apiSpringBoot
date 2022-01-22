package br.com.covid.api.controller;

import br.com.covid.api.request.HospitalRequest;
import br.com.covid.api.response.HospitalResponse;
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
   public HospitalResponse criarHospital(@RequestBody HospitalRequest hospitalRequest){
      var response = this.manterHospital.salvarHospital(HospitalRequest.converterRequestToInputPort(hospitalRequest));
      return HospitalResponse.converteHospitalOutputPortToHospitalResponse(response);

      //this.manterHospital.salvarHospital(HospitalRequest.converterRequestToInputPort(hospitalRequest));

   }

}
