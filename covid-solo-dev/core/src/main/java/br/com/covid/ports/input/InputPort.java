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


    public OutputPort converteOutputPort(InputPort inputPort){

        OutputPortLoc outputPortLoc = OutputPortLoc.builder()
                .latitude(inputPort.inputPortLoc.getLatitude())
                .longitude(inputPort.inputPortLoc.getLongitude())
                .build();

        return OutputPort.builder()
                .cnpj(inputPort.cnpj)
                .nome(inputPort.nome)
                .endereco(inputPort.endereco)
                .outputPortLoc(outputPortLoc)
                .build();

    }

}
