package com.zzw.fenda.interceptor;

import com.zzw.fenda.util.Functions;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String receipt = request.getHeader("receipt");

            Base64.Decoder decoder = Base64.getDecoder();
            receipt = new String(decoder.decode(receipt), StandardCharsets.UTF_8);

            String[] params = receipt.split("[|]");
            System.out.println(params[0]);

            Integer uid = Integer.parseInt(params[0]);
            String timestamp = params[1];
            String raw = params[2];

            String hash = Functions.md5(uid + "qa+angle" + timestamp, "its unbroken");

            if (raw.equals(hash)) {
                request.setAttribute("uid", uid);
                return true;
            } else {
                Functions.invalidReturn(response);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Functions.invalidReturn(response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
