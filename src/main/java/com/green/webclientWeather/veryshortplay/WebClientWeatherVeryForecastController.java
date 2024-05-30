package com.green.webclientWeather.veryshortplay;

import com.green.webclientWeather.common.ResultDto;
import com.green.webclientWeather.veryshortplay.model.WeatherVeryForecastEntity;
import com.green.webclientWeather.veryshortplay.model.WeatherVeryForecastGetReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/openapi/VeryShortTermForecast")
@Slf4j
@Tag(name = "초단기예보조회", description = "공공데이터를 이용해서 초단기예보를 조회할 수 있다.")
public class WebClientWeatherVeryForecastController {
    private final WebClientWeatherVeryForecastService service;

    @GetMapping
    @Operation(summary = "초단기예보조회Get", description = "좌표지점에 대한 예보정보조회기능")
    public ResultDto<List<WeatherVeryForecastEntity>> getTest(@ParameterObject @ModelAttribute WeatherVeryForecastGetReq q){
        List<WeatherVeryForecastEntity> list = service.getForecast(q);
        log.info(list.toString());
        return ResultDto.<List<WeatherVeryForecastEntity>>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(list).
                build();
    }

    @PostMapping
    @Operation(summary = "초단기예보조회Post", description = "좌표지점에 대한 예보정보조회기능")
    public ResultDto<Integer> postTest(@RequestBody WeatherVeryForecastGetReq q){
        int result = service.insTest(q);
        return ResultDto.<Integer>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(result).
                build();
    }
}
