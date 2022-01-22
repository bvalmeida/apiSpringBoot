package br.com.covid.core.data.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventarioInputPort {

    private Integer pontosDoInventario = 0;
    private List<ItemInputPort> itens;



}
