package br.com.covid.request;

import br.com.covid.ports.input.InputPort;
import br.com.covid.ports.input.InputPortLoc;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    private String nome;
    private String cnpj;
    private String endereco;
    private RequestLoc localizacao;

    public InputPort converteInputPort(Request request){
        InputPortLoc inputPortLoc = InputPortLoc.builder()
                .latitude(request.localizacao.getLatitude())
                .longitude(request.localizacao.getLongitude())
                .build();

        return InputPort.builder()
                .nome(request.nome)
                .cnpj(request.cnpj)
                .endereco(request.endereco)
                .inputPortLoc(inputPortLoc)
                .build();
    }
}
