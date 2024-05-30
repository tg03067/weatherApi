package com.green.webclientWeather.shortplay;

import com.green.webclientWeather.common.ResultDto;
import com.green.webclientWeather.shortplay.model.WeatherForecastEntity;
import com.green.webclientWeather.shortplay.model.WeatherForecastGetReq;
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
@RequestMapping("api/openapi/ShortTermForecast")
@Slf4j
@Tag(name = "단기예보조회", description = "공공데이터를 이용해서 단기예보를 조회할 수 있다.")
public class WebClientWeatherForecastController {
    private final WebClientWeatherForecastService service;

    @GetMapping
    @Operation(summary = "단기예보조회Get", description = "좌표지점에 대한 예보정보조회기능")
    public ResultDto<List<WeatherForecastEntity>> getTest(@ParameterObject @ModelAttribute WeatherForecastGetReq q){
        List<WeatherForecastEntity> list = service.getForecast(q);
        log.info(list.toString());
        return ResultDto.<List<WeatherForecastEntity>>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(list).
                build();
    }

    @PostMapping
    @Operation(summary = "단기예보조회Post", description = "좌표지점에 대한 예보정보저장기능")
    public ResultDto<Integer> postTest(@RequestBody WeatherForecastGetReq q){
        int result = service.insTest(q);
        return ResultDto.<Integer>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(result).
                build();
    }
}
