package com.company.common;

public class Pager {
	private int totalRows; // 总行数

	private int pageSize = 2000; // 每页显示的行数

	private int currentPage; // 当前页号

	private int totalPages; // 总页数

	private int startRow; // 当前页在数据库中的起始行

	private boolean pageAble = true;

	public boolean isPageAble() {
		return pageAble;
	}

	public void setPageAble(boolean pageAble) {
		this.pageAble = pageAble;
	}

	public Pager() {
	}

	public Pager(int _totalRows) {
		totalRows = _totalRows;
		totalPages = totalRows / pageSize;
		int mod = totalRows % pageSize;
		if (mod > 0) {
			totalPages++;
		}
		if (0 == totalPages)
			totalPages = 1;
		currentPage = 1;
		startRow = 0;
	}

	/**
	 * @return the startRow
	 * @uml.property name="startRow"
	 */
	public int getStartRow() {
		return startRow;
	}

	/**
	 * @return the totalPages
	 * @uml.property name="totalPages"
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @return the currentPage
	 * @uml.property name="currentPage"
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @return the pageSize
	 * @uml.property name="pageSize"
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param totalRows
	 *            the totalRows to set
	 * @uml.property name="totalRows"
	 */
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	/**
	 * @param startRow
	 *            the startRow to set
	 * @uml.property name="startRow"
	 */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	/**
	 * @param totalPages
	 *            the totalPages to set
	 * @uml.property name="totalPages"
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @param currentPage
	 *            the currentPage to set
	 * @uml.property name="currentPage"
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 * @uml.property name="pageSize"
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the totalRows
	 * @uml.property name="totalRows"
	 */
	public int getTotalRows() {
		return totalRows;
	}

	public void first() {
		currentPage = 1;
		startRow = 0;
	}

	public void previous() {
		if (currentPage == 1) {
			return;
		}
		currentPage--;
		startRow = (currentPage - 1) * pageSize;
	}

	public void next() {
		if (currentPage < totalPages) {
			currentPage++;
		}
		startRow = (currentPage - 1) * pageSize;
	}

	public void last() {
		currentPage = totalPages;
		startRow = (currentPage - 1) * pageSize;
	}

	public void refresh(int _currentPage) {
		currentPage = _currentPage;
		if (currentPage > totalPages) {
			last();
		}
	}
}
