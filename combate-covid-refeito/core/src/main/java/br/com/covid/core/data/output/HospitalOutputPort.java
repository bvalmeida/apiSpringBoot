package br.com.covid.core.data.output;

import br.com.covid.core.data.input.HospitalInputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalOutputPort {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private float percentualOcupacao;
    private LocalizacaoOutputPort localizacao;
    private InventarioOutputPort inventario;


    public static HospitalOutputPort converterInputToOutput(HospitalInputPort hospitalInputPort) {
        LocalizacaoOutputPort localizacaoOutputPort = LocalizacaoOutputPort.builder()
                .latitude(hospitalInputPort.getLocalizacao().getLatitude())
                .longitude(hospitalInputPort.getLocalizacao().getLongitude())
                .build();
        return HospitalOutputPort.builder()
                .cnpj(hospitalInputPort.getCnpj())
                .endereco(hospitalInputPort.getEndereco())
                .nome(hospitalInputPort.getNome())
                .localizacao(localizacaoOutputPort)
                .percentualOcupacao(hospitalInputPort.getPercentualOcupacao())
                .build();
    }
}
