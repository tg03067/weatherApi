package com.green.webclientWeather.shorttermforecast.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class WeatherLiveGetReq {
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
    @Schema(description = "20240530")
    private int baseDate;
}
