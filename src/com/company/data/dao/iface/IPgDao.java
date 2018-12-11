package com.company.data.dao.iface;

import java.util.List;

public interface IPgDao {
	List findth();
	int getnotth(String gh);
	List findth(String gh,String date);
	
	// 根据时间段统计当日通话时长
	public List findth(String gh, String startTime, String endTime);
	
	// 得到10085记录数
	public int getnotth(String gh, String startTime, String endTime);
}
