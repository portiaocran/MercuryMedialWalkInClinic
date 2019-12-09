package ca.sheridancollege.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Logger
 */
@WebFilter("/Logger")
public class Logger implements Filter {
	private FilterConfig fc;

    /**
     * Default constructor. 
     */
    public Logger() {
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
		// TODO Auto-generated method stub
		// System.out.println("This message is from the filter!");
		HttpServletResponse myResponse = (HttpServletResponse) response;
		myResponse.getWriter().append("<div style='color:green'>" + 
		          "Hello " + request.getParameter("fname") + " a message from the filter!" + "</div>");

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fc = fConfig;
	}

}
