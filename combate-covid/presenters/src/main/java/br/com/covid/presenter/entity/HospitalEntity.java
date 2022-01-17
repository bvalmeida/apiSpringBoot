package br.com.covid.presenter.entity;

import br.com.covid.core.data.output.HospitalOutputPort;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpj;

    private String endereco;

    @OneToOne
    @JoinColumn(name = "localizacao_10")
    private LocalizacaoEntity localizacao;

    public static HospitalEntity converteHospitalEntity(HospitalOutputPort outputPort){

        LocalizacaoEntity localizacao = LocalizacaoEntity.builder()
                .id(null)
                .latitude(outputPort.getLocalizacao().getLatitude())
                .longetude(outputPort.getLocalizacao().getLongitude())
                .build();

        return HospitalEntity.builder()
                .id(null)
                .nome(outputPort.getNome())
                .cnpj(outputPort.getCnpj())
                .endereco(outputPort.getEndereco())
                .localizacao(localizacao)
                .build();

    }
}
