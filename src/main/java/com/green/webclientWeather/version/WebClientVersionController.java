package com.green.webclientWeather.version;

import com.green.webclientWeather.common.ResultDto;
import com.green.webclientWeather.version.model.WeatherVersionEntity;
import com.green.webclientWeather.version.model.WeatherVersionGetReq;
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
@RequestMapping("api/openapi/Version")
@Slf4j
@Tag(name = "오퍼레이션 버젼 조회", description = "공공데이터를 이용해서 오퍼레이션들의 버전을 조회가능")
public class WebClientVersionController {
    private final WebClientVersionService service;

    @GetMapping
    @Operation(summary = "버전조회Get", description = "오퍼레이션 정보조회")
    public ResultDto<List<WeatherVersionEntity>> getTest(@ParameterObject @ModelAttribute WeatherVersionGetReq q){
        List<WeatherVersionEntity> list = service.getForecast(q);
        log.info(list.toString());
        return ResultDto.<List<WeatherVersionEntity>>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(list).
                build();
    }

    @PostMapping
    @Operation(summary = "버전조회Post", description = "오퍼레이젼 정보저장")
    public ResultDto<Integer> postTest(@RequestBody WeatherVersionGetReq q){
        int result = service.insTest(q);
        return ResultDto.<Integer>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(result).
                build();
    }
}
