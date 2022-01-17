package br.com.covid.core.data.output;

import br.com.covid.core.data.input.HospitalInputPort;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalOutputPort {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private LocalizacaoOutputPort localizacao;

}
