package com.xydz.suppliermateriallabelprintingtool.config;

import com.xydz.suppliermateriallabelprintingtool.entity.Login;
import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;
import com.xydz.suppliermateriallabelprintingtool.service.SuppUserService;
import com.xydz.suppliermateriallabelprintingtool.util.JwtUtil;
import com.xydz.suppliermateriallabelprintingtool.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author xiachenchen
 * @ClassName: LoginHandlerInterceptor
 * @Description: 拦截器 TODO
 * @Date 2022/11/22
*/

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private SuppUserService suppUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String path = request.getServletPath();
        System.out.println("请求接口:"+path);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "86400");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type,accessToken");
        // 如果是OPTIONS请求则结束
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
//            System.out.println("OPTIONS");
            return true;
        }
        String token = request.getHeader("accessToken");
        if (token == null){
//            throw new NoteException("请重新登录",10002);
            return false;
        }
        //验证token
        if (!JwtUtil.verify(token)){
//            throw new NoteException("请重新登录",10002);
            return false;
        }else {
            Integer state = JwtUtil.getState(token);
//            System.out.println(state);
            SuppUser suppUser = null;
            if (state == 0) {

                suppUser = suppUserService.selSupp(JwtUtil.getSuppCode(token));
                System.out.println("登录用户：admin");
                if (suppUser == null) {
                    suppUser=new SuppUser();
                    suppUser.setNAME("admin");
                    suppUser.setCODE("0");
                    suppUser.setPWD("xinyaadmin123");
                    suppUser.setSHORTNAME("admin");
                }
            } else {
                suppUser = suppUserService.selSupp(JwtUtil.getSuppCode(token));
                System.out.println("登录用户：" + suppUser.getSHORTNAME());
            }

            if (suppUser == null) {
//                throw new NoteException("请重新登录", 10002);
                return false;
            }
            Login login=new Login();
            login.setState(state);
            login.setSuppUser(suppUser);
            LoginUtil.setLoginUser(login);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        LoginUtil.remove();
    }
}
