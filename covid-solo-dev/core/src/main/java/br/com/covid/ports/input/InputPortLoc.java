package br.com.covid.ports.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputPortLoc {

    private String longitude;
    private String latitude;
}
