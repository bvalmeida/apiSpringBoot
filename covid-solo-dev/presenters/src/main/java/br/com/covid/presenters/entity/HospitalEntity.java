package br.com.covid.presenters.entity;


import br.com.covid.ports.output.OutputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HospitalEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpj;

    private String endereco;

    @OneToOne
    @JoinColumn(name = "hospital_entity_loc_id")
    private HospitalEntityLoc hospitalEntityLoc;


    public HospitalEntity converteHospitalEntity(OutputPort outputPort){

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
