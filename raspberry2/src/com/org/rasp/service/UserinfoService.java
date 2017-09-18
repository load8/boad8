package com.org.rasp.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.rasp.dao.UserinfoDao;
import com.org.rasp.model.Userinfo;

@Service 
public class UserinfoService {  
  	  
    @Resource  
    private UserinfoDao userinfodao;  
    
    public UserinfoDao getUserinfodao() {  
        return userinfodao;  
    }  
  
    public void setUserinfodao(UserinfoDao userinfodao) {  
        this.userinfodao = userinfodao;  
    }  
    
    public int insertUserinfo(Userinfo user) {  
    	return	 this.userinfodao.insertUserinfo(user);
  
    }  
  
    public long userCount(Map<String, String> pageMap) {  
        return  this.userinfodao.userCount(pageMap);  
    };  
  
/*    public List<Userinfo> selectPage(PageModel<Userinfo> page) {  
  
        return this.alldao.getUserinfodao().selectPage(page);  
    }  */
  
    public void deleteById(String id) {   
         this.userinfodao.deleteById(id);  
    }  
    public Userinfo queryById(String id){  
        return this.userinfodao.queryById(id);  
    };  
    public int updateById(Userinfo userinfo){  
        return this.userinfodao.updateById(userinfo);  
    };  
    public int updateBySelective(Userinfo userinfo){  
        return this.userinfodao.updateBySelective(userinfo);  
    };  
}  


