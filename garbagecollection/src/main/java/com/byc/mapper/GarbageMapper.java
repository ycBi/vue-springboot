package com.byc.mapper;

import com.byc.bean.Garbage;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GarbageMapper {
    //添加新的垃圾
    int addGarbage(Garbage garbage);
    //修改垃圾的信息
    int updateGarbage(Garbage garbage);
    //删除垃圾的信息
    int deleteGarbage(String gname);
    //查询垃圾的信息通过垃圾种类名称(精确查询)
    Garbage getGarbageByName(String gName);
    //通过垃圾的名称来模糊查询相关信息
    List<Garbage> getGarbageByFuzzyName(String gName);
    //通过垃圾类型查找相关垃圾种类
    Page<Garbage> getGarbageListByType(String gType);
    //查询所有的垃圾信息
    List<Garbage> getGarbageList();
    //根据垃圾可回收不可回收来查询相关垃圾种类
    List<Garbage> getGarbageListByisCycle(int isCycle);
    //获取部分垃圾信息用于展示
    List<Garbage> getPartGarbageList();
    //根据id来修改垃圾的名称
    int updateGarbageNameById(String id,String gName);
    //根据id来修改垃圾的价格
    int updateGarbagePrice(String id, float gPrice);
    //根据垃圾的id来修该垃圾
    int deleteGarbageById(String id);
    // 根据垃圾的id来修改用户的信息
    int updateGarbageInfo(String id,float gPrice,String gType,String gDesc);
    //根据垃圾名称来上传图片
    int uploadImage(String image,String gName);
}
