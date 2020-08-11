package cn.hiczy.common.utils;


import cn.hiczy.common.constants.JwtConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Permission;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Jwt工具类
 */
public class JwtUtils {
    private JwtUtils() {
    }


    /*令牌的过期时间为3小时*/
    public static final long EXPIRATION = 1000 * 60 * 60 * 3;


    /**
     * 创建JWT令牌
     * @param username      用户名
     * @param roles         用户角色信息
     * @param permissions   用户所拥有的权限
     * @return              JWT令牌
     */
    public static String createJWT(String username, List<String> roles, List<String> permissions) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtConstant.ROLES, roles);
        claims.put(JwtConstant.PERMISSIONS, permissions);
        //map里可以放自定义的claims
        return Jwts.builder()
                //设置加密算法
                .signWith(SignatureAlgorithm.HS512, JwtConstant.JWT_SECRET)
                //设置自定义的claims
                .setClaims(claims)
                //设置签发人
                .setIssuer(JwtConstant.ISSUER)
                //设置签发时间
                .setIssuedAt(new Date())
                //设置令牌的过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                //设置令牌主题(所有者)
                .setSubject(username)
                .compact();
    }

    /**
     * 解析JWT令牌
     * @param jwt 被解析的jwt
     * @return claims
     */
    public static Claims parseJWT(String jwt) {
        return Jwts.parser()
                .setSigningKey(JwtConstant.JWT_SECRET)
                .parseClaimsJws(jwt)
                .getBody();
    }


    /**
     * 从令牌中获取username
     * @param jwt  jwt令牌
     * @return     username
     */
    public static String getUsername(String jwt){
        return parseJWT(jwt).getSubject();
    }


    /**
     * 从令牌中获取用户角色信息
     * @param jwt jwt令牌
     * @return    用户角色信息
     */
    public static List<String> getUserRole(String jwt){
        return (List<String>) parseJWT(jwt).get(JwtConstant.ROLES);
    }


    /**
     * 从令牌中获取用户所拥有的权限
     * @param jwt jwt令牌
     * @return    权限信息
     */
    public static List<String> getUserPermission(String jwt){
        return (List<String>) parseJWT(jwt).get(JwtConstant.PERMISSIONS);
    }


    /**
     * 校验 jwt 是否过期
     * @param jwt jwt令牌
     * @return    过期-true, 过期-false
     */
    public static boolean isExpired(String jwt){
        return parseJWT(jwt).getExpiration().before(new Date());
    }

}
