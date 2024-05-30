package com.green.webclientWeather.version;

import com.green.webclientWeather.shorttermforecast.model.WeatherLiveGetReq;
import com.green.webclientWeather.version.model.WeatherVersionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebClientVersionMapper {
    int insItem(WeatherLiveGetReq p);
    int insWeatherForecast(List<WeatherVersionEntity> p);
}
