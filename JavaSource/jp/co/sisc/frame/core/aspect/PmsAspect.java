package jp.co.sisc.frame.core.aspect;

import javax.servlet.http.HttpServletRequest;

import jp.co.sisc.ams.domain.privilege.PrivilegeVo;
import jp.co.sisc.frame.core.domain.BaseEntity;
import jp.co.sisc.frame.core.utils.armUtil;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 配置插入pms_i_usr等的切面（项目暂时不用）
 * @author li-nf
 */
@Aspect
@Component
public class PmsAspect {
	private final Logger log = LoggerFactory.getLogger(PmsAspect.class);
		// 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
		@Pointcut("execution(* jp.co.sisc.frame.core.dao..insert*(..)) || execution(* jp.co.sisc.frame.core.dao..update*(..))")
		public void aspect(){	
		}
		
		/*
		 * 配置前置通知,使用在方法aspect()上注册的切入点
		 * 同时接受JoinPoint切入点对象,可以没有该参数
		 */
		@Before("aspect()")
		public void before(JoinPoint joinPoint){
			log.info("配置前置通知 start:dao 的insert 或 update开头的方法被切入设定新规者或跟新者.");
			//方法的参数	
			Object[] args = joinPoint.getArgs();
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			PrivilegeVo user = (PrivilegeVo)request.getSession().getAttribute("user");
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof BaseEntity) {
					// 如果被切入的方法是insert*
					BaseEntity entity = (BaseEntity)args[i];
					if (armUtil.equals("insert", joinPoint.getSignature().getName())) {
						entity.setPms_i_class(joinPoint.getSignature().getDeclaringTypeName());
						entity.setPms_i_usr(user==null?null:user.getUser_id());
					} else {
						entity.setPms_u_class(joinPoint.getSignature().getDeclaringTypeName());
						entity.setPms_u_usr(user==null?null:user.getUser_id());
					}
				}
			}
			log.info("配置前置通知 end");
		}
		
		//配置后置通知,使用在方法aspect()上注册的切入点
		@After("aspect()")
		public void after(JoinPoint joinPoint){
		}
}
