package com.byc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GcSystemRouterMapper {
    // 根据id获得权限
    String getRouterByPermission(int gcPermission);
}
