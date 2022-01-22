package br.com.covid.core.data.output;

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
public class ItemOutputPort {

    private Long id;
    private int quantidade;
    private Integer pontosDoItem;
    private String tipoItem;

    public static List<ItemOutputPort> itemInputPortToItemOutputPort(List<ItemInputPort> itemInputPort){

        List<ItemOutputPort> listaDeItemParaOutputPort = new ArrayList<>();
        itemInputPort.forEach(item -> {
            var itemOutputPort = ItemOutputPort.builder()
                    .pontosDoItem(item.getPontosDoItem())
                    .tipoItem(item.getTipoItem())
                    .quantidade(item.getQuantidade())
                    .build();
            listaDeItemParaOutputPort.add(itemOutputPort);
        });
        return listaDeItemParaOutputPort;
    }
}
