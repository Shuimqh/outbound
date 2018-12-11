package com.company.data.dao.iface;

import java.util.List;

import org.hibernate.HibernateException;

import com.company.data.ho.CallItem;
import com.company.data.ho.Calllog;

public interface IBaDao {
	List findJtl(Calllog c,int pageSize, int startRow)throws HibernateException;
	List findJtlgrp(Calllog c,int pageSize, int startRow)throws HibernateException;
	List findJtlgrpName(Calllog c,int pageSize, int startRow,String name)throws HibernateException;
	int getMessage(String nid) throws HibernateException;
	int getMessageGroup(String nid) throws HibernateException;
	int getMessageAll() throws HibernateException;
	int getMessageDate(String date,String nid) throws HibernateException;
}
