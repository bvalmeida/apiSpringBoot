package br.com.covid.ports.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutputPortLoc {

    private Long id;
    private String longitude;
    private String latitude;
}
