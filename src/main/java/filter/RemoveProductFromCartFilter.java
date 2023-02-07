package filter;

import com.controller.CartEcommerceServlet;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RemoveProductFromCartFilter extends CartEcommerceServlet implements Filter {

    public RemoveProductFromCartFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException 
	{
		String key = (String) request.getParameter("keyforremove");
		if(key.equals("remove"))
		{
			RequestDispatcher rd = null;
			System.out.println("filter");
			rd = request.getRequestDispatcher("TempCartServlet.java");
			rd.forward(request, response);
		}
		else {			
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{}

}
