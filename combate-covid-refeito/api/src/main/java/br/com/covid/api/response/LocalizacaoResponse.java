package br.com.covid.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalizacaoResponse {

    private Long id;
    private String latitude;
    private String longitude;

}
