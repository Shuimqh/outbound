package com.company.data.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.company.data.dao.iface.IBaDao;
import com.company.data.ho.CallItem;
import com.company.data.ho.Calllog;
import com.company.util.CommonUtil;

public class BaDao extends HibernateDaoSupport implements IBaDao{
	//通话时长统计
	public List findJtl(Calllog c,int pageSize, int startRow)throws HibernateException {
		
		Date d=new Date();	
		String format = "yyyy" + "/" + "MM" + "/" + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String t=null;
		String startTime=null;
		 String endTime=null;
		if("1".equals(c.getTimetype())){
			t=sdf.format(d);
			startTime = t + " 00:00:00";
		    endTime = t + " 23:59:59";
		}else if("2".equals(c.getTimetype())){			
			t=sdf.format(CommonUtil.getMondayOfThisWeek());//周一
			startTime = t + " 00:00:00";
			t=sdf.format(CommonUtil.getSundayOfThisWeek());//周日
			 endTime = t + " 23:59:59";
		}else if("3".equals(c.getTimetype())){
			t=sdf.format(CommonUtil.getdayOfMonth());
			startTime = t + " 00:00:00";
			t=sdf.format(CommonUtil.getdaysOfMonth());
			endTime = t + " 23:59:59";
		}
		List list =null;
		
		StringBuffer hql=new StringBuffer(

			"	SELECT c.numa as numa,u.nums as nums,ui.CName as name,CONVERT(decimal(18, 2), c.numa)/ u.nums * 100 AS num,cu.numm as numm"+
			"	from  "+
				"	(SELECT   COUNT(id) AS numa, AgentId "+
				"	FROM      calllog "+
				"	WHERE   (AgentId LIKE '3%') AND HangUpTime between  convert(varchar(100),'"+startTime+"',25) and convert(varchar(100),'"+endTime+"',25) and TalkDuration>59 "+ 
				"	GROUP BY AgentId "+
				" ) c, "+
				"	(SELECT   COUNT(id) AS nums, AgentId "+
				"	FROM      calllog "+
				"	WHERE   (AgentId LIKE '3%') AND  HangUpTime between  convert(varchar(100),'"+startTime+"',25) and convert(varchar(100),'"+endTime+"',25)  "+
				"	GROUP BY AgentId) u, "+
				"(SELECT   SUM(TalkDuration) AS numm, AgentId "+
				"		FROM      calllog "+
				"		WHERE   (AgentId LIKE '3%') AND  HangUpTime between  convert(varchar(100),'"+startTime+"',25) and convert(varchar(100),'"+endTime+"',25) "+
				"		GROUP BY AgentId) cu, "+
				
				"    UserInfo  ui "+
				" where  c.AgentId=u.AgentId and c.AgentId=ui.LoginName and c.AgentId=cu.AgentId order by numa desc"
				
				
				
//				"select  * " +
//				
//				//"select s1.CName AS Cname,s1.success AS num,s2.sumwork AS numa" +
//				" FROM      calllog "+
//				" and HangUpTime>='"+startTime+"' and HangUpTime<'"+endTime+"'"+
//					
//				" WHERE     AgentId LIKE '3%' "
				
				
				
				
				
				
				
		);

		final String sql=hql.toString();
//System.out.println("sql: "+sql);
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createSQLQuery(sql);//没有实体类查询  createSQLQuery
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}

	//根据小组名称查询小组的通话记录统计
public List findJtlgrpName(Calllog c,int pageSize, int startRow,String name)throws HibernateException {
		
		Date d=new Date();	
		String format = "yyyy" + "/" + "MM" + "/" + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String t=null;
		String startTime=null;
		 String endTime=null;
		if("1".equals(c.getTimetype())){
			t=sdf.format(d);
			startTime = t + " 00:00:00";
		    endTime = t + " 23:59:59";
		}else if("2".equals(c.getTimetype())){			
			t=sdf.format(CommonUtil.getMondayOfThisWeek());//周一
			startTime = t + " 00:00:00";
			t=sdf.format(CommonUtil.getSundayOfThisWeek());//周日
			 endTime = t + " 23:59:59";
		}else if("3".equals(c.getTimetype())){
			t=sdf.format(CommonUtil.getdayOfMonth());
			startTime = t + " 00:00:00";
			t=sdf.format(CommonUtil.getdaysOfMonth());
			endTime = t + " 23:59:59";
		}else if("4".equals(c.getTimetype())){
			startTime = c.getTime1() + " 00:00:00";
			endTime = c.getTime2() + " 23:59:59";
		}
		List list =null;
//		System.out.println("time1: "+startTime);
//		System.out.println("time2: "+endTime);
		StringBuffer hql=new StringBuffer(
//
			"	SELECT SUM(c.numa) as numa,SUM(u.nums) as nums,ui.TelephonistGroupId as name ,SUM(cu.numm) as numm"+
			"	from  "+
				"	(SELECT   COUNT(id) AS numa, AgentId "+
				"	FROM      calllog "+
				"	WHERE    AgentId LIKE '3%' AND HangUpTime between  convert(varchar(100),'"+startTime+"',25) and convert(varchar(100),'"+endTime+"',25) and TalkDuration>59 "+ 
				"	GROUP BY AgentId "+
				" ) c, "+
				"	(SELECT   COUNT(id) AS nums, AgentId "+
				"	FROM      calllog "+
				"	WHERE    AgentId LIKE '3%' AND  HangUpTime between  convert(varchar(100),'"+startTime+"',25) and convert(varchar(100),'"+endTime+"',25)  "+
				"	GROUP BY AgentId) u, "+
				
				"(SELECT   SUM(TalkDuration) AS numm, AgentId "+
				"		FROM      calllog "+
				"		WHERE    AgentId LIKE '3%'  AND  HangUpTime between  convert(varchar(100),'"+startTime+"',25) and convert(varchar(100),'"+endTime+"',25) "+
				"		GROUP BY AgentId) cu, "+
				
				
				
				"    UserInfo  ui "+
				
				
				" where  c.AgentId=u.AgentId and c.AgentId=ui.LoginName and c.AgentId=cu.AgentId and ui.TelephonistGroupId='"+name+"' GROUP BY ui.TelephonistGroupId"
			
				
		);

		final String sql=hql.toString();
		//System.out.println("sql2: "+sql);
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createSQLQuery(sql);//没有实体类查询  createSQLQuery
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	
	//通话时长统计
	public List findJtlgrp(Calllog c,int pageSize, int startRow)throws HibernateException {
		
		Date d=new Date();	
		String format = "yyyy" + "/" + "MM" + "/" + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String t=null;
		String startTime=null;
		 String endTime=null;
		if("1".equals(c.getTimetype())){
			t=sdf.format(d);
			startTime = t + " 00:00:00";
		    endTime = t + " 23:59:59";
		}else if("2".equals(c.getTimetype())){			
			t=sdf.format(CommonUtil.getMondayOfThisWeek());//周一
			startTime = t + " 00:00:00";
			t=sdf.format(CommonUtil.getSundayOfThisWeek());//周日
			 endTime = t + " 23:59:59";
		}else if("3".equals(c.getTimetype())){
			t=sdf.format(CommonUtil.getdayOfMonth());
			startTime = t + " 00:00:00";
			t=sdf.format(CommonUtil.getdaysOfMonth());
			endTime = t + " 23:59:59";
		}
		List list =null;
		
		StringBuffer hql=new StringBuffer(
//
			"	SELECT SUM(c.numa) as numa,SUM(u.nums) as nums,ui.TelephonistGroupId as name ,SUM(cu.numm) as numm"+
			"	from  "+
				"	(SELECT   COUNT(id) AS numa, AgentId "+
				"	FROM      calllog "+
				"	WHERE    AgentId LIKE '3%' AND HangUpTime between  convert(varchar(100),'"+startTime+"',25) and convert(varchar(100),'"+endTime+"',25) and TalkDuration>59 "+ 
				"	GROUP BY AgentId "+
				" ) c, "+
				"	(SELECT   COUNT(id) AS nums, AgentId "+
				"	FROM      calllog "+
				"	WHERE    AgentId LIKE '3%' AND  HangUpTime between  convert(varchar(100),'"+startTime+"',25) and convert(varchar(100),'"+endTime+"',25)  "+
				"	GROUP BY AgentId) u, "+
				
				"(SELECT   SUM(TalkDuration) AS numm, AgentId "+
				"		FROM      calllog "+
				"		WHERE    AgentId LIKE '3%'  AND  HangUpTime between  convert(varchar(100),'"+startTime+"',25) and convert(varchar(100),'"+endTime+"',25) "+
				"		GROUP BY AgentId) cu, "+
				
				
				
				"    UserInfo  ui "+
				
				
				" where  c.AgentId=u.AgentId and c.AgentId=ui.LoginName and c.AgentId=cu.AgentId GROUP BY ui.TelephonistGroupId  order by numa desc"
				
//				
//				
//				"	SELECT SUM(c.numa) as numa,SUM(u.nums) as nums,ui.TelephonistGroupId as name ,SUM(cu.numm) as numm"+
//				"	from  "+
//					"	(SELECT   COUNT(c.id) AS numa, c.AgentId  as AgentId"+
//					"	FROM      calllog c,UserInfo u"+
//					"	WHERE  u.LoginName=c.AgentId and (AgentId IS NOT NULL) AND (AgentId <> '') AND c.HangUpTime between  convert(varchar(100),'"+startTime+"',25) and convert(varchar(100),'"+endTime+"',25) and c.TalkDuration>59 "+ 
//					"	GROUP BY c.AgentId "+
//					" ) c, "+
//					"	(SELECT   COUNT(c.id) AS nums, c.AgentId as AgentId"+
//					"	FROM      calllog c,UserInfo uu"+
//					"	WHERE  uu.LoginName=c.AgentId and (AgentId IS NOT NULL) AND (AgentId <> '') AND  c.HangUpTime between  convert(varchar(100),'"+startTime+"',25) and convert(varchar(100),'"+endTime+"',25)  "+
//					"	GROUP BY c.AgentId) u, "+
//					
//					"(SELECT   SUM(c.TalkDuration) AS numm, c.AgentId as AgentId "+
//					"		FROM      calllog c,UserInfo u "+
//					"		WHERE    u.LoginName=c.AgentId and (AgentId IS NOT NULL) AND (AgentId <> '') AND  c.HangUpTime between  convert(varchar(100),'"+startTime+"',25) and convert(varchar(100),'"+endTime+"',25) "+
//					"		GROUP BY c.AgentId) cu, "  +
//					
//					
//					
//					"    UserInfo  ui "+
//					
//					
//					" where  c.AgentId=u.AgentId  and c.AgentId=cu.AgentId GROUP BY ui.TelephonistGroupId  order by numa desc"
//					
//					
//

				
				
				
				
//				"select  * " +
//				
//				//"select s1.CName AS Cname,s1.success AS num,s2.sumwork AS numa" +
//				" FROM      calllog "+
//				" and HangUpTime>='"+startTime+"' and HangUpTime<'"+endTime+"'"+
//					
//				" WHERE     AgentId LIKE '3%' "
				
				
				
				
				
				
				
		);

		final String sql=hql.toString();
		//System.out.println("sql2: "+sql);
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createSQLQuery(sql);//没有实体类查询  createSQLQuery
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	
	
	
	
	
	//通话时长统计(个人)
	public List findJtlGr(Calllog c,int pageSize, int startRow)throws HibernateException {
		
		Date d=new Date();	
		String format = "yyyy" + "/" + "MM" + "/" + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String t=null;
		String startTime=null;
		 String endTime=null;
		if("1".equals(c.getTimetype())){
			t=sdf.format(d);
			startTime = t + " 00:00:00";
		    endTime = t + " 23:59:59";
		}else if("2".equals(c.getTimetype())){			
			t=sdf.format(CommonUtil.getMondayOfThisWeek());//周一
			startTime = t + " 00:00:00";
			t=sdf.format(CommonUtil.getSundayOfThisWeek());//周日
			 endTime = t + " 23:59:59";
		}else if("3".equals(c.getTimetype())){
			t=sdf.format(CommonUtil.getdayOfMonth());
			startTime = t + " 00:00:00";
			t=sdf.format(CommonUtil.getdaysOfMonth());
			endTime = t + " 23:59:59";
		}
		List list =null;
		
		StringBuffer hql=new StringBuffer(

			"	SELECT c.numa as numa,u.nums as nums,ui.CName as name,CONVERT(decimal(18, 2), c.numa)/ u.nums * 100 AS num,cu.numm as numm"+
			"	from  "+
				"	(SELECT   COUNT(id) AS numa, AgentId "+
				"	FROM      calllog "+
				"	WHERE   (AgentId LIKE '3%') AND HangUpTime between  convert(varchar(100),'"+startTime+"',25) and convert(varchar(100),'"+endTime+"',25) and TalkDuration>59 "+ 
				"	GROUP BY AgentId "+
				" ) c "+
				
				" where  c.AgentId=u.AgentId and c.AgentId=ui.LoginName and c.AgentId=cu.AgentId order by numa desc"
				

				
				
				
				
				
				
		);

		final String sql=hql.toString();
//System.out.println("sql: "+sql);
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createSQLQuery(sql);//没有实体类查询  createSQLQuery
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	
	public int getMessage(String nid) throws HibernateException {
		Date d=new Date();	
		String format = "yyyy" + "/" + "MM" + "/" + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String t=null;
		String startTime=null;
		 String endTime=null;
		
			t=sdf.format(d);
			startTime = t + " 00:00:00";
		    endTime = t + " 23:59:59";
		
		int row = 0;
		String sql=null;		
		sql="Select COUNT(*) from Message  m where m.LoginName='" + nid + "' and m.recvDate>='"+startTime+"' and m.recvDate<'"+endTime+"'and (m.returnSelectValue  NOT LIKE '%预约办理%' and  m.returnSelectValue NOT LIKE '%外呼成功%')";
		List list = this.getHibernateTemplate().find(sql);
		if (list != null && list.size() > 0) {
			Iterator itr = list.iterator();
			row = Integer.parseInt(itr.next().toString());
		}
		return row;
	}	
	
	public int getMessageDate(String date,String nid) throws HibernateException {
		
		String format = "yyyy" + "/" + "MM" + "/" + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
	
		String startTime=null;
		 String endTime=null;
		
			
			startTime = date + " 00:00:00";
		    endTime = date + " 23:59:59";
		
		int row = 0;
		String sql=null;		
		sql="Select COUNT(*) from Message  m where m.LoginName='" + nid + "' and m.recvDate>='"+startTime+"' and m.recvDate<'"+endTime+"'and (m.returnSelectValue  NOT LIKE '%预约办理%' and  m.returnSelectValue NOT LIKE '%外呼成功%')";
		List list = this.getHibernateTemplate().find(sql);
		if (list != null && list.size() > 0) {
			Iterator itr = list.iterator();
			row = Integer.parseInt(itr.next().toString());
		}
		return row;
	}	
	public int getMessageGroup(String nid) throws HibernateException {
		Date d=new Date();	
		String format = "yyyy" + "/" + "MM" + "/" + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String t=null;
		String startTime=null;
		 String endTime=null;
		
			t=sdf.format(d);
			startTime = t + " 00:00:00";
		    endTime = t + " 23:59:59";
		
		int row = 0;
		String sql=null;		
		sql="Select COUNT(*) from Message  m where m.LoginName in (" + nid + ") and m.recvDate>='"+startTime+"' and m.recvDate<'"+endTime+"'and (m.returnSelectValue  NOT LIKE '%预约办理%' and  m.returnSelectValue NOT LIKE '%外呼成功%')";
		List list = this.getHibernateTemplate().find(sql);
		if (list != null && list.size() > 0) {
			Iterator itr = list.iterator();
			row = Integer.parseInt(itr.next().toString());
		}
		return row;
	}	
	public int getMessageAll() throws HibernateException {
		Date d=new Date();	
		String format = "yyyy" + "/" + "MM" + "/" + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String t=null;
		String startTime=null;
		 String endTime=null;
		
			t=sdf.format(d);
			startTime = t + " 00:00:00";
		    endTime = t + " 23:59:59";
		
		int row = 0;
		String sql=null;		
		sql="Select COUNT(*) from Message  m where m.recvDate>='"+startTime+"' and m.recvDate<'"+endTime+"' and (m.returnSelectValue  NOT LIKE '%预约办理%' and  m.returnSelectValue NOT LIKE '%外呼成功%' and   m.returnSelectValue IS NOT NULL)";	
		List list = this.getHibernateTemplate().find(sql);
		if (list != null && list.size() > 0) {
			Iterator itr = list.iterator();
			row = Integer.parseInt(itr.next().toString());
		}
		return row;
	}	
}
