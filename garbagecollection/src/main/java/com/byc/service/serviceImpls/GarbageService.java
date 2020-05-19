package com.byc.service.serviceImpls;

import com.byc.bean.Garbage;
import com.byc.config.ImageServerConfig;
import com.byc.mapper.GarbageMapper;
import com.byc.service.IGarbageService;
import com.byc.utils.FtpUtil;
import com.github.pagehelper.Page;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class GarbageService implements IGarbageService, Serializable {
    @Autowired
    GarbageMapper garbageMapper;
    @Autowired
    ImageServerConfig imageServerConfig;

    //添加新的垃圾种类
    public boolean insertGarbageName(String gName,String gType,float gPrice,String gDesc,String image) {
        Garbage garbage=new Garbage();
        garbage.setId(UUID.randomUUID().toString());
        garbage.setgName(gName);
        garbage.setgType(gType);
        garbage.setgDesc(gDesc);
        garbage.setgPrice(gPrice);
        garbage.setIsCycle(1);
        garbage.setimage(image);
        int i = garbageMapper.addGarbage(garbage);
        return i > 0 ? true : false;
    }

    //更新垃圾先关信息
    public boolean updateGarbageInformation(String gName, String gType, String gDesc, String gPrice) {
        Garbage garbage = garbageMapper.getGarbageByName(gName);
        if (gName != null)
            garbage.setgName(gName);
        if (gType != null)
            garbage.setgType(gType);
        if (gDesc != null)
            garbage.setgDesc(gDesc);
        if (gPrice != null)
            garbage.setgPrice(Float.parseFloat(gPrice));
        int i = garbageMapper.updateGarbage(garbage);
        return i > 0 ? true : false;
    }

    //根据垃圾名称来删除垃圾信息
    public boolean deleteGarbageByName(String gName) {
        int i = garbageMapper.deleteGarbage(gName);
        return i > 0 ? true : false;
    }

    //根据垃圾的名称获得垃圾相关信息
    public Garbage getGarbageByName(String name) {
        Garbage garbageByName = garbageMapper.getGarbageByName(name);
        return garbageByName;
    }
    //根据垃圾的类型获得相关垃圾的信息
    public Page<Garbage> getGarbageListByType(String gType){
        Page<Garbage> garbageListByType = garbageMapper.getGarbageListByType(gType);
        return garbageListByType;
    }

    //查询所有的垃圾信息
    public List<Garbage> getGarbageList(){
        List<Garbage> garbageList = garbageMapper.getGarbageList();
        return garbageList;
    };

    //查询部分的垃圾信息用于界面展览
    public List<Garbage> getPartGarbageList(){
        List<Garbage> partGarbageList = garbageMapper.getPartGarbageList();
        return partGarbageList;
    }

    //根据垃圾是否可回收来搜索垃圾信息
    public List<Garbage> getGarbageListByisCycle(int isCycle){
        List<Garbage> garbageListByisCycle = garbageMapper.getGarbageListByisCycle(isCycle);
        return garbageListByisCycle;
    }

    //根据id来修改垃圾的名称
    public int updateGarbageNameByIdService(String id,String gName){
        int i = garbageMapper.updateGarbageNameById(id, gName);
        return i;
    }

    //跟据id来修改垃圾的价格
    public int updateGarbageNameByPriceService(String id,float gPrice){
        int i = garbageMapper.updateGarbagePrice(id, gPrice);
        return i;
    }

    //根据id来删除垃圾
    public int deleteGarbageByIdService(String id){
        int i = garbageMapper.deleteGarbageById(id);
        return i;
    }

    // 根据id来修改休息
    public int updateGarbageService(String id,float gPrice,String gType,String gDesc){
        int i = garbageMapper.updateGarbageInfo(id, gPrice,gType, gDesc);
        return i;
    }

    //根据上传的垃圾图片调用百度图像识别api接口返回识别内容

    //通过用户输入的垃圾名称来模糊查询
    public List<Garbage> getGarbageByFuzzyNameList(String name){
        List<Garbage> garbageByFuzzyName = garbageMapper.getGarbageByFuzzyName(name);
        return garbageByFuzzyName;
    }

    //
    public Map uploadPicture(MultipartFile uploadFile,String name) {
        Map resultMap = new HashMap<>();
        try {
            //生成一个新的文件名
            //取原始文件名
            String oldName = uploadFile.getOriginalFilename();
            //生成新文件名
            //UUID.randomUUID();
            String newName = UUID.randomUUID().toString().substring(1,9);
            newName = newName + oldName.substring(oldName.lastIndexOf("."));
            //图片上传
            String imagePath = new DateTime().toString("/yyyy/MM/dd");
//            FtpUtil ftpUtil = new FtpUtil();
            boolean result = FtpUtil.uploadFile(imageServerConfig.getAddress(), imageServerConfig.getPort(), imageServerConfig.getUsername(), imageServerConfig.getPassword(),
                    imageServerConfig.getbasePath(), imagePath, newName, uploadFile.getInputStream());
            //返回结果
            if(!result) {
                resultMap.put("error", 1);
                resultMap.put("message", "文件上传失败");
                return resultMap;
            }
            resultMap.put("error", 0);
            resultMap.put("message", "文件上传成功");
         //上传成功后图片的存储路径,返回给前台显示图片
            resultMap.put("url", imageServerConfig.getImageBaseUrl() + imagePath + "/" + newName);
            String image = imageServerConfig.getImageBaseUrl()+imagePath+"/"+newName;
            int i = garbageMapper.uploadImage(image, name);
            return resultMap;

        } catch (Exception e) {
            resultMap.put("error", 1);
            resultMap.put("message", "文件上传发生异常");
            System.out.println(e);
            return resultMap;
        }

    }
}