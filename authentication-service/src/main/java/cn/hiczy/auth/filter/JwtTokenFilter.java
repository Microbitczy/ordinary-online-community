package cn.hiczy.auth.filter;



import cn.hiczy.common.utils.JwtUtils;
import cn.hiczy.pojo.common.CommonResult;
import cn.hiczy.pojo.enums.ResultEnum;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader(JwtUtils.AUTH_HEADER);
        if (ObjectUtils.isEmpty(authHeader)) {
            try {
                JwtUtils.parseJWT(authHeader);//验证令牌
            } catch (ExpiredJwtException e) {
                //如果令牌过期的处理
                httpServletResponse.setContentType("application/json;charset=utf-8");
                httpServletResponse.getWriter().write(JSONUtil.toJsonStr(CommonResult.create(ResultEnum.TOKEN_EXPIRATION, null)));
                return;
            }

            Long userId = JwtUtils.getUserId(authHeader);
            if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(username);
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);



    }



}
