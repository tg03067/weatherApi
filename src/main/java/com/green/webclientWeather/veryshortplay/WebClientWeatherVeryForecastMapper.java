package com.green.webclientWeather.veryshortplay;

import com.green.webclientWeather.veryshortplay.model.WeatherVeryForecastEntity;
import com.green.webclientWeather.shorttermforecast.model.WeatherLiveGetReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebClientWeatherVeryForecastMapper {
    int insItem(WeatherLiveGetReq p);
    int insWeatherVeryForecast(List<WeatherVeryForecastEntity> p);
}
