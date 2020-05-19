package com.byc.controller;

import com.byc.bean.Garbage;
import com.byc.mapper.GarbageMapper;
import com.byc.service.serviceImpls.GarbageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@Api(tags = "垃圾管理相关接口")
@RequestMapping("/garbage")
public class GarbageController {
    @Autowired
    GarbageService garbageService;

    @ApiOperation("添加新的垃圾种类信息")
    @PostMapping("/addNewGarbage")
    //添加新的垃圾种类信息
    public boolean addGarbageInformation(String gName,String gType,float gPrice,String gDesc,String image){
        boolean b = garbageService.insertGarbageName(gName,gType,gPrice,gDesc,image);
        return b;
    }
    @ApiOperation("根据垃圾名称来更新信息")
    @PutMapping("/update/{gName}")
    public boolean updateGarbageInformation(@PathVariable("gName") String gName, String gType, String gDesc, String gPrice){
        boolean b = garbageService.updateGarbageInformation(gName, gType, gDesc, gPrice);
        return b;
    }


    @ApiOperation("根据垃圾名称来删除该条垃圾信息")
    @DeleteMapping("/delete")
    public boolean deleteGarbageByName(@RequestParam("gName") String gName){
        boolean b = garbageService.deleteGarbageByName(gName);
        return b;
    }

    @ApiOperation("根据垃圾的id来删除垃圾")
    @DeleteMapping("/deleteById")
    public int deleteGarbageById(@RequestParam("id") String id){
        int i = garbageService.deleteGarbageByIdService(id);
        return i;
    }
    @ApiOperation("通过垃圾名称来查找垃圾信息")
    @GetMapping("/getName")
    public Garbage getGarbageByName(@RequestParam("name") String name){
        Garbage garbageByName = garbageService.getGarbageByName(name);
        return garbageByName;
    }

    @ApiOperation("通过垃圾类型来查找垃圾")
    @GetMapping("/getInfo")
    public PageInfo<Garbage> getGarbageListByType(@RequestParam("type") String gType, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        PageHelper.startPage(page,size);
        PageInfo<Garbage> garbagePageInfo = new PageInfo<>(garbageService.getGarbageListByType(gType));
        return garbagePageInfo;
    }

    @ApiOperation("查找所有的垃圾信息")
    @GetMapping("/get")
    public List<Garbage> getGarbageList(){
        List<Garbage> garbageList = garbageService.getGarbageList();
        return garbageList;
    }
    @ApiOperation("查询部分垃圾信息用于展示")
    @GetMapping("/getPartGarbageInfo")
     public List<Garbage> getPartList(){
       List<Garbage> partGarbageList = garbageService.getPartGarbageList();
       return partGarbageList;
   }

    @ApiOperation("根据是否可回收来查找垃圾")
    @GetMapping("/getGarbageList/{isCycle}")
    public List<Garbage> getGarbageListByisCycle(@PathVariable("isCycle") int isCycle){
        List<Garbage> garbageListByisCycle = garbageService.getGarbageListByisCycle(isCycle);
        return garbageListByisCycle;
    }

    @ApiOperation("根据id来修改垃圾的名称")
    @PutMapping("/updateGarbageName")
    public int updateGarbageNameById(@RequestParam("id") String id,@RequestParam("gName") String gName){
        int i = garbageService.updateGarbageNameByIdService(id, gName);
        return i;
    }

    @ApiOperation("根据id来修改垃圾的回收价格")
    @PutMapping("/updateGarbagePrice")
    public int updateGarbagePriceById(@RequestParam("id") String id,@RequestParam("gPrice") float gPrice){
        int i = garbageService.updateGarbageNameByPriceService(id,gPrice);
        return i;
    }

    @ApiOperation("根据id来修改垃圾的信息")
    @PutMapping("/updateGarbageInfo")
    public int updateGarbage(@RequestParam("id") String id,@RequestParam("gPrice") float gPrice,@RequestParam("gType") String gType,@RequestParam("gDesc") String gDesc){
        int i = garbageService.updateGarbageService(id, gPrice, gType, gDesc);
        return i;
    }

    @ApiOperation("根据名字模糊擦查询垃圾信息")
    @GetMapping("/getGarbageInfoByFuzzyName")
    public List<Garbage>  getGarbageByFuzzyName(@RequestParam("name") String name){
        List<Garbage> garbageByFuzzyNameList = garbageService.getGarbageByFuzzyNameList(name);
        return  garbageByFuzzyNameList;
    }

    @ApiOperation("上传垃圾图片信息")
    @PostMapping("/uploadImage")
    public Map uploadGarbageImage(@RequestParam("file") MultipartFile file,@RequestParam("gName") String gName){
        Map map = garbageService.uploadPicture(file,gName);
        System.out.println(gName);
        return  map;
    }
}
