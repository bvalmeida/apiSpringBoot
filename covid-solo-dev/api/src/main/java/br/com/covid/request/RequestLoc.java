package br.com.covid.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestLoc {

    private String longitude;
    private String latitude;
}
