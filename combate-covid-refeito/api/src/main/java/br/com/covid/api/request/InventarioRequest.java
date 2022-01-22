package br.com.covid.api.request;

import br.com.covid.core.data.input.InventarioInputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventarioRequest {

    private Integer pontosDoInventario = 0;
    private List<ItemRequest> itens;

    public static InventarioInputPort converterInventarioRequestToInventarioInputPort(InventarioRequest inventarioRequest){
        return InventarioInputPort.builder()
                .pontosDoInventario(inventarioRequest.getPontosDoInventario())
                .itens(ItemRequest.itemRequestToItemInputPort(inventarioRequest.getItens()))
                .build();
    }
}
