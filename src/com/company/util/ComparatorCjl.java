package com.company.util;

import java.util.Comparator;

import com.company.bean.CjlBean;

public class ComparatorCjl implements Comparator{

	
	public int compare(Object o1, Object o2) {
		CjlBean c1=(CjlBean)o1;
		CjlBean c2=(CjlBean)o2;
		Integer  n1=Integer.parseInt(c1.getNum());
		Integer  n2=Integer.parseInt(c2.getNum());
		if(n1>n2){
			return n2.compareTo(n1);
		}else if(n1==n2){
			return n2.compareTo(n1);
		}else{
			return n2.compareTo(n1);
		}
//		int num=c1.getNum().compareTo(c2.getNum());
//		if(num==0){
//			return c2.getNum().compareTo(c1.getNum());
//		}else{
//			return num;
//		}
		
	}

	
}
