package com.org.rasp.action;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.org.rasp.model.Userinfo;
import com.org.rasp.service.UserinfoService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/** 
 * 操作增删改查 
 * @author Administrator 
 * 
 */ 
@SuppressWarnings("serial")
@Controller
/*@Transactional */
public class Insert extends  ActionSupport {  
  

    @Resource
    private UserinfoService userinfoService;    
    public UserinfoService getUserinfoService() {
		return userinfoService;
	}
	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	private String jsonString;  
    public String getJsonString() {  
        return jsonString;  
    }  
  
    public void setJsonString(String jsonString) {  
        this.jsonString = jsonString;  
    }  
    
    cJson cjson = new cJson(); 
    // 分页model  
//    public PageModel<Userinfo> page;  
  

    public String insert() { 
    	  System.out.println("---insert!!!");
    	  System.out.println(jsonString);
        try {  
//            new JSONObject();
//			JSONObject object = JSONObject.fromObject(jsonString); 
       
            int id = 101; 
            System.out.println(id);
            String name = "123";/*object.getString("userName");*/  
            String email ="123"; /*object.getString("email");  */
            String sex = "男";/*object.getString("sex");*/  
            int age = 12;/*object.getInt("age"); */ 
            String creat = "";/*object.getString("creatDate"); */ 
            String modify =""; /*object.getString("modifyDate");  */
            
            Date creatDate = null; 
            Date modifyDate= null;
             if (creat != null && !creat.equals("")) {  
            	 creatDate = new SimpleDateFormat("yyyy-MM-dd").parse(creat);  
  
            } 
             if (modify != null && !modify.equals("")) {  
            	 modifyDate = new SimpleDateFormat("yyyy-MM-dd").parse(modify);  
  
            } 
    System.out.println("insert!!!");
            Userinfo user = new Userinfo(id, name, email, sex, age,  
            		new Date(), new Date());  
            System.out.println("insert1!!!");
            int ses = this.userinfoService.insertUserinfo(user);  
            System.out.println("insert2!!!");
            if (ses == 1) {  
            	 System.out.println("insert3!!!");
                cjson.write("true");  
            }  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return "ERROR";  
    }  
  
    public String selectById() {  
  
        return null;  
    }  
  
/*    public String selectPage() {  
        try {  
            JSONObject object = JSONObject.fromObject(jsonString);  
            int gotoPage = object.getInt("gotoPage");  
            int pageNum = object.getInt("pageNum");  
            Map<String, String> pageMap = new HashMap<String, String>();  
            pageMap.put("sex", "男");  
            int userCount = (int) this.getAllservice().getUserinfoservice()  
                    .userCount(pageMap);  
  
            page = new PageModel<Userinfo>(userCount, pageNum, pageMap);  
            page.setGotoPage(gotoPage);  
  
            List<Userinfo> userinfoList = this.getAllservice()  
                    .getUserinfoservice().selectPage(page);  
            page.setList(userinfoList);  
            cjson.write(page);  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return null;  
    }  */
  
    /** 
     * 根据id删除 
     *  
     * @return 
     */  
    public String deleteById() {  
  
        try {  
            this.userinfoService.deleteById(jsonString);  
            cjson.write("true");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
  
    /** 
     * 根据id查询 
     *  
     * @return 
     */  
    public String queryById() {  
    	System.out.println("hah");
        try {  
            Userinfo userinfo = this.userinfoService.queryById(jsonString);  
            cjson.write(userinfo);  
        } catch (IOException e) {  
            e.printStackTrace();  
            return "error";
        }  
        return "success";  
    }  
  
    public String update() {  
        try {  
            JSONObject object = JSONObject.fromObject(jsonString);  
            
            int id = object.getInt("userId");  
            String name = object.getString("userName");  
            String email = object.getString("email");  
            String sex = object.getString("sex");  
            int age = object.getInt("age");  
            String creat = object.getString("creatDate");  
            String modify = object.getString("modifyDate");  
            
            Date creatDate = null; 
            Date modifyDate= null;
             if (creat != null && !creat.equals("")) {  
            	 creatDate = new SimpleDateFormat("yyyy-MM-dd").parse(creat);  
  
            } 
             if (modify != null && !modify.equals("")) {  
            	 modifyDate = new SimpleDateFormat("yyyy-MM-dd").parse(modify);  
  
            } 
    
            Userinfo userinfo = new Userinfo(id, name, email, sex, age,  
            		creatDate, modifyDate);  
            this.userinfoService.updateBySelective(userinfo);  
            cjson.write("true");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return null;  
    }  
}