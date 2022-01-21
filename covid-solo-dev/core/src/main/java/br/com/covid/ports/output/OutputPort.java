package br.com.covid.ports.output;

import br.com.covid.ports.input.InputPort;
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

    public static OutputPort converteOutputPort(InputPort inputPort){

        OutputPortLoc outputPortLoc = OutputPortLoc.builder()
                .latitude(inputPort.getInputPortLoc().getLatitude())
                .longitude(inputPort.getInputPortLoc().getLongitude())
                .build();

        return OutputPort.builder()
                .cnpj(inputPort.getCnpj())
                .nome(inputPort.getNome())
                .endereco(inputPort.getEndereco())
                .outputPortLoc(outputPortLoc)
                .build();

    }
}
