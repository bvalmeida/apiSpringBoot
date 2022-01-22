package br.com.covid.api.controller;

import br.com.covid.api.request.HospitalRequest;
import br.com.covid.api.response.HospitalResponse;
import br.com.covid.core.ports.input.ManterHospitalInputPort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
   }

   @GetMapping
   public List<HospitalResponse> hospitais(){
      return this.manterHospital
              .list()
              .stream()
              .map(HospitalResponse::converteHospitalOutputPortToHospitalResponse)
              .collect(Collectors.toList());
   }

   @DeleteMapping()
   public void deleteHospital(@RequestParam Long id){
      this.manterHospital.deletarHospital(id);
   }

   @PutMapping("/atualizar-ocupacao/{id}")
   public void atualizarPercentualOcupacao(@PathVariable("id")Long id, @RequestParam("percentual")Float percentual){
      this.manterHospital.atualizarPercentualDeOcupacao(id, percentual);
   }

}
