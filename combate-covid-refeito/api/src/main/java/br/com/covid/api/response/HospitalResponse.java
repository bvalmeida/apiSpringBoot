package br.com.covid.api.response;

import br.com.covid.core.data.output.HospitalOutputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private float percentualOcupacao;
    private LocalizacaoResponse localizacao;
    private InventarioResponse inventarioResponse;


    public static HospitalResponse converteHospitalOutputPortToHospitalResponse(HospitalOutputPort hospitalOutputPort){

        LocalizacaoResponse localizacaoResponse = LocalizacaoResponse.builder()
                .id(hospitalOutputPort.getLocalizacao().getId())
                .latitude(hospitalOutputPort.getLocalizacao().getLatitude())
                .longitude(hospitalOutputPort.getLocalizacao().getLongitude())
                .build();

        InventarioResponse inventarioResponse = InventarioResponse.builder()
                .id(hospitalOutputPort.getId())
                .pontosDoInventario(hospitalOutputPort.getInventario().getPontosDoInventario())
                .itemResponse(ItemResponse.itemOutputPortToItemResponse(hospitalOutputPort.getInventario().getItens()))
                .build();

        HospitalResponse hospitalResponse = HospitalResponse.builder()
                .id(hospitalOutputPort.getId())
                .nome(hospitalOutputPort.getNome())
                .cnpj(hospitalOutputPort.getCnpj())
                .endereco(hospitalOutputPort.getEndereco())
                .localizacao(localizacaoResponse)
                .percentualOcupacao(hospitalOutputPort.getPercentualOcupacao())
                .inventarioResponse(inventarioResponse)
                .build();
        return hospitalResponse;


    }

}
