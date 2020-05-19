package com.byc.mapper;

import com.byc.bean.CommodityList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommodityListMapper {
    //生成商品列表
    int insertCommodity(String id,String commodity,float amount,String orderItemListId,float gPrice);
    //跟据orderItemListId来获取该订单相关的信息
    List<CommodityList> selectOrderListInfo(String orderItemListId);
}
