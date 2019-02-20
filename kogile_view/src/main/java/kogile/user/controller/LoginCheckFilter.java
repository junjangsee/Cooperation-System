package kogile.user.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName="loginFilter")
public class LoginCheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
        Enumeration keys = (Enumeration) session.getAttributeNames();

        boolean isUserThere = false;
        while (keys.hasMoreElements())
        {
        	String key = (String)keys.nextElement();
        	if(key.equals("user")){
        		isUserThere = true;
        	}
        }
        System.out.println(((HttpServletRequest)request).getServletPath());
        if(isUserThere == false){
        	((HttpServletResponse) response).sendRedirect("/kogile/login");
        }else{
        	((HttpServletRequest)request).getRequestDispatcher("/kogile/startPage").forward(request, response);
        }

	}

	@Override
	public void destroy() {

	}

}
