package com.xydz.suppliermateriallabelprintingtool.config;

//
//import com.polang.wenkebbsplus.entity.User;
//import com.polang.wenkebbsplus.service.UserService;
//import com.polang.wenkebbsplus.util.JwtUtil;
//import com.polang.wenkebbsplus.util.LoginUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        String path = request.getServletPath();
//        System.out.println("请求接口:"+path);
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");
//        response.setHeader("Access-Control-Max-Age", "86400");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type,accessToken");
//        // 如果是OPTIONS请求则结束
//        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
//            response.setStatus(HttpServletResponse.SC_ACCEPTED);
//            System.out.println("OPTIONS");
//            return false;
//        }
//        String token = request.getHeader("accessToken");
//        if (token == null){
//            throw new NoteException("请重新登录",10002);
//        }
//        //开始验证token
//        if (!JwtUtil.verify(token)){
//            throw new NoteException("请重新登录",10002);
//        }
//        User user = userService.selectUser(JwtUtil.getUsername(token));
//        System.out.println("登录用户："+user.getuName());
//        if (user==null) {
//            throw new NoteException("请重新登录",10002);
//        }
//        LoginUtil.setLoginUser(user);
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        LoginUtil.remove();
//    }
}
