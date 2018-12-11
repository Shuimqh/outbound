package com.company.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;



import com.company.bean.CjlBean;
import com.company.common.Pager;
import com.company.common.PagerService;
import com.company.data.ho.CallItem;
import com.company.data.ho.Calllog;
import com.company.data.ho.GroupInfo;
import com.company.data.ho.Gz;
import com.company.data.ho.NotePad;
import com.company.data.ho.UserInfo;

import com.company.service.iface.IBackService;
import com.company.util.CommonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class BackAction extends ActionSupport{
	private IBackService backService;
	private NotePad np=new NotePad();
	private CallItem call=new CallItem();
	private UserInfo u=new UserInfo();
	private GroupInfo gi=new GroupInfo();
	/**
	 * 模锟斤拷锟斤拷锟斤拷pp
	 */
	private String type;
	/**
	 * 锟斤拷页锟斤拷service
	 */
	private PagerService pagerService;

	/**
	 * 锟斤拷目锟斤拷息
	 */
//	private Project project;

	/**
	 * 锟斤拷页锟斤拷息
	 */
	private Pager pager;

	/**
	 * 锟斤拷前页锟斤拷
	 */
	protected String currentPage;

	/**
	 * 锟斤拷页锟斤拷锟斤拷锟斤拷
	 */
	protected String pagerMethod;

	/**
	 * 锟斤拷锟斤拷锟斤拷
	 */
	protected String totalRows;
	String id=null;
	String p1=null;
	String p2=null;
	String p3=null;
	String p4=null;
	String p5=null;
	String topname=null;
	String day=null;
	List list1=null;
	List list2=null;
	List list3=null;
	List list4=null;
	
	List list5=null;
	List list6=null;
	List list7=null;
	
	List list8=null;
	List list9=null;
	List list0=null;
	List list10=null;
	List list11=null;
	
	Gz g=new Gz();
	public List getList1() {
		return list1;
	}
	public void setList1(List list1) {
		this.list1 = list1;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public PagerService getPagerService() {
		return pagerService;
	}
	public void setPagerService(PagerService pagerService) {
		this.pagerService = pagerService;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public String getPagerMethod() {
		return pagerMethod;
	}
	public void setPagerMethod(String pagerMethod) {
		this.pagerMethod = pagerMethod;
	}
	public String getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(String totalRows) {
		this.totalRows = totalRows;
	}
	public String Todayly()throws Exception{
		Calllog c=new Calllog();
		c.setTimetype("1");//锟斤拷
	//	backService.findJtl(c,1000,0);
		list1=backService.findCjlly(c,100,0);
	//	list4=backService.findCjllygrp(c,100,0);
		return "success";
	}
	public String GoTodayLyCjl()throws Exception{
		return "success";
	}
	 /**
	  * 每锟斤拷小锟斤拷山锟斤拷锟斤拷锟铰硷拷锟酵筹拷锟斤拷锟斤拷
	  */
	public String TodayLyCjl()throws Exception{
		// CallItem c=new CallItem();
		call.setCallType("4");
//		System.out.println("1time1: "+call.getTime1());
//		System.out.println("1time2: "+call.getTime1());
		// list4=backService.findCjlByGroup(c,40,0);
		 list4=backService.findCjlByGroupName(call,40,0);
//		Calllog c1=new Calllog();
//		c1.setTimetype("1");//锟斤拷
//		list3=backService.findCjllygrp(c1,100,0);//录锟斤拷
		
		 return "success";
	}
	/**
	 * 锟斤拷锟斤拷员锟斤拷锟斤拷锟斤拷
	 */
	public String Addgz()throws Exception{
		backService.addGz();
		return "success";
	}
	/**
	 * 录锟斤拷员录锟斤拷锟斤拷(锟斤拷锟届）
	 */
	public String Todayldl()throws Exception{
		CallItem c=new CallItem();
	  
	  //  c.setBizType("业锟斤拷锟斤拷锟�");
	   
	   
	    c.setCallType("1");	   
	    list1=backService.findCjlLdz(c,100,0);
	    
	
//	    c.setCallType("2");	   
//	    list2=backService.findCjl(c,30,0);
//
//	    c.setCallType("3");	   
//	    list3=backService.findCjl(c,30,0);
	
	
	 return "success";
	}
	/**
	 * 录锟斤拷员录锟斤拷锟斤拷(锟斤拷锟铰ｏ拷
	 */
	public String Monthldl()throws Exception{
		CallItem c=new CallItem();
	  
	  //  c.setBizType("业锟斤拷锟斤拷锟�");
	   
//	   
//	    c.setCallType("1");	   
//	    list1=backService.findCjlLdz(c,30,0);
	    
	
//	    c.setCallType("2");	   
//	    list2=backService.findCjl(c,30,0);
//
	    c.setCallType("3");	   
	    list3=backService.findCjlLdz(c,100,0);
	
	
	 return "success";
	}
	/**
	 * 员锟斤拷锟斤拷锟斤拷 
	 * @return
	 * @throws Exception
	 */
	public String Gz()throws Exception{
		
		g.setType(type);//type 1:锟斤拷锟斤拷员
		
		 list1=backService.findGz(50, 0, g);
		 if("1.0".equals(type)){
				g.setType("锟斤拷锟斤拷员");
			}else if("2.0".equals(type)){
				g.setType("锟诫单员");
			}else{
				g.setType("锟斤拷锟斤拷");
			}
		
		
		return "success";
	}
	public String Week()throws Exception{
		 CallItem c=new CallItem();
		    int t1=backService.getAllCjlNums(c);
		    c.setBizType("业锟斤拷锟斤拷锟�");
		    int t2=backService.getAllCjlNums(c);
		    double t3=0;
		    DecimalFormat df = new DecimalFormat("0.00%");
		    String r=null;
		    if(t1>0){
		    p3=df.format((float)t2/t1);//锟斤拷锟斤拷山锟斤拷锟斤拷锟�
		    }else{
		    	p3="0";
		    }
		    p1=t1+"";//锟斤拷锟斤拷锟斤拷锟斤拷
		    p2=t2+"";//锟缴癸拷锟斤拷
		    
		    p3="锟斤拷锟斤拷前为止锟斤拷锟斤拷锟届共锟斤拷锟斤拷: "+t1+"锟轿ｏ拷锟缴癸拷: "+t2+"锟轿ｏ拷锟缴癸拷锟绞ｏ拷"+p3+"    ";
		    list5=backService.findNotPad(1, 0);
		//    c.setCallType("1");	   
		   // list1=backService.findCjl(c,30,0);
		   	
		  
		    c.setCallType("2");	   
		    list4=backService.findCjlByGroup(c,30,0);
		    list2=backService.findCjl(c,100,0);
//
//		    c.setCallType("3");	   
//		    list3=backService.findCjl(c,30,0);
		    np=backService.getNews(1);
		
		 return "success";
	}
	/**
	 * 锟斤拷态锟斤拷询锟斤拷锟斤拷锟斤拷山锟斤拷锟�
	 */
	public String Dtdata()throws Exception{
		call.setCallType("4");
		list1=backService.findCjl(call,100,0);
		return "success";
	}
	
	// 锟斤拷锟斤拷锟斤拷锟斤拷山锟斤拷锟�
	public String Today() throws Exception {		
		CallItem c = new CallItem();
		    int t1=backService.getAllCjlNums(c);
		    int t0=backService.getMessageAll();//242锟斤拷锟斤拷慕锟酵拷锟�
		    t1=t1+t0;
		    c.setBizType("业务办理");
		    int t2=backService.getAllCjlNums(c);
		    double t3=0;
		    DecimalFormat df = new DecimalFormat("0.00%");
		    String r=null;
		    if(t1>0){
		    p3=df.format((float)t2/t1);//锟斤拷锟斤拷山锟斤拷锟斤拷锟�
		    }else{
		    	p3="0";
		    }
		    p1=t1+"";//锟斤拷锟斤拷锟斤拷锟斤拷
		    p2=t2+"";//锟缴癸拷锟斤拷
		    
		 //   System.out.println("t1="+t1+" t2="+t2+" : "+(float)t2/t1);
		    //p3="锟斤拷锟斤拷前为止锟斤拷锟斤拷锟届共锟斤拷锟斤拷: "+t1+"锟轿ｏ拷锟缴癸拷: "+t2+"锟轿ｏ拷锟缴癸拷锟绞ｏ拷"+p3+"    ";
		    p3="到当前为止，今天共呼叫: "+t1+"次，成功: "+t2+"次，成功率："+p3+"    ";
		 //   list5=backService.findNotPad(1, 0);
		    c.setCallType("1");

		    list1=backService.findCjl(c,150,0);

		//锟斤拷锟斤拷    list4=backService.findCjlByGroup(c,40,0);
//		    c.setCallType("2");	   
//		    list2=backService.findCjl(c,30,0);
//
//		    c.setCallType("3");	   
//		    list3=backService.findCjl(c,30,0);
		  //  np=backService.getNews(1);
		
		 return "success";
	}
	//锟铰碉拷统锟斤拷
	public String Tongji()throws Exception{
		 CallItem c=new CallItem();
		 c.setCallType("3");	
		 list4=backService.findTongjiByGroup(c,40,0);
		 return "success";
	}
	/**
	 * 锟斤拷锟斤拷统锟斤拷
	 */
	public String Month()throws Exception{
		 
		  CallItem c=new CallItem();
		    int t1=backService.getAllCjlNums(c);
		    c.setBizType("业锟斤拷锟斤拷锟�");
		    int t2=backService.getAllCjlNums(c);
		    double t3=0;
		    DecimalFormat df = new DecimalFormat("0.00%");
		    String r=null;
		    if(t1>0){
		    p3=df.format((float)t2/t1);//锟斤拷锟斤拷山锟斤拷锟斤拷锟�
		    }else{
		    	p3="0";
		    }
		    p1=t1+"";//锟斤拷锟斤拷锟斤拷锟斤拷
		    p2=t2+"";//锟缴癸拷锟斤拷
		    c.setCallType("3");	
		 //   list4=backService.findCjlByGroup(c,40,0);
		    list4=backService.findCjlByGroup(c,40,0);
		    p3="锟斤拷锟斤拷前为止锟斤拷锟斤拷锟届共锟斤拷锟斤拷: "+t1+"锟轿ｏ拷锟缴癸拷: "+t2+"锟轿ｏ拷锟缴癸拷锟绞ｏ拷"+p3+"    ";
		    list5=backService.findNotPad(1, 0);
		  c.setBizType("业锟斤拷锟斤拷锟�");
		//  c.setCallType("3");	   
		    list3=backService.findCjl(c,100,0);
		    return "success";
	}
	/**
	 * 锟斤拷锟斤拷
	 */
	public String Fb()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
	    String userAgent = request.getHeader("User-Agent");
	    CallItem c=new CallItem();
	    int t1=backService.getAllCjlNums(c);
	    c.setBizType("业锟斤拷锟斤拷锟�");
	    int t2=backService.getAllCjlNums(c);
	    double t3=0;
	    DecimalFormat df = new DecimalFormat("0.00%");
	    String r=null;
	    if(t1>0){
	    p3=df.format((float)t2/t1);//锟斤拷锟斤拷山锟斤拷锟斤拷锟�
	    }else{
	    	p3="0";
	    }
	    p1=t1+"";//锟斤拷锟斤拷锟斤拷锟斤拷
	    p2=t2+"";//锟缴癸拷锟斤拷
	    
	    p3="锟斤拷锟斤拷前为止锟斤拷锟斤拷锟届共锟斤拷通: <span class=\"d3\">"+t1+"</span>&nbsp;锟轿ｏ拷锟缴癸拷: <span class=\"d3\">"+t2+"</span>&nbsp;锟轿ｏ拷锟缴癸拷锟绞ｏ拷<span class=\"d3\">"+p3+" </span>&nbsp;   ";
	    c.setCallType("1");	   
	    list1=backService.findCjl(c,40,0);
	    CjlBean clb=null;
	    if(list1!=null && list1.size()>0){
	    	clb=(CjlBean)list1.get(0);
	    	topname=clb.getCname();
	    }else{
	    	topname="姚锟杰筹拷";
	    }
	   
	    list4=backService.findCjlByGroup(c,40,0);
	    c.setCallType("2");	   
	    list2=backService.findCjl(c,40,0);

	    c.setCallType("3");	   
	    list3=backService.findCjl(c,40,0);
	    
	    
	    list5=backService.findNotPad(1, 0);
	//    np=backService.getNews(1);
	  //  System.out.println(": "+np.getTitle());
	    return "success";
	}
	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷息页锟斤拷
	 */
	public String Addnotpad()throws Exception{
		 return "success";
	}
	/**
	 * 锟斤拷锟斤拷锟斤拷息
	 */
	public String SaveNotPad()throws Exception{
		backService.addNotePad(np);
		 return "success";
	}
/**
 * 锟斤拷页
 * @return
 * @throws Exception
 */
	public String Head()throws Exception{
//		HttpServletRequest request = ServletActionContext.getRequest();
//	    String userAgent = request.getHeader("User-Agent");
//	    CallItem c=new CallItem();
//	    int t1=backService.getAllCjlNums(c);
//	    c.setBizType("业锟斤拷锟斤拷锟�");
//	    int t2=backService.getAllCjlNums(c);
//	    double t3=0;
//	    DecimalFormat df = new DecimalFormat("0.00%");
//	    String r=null;
//	    if(t1>0){
//	    	p3=df.format((float)t2/t1);//锟斤拷锟斤拷山锟斤拷锟斤拷锟�
//	    }else{
//	    	p3="0";
//	    }
//	    p1=t1+"";//锟斤拷锟斤拷锟斤拷锟斤拷
//	    p2=t2+"";//锟缴癸拷锟斤拷
	  //  list1=backService.findCjl(c);
	    
	  
	    
//	    int totalRow=backService.getTelNums();
//		System.out.println("totalRow: "+totalRow);
//		try {
//			pager = pagerService.getPager(this.getCurrentPage(), this
//					.getPagerMethod(), totalRow);
//			this.setCurrentPage(String.valueOf(pager.getCurrentPage()));
//			this.setTotalRows(String.valueOf(totalRow));
//		
//			list1 = backService.findTel(pager.getPageSize(), pager
//					.getStartRow());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}	
	   
	    
		    return "success";
	   
	}
	
	/**
	 * test
	 * 23200723
	   cttjs001
	 * 
	 */
	public String Login()throws Exception{
		
		//backService.test2Post("23200723","cttjs001");
		return "success";
	}
	
	/**
	 * 锟斤拷询锟斤拷锟斤拷员锟斤拷页
	 * @return
	 */
	public String Gohwy()throws Exception{
		list1=backService.findHwy();
	
		return "success";
	}
	/**
	 * 某小锟斤拷锟斤拷员统锟斤拷
	 */
	public String GroupName()throws Exception{
		gi=backService.getGroupInfo(id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  // HH:mm:ss		 
		java.util.Date d=new java.util.Date(); 	
		if(p3 !=null){
			p3=p3.substring(0, 10);
			p3=p3+" "+p4;
			call.setTime1(p3);
			
		}
		boolean flag = CommonUtil.parseDate2(call.getTime1()).before(d);		
		if(call.getTime1()==null){
			flag=true;
		}		
		String t1=null;
		if(call.getTime1()!=null){
			
			if(call.getTime1().length()==4){
				t1="1";//锟斤拷锟斤拷锟窖�	
			}else if(call.getTime1().length()==7){
				t1="2";//锟斤拷锟铰诧拷询	
			}else if(call.getTime1().length()==10){
				t1="3";//锟斤拷锟斤拷锟窖�	
			}else if(call.getTime1().length()==13){
				
				t1="4";//锟斤拷小时锟斤拷询	
			}
		}else{
			t1="3";//锟斤拷锟斤拷锟窖�	
		}
		if(flag){
			//System.out.println("锟斤拷锟节斤拷锟斤拷");		
					
			if(call.getTime1()==null){				
				call.setTime1(df.format(d));
				
			}	
		
			list1=backService.findGroupNameTime(t1,call.getTime1().toString(),id);
			if(list1!=null &&list1.size()>0){
			
				p1=(String) list1.get(0);
				p1=p1.substring(1, p1.length());
				//p1=p1+p1;
				p2=(String) list1.get(1);
				p2=p2.substring(1, p2.length());
				
				p5=(String) list1.get(2);
				p5=p5.substring(1, p5.length());
				//p2=p2+"],["+p2;
				//list2=backService.findGroupName(t1,call.getTime1().toString());
				list2=backService.findName(t1,call.getTime1().toString(),id);
			}
		}
		else{
	//	System.out.print("锟斤拷锟节斤拷锟斤拷");
		}
		
		
		return "success";
	}
	/**
	 * 小锟斤拷统锟斤拷(锟疥、锟铰★拷锟斤拷)
	 */
	public String Group()throws Exception{		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  // HH:mm:ss		 
		java.util.Date d=new java.util.Date(); 	
		if(p3 !=null){
			p3=p3.substring(0, 10);
			p3=p3+" "+p4;
			call.setTime1(p3);
			
		}
		String tt=call.getTime1();
		boolean flag = CommonUtil.parseDate2(tt).before(d);		
		if(tt==null){
			flag=true;
		}		
		String t1=null;
		if(tt!=null){		
			if(tt.length()==4){
				t1="1";//锟斤拷锟斤拷锟窖�	
			}else if(tt.length()==7){
				t1="2";//锟斤拷锟铰诧拷询	
			}else if(call.getTime1().length()==10){
				t1="3";//锟斤拷锟斤拷锟窖�	
			}else if(call.getTime1().length()==13){
				
				t1="4";//锟斤拷小时锟斤拷询	
			}
		}else{
			t1="3";//锟斤拷锟斤拷锟窖�	
		}
		if(flag){
			//System.out.print("锟斤拷锟节斤拷锟斤拷");		
					
			if(call.getTime1()==null){				
				call.setTime1(df.format(d));
				//System.out.println(": "+tt);
			}			
			list1=backService.findGroupEle(t1,call.getTime1().toString());
			if(list1!=null &&list1.size()>0){
				//System.out.print("list1: "+list1.size());
				p1=(String) list1.get(0);
				p1=p1.substring(1, p1.length());
				p2=(String) list1.get(1);
				p2=p2.substring(1, p2.length());
				list2=backService.findGroupName(t1,call.getTime1().toString());
			}
			
			
		}
		else{
		//System.out.print("锟斤拷锟节斤拷锟斤拷");
		}
		
		
		return "success";
	}
	/**
	 * 锟斤拷锟斤拷统锟狡ｏ拷每锟斤拷锟铰份ｏ拷
	 * @return
	 * @throws Exception
	 */
	public String Gr()throws Exception{
		u=backService.getUserInfo(id);
		list1=backService.findCjlGr(100,0,id);
		
		p1=(String) list1.get(0);
		p1=p1.substring(1, p1.length());
		p2=(String) list1.get(1);
		p2=p2.substring(1, p2.length());
		list2=backService.findCjlGr2(100,0,id);
//		System.out.println("p1: "+p1);
//		System.out.println("p2: "+p2);
		return "success";
	}
	/**
	 * 锟斤拷锟斤拷统锟狡ｏ拷每锟届）
	 * @return
	 * @throws Exception
	 */
	public String Grday()throws Exception{
		u=backService.getUserInfo(id);
		//day=day.replaceAll("-", "/");
		list1=backService.findCjlGrDay(100,0,id,day);
		
		p1=(String) list1.get(0);
		p1=p1.substring(1, p1.length());
		p2=(String) list1.get(1);
		p2=p2.substring(1, p2.length());
		list2=backService.findCjlGrDay2(100,0,id,day);
//		System.out.println("p1: "+p1);
//		System.out.println("p2: "+p2);
		return "success";
	}
	
	/**
	 * 锟斤拷锟斤拷统锟狡ｏ拷小时锟斤拷
	 * @return
	 * @throws Exception
	 */
	public String Grhour()throws Exception{
		u=backService.getUserInfo(id);	
		list1=backService.findCjlGrhour(100,0,id,day);	
		
		
		p1=(String) list1.get(0);
		p1=p1.substring(1, p1.length());
		p2=(String) list1.get(1);
		p2=p2.substring(1, p2.length());
		//list2=backService.findCjlGrhour2(100,0,id,day);
		
		list2=backService.findxx(id,day);
		return "success";
	}
	/**
	 * 统锟斤拷一小时锟节碉拷锟斤拷细锟斤拷录
	 * @return
	 */
	public String Detile()throws Exception{
		list1=backService.findxx(id,day);	
		return "success";
	}
	
	// 锟斤拷锟斤拷员锟斤拷锟斤拷通锟斤拷时锟斤拷统锟斤拷
	public String Thsc() throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  // HH:mm:ss		 
		java.util.Date d = new java.util.Date();
		String tt = call.getTime1();
		System.out.println("tt = " + tt);
		boolean flag = CommonUtil.parseDate2(tt).before(d);
		if(tt == null) {
			flag = true;
			call.setTime1(df.format(d));
			/*
			if(call.getTime1() == null) {				
				call.setTime1(df.format(d));				
			}
			*/	
		}		
		if(flag) {
			if(id != null && !("my".equals(id))) {
				String gh = backService.findUserAllGroup(id);	
				p1 = id;
				if(gh != null && gh.length() > 0) {
					list1 = backService.findth(gh, call.getTime1());					
				}
			}
			list2 = backService.findGroupAllName();//小锟斤拷锟斤拷锟斤拷
		}
		return "success";
	}
	
	// 鏍规嵁鏃堕棿娈电粺璁″綋鏃ラ�氳瘽鏃堕暱
	public String Thsc02() throws Exception {
		String startTime = call.getTime1();
		String endTime = call.getTime2();
		System.out.println("startTime = " + startTime + ", endTime = " + endTime);
		if (id != null && !("my".equals(id))) {
			String gh = backService.findUserAllGroup(id);
			p1 = id;
			if(gh != null && gh.length() > 0) {
				list1 = backService.findth(gh, startTime, endTime);					
			}
		}
		list2 = backService.findGroupAllName();		
		return "success";
	}
	
	
	/**
	 * 小锟斤拷统锟斤拷
	 */
	public String FindTime()throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  // HH:mm:ss		 
		java.util.Date d=new java.util.Date();
		if(p3 !=null){
			p3=p3.substring(0, 10);
			p3=p3+" "+p4;
			call.setTime1(p3);			
		}
		String tt=call.getTime1();
		boolean flag = CommonUtil.parseDate2(tt).before(d);
		if(tt==null){
			flag=true;
		}		
		String t1=null;
		if(tt!=null){		
			if(tt.length()==4){
				t1="1";//锟斤拷锟斤拷锟窖�	
			}else if(tt.length()==7){
				t1="2";//锟斤拷锟铰诧拷询	
			}else if(call.getTime1().length()==10){
				t1="3";//锟斤拷锟斤拷锟窖�	
			}else if(call.getTime1().length()==13){
				
				t1="4";//锟斤拷小时锟斤拷询	
			}
		}else{
			t1="3";//锟斤拷锟斤拷锟窖�	
		}
		if(flag){
			//System.out.print("锟斤拷锟节斤拷锟斤拷");		
					
			if(call.getTime1()==null){				
				call.setTime1(df.format(d));
				//System.out.println(": "+tt);
			}	
			int t=Integer.parseInt(t1);
			if(t<4){
				t=t+1;
			}
		//	System.out.println(": "+tt);
			
			list1=backService.findTime(t+"",call.getTime1().toString());
			if(list1!=null &&list1.size()>0){
				//System.out.print("list1: "+list1.size());
				p1=(String) list1.get(0);
				p1=p1.substring(1, p1.length());
			//	System.out.println("p1: "+p1);
				p2=(String) list1.get(1);
				p2=p2.substring(1, p2.length());
			//	p1=p1.replaceAll(tt, "");
				//System.out.println("p2: "+p2);
				//list2=backService.findGroupName(t1,call.getTime1().toString());
			}
			
			
		}
		else{
		//System.out.print("锟斤拷锟节斤拷锟斤拷");
		}
		
		
		return "success";
	}
	
	/**
	 * 锟斤拷目统锟斤拷
	 */
	public String FindName()throws Exception{		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  // HH:mm:ss		 
		java.util.Date d=new java.util.Date(); 	
		if(p3 !=null){
			p3=p3.substring(0, 10);
			p3=p3+" "+p4;
			call.setTime1(p3);
			
		}
		String tt=call.getTime1();
		boolean flag = CommonUtil.parseDate2(tt).before(d);		
		if(tt==null){
			flag=true;
		}		
		String t1=null;
		if(tt!=null){		
			if(tt.length()==4){
				t1="1";//锟斤拷锟斤拷锟窖�	
			}else if(tt.length()==7){
				t1="2";//锟斤拷锟铰诧拷询	
			}else if(call.getTime1().length()==10){
				t1="3";//锟斤拷锟斤拷锟窖�	
			}else if(call.getTime1().length()==13){
				
				t1="4";//锟斤拷小时锟斤拷询	
			}
		}else{
			t1="3";//锟斤拷锟斤拷锟窖�	
		}
		if(flag){
			//System.out.print("锟斤拷锟节斤拷锟斤拷");		
					
			if(call.getTime1()==null){				
				call.setTime1(df.format(d));
				
			}	
			
			list1=backService.findName(t1,call.getTime1().toString());
			int len=0;
			if(list1!=null ){
				len=list1.size();
			}
			CjlBean cb=null;
			int sum=0;
			for(int n=0;n<len;n++){
				cb=(CjlBean)list1.get(n);
				sum+=Integer.parseInt(cb.getNum());
			}
			p1=len+"";//锟斤拷目锟斤拷
			p2=sum+"";//锟缴斤拷锟斤拷
//			if(list1!=null &&list1.size()>0){
//			
//				p1=(String) list1.get(0);
//				p1=p1.substring(1, p1.length());
//				System.out.println("p1: "+p1);
//				p2=(String) list1.get(1);
//				p2=p2.substring(1, p2.length());
//		
//				
//				System.out.println("p2: "+p2);
//				//list2=backService.findGroupName(t1,call.getTime1().toString());
//			}
			
			
		}
		else{
		//System.out.print("锟斤拷锟节斤拷锟斤拷");
		}
		
		
		return "success";
	}
	public IBackService getBackService() {
		return backService;
	}

	public void setBackService(IBackService backService) {
		this.backService = backService;
	}
	public List getList2() {
		return list2;
	}
	public void setList2(List list2) {
		this.list2 = list2;
	}
	
	public List getList3() {
		return list3;
	}
	public void setList3(List list3) {
		this.list3 = list3;
	}
	public List getList4() {
		return list4;
	}
	public void setList4(List list4) {
		this.list4 = list4;
	}
	public String getP1() {
		return p1;
	}
	public void setP1(String p1) {
		this.p1 = p1;
	}
	public String getP2() {
		return p2;
	}
	public void setP2(String p2) {
		this.p2 = p2;
	}
	public String getP3() {
		return p3;
	}
	public void setP3(String p3) {
		this.p3 = p3;
	}
	public String getP4() {
		return p4;
	}
	public void setP4(String p4) {
		this.p4 = p4;
	}
	public List getList5() {
		return list5;
	}
	public void setList5(List list5) {
		this.list5 = list5;
	}
	public List getList6() {
		return list6;
	}
	public void setList6(List list6) {
		this.list6 = list6;
	}
	public List getList7() {
		return list7;
	}
	public void setList7(List list7) {
		this.list7 = list7;
	}
	public List getList8() {
		return list8;
	}
	public void setList8(List list8) {
		this.list8 = list8;
	}
	public List getList9() {
		return list9;
	}
	public void setList9(List list9) {
		this.list9 = list9;
	}
	public List getList0() {
		return list0;
	}
	public void setList0(List list0) {
		this.list0 = list0;
	}
	public NotePad getNp() {
		return np;
	}
	public void setNp(NotePad np) {
		this.np = np;
	}
	public String getTopname() {
		return topname;
	}
	public void setTopname(String topname) {
		this.topname = topname;
	}
	public Gz getG() {
		return g;
	}
	public void setG(Gz g) {
		this.g = g;
	}
	public CallItem getCall() {
		return call;
	}
	public void setCall(CallItem call) {
		this.call = call;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List getList10() {
		return list10;
	}
	public void setList10(List list10) {
		this.list10 = list10;
	}
	public List getList11() {
		return list11;
	}
	public void setList11(List list11) {
		this.list11 = list11;
	}
	public UserInfo getU() {
		return u;
	}
	public void setU(UserInfo u) {
		this.u = u;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public GroupInfo getGi() {
		return gi;
	}
	public void setGi(GroupInfo gi) {
		this.gi = gi;
	}
	public String getP5() {
		return p5;
	}
	public void setP5(String p5) {
		this.p5 = p5;
	}
	
}
