package com.yc.vote.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.yc.vate.util.VoteData;
/**
 * 用户登录拦截器
 * @author Gao Yang
 *
 */
//MethodFilterInterceptor 可以对请求方法进行过滤
public class LoginInterceptor extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1307687631270550421L;
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> session=ActionContext.getContext().getSession();//取到session的封装对象
		Object obj=session.get(VoteData.LOGIN_USER);
		if(obj==null){
			session.put(VoteData.ERROR_MSG, "请登录后再进行操作。。");
			return "login";
		}
		return invocation.invoke();
	}
	

}
