package com.green.webclientWeather.shorttermforecast;

import com.green.webclientWeather.shorttermforecast.model.WeatherLiveEntity;
import com.green.webclientWeather.shorttermforecast.model.WeatherLiveGetReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebClientWeatherLiveMapper {
    int insItem(WeatherLiveGetReq p);
    int insWeatherLive(List<WeatherLiveEntity> p);
}
