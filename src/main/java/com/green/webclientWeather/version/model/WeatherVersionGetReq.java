package com.green.webclientWeather.version.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class WeatherVersionGetReq {
    @Schema(defaultValue = "1")
    private int pageNo;
    @Schema(defaultValue = "10")
    private int numOfRows;
    @Schema(defaultValue = "ODAM",
            description = "ODAM(동네예보실황), VSRT(동네예보초단기), SHRT(동네예보단기)")
    private String ftype;
    @Schema(description = "202405300800")
    private String baseDate;
}
