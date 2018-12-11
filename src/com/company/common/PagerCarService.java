package com.company.common;

public class PagerCarService {
	public PagerCar getPager(String currentPage,String pagerMethod,int totalRows) {
		//	����pager�������ڴ���ҳ��
		PagerCar pagercar = new PagerCar(totalRows);
		//	�����ǰҳ��Ϊ�գ���ʾΪ�״β�ѯ��ҳ
		//	�����Ϊ�գ���ˢ��pager�������뵱ǰҳ�ŵ���Ϣ
		if (currentPage != null) {
			pagercar.refresh(Integer.parseInt(currentPage));
		}
		//	��ȡ��ǰִ�еķ�������ҳ��ǰһҳ����һҳ��βҳ��
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
