package com.company.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xxf
 * @version
 * @date Feb 23, 2010 11:23:50 AM
 * 
 */
public class GetIp {
	/**
	 * 获取ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getip(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip == null || ip.length() == 0) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public String getCity(String ip) {
		String basePath = "http://open.baidu.com/ipsearch/s";
		String city = "";
		int beginnum=0;
		int endnum=0;
		if (ip != null) {
			String temp = this.getWebSource(basePath,"?wd="+ip+"&tn=baiduip");//?wd=202.112.176.11&tn=baiduip
			if(temp.indexOf("省")>=0)
			{
				beginnum=temp.indexOf("省")+1;
			}else
			{
				beginnum=temp.indexOf("来自：")+3;
			}
			if(temp.indexOf("市")>=0)
			{
				endnum=temp.indexOf("市");
			}
			if(beginnum<endnum)
			{
			city = temp.substring(beginnum,endnum);
			}
		}
		return city;
	}

	public String getWebSource(String basePath, String childPath) {
		StringBuffer sb = new StringBuffer("");
		try {
			URL url = new URL(basePath + childPath);
			System.out.println(url);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			// con.setFollowRedirects(true);
			con.setInstanceFollowRedirects(false);
			con.setConnectTimeout(20000);
			con.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader(con
					.getInputStream()));
			String s = "";
			while ((s = br.readLine()) != null) {
				sb.append(s + "\r\n");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
