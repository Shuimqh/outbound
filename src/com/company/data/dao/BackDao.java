package com.company.data.dao;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.company.data.dao.iface.IBackDao;
import com.company.data.ho.CallItem;
import com.company.data.ho.GroupInfo;
import com.company.data.ho.Gz;
import com.company.data.ho.UserInfo;


import com.company.data.ho.NotePad;
import com.company.util.CommonUtil;

import org.hibernate.Session;    
import org.hibernate.SessionFactory;  
public class BackDao extends HibernateDaoSupport implements IBackDao {
	/**
	 * ��ѯ���ճɽ�����ÿ������Ա��
	 */
	public List findAllCjl(CallItem c)throws HibernateException {
		
		Date d=new Date();	
		String format = "yyyy" + "/" + "MM" + "/" + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String t=sdf.format(d);	
		String startTime = t + " 00:00:00";
	    String endTime = t + " 23:59:59";
		List list =null;
		StringBuffer hql=new StringBuffer("select new map(U.Cname as Cname,C.BizType as BizType,C.BizSubType as BizSubType,C.status as status,U.TelephonistGroupId as TelephonistGroupId)" +
				" FROM CallItem C,UserInfo U  where C.CreateUser=U.id "
		);
		hql.append(" and C.CreateDate>='"+startTime+"'  ");
		hql.append(" and C.CreateDate<'"+endTime+"'  ");
		if(c.getBizType()!=null){  //ҵ������Ƿ�ɽ�
			hql.append(" and C.BizType='"+c.getBizType()+"'  ");
		}
		
		//hql.append(" group by U.Cname");
		final String sql=hql.toString();
		list = this.getHibernateTemplate().find(sql);
		return list;
	}
	public int getAllCjlNums(CallItem c)throws HibernateException {
		Date d=new Date();	
		String format = "yyyy" + "/" + "MM" + "/" + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String t=sdf.format(d);	
		String startTime = t + " 00:00:00";
	    String endTime = t + " 23:59:59";
	
		StringBuffer hql=new StringBuffer("Select COUNT(*) FROM CallItem C,UserInfo U  where C.CreateUser=U.id "
		);
		hql.append(" and C.CreateDate>='"+startTime+"'  ");
		hql.append(" and C.CreateDate<'"+endTime+"'  ");
		hql.append(" and C.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') ");
		if(c.getBizType()!=null){  //ҵ������Ƿ�ɽ�
			hql.append(" and C.BizType='"+c.getBizType()+"'  ");
			
		}
		int row = 0;
		final String sql=hql.toString();
		List list = this.getHibernateTemplate().find(sql);
		row = Integer.parseInt(list.get(0).toString());
		System.out.println("row = " + row);
		/*
		if (list != null && list.size() > 0) {
			Iterator itr = list.iterator();
			row = Integer.parseInt(itr.next().toString());
		}
		*/
		return row;
	}
	
	public List findCjl(CallItem c,int pageSize, int startRow)throws HibernateException {
		
		Date d=new Date();	
		String format = "yyyy" + "/" + "MM" + "/" + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String t=null;
		String startTime=null;
		 String endTime=null;
		 System.out.println("callType = " + c.getCallType());
		if("1".equals(c.getCallType())){
			t=sdf.format(d);
			startTime = t + " 00:00:00";
		    endTime = t + " 23:59:59";
		}else if("2".equals(c.getCallType())){			
			t=sdf.format(CommonUtil.getMondayOfThisWeek());//��һ
			startTime = t + " 00:00:00";
			t=sdf.format(CommonUtil.getSundayOfThisWeek());//����
			 endTime = t + " 23:59:59";
		}else if("3".equals(c.getCallType())){
			t=sdf.format(CommonUtil.getdayOfMonth());
			startTime = t + " 00:00:00";
			t=sdf.format(CommonUtil.getdaysOfMonth());
			endTime = t + " 23:59:59";
		}else if("4".equals(c.getCallType())){
			startTime = c.getTime1() + " 00:00:00";
			endTime = c.getTime2() + " 23:59:59";
		}
		
		List list =null;

		
		
		StringBuffer hql=new StringBuffer(
			"select successtable.CName AS Cname, " +
			"successtable.success AS num, " + 
			"sumtable.sumwork AS numa," +
			"CONVERT(decimal(18, 2), successtable.success) / sumtable.sumwork * 100 AS nums, " +
			"successtablee.success  as numss, " +
			"g.CName AS GName, " +
			"successtable.loginName as loginName" +																								
			" FROM (("+
					"(select U.GroupId as GroupId, " +
					"U.Cname as Cname, " + 
					"count(C.id) as success, " +
					"u.LoginName as loginName " + 
					"from CallItem C, UserInfo U where C.CreateUser=U.id and C.CallType ='תӪҵ������'"+
					" and C.CreateDate>='"+startTime+"' and C.CreateDate<'"+endTime+"'  and C.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') "+
					" group by U.Cname,U.GroupId,u.LoginName) successtable left join" +					
					" (select U.Cname as Cname,count(C.id) as sumwork from CallItem C,UserInfo U  where C.CreateUser=U.id "+
					" and C.CreateDate>='"+startTime+"' and C.CreateDate<'"+endTime+"'  and C.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') "+
					" group by U.Cname) sumtable on successtable.Cname=sumtable.Cname) left join  "+
					
				
					
					" (select U.Cname as Cname,count(C.id) as success  from CallItem C,UserInfo U  where C.CreateUser=U.id and C.CallType ='תӪҵ������' and C.Char02='����ɹ�'"+
					" and C.CreateDate>='"+startTime+"' and C.CreateDate<'"+endTime+"'  and C.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') "+
					" group by U.Cname )  successtablee  on successtablee.Cname=sumtable.Cname ) ,GroupInfo g"+
					
					
				" where  successtable.GroupId=g.id    order by num desc "
				//	" where successtable.Cname=sumtable.Cname  and  successtable.GroupId=g.id    order by num desc "
					
				
		);
//		hql.append(" and C.CreateDate>='"+startTime+"'  ");
//		hql.append(" and C.CreateDate<'"+endTime+"'  ");
//		if(c.getBizType()!=null){  //ҵ������Ƿ�ɽ�
//			hql.append(" and C.BizType='"+c.getBizType()+"'  ");
//		}
		
	//	hql.append(" group by num desc ");
		final String sql=hql.toString();
	//	System.out.println("sql: "+sql);
//		list = this.getHibernateTemplate().find(sql);
//		return list;
		
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createSQLQuery(sql);//û��ʵ�����ѯ  createSQLQuery
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	
	
	
public List findCjl2(CallItem c,int pageSize, int startRow)throws HibernateException {
	
		Date d=new Date();	
		String format = "yyyy" + "/" + "MM" + "/" + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String t=null;
		String startTime=null;
		 String endTime=null;
		if("1".equals(c.getCallType())){
			t=sdf.format(d);
			startTime = t + " 00:00:00";
		    endTime = t + " 23:59:59";
		}else if("2".equals(c.getCallType())){			
			t=sdf.format(CommonUtil.getMondayOfThisWeek());//��һ
			startTime = t + " 00:00:00";
			t=sdf.format(CommonUtil.getSundayOfThisWeek());//����
			 endTime = t + " 23:59:59";
		}else if("3".equals(c.getCallType())){
			t=sdf.format(CommonUtil.getdayOfMonth());
			startTime = t + " 00:00:00";
			t=sdf.format(CommonUtil.getdaysOfMonth());
			endTime = t + " 23:59:59";
		}
		
		
		List list =null;
		StringBuffer hql=new StringBuffer("select new map(U.Cname as Cname,count(*) as nums)" +
				" FROM CallItem C,UserInfo U  where C.CreateUser=U.id "
		);
		hql.append(" and C.CreateDate>='"+startTime+"'  ");
		hql.append(" and C.CreateDate<'"+endTime+"'  ");
		if(c.getBizType()!=null){  //ҵ������Ƿ�ɽ�
			hql.append(" and C.BizType='"+c.getBizType()+"'  ");
		}
		
		hql.append(" group by U.Cname order by count(*) desc");
		final String sql=hql.toString();
//		list = this.getHibernateTemplate().find(sql);
//		return list;
		
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery(sql);
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
//����С��id ��ѯ Ա������
public List findGh(String gid)throws HibernateException{
	List list = null;
	String hql = null;	
	hql = "from UserInfo u where u.GroupId='" + gid + "'";	
	list = this.getHibernateTemplate().find(hql);
	return list;
}
public List findCjlByGroup(CallItem c,int pageSize, int startRow)throws HibernateException {
	
	Date d=new Date();	
	String format = "yyyy" + "/" + "MM" + "/" + "dd";
	SimpleDateFormat sdf = new SimpleDateFormat(format);
	String t=null;
	String startTime=null;
	 String endTime=null;
	if("1".equals(c.getCallType())){
		t=sdf.format(d);
		startTime = t + " 00:00:00";
	    endTime = t + " 23:59:59";
	}else if("2".equals(c.getCallType())){			
		t=sdf.format(CommonUtil.getMondayOfThisWeek());//��һ
		startTime = t + " 00:00:00";
		t=sdf.format(CommonUtil.getSundayOfThisWeek());//����
		 endTime = t + " 23:59:59";
	}else if("3".equals(c.getCallType())){
		t=sdf.format(CommonUtil.getdayOfMonth());
		startTime = t + " 00:00:00";
		t=sdf.format(CommonUtil.getdaysOfMonth());
		endTime = t + " 23:59:59";
	}else if("4".equals(c.getCallType())){
		startTime = c.getTime1() + " 00:00:00";
		endTime = c.getTime2() + " 23:59:59";
	}
	List list =null;
	
	//'����4Gת��Ŀ�꣨��50Ԫ+60G������',
	StringBuffer hql=new StringBuffer(
			"select g.CName AS GroupId,successtable.success AS num,sumtable.sumwork AS numa,CONVERT(decimal(18, 2), successtable.success)/ sumtable.sumwork * 100 AS nums,successtablee.success as numss,successtable.GroupId as gid " +
			
			//"select s1.CName AS Cname,s1.success AS num,s2.sumwork AS numa" +
//			" FROM "+
//				" (select  U.GroupId  as GroupId,count(C.id) as success  from CallItem C,UserInfo U  where C.CreateUser=U.id and C.CallType ='תӪҵ������'"+
//				" and C.CreateDate>='"+startTime+"' and C.CreateDate<'"+endTime+"'  and c.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') "+
//				" group by  U.GroupId  )  successtable,"+
//				" (select  U.GroupId  as GroupId,count(C.id) as sumwork from CallItem C,UserInfo U  where C.CreateUser=U.id "+
//				" and C.CreateDate>='"+startTime+"' and C.CreateDate<'"+endTime+"'  and c.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') "+
//				" group by  U.GroupId  )   sumtable, "+
//				
//				" (select  U.GroupId  as GroupId,count(C.id) as success  from CallItem C,UserInfo U  where C.CreateUser=U.id and C.CallType ='תӪҵ������' and C.Char02='����ɹ�'"+
//				" and C.CreateDate>='"+startTime+"' and C.CreateDate<'"+endTime+"'  and c.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') "+
//				" group by  U.GroupId  )  successtablee,GroupInfo g"+
//				
//				
//
//				
//			" where successtable.GroupId=sumtable.GroupId and successtablee.GroupId=sumtable.GroupId and successtable.GroupId=g.id order by num desc"
//			" FROM (("+
//			" (select U.GroupId as GroupId,U.Cname as Cname,count(C.id) as success  from CallItem C,UserInfo U  where C.CreateUser=U.id and C.CallType ='תӪҵ������'"+
//			" and C.CreateDate>='"+startTime+"' and C.CreateDate<'"+endTime+"'  and C.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') "+
//			" group by U.Cname,U.GroupId )  successtable left join"+
//			
//			" (select U.Cname as Cname,count(C.id) as sumwork from CallItem C,UserInfo U  where C.CreateUser=U.id "+
//			" and C.CreateDate>='"+startTime+"' and C.CreateDate<'"+endTime+"'  and C.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') "+
//			" group by U.Cname )   sumtable on successtable.Cname=sumtable.Cname ) left join  "+
//			
//		
//			
//			" (select U.Cname as Cname,count(C.id) as success  from CallItem C,UserInfo U  where C.CreateUser=U.id and C.CallType ='תӪҵ������' and C.Char02='����ɹ�'"+
//			" and C.CreateDate>='"+startTime+"' and C.CreateDate<'"+endTime+"'  and C.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') "+
//			" group by U.Cname )  successtablee  on successtablee.Cname=sumtable.Cname ) ,GroupInfo g"+
//			
//			
//		" where  successtable.GroupId=g.id    order by num desc "
//			
				
				" FROM (("+
				" (select  U.GroupId  as GroupId,count(C.id) as success  from CallItem C,UserInfo U  where C.CreateUser=U.id and C.CallType ='תӪҵ������'"+
				" and C.CreateDate>='"+startTime+"' and C.CreateDate<'"+endTime+"'  and c.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') "+
				" group by  U.GroupId  )  successtable left join"+
				" (select  U.GroupId  as GroupId,count(C.id) as sumwork from CallItem C,UserInfo U  where C.CreateUser=U.id "+
				" and C.CreateDate>='"+startTime+"' and C.CreateDate<'"+endTime+"'  and c.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') "+
				" group by  U.GroupId  )   sumtable on successtable.GroupId=sumtable.GroupId ) left join"+
				
				" (select  U.GroupId  as GroupId,count(C.id) as success  from CallItem C,UserInfo U  where C.CreateUser=U.id and C.CallType ='תӪҵ������' and C.Char02='����ɹ�'"+
				" and C.CreateDate>='"+startTime+"' and C.CreateDate<'"+endTime+"'  and c.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') "+
				" group by  U.GroupId  )  successtablee on successtablee.GroupId=sumtable.GroupId) left join   GroupInfo g"+
				
				

				
			" on  successtable.GroupId=g.id order by num desc"
			
	);
	
	
//	StringBuffer hql=new StringBuffer("select new map(U.TelephonistGroupId as TelephonistGroupId,count(*) as nums)" +
//			" FROM CallItem C,UserInfo U  where C.CreateUser=U.id "
//	);
//	hql.append(" and C.CreateDate>='"+startTime+"'  ");
//	hql.append(" and C.CreateDate<'"+endTime+"'  ");
//	if(c.getBizType()!=null){  //ҵ������Ƿ�ɽ�
//		hql.append(" and C.BizType='"+c.getBizType()+"'  ");
//	}
//	
//	hql.append(" group by U.TelephonistGroupId ");
	final String sql=hql.toString();
//	list = this.getHibernateTemplate().find(sql);
//	return list;
	
	final int pageSize1 = pageSize;
	final int startRow1 = startRow;
	return this.getHibernateTemplate().executeFind(new HibernateCallback() {
		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query query = session
					.createSQLQuery(sql);
			query.setFirstResult(startRow1);
			query.setMaxResults(pageSize1);
			return query.list();
		}
	});
}
/**
 * ������Ϣ
 */
public void addNotePad(Object o) throws HibernateException {

	this.getHibernateTemplate().save(o);
}
/**
 * ������Ϣ
 */
public void updateNews(NotePad n) throws HibernateException {
	this.getHibernateTemplate().update(n);
}	

/**
 * ����ID��ѯ��������
 */
public NotePad getNews(int id) throws HibernateException {
	NotePad n = null;
	String sql = "from NotePad where id='" + id + "'";
	List list = this.getHibernateTemplate().find(sql);
	if (list != null && list.size() > 0) {
		n = (NotePad) list.get(0);
	}
	return n;
}
/**
 * ��ѯԱ������
 */
public List findGz(int pageSize, int startRow,Gz gz)throws HibernateException {	
	StringBuffer hql = new StringBuffer("from Gz g");
	if(gz.getType()!=null){
		hql.append(" where g.type='" +gz.getType() + "' ");
	}
	if(gz.getBk1()!=null){
		hql.append(" where g.bk1='" +gz.getBk1() + "' ");
	}
	hql.append(" order by g.gz desc");
	final String sql=hql.toString();
	final int pageSize1 = pageSize;
	final int startRow1 = startRow;
	return this.getHibernateTemplate().executeFind(new HibernateCallback() {
		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query query = session
					.createQuery(sql);
			query.setFirstResult(startRow1);
			query.setMaxResults(pageSize1);
			return query.list();
		}
	});
}
/**
 * ��ѯ��������Ϣ
 */
public List findNotPad(int pageSize, int startRow)throws HibernateException {
	final int pageSize1 = pageSize;
	final int startRow1 = startRow;
	return this.getHibernateTemplate().executeFind(new HibernateCallback() {
		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query query = session
					.createQuery("from NotePad order by id desc");
			query.setFirstResult(startRow1);
			query.setMaxResults(pageSize1);
			return query.list();
		}
	});
}



//¼��Ա��¼����
public List findCjlLdz(CallItem c,int pageSize, int startRow)throws HibernateException {
	
	Date d=new Date();	
	String format = "yyyy" + "/" + "MM" + "/" + "dd";
	SimpleDateFormat sdf = new SimpleDateFormat(format);
	String t=null;
	String startTime=null;
	 String endTime=null;
	if("1".equals(c.getCallType())){
		t=sdf.format(d);
		startTime = t + " 00:00:00";
	    endTime = t + " 23:59:59";
	}else if("2".equals(c.getCallType())){			
		t=sdf.format(CommonUtil.getMondayOfThisWeek());//��һ
		startTime = t + " 00:00:00";
		t=sdf.format(CommonUtil.getSundayOfThisWeek());//����
		 endTime = t + " 23:59:59";
	}else if("3".equals(c.getCallType())){
		t=sdf.format(CommonUtil.getdayOfMonth());
		startTime = t + " 00:00:00";
		t=sdf.format(CommonUtil.getdaysOfMonth());
		endTime = t + " 23:59:59";
	}
	List list =null;
	
	
	StringBuffer hql=new StringBuffer(
//			"select C.Char05 as Char05,count(C.id) as num from CallItem C where C.CallType ='תӪҵ������' "+
//			" and C.CreateDate>='"+startTime+"' and C.CreateDate<'"+endTime+"'"+
//			" group by C.Char05 order by num desc"

			
			"select successtable.Char05 AS Char05,successtable.num AS num,sumtable.num AS numa" +
			
			//"select s1.CName AS Cname,s1.success AS num,s2.sumwork AS numa" +
			" FROM "+
				" (select C.Char05 as Char05,count(C.id) as num  from CallItem C  where C.CallType ='תӪҵ������' and C.Char02='����ɹ�'"+
				" and C.Date03>='"+startTime+"' and C.Date03<'"+endTime+"'"+
				" group by  C.Char05 )  successtable,"+
				" (select C.Char05 as Char05,count(C.id) as num  from CallItem C  where C.CallType ='תӪҵ������' "+
				" and C.Date03>='"+startTime+"' and C.Date03<'"+endTime+"'"+
				" group by  C.Char05  )   sumtable "+
				
			" where successtable.Char05=sumtable.Char05 order by num desc "
			
			
	);
	final String sql=hql.toString();
	//System.out.println("sql: "+sql);
	final int pageSize1 = pageSize;
	final int startRow1 = startRow;
	return this.getHibernateTemplate().executeFind(new HibernateCallback() {
		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query query = session
					.createSQLQuery(sql);//û��ʵ�����ѯ  createSQLQuery
			query.setFirstResult(startRow1);
			query.setMaxResults(pageSize1);
			return query.list();
		}
	});
}



//����Ա��ID��ѯ������Ա�ɽ��������·ݣ�

public List findCjlGr(int pageSize, int startRow,String uid)throws HibernateException {
	StringBuffer hql=new StringBuffer(
			
				" select  convert(nvarchar(7),CreateDate,120)  as mon, count(C.id) as success  from CallItem C  where C.CreateUser= '"+uid+"' and C.CallType ='תӪҵ������'"+
				"  and C.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') group by convert(nvarchar(7),CreateDate,120)  "+
				"   ORDER BY mon  "
			
			
	);


	final String sql=hql.toString();
	

	
	final int pageSize1 = pageSize;
	final int startRow1 = startRow;
	return this.getHibernateTemplate().executeFind(new HibernateCallback() {
		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query query = session
					.createSQLQuery(sql);//û��ʵ�����ѯ  createSQLQuery
			query.setFirstResult(startRow1);
			query.setMaxResults(pageSize1);
			return query.list();
		}
	});
}
//��ĳС����Ա����������ʱ���ѯ�ɽ���
public List findGroupNameTime(String type,String date,String gid)throws HibernateException{
	int n=0;
	if("1".equals(type)){
		n=4;//����
	}else if("2".equals(type)){
		n=7;//����
	}else if("3".equals(type)){
		n=10;//����
	}else if("4".equals(type)){
		n=13;//��Сʱ
	}
//	StringBuffer hql=new StringBuffer(
//			
//			"select   U.Cname  as Cname ,count(C.id) as success,convert(nvarchar("+n+"),C.CreateDate,120)  as mon,U.id  from CallItem C,UserInfo U,GroupInfo g  where C.CreateUser=U.id and U.GroupId='"+gid+"' and U.GroupId=g.id"+" and C.CallType ='תӪҵ������'"+
//			
//			" group by convert(nvarchar("+n+"),C.CreateDate,120),U.Cname,U.id" +
//			" having convert(nvarchar("+n+"),C.CreateDate,120) like '%"+date+"%'"
//			//"   ORDER BY mon  "		
//			
//			);	
	
	StringBuffer hql=new StringBuffer(
	" SELECT a.Cname,a.success,a.mon,a.id,b.success as success1,a.LoginName  from "+

	"(select   U.Cname  as Cname ,count(C.id) as success,convert(nvarchar("+n+"),C.CreateDate,120)  as mon,U.id ,U.LoginName as LoginName from CallItem C,UserInfo U,GroupInfo g "+
	" where C.CreateUser=U.id and U.GroupId='"+gid+"' and U.GroupId=g.id and C.CallType ='תӪҵ������' "+
	" group by convert(nvarchar("+n+"),C.CreateDate,120),U.Cname,U.id,U.LoginName having convert(nvarchar("+n+"),C.CreateDate,120) like '%"+date+"%'"+
	" ) a  left join "+

	"(select   U1.Cname  as Cname ,count(C1.id) as success,convert(nvarchar("+n+"),C1.CreateDate,120)  as mon,U1.id  from CallItem C1,UserInfo U1,GroupInfo g1 "+
	" where C1.CreateUser=U1.id and U1.GroupId='"+gid+"' and U1.GroupId=g1.id "+ 
	" group by convert(nvarchar("+n+"),C1.CreateDate,120),U1.Cname,U1.id having convert(nvarchar("+n+"),C1.CreateDate,120) like '%"+date+"%'"+
	" ) b  "+

	" on a.id=b.id" +" order by a.success DESC"
	
	);

	
	

	final String sql=hql.toString();	
	final int pageSize1 = 100;
	final int startRow1 = 0;
	return this.getHibernateTemplate().executeFind(new HibernateCallback() {
		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query query = session
					.createSQLQuery(sql);//û��ʵ�����ѯ  createSQLQuery
			query.setFirstResult(startRow1);
			query.setMaxResults(pageSize1);
			return query.list();
		}
	});
}


//��С�����ƣ�����ʱ���ѯ�ɽ���
public List findGroupTime(String type,String date)throws HibernateException{
	int n=0;
	if("1".equals(type)){
		n=4;//����
	}else if("2".equals(type)){
		n=7;//����
	}else if("3".equals(type)){
		n=10;//����
	}else if("4".equals(type)){
		n=13;//��Сʱ
	}
	StringBuffer hql=new StringBuffer(
			
			"select   g.Cname  as Cname ,count(C.id) as success,convert(nvarchar("+n+"),C.CreateDate,120)  as mon,g.id as id  from CallItem C,UserInfo U,GroupInfo g  where C.CreateUser=U.id  and U.GroupId=g.id"+" and C.CallType ='תӪҵ������'"+
			
			" group by convert(nvarchar("+n+"),C.CreateDate,120),g.Cname,g.id" +
			" having convert(nvarchar("+n+"),C.CreateDate,120) like '%"+date+"%'"
			//+"   ORDER BY success DESC  "		
			
			);	

	final String sql=hql.toString();	
	final int pageSize1 = 100;
	final int startRow1 = 0;
	return this.getHibernateTemplate().executeFind(new HibernateCallback() {
		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query query = session
					.createSQLQuery(sql);//û��ʵ�����ѯ  createSQLQuery
			query.setFirstResult(startRow1);
			query.setMaxResults(pageSize1);
			return query.list();
		}
	});
}
//ĳС�鰴�³ɽ�����ѯ
public List findGroupEle(int groupId)throws HibernateException{		
	StringBuffer hql=new StringBuffer(
			"select  convert(nvarchar(7),C.CreateDate,120)  as mon,count(C.id) as success, U.GroupId  as GroupId from CallItem C,UserInfo U  where C.CreateUser=U.id "+" and C.CallType ='תӪҵ������'"+
			
			" group by convert(nvarchar(7),C.CreateDate,120),GroupId" +
			" having U.GroupId="+groupId+
			"   ORDER BY mon  "		
			
			);	

	final String sql=hql.toString();	
	final int pageSize1 = 100;
	final int startRow1 = 0;
	return this.getHibernateTemplate().executeFind(new HibernateCallback() {
		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query query = session
					.createSQLQuery(sql);//û��ʵ�����ѯ  createSQLQuery
			query.setFirstResult(startRow1);
			query.setMaxResults(pageSize1);
			return query.list();
		}
	});
	
}

//��ѯ����Ա List findCjl
public List findHwy()throws HibernateException{
	String sql = "from UserInfo where TelephonistGroupId IS NOT NULL and TelephonistGroupId <>''";
	List list = this.getHibernateTemplate().find(sql);
	return list;
}
//����id ��ѯԱ������
public UserInfo getUserInfo(String id)throws HibernateException{
	UserInfo n = null;
	String sql = "from UserInfo where id='" + id + "'";
	List list = this.getHibernateTemplate().find(sql);
	if (list != null && list.size() > 0) {
		n = (UserInfo) list.get(0);
	}
	return n;
}


//���ݹ��� ��ѯԱ������
public UserInfo getUserInfoGh(String id)throws HibernateException{
	UserInfo n = null;
	String sql = "from UserInfo where LoginName='" + id + "'";
	List list = this.getHibernateTemplate().find(sql);
	if (list != null && list.size() > 0) {
		n = (UserInfo) list.get(0);
	}
	return n;
}
//����ID��ѯ����
public GroupInfo getGroupInfo(String id)throws HibernateException{
	GroupInfo g = null;
	String sql = "from GroupInfo where id='" + id + "'";
	List list = this.getHibernateTemplate().find(sql);
	if (list != null && list.size() > 0) {
		g = (GroupInfo) list.get(0);
	}
	return g;
}

//����Ա��ID��ѯ������Ա�ɽ��������죩

public List findCjlGrDay(int pageSize, int startRow,String uid,String day)throws HibernateException {
	

	Date d=new Date();	
	String format = "yyyy" + "/" + "MM" ;
	SimpleDateFormat sdf = new SimpleDateFormat(format);
	String t=null;
	String startTime=null;
	 String endTime=null;

		
		startTime ="2018/09/01" + " 00:00:00";
	    endTime = "2018/09/01" + " 23:59:59";
	
	    
	StringBuffer hql=new StringBuffer(
			
				" select  convert(nvarchar(10),CreateDate,120)  as mon, count(C.id) as success  from CallItem C  where C.CreateUser= '"+uid+"' and C.CallType ='תӪҵ������'"+
				"   and C.BizSubType not in('��2����3.3��G�������Զ��ر�','��1����10G�����������Զ��ر�','��3����ҹ�������������ڲ��Զ��ر�','����4Gת��Ŀ��','����4Gת��Ŀ��(�ѻ���δ�����ܣ�','����4Gת��Ŀ�꣨δ������','��3G*7����','��2G*7����','4G�������û���6G����','����4Gת��Ŀ�꣨�ض�Ŀ����52G������','����4Gת��Ŀ��') group by convert(nvarchar(10),CreateDate,120)  "+
				" having convert(nvarchar(10),CreateDate,120) like   '"+day+"%' "+
				"   ORDER BY mon  "
			
			
	);

	final String sql=hql.toString();
	//System.out.println("sql: "+sql);

	
	final int pageSize1 = pageSize;
	final int startRow1 = startRow;
	return this.getHibernateTemplate().executeFind(new HibernateCallback() {
		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query query = session
					.createSQLQuery(sql);//û��ʵ�����ѯ  createSQLQuery
			query.setFirstResult(startRow1);
			query.setMaxResults(pageSize1);
			return query.list();
		}
	});
}

//����Ա��ID��ѯ������Ա�ɽ�������Сʱ��

public List findCjlGrhour(int pageSize, int startRow,String uid,String day)throws HibernateException {
	    
	StringBuffer hql=new StringBuffer(
			
				" select  convert(nvarchar(13),CreateDate,120)  as mon, count(C.id) as success  from CallItem C  where C.CreateUser= '"+uid+"' and C.CallType ='תӪҵ������'"+
				" group by convert(nvarchar(13),CreateDate,120)  "+
				" having convert(nvarchar(13),CreateDate,120) like   '"+day+"%' "+
				"   ORDER BY mon  "
			
			
	);

	final String sql=hql.toString();
	//System.out.println("sql: "+sql);

	
	final int pageSize1 = pageSize;
	final int startRow1 = startRow;
	return this.getHibernateTemplate().executeFind(new HibernateCallback() {
		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query query = session
					.createSQLQuery(sql);//û��ʵ�����ѯ  createSQLQuery
			query.setFirstResult(startRow1);
			query.setMaxResults(pageSize1);
			return query.list();
		}
	});
}
/**
 * ĳ��Ա��һСʱ�ڵ���ϸ��Ϣ
 */
	public List findxx(String uid,String day){
		StringBuffer hql=new StringBuffer(
				
			"SELECT     c.BizSubType, c.AgentUser, c.TaskId, c.CustomerId, c.CreateDate, c.CreateUser, ti.TaskId AS Expr1, t.TaskName" +
			" FROM         CallItem AS c INNER JOIN  TaskItem AS ti ON c.TaskId = ti.Id INNER JOIN Task AS t ON ti.TaskId = t.Id" +
			" WHERE     (c.BizType = 'ҵ�����') AND (c.CreateUser =  '"+uid+"') AND (CONVERT(nvarchar(13), c.CreateDate, 120) LIKE '"+day+"%')"	
			+" order by c.CreateDate DESC"
			
			);
		final String sql=hql.toString();
		
		 List<Object[]> list = getSession().createSQLQuery(sql).list();    
	        return list;
	}
	/**
	 * ��ѯ����������
	 */	
	
	public List findGroupAllName()throws HibernateException{
		// String sql = "from GroupInfo where ParentId in ('8','1','19')";
		String sql = "from GroupInfo where ParentId in(8, 1, 19) and Id not in(5, 6, 7, 8, 9, 15, 20, 35)";
		List list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/**
	 * ����С��id��ѯ��Ա
	 */
	public List findUserAllGroup(String id) throws HibernateException {
		String sql = "from UserInfo where GroupId='"+id+"'";
		List list = this.getHibernateTemplate().find(sql);
		return list;
	}
	
	/**
	 * ����С��id��ѯ��Ա����
	 */
	public int getUsernews(String id) throws HibernateException {
		int row = 0;
		String sql=null;		
		sql="Select COUNT(*) from UserInfo  u where u.GroupId='" + id + "'";	
		List list = this.getHibernateTemplate().find(sql);
		if (list != null && list.size() > 0) {
			Iterator itr = list.iterator();
			row = Integer.parseInt(itr.next().toString());
		}
		return row;
	}
	/**
	 * ����ʱ�䡢ͳ�Ƴɽ�����ȫ�塢С�顢���ˣ�
	 */
	public List findTime(String type,String date)throws HibernateException{
		int n=0;
		if("1".equals(type)){
			n=4;//����
		}else if("2".equals(type)){
			n=7;//����
		}else if("3".equals(type)){
			n=10;//����
		}else if("4".equals(type)){
			n=13;//��Сʱ
		}
		
		StringBuffer hql=new StringBuffer(				
				"select  count(C.id) as success,convert(nvarchar("+n+"),C.CreateDate,120)  as mon  from CallItem C where  C.CallType ='תӪҵ������'"+				
				" group by convert(nvarchar("+n+"),C.CreateDate,120)" +
				" having convert(nvarchar("+n+"),C.CreateDate,120) like '%"+date+"%'"
				+"   ORDER BY convert(nvarchar("+n+"),C.CreateDate,120) ASC  "					
				);	

		final String sql=hql.toString();	
		final int pageSize1 = 100;
		final int startRow1 = 0;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createSQLQuery(sql);//û��ʵ�����ѯ  createSQLQuery
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	//������Ŀ���Ʋ�ѯ�ɽ���
	public List findName(String type,String date)throws HibernateException{
		int n=0;
		if("1".equals(type)){
			n=4;//����
		}else if("2".equals(type)){
			n=7;//����
		}else if("3".equals(type)){
			n=10;//����
		}else if("4".equals(type)){
			n=13;//��Сʱ
		}
		StringBuffer hql=new StringBuffer(
				
				//"SELECT     c.BizSubType, c.AgentUser, c.TaskId, c.CustomerId, c.CreateDate, c.CreateUser, ti.TaskId AS Expr1, t.TaskName" +
				"SELECT     count(C.id) as success, t.TaskName as name" +
				" FROM         CallItem AS c INNER JOIN  TaskItem AS ti ON c.TaskId = ti.Id INNER JOIN Task AS t ON ti.TaskId = t.Id" +
				" WHERE     (c.BizType = 'ҵ�����') AND (CONVERT(nvarchar(13), c.CreateDate, 120) LIKE '"+date+"%')"	
				
				+" group by t.TaskName " 
				+" order by success DESC"
				
				);
//			final String sql=hql.toString();
//			
//			 List<Object[]> list = getSession().createSQLQuery(sql).list();    
//		        return list;
		        
		        
//		StringBuffer hql=new StringBuffer(				
//				"select  count(C.id) as success,t.TaskName as name  from CallItem C where  C.CallType ='תӪҵ������'"+				
//				" group by convert(nvarchar("+n+"),C.CreateDate,120)" +
//				" having convert(nvarchar("+n+"),C.CreateDate,120) like '%"+date+"%'"
//				+"   ORDER BY convert(nvarchar("+n+"),C.CreateDate,120) ASC  "					
//				);	

		final String sql=hql.toString();	
		final int pageSize1 = 100;
		final int startRow1 = 0;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createSQLQuery(sql);//û��ʵ�����ѯ  createSQLQuery
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
}
