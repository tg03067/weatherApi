package com.green.webclientItem;

import com.green.webclientItem.common.ResultDto;
import com.green.webclientItem.model.itemGetReq;
import com.green.webclientItem.model.itemEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/openapi")
@Slf4j
public class WebClientItemController {
    private final WebClientService service;

    @GetMapping
    public ResultDto<List<itemEntity>> getFsv(@ParameterObject @ModelAttribute itemGetReq q){
        List<itemEntity> list = service.getFsv(q);
        log.info(list.toString());
        return ResultDto.<List<itemEntity>>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(list).
                build();
    }

    @PostMapping
    public ResultDto<Integer> postFsv(@RequestBody itemGetReq q){
        int result = service.insFsv(q);
        return ResultDto.<Integer>builder().
                status(HttpStatus.OK).
                message(HttpStatus.OK.toString()).
                data(result).
                build();
    }
}
