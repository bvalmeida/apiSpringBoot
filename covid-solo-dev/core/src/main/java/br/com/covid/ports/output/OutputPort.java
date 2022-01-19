package br.com.covid.ports.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutputPort {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private OutputPortLoc outputPortLoc;
}
