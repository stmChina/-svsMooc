package jp.co.sisc.frame.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sisc.ams.domain.privilege.Privilege;
import jp.co.sisc.ams.service.privilege.IPrivilegeService;
import jp.co.sisc.frame.core.constants.Constants;
import jp.co.sisc.frame.core.utils.RequestUtil;
import jp.co.sisc.frame.core.utils.armUtil;

import org.springframework.web.context.WebApplicationContext;

public class SecurityServlet extends HttpServlet implements Filter {

	private static final long serialVersionUID = 1L;
	private ServletContext  servletContext;
	/**
	 * 过滤权限
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
			ServletException {
//		HttpServletRequest request = (HttpServletRequest) arg0;
//		HttpServletResponse response = (HttpServletResponse) arg1;
//
//		// 用户访问的资源地址
//		String requestPath = RequestUtil.getRequestPath(request);
//		// 未登陆或session过期
//		List parentMenuList = (List) request.getSession().getAttribute("parentMenuList");
//
//		if (parentMenuList == null) {
//			// 未登录
//			PrintWriter out = response.getWriter();
//			StringBuilder builder = new StringBuilder();
//			builder.append(" <script type=\"text/javascript\" charset=\"UTF-8\"> \n");
//			builder.append(" alert('Session expired.'); \n");
//			builder.append(" window.top.location.href='" + request.getContextPath() + "/index.html'");
//			builder.append(" </script>");
//			out.print(builder.toString());
//			out.close();
//			return;
//		}
//		// 程程主入口不需要验证权限
//		if (requestPath.contains("/page/main/main.html") || requestPath.contains("/login/login") ) {
//			arg2.doFilter(arg0, arg1);
//			return;
//		}
//		// 每个模块主页面的按钮权限验证
//		if (requestPath.contains("main.html")) {
//			// 查询权限
//			for (int i = 0; i < parentMenuList.size(); i++) {
//				Privilege menu = (Privilege) parentMenuList.get(i);
//				// 如果选中当前menu
//				if (armUtil.equals(menu.getMenu_url(), requestPath)) {
//					// 查询当前menu下的所有子功能
//					WebApplicationContext context =  (WebApplicationContext)servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//					IPrivilegeService service = (IPrivilegeService)context.getBean("privilegeServiceImpl");
//					List childs = service.selectPrivilegeByParent(menu);
//					for (int j = 0; j < childs.size(); j++) {
//						Privilege child = (Privilege) childs.get(j);
//						if (armUtil.equals(child.getPrivilege_type(), Constants.PRIVILEGE_TYPE_SEARCH)) {
//							Cookie cooike = new Cookie(request.getSession().getId() + "search",
//									child.getPrivilege_type());
//							response.addCookie(cooike);
//							continue;
//						}
//						if (armUtil.equals(child.getPrivilege_type(), Constants.PRIVILEGE_TYPE_ADD)) {
//							Cookie cooike = new Cookie(request.getSession().getId() + "add", child.getPrivilege_type());
//							response.addCookie(cooike);
//							continue;
//						}
//						if (armUtil.equals(child.getPrivilege_type(), Constants.PRIVILEGE_TYPE_DELETE)) {
//							Cookie cooike = new Cookie(request.getSession().getId() + "delete",
//									child.getPrivilege_type());
//							response.addCookie(cooike);
//							continue;
//						}
//						if (armUtil.equals(child.getPrivilege_type(), Constants.PRIVILEGE_TYPE_UPDATE)) {
//							Cookie cooike = new Cookie(request.getSession().getId() + "update",
//									child.getPrivilege_type());
//							response.addCookie(cooike);
//							continue;
//						}
//						if (armUtil.equals(child.getPrivilege_type(), Constants.PRIVILEGE_TYPE_EXCEL)) {
//							Cookie cooike = new Cookie(request.getSession().getId() + "excel",
//									child.getPrivilege_type());
//							response.addCookie(cooike);
//							continue;
//						}
//						if (armUtil.equals(child.getPrivilege_type(), Constants.PRIVILEGE_TYPE_PDF)) {
//							Cookie cooike = new Cookie(request.getSession().getId() + "pdf", child.getPrivilege_type());
//							response.addCookie(cooike);
//							continue;
//						}
//					}
//				}
//			}
//		}
		arg2.doFilter(arg0, arg1);
		return;
		//			if (requestPath.contains("add")) {
		//				// ADD权限
		//				for (int i=0; i < userPrivilegeList.size(); i++) {
		//					Privilege privilege = (Privilege) userPrivilegeList.get(i);
		//					if (armUtil.equals(privilege.getPrivilege_type(), Constants.PRIVILEGE_TYPE_ADD)
		//							&& armUtil.equals(privilege.getMenu_url(), requestPath)) {
		//						Cookie cooike = new Cookie(request.getSession().getId() + "privilege", privilege.getPrivilege_type());
		//						response.addCookie(cooike);
		//						arg2.doFilter(arg0, arg1);
		//						return;
		//					}
		//				}
		//			}
		//			if (requestPath.contains("updateAll")) {
		//				// EDIT,DEL,ADD权限
		//				for (int i=0; i < userPrivilegeList.size(); i++) {
		//					Privilege privilege = (Privilege) userPrivilegeList.get(i);
		//					if (armUtil.equals(privilege.getPrivilege_type(), Constants.PRIVILEGE_TYPE_UPDATE)
		//							&&armUtil.equals(privilege.getPrivilege_type(), Constants.PRIVILEGE_TYPE_ADD)
		//							&&armUtil.equals(privilege.getPrivilege_type(), Constants.PRIVILEGE_TYPE_DELETE)
		//							&& armUtil.equals(privilege.getMenu_url(), requestPath)) {
		//						Cookie cooike = new Cookie(request.getSession().getId() + "privilege", privilege.getPrivilege_type());
		//						response.addCookie(cooike);
		//						arg2.doFilter(arg0, arg1);
		//						return;
		//					}
		//				}
		//				PrintWriter out = response.getWriter();
		//				StringBuilder builder = new StringBuilder();
		//				builder.append("保存不成功,必须有新规,编辑和删除权限");
		//				out.print(builder.toString());
		//				out.close();
		//				return;
		//			}
		//			if (requestPath.contains("del") || requestPath.contains("delete")) {
		//				// EDIT权限
		//				for (int i=0; i < userPrivilegeList.size(); i++) {
		//					Privilege privilege = (Privilege) userPrivilegeList.get(i);
		//					if (armUtil.equals(privilege.getPrivilege_type(), Constants.PRIVILEGE_TYPE_DELETE)
		//							&& armUtil.equals(privilege.getMenu_url(), requestPath)) {
		//						Cookie cooike = new Cookie(request.getSession().getId() + "privilege", privilege.getPrivilege_type());
		//						response.addCookie(cooike);
		//						arg2.doFilter(arg0, arg1);
		//						return;
		//					}
		//				}
		//			}
		//			return;
		//		HttpServletRequest request = (HttpServletRequest) arg0;
		//		String url = request.getRequestURI();
		//		// 需要进行权限验证的url
		//		if (url.contains("/security")) {
		//			// 取得权限列表
		//			List privilegeList = (List) request.getSession().getAttribute("user_privilege");
		//			/* 权限校验 */
		//			// 1:查询权限
		//			if (url.contains("search") || url.contains("query")) {
		//				boolean rst = false;
		//				for (int i=0; i < privilegeList.size(); i++) {
		//					Privilege privilege = (Privilege)privilegeList.get(i);
		//					// 权限列表中存在当前url,并且权限类型是查询权限
		//					if (armUtil.equals(privilege.getMenu_url(), url)
		//							&& armUtil.equals(privilege.getPrivilege_type(), Constants.PRIVILEGE_TYPE_SEARCH)) {
		//						rst = true;
		//						break;
		//					}
		//				}
		//				// 存在查询权限
		//				if (rst) {
		//					arg2.doFilter(arg0, arg1);
		//					return;
		//				} else {
		//					StringBuilder builder = new StringBuilder();
		//					builder.append("<script type=\"text/javascript\"\">");
		//					builder.append("alert(\"没有权限\");");
		//					arg1.getWriter().write(builder.toString());
		//				}
		//			}
		//		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		servletContext =arg0.getServletContext();
	}

}
