package br.com.covid.api.request;

import br.com.covid.core.data.input.HospitalInputPort;
import br.com.covid.core.data.input.InventarioInputPort;
import br.com.covid.core.data.input.LocalizacaoInputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalRequest {

    private String nome;
    private String cnpj;
    private String endereco;
    private float percentualOcupacao;
    private LocalizacaoRequest localizacao;
    private InventarioRequest inventario;


    public static HospitalInputPort converterRequestToInputPort(HospitalRequest request){

        LocalizacaoInputPort localizacaoInputPort = LocalizacaoInputPort.builder()
                .latitude(request.localizacao.getLatitude())
                .longitude(request.localizacao.getLongitude())
                .build();

        InventarioInputPort inventarioInputPort = InventarioInputPort.builder()
                .pontosDoInventario(request.inventario.getPontosDoInventario())
                .itens(ItemRequest.itemRequestToItemInputPort(request.getInventario().getItens()))
                .build();

        return HospitalInputPort.builder()
                .cnpj(request.cnpj)
                .endereco(request.endereco)
                .nome(request.nome)
                .localizacao(localizacaoInputPort)
                .percentualOcupacao(request.getPercentualOcupacao())
                .inventario(inventarioInputPort)
                .build();
    }







}
