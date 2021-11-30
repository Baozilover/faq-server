package com.example.aop;

import com.example.CustomException;
import com.example.pojo.ReturnResult;
import com.example.utils.LogUtil;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ResponseWrappingAspect {

    @Autowired
    Gson gson;

    @Pointcut("execution(* com.example.controller.*.*(..))")
    public void anyControllerPointCut() {
    }

    @Around("anyControllerPointCut()")
    public Object wrapResponse(ProceedingJoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();

        StringBuilder argsStringBuilder = new StringBuilder();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        signature.getMethod().getName();
        String[] parameterNames = signature.getParameterNames();
        for (int i = 0; i < args.length; ++i) {
            Object arg = args[i];
            if (i < parameterNames.length && parameterNames[i].equals("username")) {
                String username = (String) arg;
                args[i] = username.replaceAll("^[0]{0,3}", "00");
            }
            if (arg != null) {
                argsStringBuilder.append(arg).append(" ");
            }
        }

        try {
            Object proceed = joinPoint.proceed(args);
            String result = gson.toJson(new ReturnResult("0", "", proceed));
            log.info("Method " + joinPoint.getSignature().getName() + " Params " + argsStringBuilder + "Return result " + result + "\n");
            return result;
        } catch (Throwable e) {

            String result;
            if (e instanceof CustomException) {
                CustomException customException = (CustomException) e;
                result = gson.toJson(new ReturnResult(customException.getErrorCode(), ""));
            } else if (e.getMessage() != null && e.getMessage().equals("4006")) {
                // Temp Solution for Android
                result = gson.toJson(new ReturnResult("4006", "4006", ""));
                log.error("Method " + joinPoint.getSignature().getName() + " Params " + argsStringBuilder + "Return result " + result + "\n");
                return result;
            } else {
                result = gson.toJson(new ReturnResult("1", e.getMessage(), ""));
            }

            log.error("Method " + joinPoint.getSignature().getName() + " Params " + argsStringBuilder + "Return result " + result);
            LogUtil.throwable(e);
            return result;
        }
    }
}
