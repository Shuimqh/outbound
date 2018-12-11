package com.company.data.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.company.data.dao.iface.IPgDao;

public class PgDao extends HibernateDaoSupport implements IPgDao{
	
	// ͳ��ÿ�����ŵ�ͨ��ʱ��
	public List findth(String gh, String date) {	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  // HH:mm:ss		 
		java.util.Date d = new java.util.Date();
		String day = df.format(d);
		Session session = this.getSession();		
		String startTime = null;
		String endTime = null;		 
		startTime = date + " 00:00:00";
		endTime = date + " 23:59:59";
		StringBuffer hql = new StringBuffer(				
				"select sum(billsec) as s, substring(cc_agent, 0, 5) as gh from cdr " + 
				"where cc_agent is not null and start_stamp > '" + startTime + 
				"' and start_stamp < '" + endTime + 
				"'  and substring(cc_agent, 0, 5) IN(" + gh + ")" +
				" group by substring(cc_agent,0,5) order by s desc"
		);
		final String sql = hql.toString();
		try {
			List <Object[]> list = session.createSQLQuery(sql).list();
			return list;
		} finally {
			releaseSession(session); //�ͷ�session
		}
	}
	
	// 根据时间段统计当日通话时长
	public List findth(String gh, String startTime, String endTime) {	
		Session session = this.getSession();		
		StringBuffer hql = new StringBuffer(				
				"select sum(billsec) as s, substring(cc_agent, 0, 5) as gh from cdr " + 
				"where cc_agent is not null and start_stamp > '" + startTime + 
				"' and start_stamp < '" + endTime + 
				"'  and substring(cc_agent, 0, 5) IN(" + gh + ")" +
				" group by substring(cc_agent,0,5) order by s desc"
		);
		final String sql = hql.toString();
		try {
			List <Object[]> list = session.createSQLQuery(sql).list();
			return list;
		} finally {
			releaseSession(session); //�ͷ�session
		}
	}
	/*
	 * 
	 * ����ʱ��ͳ��Ա����ͨ��ʱ��
	 */

	public List findth(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  // HH:mm:ss		 
		java.util.Date d = new java.util.Date();
		String day = df.format(d);
		
		Session session = this.getSession();
		StringBuffer hql=new StringBuffer(
				
			"select sum(billsec) as s, substring(cc_agent,0,5) as gh from cdr where cc_agent is not null and start_stamp>'"+day+"'  "+
			"group by substring(cc_agent,0,5)"+
			"order by s desc"

			
			
			);
		final String sql=hql.toString();
		
		// List<Object[]> list = getSession().createSQLQuery(sql).list(); 
		
		try {
			List <Object[]> list = session.createSQLQuery(sql).list();
			return list;
			} finally {
			releaseSession(session); //�ͷ�session
			}
	    //    return list;
	}
	
	// ���ݹ��Ų�ѯ10086��10085��¼������
	 public int getnotth(String gh) {    
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  // HH:mm:ss		 
			java.util.Date d = new java.util.Date();
			String day = df.format(d);			
			Session session = this.getSession();		
	        String sql = "select count(*) from cdr " + 
	        			 "where cc_agent is not null " + 
	        			 "and start_stamp > '" + day + "' " + 
	        			 "and ani like '%10085' " + 
	        			 "and substring(cc_agent, 0, 5) = '" + gh + "'";   	        	        
	        try {
				int count = ((Number) session.createSQLQuery(sql).uniqueResult()).intValue();
				return count;
			} finally {
				releaseSession(session); //�ͷ�session
			}
	   } 
	 
	 // 获取10085记录数
	 public int getnotth(String gh, String startTime, String endTime) {    
			Session session = this.getSession();		
	        String sql = "select count(*) from cdr " + 
	        			 "where cc_agent is not null " + 
	        			 "and start_stamp > '" + startTime + "' " + "and start_stamp < '" + endTime + "' " +
	        			 "and ani like '%10085' " + 
	        			 "and substring(cc_agent, 0, 5) = '" + gh + "'";   	        	        
	        try {
				int count = ((Number) session.createSQLQuery(sql).uniqueResult()).intValue();
				
				return count;
			} finally {
				releaseSession(session); //�ͷ�session
			}
	   } 
	 
}
