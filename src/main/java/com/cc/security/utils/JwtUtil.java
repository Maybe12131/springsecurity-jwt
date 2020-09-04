package com.cc.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @Author CaiCang
 * @Date 2020/9/1 10:35
 * @Version 1.0
 */
@Component
public class JwtUtil {

    private static final String jwtClaimKey = "tokenObj-key";
    private static final String jwtSecretKey = "jwtSecret-Key";

    /**
     * 生成jwt的token串
     *
     * @param value
     * @return
     */
    public static String createJwtToken(String value) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put(jwtClaimKey, value);
        Calendar calendar = Calendar.getInstance();
        //当前时间添加24是小时,即token在24小时后过期
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return Jwts.builder()
                //设置载荷部分
                .setClaims(claims)
                //设置过期时间
                .setExpiration(calendar.getTime())
                //设置加密算法
                .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
                .compact();
    }

    /**
     * 从jwttoken串中获取载荷值
     *
     * @param tokenStr
     * @return
     */
    public static String getJwtTokenClaimValue(String tokenStr) {
        String result = null;
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecretKey)
                    .parseClaimsJws(tokenStr)
                    .getBody();

            if (claims.getExpiration().compareTo(Calendar.getInstance().getTime()) > 0) {
                //token未过期
                result = claims.get(jwtClaimKey, String.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
