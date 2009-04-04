package jp.co.sisc.ams.web.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sisc.ams.domain.privilege.Privilege;
import jp.co.sisc.ams.domain.privilege.PrivilegeVo;
import jp.co.sisc.ams.service.privilege.IPrivilegeService;
import jp.co.sisc.frame.core.constants.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

/**
 * 用户登录Controler
 * @author lnf
 */
@RestController
@RequestMapping(value = "/login")
public class LoginControler {
	@Autowired
	private IPrivilegeService privilegeService;

	@Autowired(required=true)
	private HttpServletRequest request;

	/**
	 * 用户登录
	 * @param Privilege
	 * @return Json对象
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object login(Privilege query) {
		// 查找用户是否存在
		PrivilegeVo user = privilegeService.selectUser(query);
		if (user == null) {
			// 登陆失败返回
			return Constants.FAILURE;
		} else {
			// 登陆用户的信息放入session
			request.getSession().setAttribute("user", user);
			return Constants.SUCCESS;
		}
	}

	/**
	 * Menu生成
	 * Privilege query
	 * @return Json对象
	 */
//	@RequestMapping(value = "/menu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	public Object menu(Privilege query) {
//		return JSON.toJSON(request.getSession().getAttribute("parentMenuList"));
//	}

	/**
	 * 获取服务器sessionid
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/session", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getSession(HttpServletRequest request, HttpServletResponse response) {
		return request.getSession().getId();
	}
		
//		Privilege result = new Privilege();
//		if (userPrivilegeList == null || (userPrivilegeList != null && userPrivilegeList.size() ==0)) {
//			// 登陆失败返回
//			result.setResult(Constants.FAILURE);
//		} else {
//			// 登陆成功返回主页面,权限设定保存在session中
//			request.getSession().setAttribute("user_privilege", userPrivilegeList);
//			request.getSession().setAttribute("user", request.getParameter("user_id"));
//			// Menu tree 生成
//			List<Integer> mapParentList = new ArrayList<Integer>();
//			List<Integer> mapList = new ArrayList<Integer>();
//			Integer tempMenuId = 0;
//			for (int i=0; i< userPrivilegeList.size(); i++) {
//				Privilege entity = userPrivilegeList.get(i);
//				Integer menuId = Integer.valueOf(entity.getMenu_id());
//				if (armUtils.isEmpty(entity.getMenu_pid())) {
//					// 如果当前节点没有父亲节点,那么它就是父亲节点
//					if (menuId != tempMenuId) {
//						tempMenuId = menuId;
//						mapParentList.add(menuId);
//					}
//				} 
//				// 叶子节点
//				mapList.add(menuId);
//			}
//			// 根据权限查找menu
//			Map<String, List<Integer>> queryMap = new HashMap<String, List<Integer>>();
//			queryMap.put("menuParentList", mapParentList);
//			queryMap.put("menuList", mapList);
//			List menuLst = privilegeService.selectMenuTreeByUser(queryMap);
//			// 循环menu,生成符合页面规则的菜单
//			List<Privilege> menuParentList = new ArrayList<Privilege>();
//			List<Privilege> menuChildList = new ArrayList<Privilege>();
//			Map<String, List<Privilege>> treeMap = new HashMap<String, List<Privilege>>();
//			for (int i=0; i< menuLst.size(); i++) {
//				Privilege entity = (Privilege)menuLst.get(i);
//				if (armUtils.isEmpty(entity.getMenu_pid())) {
//					// 如果当前节点没有父亲节点,那么它就是父亲节点
//					menuParentList.add(entity);
//				} else {
//					menuChildList.add(entity);
//				}
//			}
//			treeMap.put("menuParentList", menuParentList);
//			treeMap.put("menuChildList", menuChildList);
//			
//			// Menu 放入session
//			request.getSession().setAttribute("user_menu", treeMap);
//			result.setResult(Constants.SUCCESS);
//		}
//		return result;
}
