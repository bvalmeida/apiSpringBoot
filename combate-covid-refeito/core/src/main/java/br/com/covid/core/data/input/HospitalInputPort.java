package br.com.covid.core.data.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalInputPort {


    private String nome;
    private String cnpj;
    private String endereco;
    private float percentualOcupacao;
    private LocalizacaoInputPort localizacao;
    private InventarioInputPort inventario;



}
