package com.green.webclientWeather.shortplay.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherForecastEntity {
    private String baseDate;
    private String baseTime;
    private String category;
    private String fcstDate;
    private String fcstTime;
    private String fcstValue;
    private int nx;
    private int ny;
}
