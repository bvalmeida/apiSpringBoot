package br.com.covid.api.request;

import br.com.covid.core.data.input.HospitalInputPort;
import br.com.covid.core.data.input.LocalizacaoInputPort;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalRequest {

    private String nome;
    private String cnpj;
    private String endereco;
    private LocalizacaoRequest localizacao;

    public HospitalInputPort convertHospitalInputPort(HospitalRequest request){

        LocalizacaoInputPort localizacaoInputPort = LocalizacaoInputPort.builder()
                .latitude(request.localizacao.getLatitude())
                .longitude(request.localizacao.getLongitude())
                .build();

        return HospitalInputPort.builder()
                .cnpj(request.cnpj)
                .nome(request.nome)
                .endereco(request.endereco)
                .localizacao(localizacaoInputPort)
                .build();
    }
}
