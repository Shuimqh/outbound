package com.company.common;

public class PagerCarService {
	public PagerCar getPager(String currentPage,String pagerMethod,int totalRows) {
		//	定义pager对象，用于传到页面
		PagerCar pagercar = new PagerCar(totalRows);
		//	如果当前页号为空，表示为首次查询该页
		//	如果不为空，则刷新pager对象，输入当前页号等信息
		if (currentPage != null) {
			pagercar.refresh(Integer.parseInt(currentPage));
		}
		//	获取当前执行的方法，首页，前一页，后一页，尾页。
		if (pagerMethod != null) {
			if (pagerMethod.equals("first")) {
				pagercar.first();
			} else if (pagerMethod.equals("previous")) {
				pagercar.previous();
			} else if (pagerMethod.equals("next")) {
				pagercar.next();
			} else if (pagerMethod.equals("last")) {
				pagercar.last();
			}
		}
		return pagercar;
	}
	
}
