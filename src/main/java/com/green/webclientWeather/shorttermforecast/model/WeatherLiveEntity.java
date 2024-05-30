package com.green.webclientWeather.shorttermforecast.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherLiveEntity {
    private String baseDate;
    private String baseTime;
    private String category;
    private int nx;
    private int ny;
    private String obsrValue;
}
