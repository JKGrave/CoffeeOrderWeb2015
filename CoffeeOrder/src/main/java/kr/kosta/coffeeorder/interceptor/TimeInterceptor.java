package kr.kosta.coffeeorder.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView mav) throws Exception {
		Date time = new Date();
		StringBuilder sb = new StringBuilder();
		int hours = time.getHours();
		int minutes = time.getMinutes();
		int seconds = time.getSeconds();
		//오전 오후 구분
		if(hours >= 12 && hours < 24){
			sb.append("오후 ");
			if(hours != 12){
				hours = hours - 12;
			}
		}else {
			sb.append("오전 ");
			if(hours == 24){
				hours = 0;
			}
		}
		
		if(hours < 10){
			sb.append("0"+hours+":");
		}else{
			sb.append(hours+":");
		}
		
		if(minutes < 10){
			sb.append("0"+minutes+":");
		}else{
			sb.append(minutes+":");
		}
		if(seconds < 10){
			sb.append("0"+seconds);
		}else{
			sb.append(seconds);
		}
		mav.addObject("thisTime", sb);
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
