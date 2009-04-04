package jp.co.sisc.frame.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sisc.ams.domain.privilege.Privilege;
import jp.co.sisc.frame.core.constants.Constants;
import jp.co.sisc.frame.core.utils.RequestUtil;
import jp.co.sisc.frame.core.utils.armUtil;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Repository
public class AuthInterceptor extends HandlerInterceptorAdapter {
	/** 
	 * 在业务处理器处理请求之前被调用 
	 * 如果返回false 
	 *	 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 如果返回true 
	 *	执行下一个拦截器,直到所有的拦截器都执行完毕 
	 *	再执行被拦截的Controller 
	 *	然后进入拦截器链, 
	 *	从最后一个拦截器往回执行所有的postHandle() 
	 *	接着再从最后一个拦截器往回执行所有的afterCompletion() 
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//		// 用户访问的资源地址
//		String requestPath = RequestUtil.getRequestPath(request);
//		// 登陆不需要验证权限
//		if (requestPath.contains("/page/main/main.html")) {
//			return true;
//		}
//		// 未登陆或session过期
//		List userPrivilegeList = (List) request.getSession().getAttribute("user_privilege");
//		
//		if (userPrivilegeList == null) {
//			// 未登录
//			PrintWriter out = response.getWriter();
//			out.print("messages.session_out");
//			out.close();
//			return false;
//		} else {
//			// 权限验证
//			if (requestPath.contains("search") || requestPath.contains("query")) {
//				// 查询权限
//				for (int i=0; i < userPrivilegeList.size(); i++) {
//					Privilege privilege = (Privilege) userPrivilegeList.get(i);
//					if (armUtil.equals(privilege.getPrivilege_type(), Constants.PRIVILEGE_TYPE_SEARCH)
//							&& requestPath.contains(privilege.getMenu_url())) {
//						return true;
//					}
//				}
//			}
//			if (requestPath.contains("add")) {
//				// ADD权限
//				
//			}
//			PrintWriter out = response.getWriter();
//			out.print("messages.no_privilege");
//			out.close();
//			return false;
//		}
		return true;
	}
}
