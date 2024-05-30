package com.green.webclientWeather.shortplay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class WeatherForecastGetReq {
    @Schema(defaultValue = "1")
    private int pageNo;
    @Schema(defaultValue = "1000")
    private int numOfRows;
    @Schema(defaultValue = "55")
    private int nx;
    @Schema(defaultValue = "127")
    private int ny;
    @Schema(description = "20240530")
    private int baseDate;
}
