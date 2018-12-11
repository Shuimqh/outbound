package com.company.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class SubString extends BodyTagSupport{
	private int length;     //截取的长度
	  private String status;   //判断截取后是否使用省略号,如不使用省略号，给他赋“true"
	  public void setLength(int length){
	    this.length=length;
	  }
	  public void setStatus(String status){
	    this.status=status;
	  }
	  public int doEndTag() throws JspException {
	    String content = bodyContent.getString();
	    JspWriter out = pageContext.getOut();
	    try {
	      if(content==null){
	        out.println(" ");
	      }
	      else if(content.length()<=length){
	        out.println(content);
	      }
	      else{
	        if(status==null){
	          content = content.substring(0, length) + "...";
	        }
	        else if(status.equals("true")){
	          content=content.substring(0, length);
	        }
	        out.println(content);
	      }
	    }
	    catch (IOException e) {
	   //   DBLogger.log(e.getMessage());
	    }
	    return EVAL_PAGE;
	  }
}
