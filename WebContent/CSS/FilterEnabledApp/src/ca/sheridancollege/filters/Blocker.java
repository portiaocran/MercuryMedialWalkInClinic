package ca.sheridancollege.filters;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Blocker
 */
@WebFilter("/Blocker")
public class Blocker implements Filter {
	FilterConfig fc;

    /**
     * Default constructor. 
     */
    public Blocker() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		int bHour = Integer.parseInt(fc.getInitParameter("bTime"));
		int eHour = Integer.parseInt(fc.getInitParameter("eTime"));
		Calendar c = Calendar.getInstance();
		int currentHour = c.get(Calendar.HOUR_OF_DAY);
		if (currentHour >= bHour && currentHour <= eHour)
			System.out.println("Warning! you are not allowed to access" + 
		    "this resource at the current time");
		else
			System.out.println("The server at " + request.getRemoteHost() + 
					" was accessed at " + new Date() + "from " +
					request.getRemoteAddr());

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.fc = fConfig;
	}

}
