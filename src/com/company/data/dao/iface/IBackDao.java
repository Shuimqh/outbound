package com.company.data.dao.iface;

import java.util.List;
import org.hibernate.HibernateException;

import com.company.data.ho.CallItem;
import com.company.data.ho.GroupInfo;
import com.company.data.ho.Gz;
import com.company.data.ho.NotePad;
import com.company.data.ho.UserInfo;





public interface IBackDao {
	/**
	 * 查询当日成交量（每个话务员）
	 */
	List findAllCjl(CallItem c)throws HibernateException;
	int getAllCjlNums(CallItem c)throws HibernateException;
	List findCjl(CallItem c,int pageSize, int startRow)throws HibernateException ;
	List findCjl2(CallItem c,int pageSize, int startRow)throws HibernateException;
	List findCjlByGroup(CallItem c,int pageSize, int startRow)throws HibernateException;
	void addNotePad(Object o) throws HibernateException;
	void updateNews(NotePad n) throws HibernateException;
	NotePad getNews(int id) throws HibernateException;
	List findNotPad(int pageSize, int startRow)throws HibernateException;
	List findGz(int pageSize, int startRow,Gz gz)throws HibernateException;
	List findCjlLdz(CallItem c,int pageSize, int startRow)throws HibernateException;
	List findCjlGr(int pageSize, int startRow,String uid)throws HibernateException;
	List findHwy()throws HibernateException;
	UserInfo getUserInfo(String id)throws HibernateException;
	List findCjlGrDay(int pageSize, int startRow,String uid,String day)throws HibernateException;
	List findCjlGrhour(int pageSize, int startRow,String uid,String day)throws HibernateException;
	List findGh(String gid)throws HibernateException;
	List findGroupEle(int groupId)throws HibernateException;
	List findGroupTime(String type,String date)throws HibernateException;
	List findGroupNameTime(String type,String date,String gid)throws HibernateException;
	GroupInfo getGroupInfo(String id)throws HibernateException;
	List findxx(String uid,String day);
	UserInfo getUserInfoGh(String id)throws HibernateException;
	List findGroupAllName()throws HibernateException;
	List findUserAllGroup(String id)throws HibernateException;
	int getUsernews(String id) throws HibernateException;
	List findTime(String type,String date)throws HibernateException;
	List findName(String type,String date)throws HibernateException;
}
