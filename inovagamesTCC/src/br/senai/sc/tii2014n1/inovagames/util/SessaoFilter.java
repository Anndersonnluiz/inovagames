package br.senai.sc.tii2014n1.inovagames.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senai.sc.tii2014n1.inovagames.managebean.SessaoMB;






@WebFilter
public class SessaoFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		SessaoMB sessaoMB = (SessaoMB) httpServletRequest.getSession().getAttribute("sessaoMB");
		
		if (sessaoMB == null || !sessaoMB.estaLogado()) {
			HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath().concat("/index.xhtml?erro"));
			return;
			
		}
		filterChain.doFilter(servletRequest, servletResponse);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}	
	
}
