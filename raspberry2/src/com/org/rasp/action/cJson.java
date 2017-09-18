package com.org.rasp.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

public class cJson {
	static HttpServletResponse response;
	static PrintWriter out;

	public void write(String jsonString) throws IOException {

		String returnJSONObject = jsonString;
		// System.out.println(returnJSONObject);
		response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/htm;");
		out = response.getWriter();

		out.print(returnJSONObject);
		out.flush();
		out.close();

	}

	public void write(Object jsonObj) throws IOException {

		String returnJSONObject = JSONArray.fromObject(jsonObj).toString();
		// System.out.println(returnJSONObject);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/htm;");

		PrintWriter out = response.getWriter();

		out.print(returnJSONObject);
		out.flush();
		out.close();
	}
}