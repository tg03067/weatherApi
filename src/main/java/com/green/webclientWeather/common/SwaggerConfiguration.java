package com.green.webclientWeather.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "기상정보 조회"
                , description = "Weather Info"
                , version = "v1"
        )
)
public class SwaggerConfiguration {

}
