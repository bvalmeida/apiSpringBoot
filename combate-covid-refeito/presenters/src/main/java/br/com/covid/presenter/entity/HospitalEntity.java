package br.com.covid.presenter.entity;

import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.data.output.LocalizacaoOutputPort;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String cnpj;

    @Column
    private String endereco;

    @Column
    private float percentualOcupacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "localizacao_ID")
    private LocalizacaoEntity localizacao;




    public float atualizaPercentualDeOcupacao(Float percentual){
        return this.percentualOcupacao = percentual;
    }


    public static HospitalEntity converterOutputPortToEntity(HospitalOutputPort hospitalOutputPort){
        LocalizacaoEntity localizacaoEntity = LocalizacaoEntity.builder()
                .id(null)
                .latitude(hospitalOutputPort.getLocalizacao().getLatitude())
                .longitude(hospitalOutputPort.getLocalizacao().getLongitude())
                .build();

        return HospitalEntity.builder()
                .id(null)
                .cnpj(hospitalOutputPort.getCnpj())
                .endereco(hospitalOutputPort.getEndereco())
                .nome(hospitalOutputPort.getNome())
                .localizacao(localizacaoEntity)
                .percentualOcupacao(hospitalOutputPort.getPercentualOcupacao())
                .build();

    }
    public static HospitalOutputPort converterHospitalOutputPort(HospitalEntity hospitalEntity){
        LocalizacaoOutputPort localizacaoOutputPort = LocalizacaoOutputPort.builder()
                .id(hospitalEntity.id)
                .latitude(hospitalEntity.getLocalizacao().getLatitude())
                .longitude(hospitalEntity.getLocalizacao().getLongitude())
                .build();

        return HospitalOutputPort.builder()
                .id(hospitalEntity.id)
                .nome(hospitalEntity.getNome())
                .cnpj(hospitalEntity.getCnpj())
                .endereco(hospitalEntity.getEndereco())
                .localizacao(localizacaoOutputPort)
                .percentualOcupacao(hospitalEntity.percentualOcupacao)
                .build();

    }




}
