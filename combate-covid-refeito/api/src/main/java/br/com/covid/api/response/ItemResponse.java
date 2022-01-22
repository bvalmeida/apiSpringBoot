package br.com.covid.api.response;

import br.com.covid.core.data.output.ItemOutputPort;
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
public class ItemResponse {

    private long id;
    private Integer pontosDoItem;
    private String tipoDoItem;

    public static List<ItemResponse> itemOutputPortToItemResponse(List<ItemOutputPort> itemOutputPort){

        List<ItemResponse> itemResponse = new ArrayList<>();
        itemOutputPort.forEach(item ->{
            ItemResponse itens = ItemResponse.builder()
                    .id(item.getId())
                    .tipoDoItem(item.getTipoItem())
                    .pontosDoItem(item.getPontosDoItem())
                    .build();
            itemResponse.add(itens);
        });
        return itemResponse;
    }
}
