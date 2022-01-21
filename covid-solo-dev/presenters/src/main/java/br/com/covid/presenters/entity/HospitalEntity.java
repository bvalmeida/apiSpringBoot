package br.com.covid.presenters.entity;


import br.com.covid.ports.output.OutputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne
    private HospitalEntityLoc hospitalEntityLoc;


    public static HospitalEntity converteHospitalEntity(OutputPort outputPort){

        HospitalEntityLoc hospitalEntityLoc = HospitalEntityLoc.builder()
                .id(null)
                .latitude(outputPort.getOutputPortLoc().getLatitude())
                .longitude(outputPort.getOutputPortLoc().getLongitude())
                .build();

        return HospitalEntity.builder()
                .id(null)
                .nome(outputPort.getNome())
                .cnpj(outputPort.getCnpj())
                .endereco(outputPort.getEndereco())
                .hospitalEntityLoc(hospitalEntityLoc)
                .build();

    }

}
