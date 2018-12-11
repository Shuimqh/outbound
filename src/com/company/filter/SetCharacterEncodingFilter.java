package com.company.filter;

import javax.servlet.*;

/**
 * User:zxd
 * Date: 2007-5-23
 * Time: 16:39:05
 */
public class SetCharacterEncodingFilter implements Filter
{
    /** whether change request and response charset */
    private boolean allow = true;

    /** request and response charset */
    private String encode = "GBK";

    /** if charset is not correct,then go to this page */
    private String refusePage = "/refuse.htm";

    public void init(FilterConfig config)
    {
        this.encode = config.getInitParameter("encoding");
        this.refusePage = config.getInitParameter("refusePage");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    {
        try
        {
            if (this.allow)
            {
                request.setCharacterEncoding(this.encode);
                response.setContentType("text/html;charset=" + encode);

            } else
                request.getRequestDispatcher(this.refusePage).forward(request, response);
            chain.doFilter(request,response);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void destroy()
    {
    }
}
