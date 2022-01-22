package br.com.covid.api.request;

import br.com.covid.core.data.input.ItemInputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    private int quantidade;
    private Integer pontosDoItem;
    private String tipoItem;

    public static List<ItemInputPort> itemRequestToItemInputPort(List<ItemRequest> itemRequest){
        List<ItemInputPort> listaDeItemParaInputPort = new ArrayList<>();
        itemRequest.forEach(item -> {
            var itemInputPort = ItemInputPort.builder()
                    .pontosDoItem(item.getPontosDoItem())
                    .tipoItem(item.getTipoItem())
                    .quantidade(item.getQuantidade())
                    .build();
            listaDeItemParaInputPort.add(itemInputPort);
        });
        return listaDeItemParaInputPort;
    }


}
