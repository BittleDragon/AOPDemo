package com.rxt.aopdemo;


import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by raoxuting on 2020/3/15.
 */
@Aspect
public class LoginCheckerAspect {

    @Pointcut("execution(@com.rxt.aopdemo.LoginChecker * *(..))")
    public void loginChecker() {}

    @Around("loginChecker()")
    public void beforeLoginCheckPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new Throwable("LoginChecker注解只能用于方法上");
        }

        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();
        int paramIndex = 0;
        for (int i = 0; i < parameterNames.length; i++) {
            if ("loginCheck".equals(parameterNames[i])) {
                paramIndex = i;
            }
        }
        Object[] args = joinPoint.getArgs();
        if (args != null && paramIndex < args.length && args[paramIndex] instanceof Boolean) {
            boolean isLogin = (boolean) args[paramIndex];
            Toast.makeText(MyApplication.getMyApplicationContext(),
                    isLogin? "hello" : "please Login first", Toast.LENGTH_SHORT).show();
            if (isLogin) {
                joinPoint.proceed();
            }
        }
    }
}
