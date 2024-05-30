package com.green.webclientWeather.veryshortplay.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class WeatherVeryForecastGetReq {
    @Schema(defaultValue = "1")
    private int pageNo;
    @Schema(defaultValue = "1000")
    private int numOfRows;
    @Schema(defaultValue = "0600")
    private String baseTime;
    @Schema(defaultValue = "55")
    private int nx;
    @Schema(defaultValue = "127")
    private int ny;
    private int baseDate;
}
