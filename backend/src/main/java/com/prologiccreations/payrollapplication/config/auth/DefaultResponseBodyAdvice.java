package com.prologiccreations.payrollapplication.config.auth;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Map;

import static com.prologiccreations.payrollapplication.constants.Constants.*;
import static com.prologiccreations.payrollapplication.filter.auth.AuthFilter.*;
import static com.prologiccreations.payrollapplication.utils.auth.CookieUtil.*;

@ControllerAdvice
public class DefaultResponseBodyAdvice<T> implements ResponseBodyAdvice<T> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public T beforeBodyWrite(T body, MethodParameter returnType, MediaType selectedContentType,
                             Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

            HttpHeaders requestHeaders = request.getHeaders();
            HttpHeaders responseHeaders = response.getHeaders();
            String authToken = String.join("", requestHeaders.getOrEmpty(HttpHeaders.AUTHORIZATION));
            if(REFRESH_STATUS_MAP.containsKey(authToken)){
                Map<String, String> tokenMap = REFRESH_STATUS_MAP.remove(authToken);
                String accessTokenCookie = createCookie(ACCESS_TOKEN_NAME, tokenMap.get(ACCESS_TOKEN_NAME), ACCESS_TOKEN_DURATION_MILLISECONDS);
                String refreshTokenCookie = createCookie(REFRESH_TOKEN_NAME, tokenMap.get(REFRESH_TOKEN_NAME), REFRESH_TOKEN_DURATION_MILLISECONDS);
                responseHeaders.add(HttpHeaders.SET_COOKIE, accessTokenCookie);
                responseHeaders.add(HttpHeaders.SET_COOKIE, refreshTokenCookie);
                responseHeaders.add(REFRESHED_ACCESS_TOKEN, accessTokenCookie.substring(ACCESS_TOKEN_NAME.length() + 1, accessTokenCookie.indexOf(";")));
            }
        return body;
    }

}
