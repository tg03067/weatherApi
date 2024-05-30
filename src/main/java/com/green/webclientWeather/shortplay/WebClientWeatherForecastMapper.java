package com.green.webclientWeather.shortplay;

import com.green.webclientWeather.shortplay.model.WeatherForecastEntity;
import com.green.webclientWeather.shorttermforecast.model.WeatherLiveGetReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebClientWeatherForecastMapper {
    int insItem(WeatherLiveGetReq p);
    int insWeatherForecast(List<WeatherForecastEntity> p);
}
