package br.com.covid.core.data.input;

import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.data.output.LocalizacaoOutputPort;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalInputPort {

    private String nome;
    private String cnpj;
    private String endereco;
    private LocalizacaoInputPort localizacao;

    public HospitalOutputPort converteHospitalOutputPort(HospitalInputPort inputPort){

        LocalizacaoOutputPort localizacaoOutputPort = LocalizacaoOutputPort.builder()
                .latitude(inputPort.localizacao.getLatitude())
                .longitude(inputPort.localizacao.getLongitude())
                .build();

        return HospitalOutputPort.builder()
                .cnpj(inputPort.cnpj)
                .nome(inputPort.nome)
                .endereco(inputPort.endereco)
                .localizacao(localizacaoOutputPort)
                .build();

    }
}
