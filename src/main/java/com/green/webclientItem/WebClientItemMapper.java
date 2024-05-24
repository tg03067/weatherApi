package com.green.webclientItem;

import com.green.webclientItem.model.itemEntity;
import com.green.webclientItem.model.itemGetReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WebClientItemMapper {
    int insItem(itemGetReq p);
    int insItemEntity(List<itemEntity> p);
}
