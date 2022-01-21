package br.com.covid.ports.input;

import br.com.covid.ports.output.OutputPort;
import br.com.covid.ports.output.OutputPortLoc;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputPort {

    private String nome;
    private String cnpj;
    private String endereco;
    private InputPortLoc inputPortLoc;




}
