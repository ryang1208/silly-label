package com.label.configuration;

import com.label.bo.LoginUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * 增加方法注入，将 LoginUser 方法参数封装当前用户
 */
public class LoginUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return LoginUser.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) throws Exception {
        LoginUser user = (LoginUser) webRequest.getAttribute("loginUser", RequestAttributes.SCOPE_REQUEST);
        if (user != null) {
            return user;
        }
        throw new MissingServletRequestPartException("loginUser");
    }
}
