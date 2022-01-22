package br.com.covid.core.data.output;

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
public class InventarioOutputPort {

    private Long id;
    private Integer pontosDoInventario = 0;
    private List<ItemOutputPort> itens;

    public static InventarioOutputPort converterInventarioInputPortToInventarioOutputPort(InventarioInputPort inventarioInputPort){

        return InventarioOutputPort.builder()
                .pontosDoInventario(inventarioInputPort.getPontosDoInventario())
                .itens(ItemOutputPort.itemInputPortToItemOutputPort(inventarioInputPort.getItens()))
                .build();
    }
}
