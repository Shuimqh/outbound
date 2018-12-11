package com.company.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Date;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.HibernateException;


import com.company.bean.CjlBean;
import com.company.bean.CustomerInfoBean;

import com.company.data.dao.iface.IBaDao;
import com.company.data.dao.iface.IBackDao;
import com.company.data.dao.iface.IPgDao;
import com.company.data.ho.CallItem;
import com.company.data.ho.Calllog;
import com.company.data.ho.CustomerInfo;
import com.company.data.ho.DessTx;
import com.company.data.ho.GroupInfo;
import com.company.data.ho.Gz;
import com.company.data.ho.UserInfo;



import com.company.data.ho.NotePad;
import com.company.data.ho.UserTel;
import com.company.data.ho.UserTelNs;

import com.company.service.iface.IBackService;
import com.company.util.ComparatorCjl;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.util.Map;

public class BackService implements IBackService {
	private IBackDao backDao;
	private IBaDao baDao;
	private IPgDao pgDao;
	public IBaDao getBaDao() {
		return baDao;
	}
	public void setBaDao(IBaDao baDao) {
		this.baDao = baDao;
	}
	public List findJtl(Calllog c,int pageSize, int startRow){
		List list =baDao.findJtl(c,pageSize,startRow);
		List listcb=new ArrayList();
		
	//	System.out.println(": "+list.size());
		return listcb;
	}
	//录锟斤拷员锟斤拷录锟斤拷锟斤拷
	public List findCjlLdz(CallItem c,int pageSize, int startRow)throws HibernateException {
		List list =backDao.findCjlLdz(c,pageSize,startRow);			
		CjlBean cb=null;		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			cb.setCname((String)object[0]);		
			if(cb.getCname()==null){
				cb.setCname("未录锟斤拷");
			}
			cb.setNum((Integer )object[1]+"");
			cb.setNuma((Integer )object[2]+"");
			listcb.add(cb);
		}	
		return listcb;
	}
	
	/**
	 * 锟斤拷询锟斤拷锟秸成斤拷锟斤拷锟斤拷每锟斤拷锟斤拷锟斤拷员锟斤拷
	 */
	public List findAllCjl(CallItem c)throws HibernateException{
		//System.out.println("1: ");
		List list =backDao.findAllCjl(c);
		//System.out.println("2: ");
		Map map=null;
		CjlBean cb=null;
		List listcb=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		for(int n=0;n<lenth;n++){
			map=(Map)list.get(n);
			cb=new CjlBean();
			cb=cb.mapToBean(map);
			listcb.add(cb);
		}
		return listcb;
	}
	public int getAllCjlNums(CallItem c)throws HibernateException{
		return backDao.getAllCjlNums(c);
	}
	public int getMessageAll()throws HibernateException{
		return baDao.getMessageAll();
	}
	/**
	 * 锟斤拷询锟斤拷锟秸成斤拷锟斤拷锟斤拷每锟斤拷锟斤拷锟斤拷员锟斤拷
	 */
	@SuppressWarnings("unchecked")
	public List findCjl(CallItem c,int pageSize, int startRow)throws HibernateException{	
		c.setBizType(null);
		List list =backDao.findCjl(c,pageSize,startRow);	
		

		//Map map=null;
		
		CjlBean cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		DecimalFormat df = new DecimalFormat("0.00%");
		int m=0;
		int m1=0;
		int m2=0;
		float f=0;	
	    DecimalFormat dqf=new DecimalFormat("0.000000");    
	    
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			m=baDao.getMessage((String)object[6]);
			cb=new CjlBean();
			cb.setCname((String)object[0]);		
			cb.setNum((Integer )object[1]+"");
			cb.setNuma((Integer )object[2]+m+"");
			m1=(Integer )object[1];
			m2=(Integer )object[2]+m;
			
			f=Float.parseFloat(dqf.format((float)m1/m2))*100;

			if((f+"").length()>4){
			cb.setNums((f+"").substring(0, 4)+"%");
			}else{
				cb.setNums((f+"")+"%");
			}
			//cb.setNums((object[3].toString()).substring(0, 4)+"%");
			if((Integer )object[4]==null){
				cb.setNumss("0");
			}else{
				cb.setNumss((Integer )object[4]+"");
			}
			cb.setTelephonistGroupId((String)object[5]);
			
			
			
//			int t1=Integer.parseInt(cb.getNuma());
//			int t2=Integer.parseInt(cb.getNum());
//			
//			if(t1>0){
//				cb.setNums(df.format((float)t2/t1));//锟缴斤拷锟斤拷锟斤拷
//			}
		//	System.out.println("name: "+cb.getCname()+" num: "+cb.getNum()+" numa: "+cb.getNuma()+ " nums: "+cb.getNums());

			listcb.add(cb);
		}	
//		ComparatorCjl comparator=new ComparatorCjl();
//		Collections.sort(listcb,comparator);
//		for(int i=0;i<listcb.size();i++){
//			cb=(CjlBean)listcb.get(i);
//			listcb2.add(cb);
//			//System.out.println("name: "+cb.getCname()+" num: "+cb.getNum()+" nums: "+cb.getNums());
//		}
		return listcb;
	}
	/**
	 * 锟斤拷询锟斤拷锟秸成斤拷锟斤拷锟斤拷每锟斤拷锟斤拷锟斤拷员锟斤拷
	 */
	
	public List findCjl2(CallItem c,int pageSize, int startRow)throws HibernateException{	
		
	//	c.setBizType("业锟斤拷锟斤拷锟�");
		List list =backDao.findCjl2(c,pageSize,startRow);	//锟缴斤拷锟斤拷
		Map map=null;
		
		CjlBean cb=null;
		
		List listcb=new ArrayList();
	
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		DecimalFormat df = new DecimalFormat("0.00%");
		for(int n=0;n<lenth;n++){
			map=(Map)list.get(n);
			
			cb=new CjlBean();
			
			cb=cb.mapToBean(map);
			
			cb.setNum(cb.getNums());
		//System.out.println("name: "+cb.getCname()+" num: "+cb.getNum());
			
			listcb.add(cb);
		}	
		
		return listcb;
	}
	public IBackDao getBackDao() {
		return backDao;
	}

	public void setBackDao(IBackDao backDao) {
		this.backDao = backDao;
	}
	/**
	 * 锟斤拷询锟斤拷锟秸成斤拷锟斤拷锟斤拷锟介（每锟斤拷小锟介）
	 */
	@SuppressWarnings("unchecked")
	public List findCjlByGroup(CallItem c,int pageSize, int startRow)throws HibernateException{	
		c.setBizType(null);
		List list =backDao.findCjlByGroup(c,pageSize,startRow);	//锟斤拷通锟斤拷
		List list2=null;
//		c.setBizType("业锟斤拷锟斤拷锟�");
//		List list2 =backDao.findCjlByGroup(c,pageSize,startRow);	//锟缴斤拷锟斤拷
//		Map map=null;
//		Map map2=null;
		CjlBean cb=null;
//		CjlBean cb2=null;
		List listcb=new ArrayList();
//		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
	
		String groupname=null;
//		DecimalFormat df = new DecimalFormat("0.00%");
		int gid =0;
		
		
		int size=0;
		String ghh=null;
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			groupname=(String)object[0];
			
			
			if( !"".equals(groupname)){
			cb.setTelephonistGroupId(groupname);	
			}else{
				cb.setTelephonistGroupId("未锟斤拷锟斤拷锟矫伙拷");
			}
			cb.setNum((Integer )object[1]+"");
		//	cb.setNuma((Integer )object[2]+"");
		//	cb.setNums((object[3].toString()).substring(0, 4)+"%");
			//cb.setNumss((Integer )object[4]+"");
			
//			if((Integer )object[4]==null){
//				cb.setNumss("0");
//			}else{
//			cb.setNumss((Integer )object[4]+"");
//			}
			gid=(Integer)object[5];
			//gid=25;
		//	System.out.println(groupname+" : "+gid);
			
			list2=backDao.findGh(gid+"");
			size=list2.size();
			UserInfo u=null;
			StringBuffer gh = new StringBuffer("");
			int m=0;
			int m1=0;
			int m2=0;
			float f=0;	
		    DecimalFormat dqf=new DecimalFormat("0.000000");
		    
			if(list2 !=null){
				for(int ii=0;ii<size;ii++){
					u=(UserInfo)list2.get(ii);
				//	System.out.println("g1h: "+gh.toString());
					gh.append(u.getLoginName()+",");

				}
			}
			ghh=gh.toString();
			ghh=ghh.substring(0,ghh.length()-1);
			m=baDao.getMessageGroup(ghh);
			
			
			
			
			cb.setNuma((Integer )object[2]+m+"");
			
			m1=(Integer )object[1];
			m2=(Integer )object[2]+m;
			
			f=Float.parseFloat(dqf.format((float)m1/m2))*100;

			if((f+"").length()>4){
			cb.setNums((f+"").substring(0, 4)+"%");
			}else{
				cb.setNums((f+"")+"%");
			}
			//cb.setNums((object[3].toString()).substring(0, 4)+"%");
			if((Integer )object[4]==null){
				cb.setNumss("0");
			}else{
				cb.setNumss((Integer )object[4]+"");
			}
		//	System.out.println("m:"+m);
			
//			map=(Map)list.get(n);
//			map2=(Map)list2.get(n);
//			cb=new CjlBean();
//			cb2=new CjlBean();
//			cb=cb.mapToBean(map);
//			cb2=cb2.mapToBean(map2);
//			cb.setNum(cb2.getNums());
//			cb.setNuma(cb.getNums());
			//System.out.println("name: "+cb.getCname()+" num: "+cb.getNum()+" nums: "+cb.getNums());
//			if(cb.getTelephonistGroupId()==null || "".equals(cb.getTelephonistGroupId())){
//				cb.setTelephonistGroupId("锟斤拷时小锟斤拷");
//			}
//			int t1=Integer.parseInt(cb.getNuma());
//			int t2=Integer.parseInt(cb.getNum());
//			if(t1>0){
//				cb.setNums(df.format((float)t2/t1));//锟缴斤拷锟斤拷锟斤拷
//			}
			listcb.add(cb);
		}	
		
		return listcb;
	}
	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷
	 */
	public void updateNews(NotePad n) throws HibernateException{
		//NotePad n=nb.beanToHo();
	
		backDao.updateNews(n);
	}
	/**
	 * 锟斤拷锟斤拷ID锟斤拷询锟斤拷锟斤拷锟斤拷锟斤拷
	 */
	public NotePad getNews(int id) throws HibernateException {
		NotePad n=backDao.getNews(id);
		return n;
	}
	/**
	 * 锟斤拷锟斤拷锟斤拷息
	 */
	public void addNotePad(NotePad n) throws HibernateException{
	//	System.out.println("=="+n.getTitle());
		backDao.addNotePad(n);
	}
	
	/**
	 * 锟斤拷询员锟斤拷锟斤拷锟斤拷
	 */
	public List findGz(int pageSize, int startRow,Gz gz)throws HibernateException{
		List list=null;
		List listGz=new ArrayList();
		list=backDao.findGz(pageSize, startRow,gz);
		int length=0;
		Gz g=null;		
		if(list !=null){
			length=list.size();
		}
		
		for(int n=0;n<length;n++){
			g=(Gz)list.get(n);
			 g.setGrsds((float)(Math.round(g.getGrsds()*100))/100);
			 g.setAddgz((float)(Math.round(g.getAddgz()*100))/100);
			 g.setYfgz((float)(Math.round(g.getYfgz()*100))/100);
			 g.setGz((float)(Math.round(g.getGz()*100))/100);
			listGz.add(g);
		}
		return listGz;
	}
	//专锟斤拷锟斤拷锟斤拷
	public List findNotPad(int pageSize, int startRow)throws HibernateException {
		List list=null;
		List listNewstype=new ArrayList();
		list=backDao.findNotPad(pageSize, startRow);
		int length=0;
		NotePad np=null;
		
		if(list !=null){
			length=list.size();
		}
		for(int n=0;n<length;n++){
			np=(NotePad)list.get(n);
		
			listNewstype.add(np);
		}
		return listNewstype;
	}
	/**
	 * 锟斤拷锟斤拷员锟斤拷锟斤拷锟斤拷
	 */
	public void addGz()throws HibernateException, IOException{
		 Date date = new Date();
		   SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMM");				
		   String dd = sdf1.format(date);
		 File f = new File("E:\\gz.xls");   
		 try { 
			 String str="";
			 FileInputStream is = new FileInputStream(f);   
			 HSSFWorkbook wbs = new HSSFWorkbook(is);   
			 HSSFSheet childSheet = wbs.getSheetAt(0);   
			  // System.out.println(childSheet.getPhysicalNumberOfRows());   
			// System.out.println("锟斤拷锟斤拷锟斤拷" + childSheet.getLastRowNum());   
			 for (int j = 1; j < childSheet.getLastRowNum()+1; j++) { 
				 Gz gz=new Gz();
				 HSSFRow row = childSheet.getRow(j);   
				 if (null != row) { 
					 for (int k = 0; k < row.getLastCellNum(); k++) { 
						 
						 HSSFCell cell = row.getCell(k);   
						 if (null != cell) {   
							                             switch (cell.getCellType()) {   
							                             case HSSFCell.CELL_TYPE_NUMERIC: // 锟斤拷锟斤拷  
							                            	 str=cell.getNumericCellValue()+"  ";
							                            	//str=str.replaceAll(".0", "");
							                            	 str=str.trim();
//							                            	 if(str.length()<5){
//							                            		 str=str.replaceAll(".0", "");
//							                            	 }
							                               //  System.out.print(str);   
							                                 break;   
							                             case HSSFCell.CELL_TYPE_STRING: // 锟街凤拷锟斤拷 
							                            	 str=cell.getStringCellValue()+"  ";
							                            	
							                            	// System.out.print(str);   
							                                 break;   
							                             case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean   
							                            	 str=cell.getBooleanCellValue()   
							                                         + "   "; 
							                            	 //System.out.print(str);
							                                 break;   
							                             case HSSFCell.CELL_TYPE_FORMULA: // 锟斤拷式   
							                            	 str=cell.getCellFormula() + "   ";   
							                            	 //System.out.print(str);
							                                 break;   
							                             case HSSFCell.CELL_TYPE_BLANK: // 锟斤拷值   
							                            	 str="  ";
							                            	 //System.out.print(str);   
							                                 break;   
//							                             case HSSFCell.CELL_TYPE_ERROR: // 锟斤拷锟斤拷   
//							                                 System.out.println(" ");   
//							                                 break;   
//							                             default:   
//							                                 System.out.print("未知锟斤拷锟斤拷   ");   
//							                                 break;   
							                             }   
							                         } else {   
							                             //System.out.print("-   ");   
							                         }						 
					
						 if(k==0){//锟斤拷锟斤拷							
							 gz.setName(str);							
						 }
						 if(k==1){//锟斤拷锟斤拷
							 if(str!=null && str.trim().length()>0){
							 		gz.setJbgz(Float.parseFloat(str));
							 		}
						 }
						 if(k==2){//锟接帮拷锟�	
							 if(str!=null && str.trim().length()>0){
							 		gz.setAddgz(Float.parseFloat(str));
							 		}
						 }
						 if(k==3){//锟斤拷位锟斤拷锟斤拷	
							 if(str!=null && str.trim().length()>0){
						 			
					 				gz.setGwjt(Float.parseFloat(str));
					 			
					 		}
						 }
						 if(k==4){//锟斤拷锟斤拷
							 if(str!=null && str.trim().length()>0){
							 		gz.setBx(Float.parseFloat(str));
							 		}
						 	
						 } 
						 	if(k==5){
						 		
						 		//锟斤拷锟斤拷
						 		if(str!=null && str.trim().length()>0){
						 		gz.setKh(Float.parseFloat(str));
						 		}
						 		//锟斤拷锟斤拷
//						 		if(str!=null && str.trim().length()>0){
//						 		gz.setJbgz(Float.parseFloat(str));
//						 		}
						 	
						 } 
						 	if(k==6){
						 		//锟斤拷锟斤拷锟斤拷锟斤拷税
						 		if(str!=null && str.trim().length()>0){
						 			if("0".equals(str)){
						 				gz.setGrsds(0);
						 			}else{
						 				gz.setGrsds(Float.parseFloat(str));
						 			}
						 		}
						 		//锟接帮拷锟�
//						 		if(str!=null && str.trim().length()>0){
//						 		gz.setAddgz(Float.parseFloat(str));
//						 		}
						 	
						 } 
						 	if(k==7){
						 		gz.setGz(gz.getJbgz()+gz.getAddgz()+gz.getGwjt()+gz.getBx()+gz.getKh()+gz.getGrsds());
						 	
						 		//锟斤拷位锟斤拷锟斤拷
//						 		if(str!=null && str.trim().length()>0){
//						 			
//						 				gz.setGwjt(Float.parseFloat(str));
//						 			
//						 		}
						 	
						 } 
//						 	if(k==8){//应锟斤拷
////						 		if(str!=null){
////						 		gz.setYfgz(Float.parseFloat(str));
////						 		}
//						 } 
//						 	if(k==9){//锟斤拷锟斤拷
////						 		if(str!=null && str.trim().length()>0){
////						 		gz.setKh(Float.parseFloat(str));
////						 		}
//						 } 
//						 	if(k==10){//锟斤拷锟斤拷
////						 		if(str!=null && str.trim().length()>0){
////						 		gz.setBx(Float.parseFloat(str));
////						 		}
//						 } 
//						 	if(k==11){//锟斤拷锟斤拷锟斤拷锟斤拷税
////						 		if(str!=null && str.trim().length()>0){
////						 			if("0".equals(str)){
////						 				gz.setGrsds(0);
////						 			}else{
////						 				gz.setGrsds(Float.parseFloat(str));
////						 			}
////						 		}
////						 		 str=str.replace(".0", "");
////						 		System.out.println("9: "+str);
//							// l.setBk2(str);//锟斤拷锟斤拷2
//						 } 
//						 	if(k==12){//实锟斤拷
////						 		System.out.println("kh: "+gz.getKh());
////						 		System.out.println("bx: "+gz.getBx());
////						 		System.out.println("grsds: "+gz.getGrsds());
//						 		
//						 		//gz.setGz(gz.getYfgz()+gz.getKh()+gz.getBx()+gz.getGrsds());
//						 		//System.out.println("gz: "+gz.getGz());
//						 		
//						 	
//						 } 
						 	if(k==8){//锟斤拷锟斤拷
						 		
						 		 gz.setType(str);
						 		
						 } 
					 }


						
				 }
				backDao.addNotePad(gz);
			 }
		 }catch (Exception e) {   
			 e.printStackTrace();   
		 }
		
		
//			
			
		
		
		
	}
	
	
	
	/**
	 * 锟斤拷询锟斤拷锟斤拷录锟斤拷锟斤拷每锟斤拷锟斤拷锟斤拷员锟斤拷
	 */
	
	public List findCjlly(Calllog c,int pageSize, int startRow)throws HibernateException{	
		//c.setBizType(null);
		List list =baDao.findJtl(c,pageSize,startRow);	
		

		//Map map=null;
		
		Calllog cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		DecimalFormat df = new DecimalFormat("0.00%");
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new Calllog();
				
			cb.setNuma((Integer )object[0]);
			cb.setNums((Integer )object[1]);
			cb.setName((String)object[2]);	
			cb.setNum((object[3].toString()).substring(0, 4)+"%");
		//	cb.setNumm((Integer )object[4]);
			
			int mm=(Integer )object[4];
		//	System.out.println("mm: "+mm);
			int h=mm/3600;
			int m=(mm%3600)/60;
		//	int ss=(mm%3600)%60;
		//	System.out.println(h+"小时");
			cb.setNumss(h+"时"+m+"锟斤拷");
			
			
			listcb.add(cb);
		}	

		return listcb;
	}
	
	
	/**
	 * 锟斤拷询锟斤拷锟斤拷录锟斤拷锟斤拷每锟斤拷小锟介）
	 */
	
	public List findCjllygrp(Calllog c,int pageSize, int startRow)throws HibernateException{	
		//c.setBizType(null);
		List list =baDao.findJtlgrp(c,pageSize,startRow);	
		

		//Map map=null;
		
		Calllog cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		DecimalFormat df = new DecimalFormat("0.00%");
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new Calllog();
				
			cb.setNuma((Integer )object[0]);
			cb.setNums((Integer )object[1]);
			cb.setName((String)object[2]);
			
			int mm=(Integer )object[3];
			//System.out.println("mm: "+mm);
			int h=mm/3600;
			int m=(mm%3600)/60;
		//	int ss=(mm%3600)%60;
		//	System.out.println(h+"小时");
			cb.setNumss(h+"时"+m+"锟斤拷");
			//cb.setNumm((Integer )object[3]);
			int a=cb.getNuma();
			int b=cb.getNums();
			String s=null;
			double f1=0;
			if(b>0){
				 f1 = new BigDecimal((float)a/b).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
				 s=(f1*100+"%");
				 if(s.length()>5){
					 cb.setNum(s.substring(0,4)+"%");
				 }else{
					 cb.setNum(s);
				 }
//				cb.setNum(f1*100+"%");
			}else{
				cb.setNum("0");
			}
			if(cb.getName()==null ||"".equals(cb.getName())){
				cb.setName("未锟斤拷锟斤拷小锟斤拷");
			}
			listcb.add(cb);
		}	

		return listcb;
	}
	
	
	
	/**
	 * 锟斤拷询锟斤拷锟秸成斤拷锟斤拷锟斤拷锟介（每锟斤拷小锟介）
	 */

	public List findTongjiByGroup(CallItem c,int pageSize, int startRow)throws HibernateException{	
		c.setBizType(null);
		List list =backDao.findCjlByGroup(c,pageSize,startRow);	//锟斤拷通锟斤拷
		
//		c.setBizType("业锟斤拷锟斤拷锟�");
//		List list2 =backDao.findCjlByGroup(c,pageSize,startRow);	//锟缴斤拷锟斤拷
//		Map map=null;
//		Map map2=null;
		CjlBean cb=null;
//		CjlBean cb2=null;
		List listcb=new ArrayList();
//		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		String groupname=null;
//		DecimalFormat df = new DecimalFormat("0.00%");
		for(int n=0;n<lenth;n++){
Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			groupname=(String)object[0];
			if( !"".equals(groupname)){
				cb.setTelephonistGroupId(groupname);	
			}else{
				cb.setTelephonistGroupId("未锟斤拷锟斤拷锟矫伙拷");
			}
			cb.setNum((Integer )object[1]+"");
			cb.setNuma((Integer )object[2]+"");
			cb.setNums((object[3].toString()).substring(0, 4)+"%");
			cb.setNumss((Integer )object[4]+"");
			cb.setNumee("10000");
			int a=10000;
			int b=(Integer )object[4];
			int c1=a-b;
			int d=(Integer )object[4];
			double f1=0;
			f1 = new BigDecimal((float)d/a).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
			String s=(f1*100+"%");
			
			cb.setNumm(c1+"");
			
			
			 if(s.length()>5){
				 cb.setNumw(s.substring(0,4)+"%");
			 }else{
				 cb.setNumw(s);
			 }
			//cb.setNumw(s);
			listcb.add(cb);
		}	
		
		return listcb;
	}
	
	
	/**
	 * 锟斤拷询锟斤拷锟秸成斤拷锟斤拷锟斤拷锟介（每锟斤拷小锟介）
	 */

	public List findCjlByGroupName(CallItem c,int pageSize, int startRow)throws HibernateException{	
		c.setBizType(null);
		
		List list =backDao.findCjlByGroup(c,pageSize,startRow);	//锟斤拷通锟斤拷
		List list2=new ArrayList();
		CjlBean cb=null;
		List listcb=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}	
		String groupname=null;
		Calllog c1=new Calllog();
		c1.setTimetype("4");
		for(int n=0;n<lenth;n++){
Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			groupname=(String)object[0];
			if( !"".equals(groupname)){
				cb.setTelephonistGroupId(groupname);	
			
			}else{
				cb.setTelephonistGroupId("未锟斤拷锟斤拷锟矫伙拷");
			}
			c1.setTime1(c.getTime1());
			c1.setTime2(c.getTime2());
			Object[] object1=null;
			list2=baDao.findJtlgrpName(c1, pageSize, startRow, groupname);
			
			if(list2 !=null && list2.size()>0){
				
				object1 = (Object[])list2.get(0);
				
				
				{
					cb.setNuma_((Integer )object1[0]);
					cb.setNums_((Integer )object1[1]);

					int mm=(Integer )object1[3];
					//System.out.println("mm: "+mm);
					int h=mm/3600;
					int m=(mm%3600)/60;
				//	int ss=(mm%3600)%60;
				//	System.out.println(h+"小时");
					cb.setNumss_(h+"时"+m+"锟斤拷");
					//cb.setNumm((Integer )object[3]);
					int a=cb.getNuma_();
					int b=cb.getNums_();
					String s=null;
					double f1=0;
					if(b>0){
						 f1 = new BigDecimal((float)a/b).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
						 s=(f1*100+"%");
						 if(s.length()>5){
							 cb.setNum_(s.substring(0,4)+"%");
						 }else{
							 cb.setNum_(s);
						 }
//						cb.setNum(f1*100+"%");
					}else{
						cb.setNum_("0");
					}			
				}
				
				
			}else{
				cb.setNuma_(0);
				cb.setNums_(0);
				cb.setNumss_("0");
				cb.setNum_("0");
				//System.out.println("锟斤拷");
			}
//			object1 = (Object[])list2.get(0);
//			
//			
//			{
//				cb.setNuma_((Integer )object1[0]);
//				cb.setNums_((Integer )object1[1]);
//
//				int mm=(Integer )object1[3];
//				//System.out.println("mm: "+mm);
//				int h=mm/3600;
//				int m=(mm%3600)/60;
//			//	int ss=(mm%3600)%60;
//			//	System.out.println(h+"小时");
//				cb.setNumss_(h+"时"+m+"锟斤拷");
//				//cb.setNumm((Integer )object[3]);
//				int a=cb.getNuma_();
//				int b=cb.getNums_();
//				String s=null;
//				double f1=0;
//				if(b>0){
//					 f1 = new BigDecimal((float)a/b).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
//					 s=(f1*100+"%");
//					 if(s.length()>5){
//						 cb.setNum_(s.substring(0,4)+"%");
//					 }else{
//						 cb.setNum_(s);
//					 }
////					cb.setNum(f1*100+"%");
//				}else{
//					cb.setNum_("0");
//				}			
//			}
			
			
//			System.out.println(": "+cb.getNuma_());
//			System.out.println(": "+cb.getNums_());
			
			cb.setNum((Integer )object[1]+"");
			cb.setNuma((Integer )object[2]+"");
			cb.setNums((object[3].toString()).substring(0, 4)+"%");
			cb.setNumss((Integer )object[4]+"");
			
			
			listcb.add(cb);
		}	
		
		return listcb;
	}
	/**
	 * 锟斤拷询锟斤拷锟秸成斤拷锟斤拷锟斤拷每锟斤拷锟斤拷锟斤拷员锟斤拷
	 */
	
	public List findCjlGr2(int pageSize, int startRow,String uid)throws HibernateException{	
	
		List list =backDao.findCjlGr(pageSize,startRow, uid);	
		

		//Map map=null;
		
		CjlBean cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		StringBuffer createDate=new StringBuffer();
		StringBuffer num=new StringBuffer();
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			cb.setCreateDate((String)object[0]);		
			cb.setNum((Integer )object[1]+"");
//			createDate.append(","+cb.getCreateDate());
//			num.append(","+cb.getNum());
			listcb.add(cb);
		}	
//		String createDate1=createDate.toString();
//		String num1=num.toString();
//		listcb.add(createDate1);
//		listcb.add(num1);
		return listcb;
	}
	/**
	 * 
	 */
	
	/**
	 * 锟斤拷询锟斤拷锟秸成斤拷锟斤拷锟斤拷每锟斤拷锟斤拷锟斤拷员锟斤拷
	 */
	
	public List findCjlGr(int pageSize, int startRow,String uid)throws HibernateException{	
	
		List list =backDao.findCjlGr(pageSize,startRow, uid);	
		
	//	System.out.println("list: "+list.size());
		

		//Map map=null;
		
		CjlBean cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		StringBuffer createDate=new StringBuffer();
		StringBuffer num=new StringBuffer();
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			cb.setCreateDate((String)object[0]);		
			cb.setNum((Integer )object[1]+"");
			createDate.append(","+cb.getCreateDate());
			num.append(","+cb.getNum());
			//listcb.add(cb);
		}	
		String createDate1=createDate.toString();
		String num1=num.toString();
		listcb.add(createDate1);
		listcb.add(num1);
		return listcb;
	}
	
	//锟斤拷锟斤拷员
	public List findHwy()throws HibernateException {
		List list=null;
		List listHwy=new ArrayList();
		list=backDao.findHwy();
		int length=0;
		UserInfo u=null;
		
		if(list !=null){
			length=list.size();
		}
		for(int n=0;n<length;n++){
			u=(UserInfo)list.get(n);
			
			listHwy.add(u);
		}
		return listHwy;
	}
	/**
	 * 锟斤拷锟斤拷ID锟斤拷询锟斤拷锟斤拷
	 */
	public GroupInfo getGroupInfo(String id) throws HibernateException {
		GroupInfo g=backDao.getGroupInfo(id);
		return g;
	}
	/**
	 * 锟斤拷锟斤拷ID锟斤拷询小锟斤拷锟斤拷息
	 */
	public UserInfo getUserInfo(String id) throws HibernateException {
		UserInfo n=backDao.getUserInfo(id);
		return n;
	}
	/**
	 * 锟斤拷询锟斤拷锟秸成斤拷锟斤拷锟斤拷每锟斤拷锟斤拷锟斤拷员锟斤拷
	 */
	
	public List findCjlGrDay(int pageSize, int startRow,String uid,String day)throws HibernateException{	
	
		List list =backDao.findCjlGrDay(pageSize,startRow, uid,day);	
		

		//Map map=null;
		
		CjlBean cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		StringBuffer createDate=new StringBuffer();
		StringBuffer num=new StringBuffer();
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			cb.setCreateDate((String)object[0]);		
			cb.setNum((Integer )object[1]+"");
			createDate.append(","+cb.getCreateDate());
			num.append(","+cb.getNum());
			//listcb.add(cb);
		}	
		String createDate1=createDate.toString();
		String num1=num.toString();
		listcb.add(createDate1);
		listcb.add(num1);
		return listcb;
	}
	public List findCjlGrDay2(int pageSize, int startRow,String uid,String day)throws HibernateException{	
		
		List list =backDao.findCjlGrDay(pageSize,startRow, uid,day);	
		

		//Map map=null;
		
		CjlBean cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		StringBuffer createDate=new StringBuffer();
		StringBuffer num=new StringBuffer();
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			cb.setCreateDate((String)object[0]);		
			cb.setNum((Integer )object[1]+"");
//			createDate.append(","+cb.getCreateDate());
//			num.append(","+cb.getNum());
			listcb.add(cb);
		}	
//		String createDate1=createDate.toString();
//		String num1=num.toString();
//		listcb.add(createDate1);
//		listcb.add(num1);
		return listcb;
	}
	
	/**
	 * 锟斤拷询锟斤拷锟秸成斤拷锟斤拷锟斤拷每锟斤拷锟斤拷锟斤拷员锟斤拷
	 */
	
	public List findCjlGrhour(int pageSize, int startRow,String uid,String day)throws HibernateException{	
	
		List list =backDao.findCjlGrhour(pageSize,startRow, uid,day);	
		

		//Map map=null;
		
		CjlBean cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		StringBuffer createDate=new StringBuffer();
		StringBuffer num=new StringBuffer();
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			cb.setCreateDate((String)object[0]);		
			cb.setNum((Integer )object[1]+"");
			createDate.append(","+cb.getCreateDate());
			num.append(","+cb.getNum());
			//listcb.add(cb);
		}	
		String createDate1=createDate.toString();
		String num1=num.toString();
		listcb.add(createDate1);
		listcb.add(num1);
		return listcb;
	}
	public List findCjlGrhour2(int pageSize, int startRow,String uid,String day)throws HibernateException{	
		
		List list =backDao.findCjlGrhour(pageSize,startRow, uid,day);	
		

		//Map map=null;
		
		CjlBean cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		StringBuffer createDate=new StringBuffer();
		StringBuffer num=new StringBuffer();
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			cb.setCreateDate((String)object[0]);		
			cb.setNum((Integer )object[1]+"");
			
			listcb.add(cb);
		}	
		
		return listcb;
	}
	
	
	/**
	 * 小锟介按锟铰成斤拷锟斤拷锟斤拷询(未锟斤拷)
	 */
	
	public List findGroupEle2()throws HibernateException{		
		//List list =backDao.findGroupEle(6);	
		List list =backDao.findGroupTime("2","2018-06");	
			
		//Map map=null;		
		CjlBean cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		StringBuffer createDate=new StringBuffer();
		StringBuffer num=new StringBuffer();
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			cb.setCreateDate((String)object[0]);		
			cb.setNum((Integer )object[1]+"");
			//cb.setCname((Integer)object[2]+"");
			createDate.append(","+cb.getCreateDate());
			num.append(","+cb.getNum());
			//listcb.add(cb);
		}
		String createDate1=createDate.toString();
		String num1=num.toString();
		listcb.add(createDate1);
		listcb.add(num1);
		return listcb;
	}
	/**
	 * 小锟斤拷锟斤拷员锟斤拷锟斤拷锟斤拷询
	 */
	
	public List findName(String type,String date,String gid)throws HibernateException{		
		List list =backDao.findGroupNameTime(type,date,gid);	
		//System.out.println("list: "+list.size());		
		//Map map=null;		
		CjlBean cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		StringBuffer createDate=new StringBuffer();
		StringBuffer num=new StringBuffer();
		DecimalFormat dqf=new DecimalFormat("0.000000"); 
		float f=0;
		int m1=0;
		int m2=0;
		int m=0;
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
					
			cb.setNum((Integer )object[1]+"");
			
			cb.setCname((String)object[0]);	
			
			cb.setId((Integer)object[3]+"");
			//cb.setNuma((Integer)object[4]+"");
			
			//System.out.println("id: "+(String)object[5]);
			
			m=baDao.getMessageDate(date,(String)object[5]);//10085锟斤拷通锟斤拷
			
			m1=(Integer )object[1];
			m2=(Integer)object[4];//锟斤拷10085锟斤拷通锟斤拷
			
			m2=m2+m;//锟杰斤拷通锟斤拷
			cb.setNuma(m2+"");
			
			f=Float.parseFloat(dqf.format((float)m1/m2))*100;

			if((f+"").length()>4){
			cb.setNums((f+"").substring(0, 4)+"%");
			}else{
				cb.setNums((f+"")+"%");
			}
			listcb.add(cb);
		}
		
		return listcb;
	}
	//锟斤拷某小锟斤拷锟斤拷员锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷时锟斤拷锟窖拷山锟斤拷锟�
	public List findGroupNameTime(String type,String date,String gid)throws HibernateException{
		List list =backDao.findGroupNameTime(type,date,gid);	
		//System.out.println("list: "+list.size());		
		//Map map=null;		
		CjlBean cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		int m=0;
		StringBuffer createDate=new StringBuffer();
		StringBuffer num=new StringBuffer();
		StringBuffer numa=new StringBuffer();
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			//cb.setCreateDate((String)object[0]);	
			cb.setCname((String)object[0]);
			cb.setNum((Integer )object[1]+"");
			//cb.setTelephonistGroupId((Integer)object[0]+"");
				
			//cb.setCname((Integer)object[2]+"");
		//	cb.setNuma((Integer )object[4]+"");
			m=baDao.getMessageDate(date,(String)object[5]);//10085锟斤拷通锟斤拷
			m=m+(Integer )object[4];
			cb.setNuma(m+"");
			createDate.append(","+cb.getCname());
			num.append(","+cb.getNum());
			numa.append(","+cb.getNuma());
			
			
			//listcb.add(cb);
		}
		String createDate1=createDate.toString();
		String num1=num.toString();
		String numa1=numa.toString();
		
		
//		System.out.println("createDate1: "+createDate1);
//		System.out.println("num1: "+num1);
		if(!"".equals(createDate1)){
		listcb.add(createDate1);
		listcb.add(num1);
		listcb.add(numa1);
		}
		return listcb;
		
	}
	/**
	 * 小锟介按锟铰成斤拷锟斤拷锟斤拷询
	 */
	
	public List findGroupName(String type,String date)throws HibernateException{		
		CjlBean cb=null;
		List list =backDao.findGroupTime(type,date);
		
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		List list2=null;
		List listcb=new ArrayList();
		int usernums=0;
		int m1=0;
		int m2=0;
		float f=0;
		  DecimalFormat dqf=new DecimalFormat("0.000000");    
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			//cb.setCreateDate((String)object[0]);		
			cb.setNum((Integer )object[1]+"");
			//cb.setTelephonistGroupId((Integer)object[0]+"");
			cb.setCname((String)object[0]);	
			cb.setTelephonistGroupId((Integer)object[3]+"");
			list2=backDao.findGroupNameTime(type, date, (Integer)object[3]+"");
			if(list2!=null){
				usernums=list2.size();
			}
			cb.setNums(usernums+"");
		//	cb.setNums(backDao.getUsernews((Integer)object[3]+"")+"");//统锟斤拷小锟斤拷锟斤拷锟斤拷
			
			
			m1=(Integer )object[1];
			m2=usernums;
			
			f=Float.parseFloat(dqf.format((float)m1/m2));

			if((f+"").length()>4){
			cb.setNuma((f+"").substring(0, 4));
			}else{
				cb.setNuma((f+""));
			}
			listcb.add(cb);
		}
		return listcb;
	}
	/**
	 * 小锟介按锟铰成斤拷锟斤拷锟斤拷询
	 */
	
	public List findGroupEle(String type,String date)throws HibernateException{		
		//List list =backDao.findGroupEle(6);
		  
	    
		List list =backDao.findGroupTime(type,date);	
		//System.out.println("list: "+list.size());		
		//Map map=null;		
		CjlBean cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		StringBuffer createDate=new StringBuffer();
		StringBuffer num=new StringBuffer();
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			//cb.setCreateDate((String)object[0]);		
			cb.setNum((Integer )object[1]+"");
			//cb.setTelephonistGroupId((Integer)object[0]+"");
			cb.setCname((String)object[0]);	
			//cb.setCname((Integer)object[2]+"");
			createDate.append(","+cb.getCname());
			num.append(","+cb.getNum());
			//listcb.add(cb);
		}
		String createDate1=createDate.toString();
		String num1=num.toString();
//		System.out.println("createDate1: "+createDate1);
//		System.out.println("num1: "+num1);
		if(!"".equals(createDate1)){
		listcb.add(createDate1);
		listcb.add(num1);
		}
		return listcb;
	}
	/**
	 * 统锟斤拷员锟斤拷通锟斤拷时锟斤拷
	 */
	public List findth(){
		List list =pgDao.findth();
		CjlBean cb=null;		
		List listcb=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		UserInfo u=null;
		GroupInfo g=null;
		int ss=0;
		int hh=0;
		int mm=0;
		int ss2=0;
		List list2 =null;
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();							
			
			cb.setGh((String)object[1]);			
			
			ss2=pgDao.getnotth(cb.getGh());// 10085璁板綍鏁�			
			
			cb.setNum((BigInteger)object[0]+"");
			ss=Integer.parseInt(cb.getNum());
			ss=ss-ss2*20; //鎬荤殑閫氳瘽鏃跺父
			
			hh=ss/3600; //閫氳瘽鏃跺父灏忔椂
			mm=(ss%3600)/60; //閫氳瘽鏃跺父鍒嗛挓
			cb.setNum(hh+"时"+mm+"锟斤拷");				
			
			u=backDao.getUserInfoGh(cb.getGh());
			cb.setCname(u.getCname());			
			
			g=backDao.getGroupInfo(u.getGroupId());
			cb.setTelephonistGroupId(g.getCname());
//			System.out.println("gh: "+cb.getGh());
//			System.out.println("num: "+cb.getNum());
			
		//	ss2=pgDao.getnotth(cb.getGh());

//			System.out.println("ss2: "+ss2);
//			System.out.println("gh: "+cb.getGh());
			listcb.add(cb);
		}	
		
		
		
	
		return listcb;
		
	}
	
	
	
	/**
	 * 锟斤拷询锟斤拷锟秸成斤拷锟斤拷锟斤拷每锟斤拷锟斤拷锟斤拷员锟斤拷
	 */
	
	public List findxx(String uid,String day)throws HibernateException{	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // HH:mm:ss	
		java.util.Date d=null;
		List list =backDao.findxx(uid,day);	
		

		//Map map=null;
		
		CjlBean cb=null;
		
		List listcb=new ArrayList();
		List listcb2=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		StringBuffer createDate=new StringBuffer();
		StringBuffer num=new StringBuffer();
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean();
			cb.setBizSubType((String)object[0]);
			d=(Date)object[4];
			cb.setCreateDate(df.format(d));
		//	cb.setCreateDate(((Date)object[4]+"").substring(0, 16));		
			cb.setNum((Integer )object[1]+"");
			cb.setCname((String)object[7]);
			
			cb.setNum((BigInteger)object[3]+"");
			listcb.add(cb);
		}	
		
		return listcb;
	}
	/**
	 * 锟斤拷询锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	 */	
	
	public List findGroupAllName(){
		List list =backDao.findGroupAllName();	
		List listName=new ArrayList();
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		GroupInfo g=null;
		for(int n=0;n<lenth;n++){
			g=(GroupInfo)list.get(n);
			listName.add(g);
		}
		return listName;
	}
	/**
	 * 锟斤拷锟斤拷小锟斤拷id锟斤拷询锟斤拷员
	 */
	public String findUserAllGroup(String id) {
		StringBuffer str = new StringBuffer();
		List list = backDao.findUserAllGroup(id);
		List listName = new ArrayList();
		int length = 0;
		if(list != null){
			length = list.size();
		}
		UserInfo u = null;
		CjlBean cb = null;
		for(int n=0;n<length;n++){
			u = (UserInfo)list.get(n);
			cb = new CjlBean();
			//cb.setCname(u.getCname());
			//cb.setGh(u.getLoginName());
			str.append("'" + u.getLoginName() + "',");
			listName.add(cb);
		}
		String s = str.toString();
		if(s != null && s.length() > 1) {
			s = s.substring(0, s.length() - 1);
		}
		return s;
	}
	
	
	/**
	 * 统锟斤拷锟斤拷席锟斤拷锟斤拷通锟斤拷时锟斤拷
	 */
	public List findth(String gh, String date) {		
		List list = pgDao.findth(gh, date);
		CjlBean cb = null;		
		List listcb = new ArrayList();
		int length = 0;
		if(list != null) {
			length = list.size();
		}
		UserInfo u = null;
		GroupInfo g = null;
		int ss = 0;
		int hh = 0;
		int mm = 0;
		int ss2 = 0;
		List list2 = null;
		for(int n=0;n<length;n++) {
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷			
			cb = new CjlBean();						
			// 锟斤拷锟斤拷
			cb.setGh((String)object[1]);			
			ss2 = pgDao.getnotth(cb.getGh());//10085锟斤拷锟斤拷
			u = backDao.getUserInfoGh(cb.getGh());
			// 锟斤拷席锟斤拷锟斤拷
			cb.setCname(u.getCname());			
			cb.setNum((BigInteger)object[0] + "");
			ss = Integer.parseInt(cb.getNum());
			ss2 = ss2 * 20;
			ss = ss - ss2;
			hh = ss / 3600;
			mm = (ss % 3600) / 60;
			// 通锟斤拷时锟斤拷
			cb.setNum(hh + "时" + mm + "锟斤拷");							
			g = backDao.getGroupInfo(u.getGroupId());
			// 锟斤拷席锟斤拷锟斤拷锟斤拷
			cb.setTelephonistGroupId(g.getCname());
			listcb.add(cb);
		}		
		return listcb;		
	}
	
	// 鏍规嵁鏃堕棿娈电粺璁″綋鏃ラ�氳瘽鏃堕暱
	public List findth(String gh, String startTime, String endTime) {		
		List list = pgDao.findth(gh, startTime, endTime);
		CjlBean cb = null;		
		List listcb = new ArrayList();
		int length = 0;
		if(list != null) {
			length = list.size();
		}
		UserInfo u = null;
		GroupInfo g = null;
		int ss = 0;
		int hh = 0;
		int mm = 0;
		int ss2 = 0;
		List list2 = null;
		for(int n=0;n<length;n++) {
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷			
			cb = new CjlBean();						
			// 锟斤拷锟斤拷
			cb.setGh((String)object[1]);
			ss2 = pgDao.getnotth(cb.getGh(), startTime, endTime);
			//ss2 = pgDao.getnotth(cb.getGh());//10085锟斤拷锟斤拷
			u = backDao.getUserInfoGh(cb.getGh());
			// 锟斤拷席锟斤拷锟斤拷
			cb.setCname(u.getCname());			
			cb.setNum((BigInteger)object[0] + "");
			ss = Integer.parseInt(cb.getNum());
			ss2 = ss2 * 20;
			ss = ss - ss2;
			hh = ss / 3600;
			mm = (ss % 3600) / 60;
			// 通锟斤拷时锟斤拷
			cb.setNum(hh + "小时" + mm + "分钟");							
			g = backDao.getGroupInfo(u.getGroupId());
			// 锟斤拷席锟斤拷锟斤拷锟斤拷
			cb.setTelephonistGroupId(g.getCname());
			listcb.add(cb);
		}		
		return listcb;		
	}
	
	/**
	 * 锟斤拷锟斤拷小锟斤拷id锟斤拷询锟斤拷员锟斤拷锟斤拷
	 */
	public int getUsernews(String id) throws HibernateException {
		return backDao.getUsernews(id);
	}
	
	
	/**
	 * 小锟介按时锟斤拷山锟斤拷锟斤拷锟窖�
	 */
	
	public List findTime(String type,String date)throws HibernateException{		
		CjlBean cb=null;
		List list =backDao.findTime(type,date);
		
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		List list2=null;
		List listcb=new ArrayList();
		int usernums=0;
		int m1=0;
		int m2=0;
		float f=0;
		  DecimalFormat dqf=new DecimalFormat("0.000000");
		 
		  StringBuffer createDate=new StringBuffer();
			StringBuffer num=new StringBuffer();
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean(); 
			cb.setNum((Integer)object[0]+"");		
			cb.setCreateDate((String )object[1]);
			
			
			createDate.append(","+cb.getCreateDate());
			num.append(","+cb.getNum());
			
			
		}
		
		String createDate1=createDate.toString();
		String num1=num.toString();
		listcb.add(createDate1);
		listcb.add(num1);
		return listcb;
	}
	
	/**
	 * 锟斤拷锟斤拷目锟缴斤拷锟斤拷锟斤拷询
	 */
	
	public List findName(String type,String date)throws HibernateException{		
		CjlBean cb=null;
		List list =backDao.findName(type,date);
		
		int lenth=0;
		if(list !=null){
			lenth=list.size();
		}
		List list2=null;
		List listcb=new ArrayList();
		int usernums=0;
		int m1=0;
		int m2=0;
		float f=0;
		  DecimalFormat dqf=new DecimalFormat("0.000000");
		 
		  StringBuffer name=new StringBuffer();
			StringBuffer num=new StringBuffer();
		for(int n=0;n<lenth;n++){
			Object[] object = (Object[])list.get(n);// 每锟叫硷拷录锟斤拷锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
			
			cb=new CjlBean(); 
			cb.setNum((Integer)object[0]+"");		
			cb.setCname((String )object[1]);
			
			
//			name.append(","+cb.getCreateDate());
//			num.append(","+cb.getNum());
			
			listcb.add(cb);
		}
		
//		String name1=name.toString();
//		String num1=num.toString();
//		listcb.add(name1);
//		listcb.add(num1);
		return listcb;
	}
	public IPgDao getPgDao() {
		return pgDao;
	}
	public void setPgDao(IPgDao pgDao) {
		this.pgDao = pgDao;
	}
}
