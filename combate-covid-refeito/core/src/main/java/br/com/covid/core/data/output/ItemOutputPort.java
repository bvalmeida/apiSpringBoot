package br.com.covid.core.data.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemOutputPort {

    private int quantidade;

    private Integer pontosDoItem;

    private String tipoItem;
}
