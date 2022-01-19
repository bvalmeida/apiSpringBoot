package br.com.covid.request;

import br.com.covid.ports.input.InputPort;
import br.com.covid.ports.input.InputPortLoc;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {

    private String nome;
    private String cnpj;
    private String endereco;
    private RequestLoc requestLoc;

    public InputPort converteInputPort(Request request){
        InputPortLoc inputPortLoc = InputPortLoc.builder()
                .latitude(request.requestLoc.getLatitude())
                .longitude(request.requestLoc.getLongitude())
                .build();

        return InputPort.builder()
                .nome(request.nome)
                .cnpj(request.cnpj)
                .endereco(request.endereco)
                .inputPortLoc(inputPortLoc)
                .build();
    }
}
