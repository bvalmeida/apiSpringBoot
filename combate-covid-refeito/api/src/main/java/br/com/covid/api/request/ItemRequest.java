package br.com.covid.api.request;

import br.com.covid.core.data.input.ItemInputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    private int quantidade;

    private Integer pontosDoItem;

    private String tipoItem;



}
