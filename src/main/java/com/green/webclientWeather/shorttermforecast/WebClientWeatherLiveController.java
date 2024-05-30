package com.green.webclientWeather.shorttermforecast;

import com.green.webclientWeather.common.ResultDto;
import com.green.webclientWeather.shorttermforecast.model.WeatherLiveEntity;
import com.green.webclientWeather.shorttermforecast.model.WeatherLiveGetReq;
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
@RequestMapping("api/openapi/LiveView")
@Slf4j
@Tag(name = "초단기실황조회", description = "공공데이터를 이용해서 초단기실황정보를 조회할 수 있다.")
public class WebClientWeatherLiveController {
    private final WebClientWeatherLiveService service;

    @GetMapping
    @Operation(summary = "초단기실황조회Get", description = "좌표지점에 대한 실황정보조회기능")
    public ResultDto<List<WeatherLiveEntity>> getTest(@ParameterObject @ModelAttribute WeatherLiveGetReq q){
        List<WeatherLiveEntity> list = service.getWeatherLive(q);
        log.info(list.toString());
        return ResultDto.<List<WeatherLiveEntity>>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(list).
                build();
    }

    @PostMapping
    @Operation(summary = "초단기실황조회Post", description = "좌표지점에 대한 실황정보저장기능")
    public ResultDto<Integer> postTest(@RequestBody WeatherLiveGetReq q){
        int result = service.insWeatherLive(q);
        return ResultDto.<Integer>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(result).
                build();
    }
}
