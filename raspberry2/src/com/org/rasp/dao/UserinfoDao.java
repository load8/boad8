package com.org.rasp.dao;

import java.util.Map;

import com.org.rasp.model.Userinfo;

public interface UserinfoDao {  
	  
    public int insertUserinfo(Userinfo userinfo);  
//    public List<Userinfo> selectPage(PageModel<Userinfo> page);  
    public long userCount(Map<String,String> pageMap);  
    public void deleteById(String id);  
    public Userinfo queryById(String id);  
    public int updateById(Userinfo userinfo);  
    public int updateBySelective(Userinfo userinfo);  
      
} 