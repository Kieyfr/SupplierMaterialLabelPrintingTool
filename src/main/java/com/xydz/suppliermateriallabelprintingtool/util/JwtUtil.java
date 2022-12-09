package com.xydz.suppliermateriallabelprintingtool.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xydz.suppliermateriallabelprintingtool.entity.Login;
import com.xydz.suppliermateriallabelprintingtool.entity.SuppUser;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author xiachenchen
 * @ClassName: JwtUtil
 * @Description: token工具类 TODO
 * @Date 2022/9/13 10:26
 */
public class JwtUtil {

    /**
     * 过期时间
     */
    private static final long EXPIRE_TIME = 3 * 24 * 60 * 60 * 1000;

    private static final String TOKEN_SECRET = "8808e1e79b9241aba038e16553bd1836";

    /**
     * 生成token
     * @param login
     * @return
     */
    public static String sign(Login login){
//        Date date = new Date(TimeUtil.getTimeStampMillisecond() + EXPIRE_TIME);
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Map<String, Object> header = new HashMap<String, Object>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            SuppUser suppUser=login.getSuppUser();
            Integer state=login.getState();

            return JWT.create()
                    .withHeader(header)
                    .withClaim("CODE",suppUser.getCODE())
                    .withClaim("NAME",suppUser.getNAME())
                    .withClaim("SHORTNAME",suppUser.getSHORTNAME())
                    .withClaim("STATE",state+"")
//                    .withExpiresAt(date)
                    .withIssuedAt(new Date())
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }



    /**
     * 校验token
     * @param token
     * @return
     */
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT jwt = jwtVerifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取登录用户供应商代码
     * @param token
     * @return
     */
    public static String getSuppCode(String token){
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("CODE").asString();
    }
    /**
     * 获取是否是管理员登录
     * @param token
     * @return
     */
    public static Integer getState(String token) {
        DecodedJWT jwt = JWT.decode(token);
        String State = jwt.getClaim("STATE").asString();
        if (State == null || State == "") {
            State="1";
        }
        return Integer.valueOf(State);
    }

}
