package com.org.rasp.test;
/*
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.NameValuePair;
import org.springframework.http.HttpEntity;

public class music {
	public void postForSearchSong() throws Exception{
	    //����Ĭ�ϵ�httpclientʵ��
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	    //����httpPost
	    HttpPost httpPost = new HttpPost("http://music.163.com/api/search/pc");
	    List<NameValuePair> params = new ArrayList<>();
	    params.add(new BasicNameValuePair("s","ͯ����"));
	    params.add(new BasicNameValuePair("offset","1"));
	    params.add(new BasicNameValuePair("limit", "1"));
	    params.add(new BasicNameValuePair("type", "1"));
	    httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	    CloseableHttpResponse response = httpClient.execute(httpPost);
	    try {
	        HttpEntity entity = response.getEntity();
	        if (entity != null) {
	            System.out.println("Response Size: "+EntityUtils.toString(entity,"UTF-8"));
	        }
	    }finally {
	        response.close();
	    }
	    httpClient.close();
	     
	}
}*/
