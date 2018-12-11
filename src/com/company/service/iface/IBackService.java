package com.company.service.iface;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;

import com.company.data.ho.CallItem;
import com.company.data.ho.Calllog;
import com.company.data.ho.GroupInfo;
import com.company.data.ho.Gz;
import com.company.data.ho.NotePad;
import com.company.data.ho.UserInfo;
import com.company.pojos.CrawlResultPojo;





public interface IBackService {
	/**
	 * ��ѯ���ճɽ�����ÿ������Ա��
	 */
	List findAllCjl(CallItem c)throws HibernateException;
	int getAllCjlNums(CallItem c)throws HibernateException;
	List findCjl(CallItem c,int pageSize, int startRow)throws HibernateException;
	List findCjl2(CallItem c,int pageSize, int startRow)throws HibernateException;
	List findCjlByGroup(CallItem c,int pageSize, int startRow)throws HibernateException;
	void updateNews(NotePad n) throws HibernateException;
	NotePad getNews(int id) throws HibernateException;
	void addNotePad(NotePad n) throws HibernateException;
	List findNotPad(int pageSize, int startRow)throws HibernateException ;
	List findGz(int pageSize, int startRow,Gz gz)throws HibernateException;
	void addGz()throws HibernateException, IOException;
	List findCjlLdz(CallItem c,int pageSize, int startRow)throws HibernateException;
	List findJtl(Calllog c,int pageSize, int startRow);
	List findCjlly(Calllog c,int pageSize, int startRow)throws HibernateException;
	List findCjllygrp(Calllog c,int pageSize, int startRow)throws HibernateException;
	
	List findTongjiByGroup(CallItem c,int pageSize, int startRow)throws HibernateException;
	List findCjlByGroupName(CallItem c,int pageSize, int startRow)throws HibernateException;
	List findCjlGr(int pageSize, int startRow,String uid)throws HibernateException;
	
	List findHwy()throws HibernateException;
	UserInfo getUserInfo(String id) throws HibernateException;
	List findCjlGr2(int pageSize, int startRow,String uid)throws HibernateException;
	List findCjlGrDay(int pageSize, int startRow,String uid,String day)throws HibernateException;
	List findCjlGrDay2(int pageSize, int startRow,String uid,String day)throws HibernateException;
	List findCjlGrhour(int pageSize, int startRow,String uid,String day)throws HibernateException;
	List findCjlGrhour2(int pageSize, int startRow,String uid,String day)throws HibernateException;
	int getMessageAll()throws HibernateException;
	List findGroupEle(String type,String date)throws HibernateException;
	List findGroupName(String type,String date)throws HibernateException;
	List findGroupNameTime(String type,String date,String gid)throws HibernateException;
	GroupInfo getGroupInfo(String id) throws HibernateException;
	List findxx(String uid,String day)throws HibernateException;
	List findName(String type,String date,String gid)throws HibernateException;
	List findth();
	List findGroupAllName();
	
//	List findUserAllGroup(String id);
	String findUserAllGroup(String id);
	List findth(String gh,String date);
	int getUsernews(String id) throws HibernateException;
	List findTime(String type,String date)throws HibernateException;
	List findName(String type,String date)throws HibernateException;
	
	// 根据时间段统计当日通话时长
	public List findth(String gh, String startTime, String endTime);
}
