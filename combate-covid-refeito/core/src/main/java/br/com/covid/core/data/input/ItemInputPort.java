package br.com.covid.core.data.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemInputPort {

    private int quantidade;
    private Integer pontosDoItem;
    private String tipoItem;



}
