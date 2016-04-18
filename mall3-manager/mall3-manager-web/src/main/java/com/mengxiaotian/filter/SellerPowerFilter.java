package com.mengxiaotian.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

import com.mengxiaotian.common.meta.User;

/**
 * 卖家权限控制过滤器
 * @author mengxiaotian
 */
public class SellerPowerFilter extends OncePerRequestFilter {
	private User user;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		HttpSession session =request.getSession(false);
		if(session!=null){
		user = (User) session.getAttribute("user");
		if (user != null && user.getUsertype() == 1) {
			// 如果session中存在登录者实体，且类型相符则继续
			filterChain.doFilter(request, response);
		} else {
			// 如果session中不存在登录者实体，则弹出框提示重新登录
			PrintWriter out = response.getWriter();
			String loginPage = "/login";
			StringBuilder builder = new StringBuilder();
			builder.append("<script type=\"text/javascript\">");
			builder.append("alert('please login with seller.');");
			builder.append("window.top.location.href='");
			builder.append(loginPage);
			builder.append("';");
			builder.append("</script>");
			out.print(builder.toString());
		}
		}else{
			filterChain.doFilter(request, response);
		}
		
	}

}
