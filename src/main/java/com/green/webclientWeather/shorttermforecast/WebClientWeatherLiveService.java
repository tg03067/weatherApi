package com.green.webclientWeather.shorttermforecast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.webclientWeather.shorttermforecast.model.WeatherLiveEntity;
import com.green.webclientWeather.shorttermforecast.model.WeatherLiveGetReq;
import io.netty.channel.ChannelOption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class WebClientWeatherLiveService {
    private final WebClient webClient;
    private final String key;
    private final WebClientWeatherLiveMapper mapper;

    @Autowired
    public WebClientWeatherLiveService(@Value("${properties.key}") String key, WebClientWeatherLiveMapper mapper) {
        this.mapper = mapper;
        HttpClient tcpClient = HttpClient.create().
                option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        ExchangeStrategies es = ExchangeStrategies.builder().
                codecs(config -> config.defaultCodecs().maxInMemorySize(-1)).
                build();
        this.webClient = WebClient.builder().
                exchangeStrategies(es).
                clientConnector(new ReactorClientHttpConnector(tcpClient)).
                defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).
                build();
        this.key = key;
    }

    public List<WeatherLiveEntity> getWeatherLive(WeatherLiveGetReq p) {
        System.out.println(p);
        String json = null;
        String uriString =
                String.format("https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?serviceKey=%s&pageNo=%s&numOfRows=%s&dataType=json&base_date=%s&base_time=%s&nx=%d&ny=%d",
                        this.key, p.getPageNo(), p.getNumOfRows(), p.getBaseDate(), p.getBaseTime(), p.getNx(), p.getNy());
        log.info(uriString);
        try {
            json = webClient.get().
                    uri(new URI(uriString)).
                    retrieve().
                    onStatus(HttpStatusCode::isError, clientResponse -> {
                        log.error("Error status code: {}", clientResponse);
                        return clientResponse.bodyToMono(String.class).
                                flatMap(body -> Mono.error(new RuntimeException()));

                    }).
                    bodyToMono(String.class).
                    block();
            log.info("Response JSON: {}", json);
        } catch ( Exception e){
            e.printStackTrace();
            log.error("Unexpected error 111", e);
        }


        ObjectMapper om = new ObjectMapper().
                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<WeatherLiveEntity> testList = null;

        try{
            JsonNode node = om.readTree(json);
            testList = om.convertValue(node.at("/response/body/items/item"),
                    new TypeReference<List<WeatherLiveEntity>>(){});
        } catch (Exception e){
            log.error("Unexpected error 222", e);
            throw new RuntimeException(e);
        }
        return testList != null ? testList : Collections.emptyList();
    }

    public int insWeatherLive(WeatherLiveGetReq p) {
        List<WeatherLiveEntity> list = getWeatherLive(p);
        int result = 0;
        result = mapper.insWeatherLive(list);
        return result;
    }
}
