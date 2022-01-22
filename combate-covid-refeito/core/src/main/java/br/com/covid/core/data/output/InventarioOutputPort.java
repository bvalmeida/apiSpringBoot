package br.com.covid.core.data.output;

import br.com.covid.core.data.input.ItemInputPort;
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

    private Integer pontosDoInventario = 0;

    private List<ItemOutputPort> itens;
}
