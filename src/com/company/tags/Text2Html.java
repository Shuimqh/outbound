package com.company.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Text2Html extends BodyTagSupport {
	public Text2Html() {
	}

	public int doEndTag() throws javax.servlet.jsp.JspException {
		String content=bodyContent.getString();
		content=content.replaceAll(" ","&nbsp;").replaceAll("\n","<br/>");
		JspWriter out=pageContext.getOut();
		try {
			out.println(content);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}


		return EVAL_PAGE;
	}

}