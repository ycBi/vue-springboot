package com.byc.service;

import com.byc.bean.Garbage;
import com.github.pagehelper.Page;

import java.util.List;

public interface IGarbageService {
    public boolean insertGarbageName(String gName,String gType,float gPrice,String gDesc,String image);
    public boolean updateGarbageInformation(String gName, String gType, String gDesc, String gPrice);

    public boolean deleteGarbageByName(String gName);
    public Garbage getGarbageByName(String name);
    public Page<Garbage> getGarbageListByType(String gType);
    public List<Garbage> getGarbageList();
    public List<Garbage> getGarbageListByisCycle(int isCycle);
}
