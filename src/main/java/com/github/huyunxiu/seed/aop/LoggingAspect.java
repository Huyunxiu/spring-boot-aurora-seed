package com.github.huyunxiu.seed.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author huyunxiu01@gmail.com
 * @version 1.0.0
 * @since 2019-03-29
 */
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restControllerPoint() {}

    @Around("restControllerPoint()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = StopWatch.createStarted();
        ObjectMapper mapper = new ObjectMapper();

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        log.info("METHOD: {}, URL: {}, BODY: {}", request.getMethod(), request.getRequestURL(), mapper.writeValueAsString(request.getParameterMap()));

        Object result = pjp.proceed();

        stopWatch.stop();

        log.info("TIME: {}", stopWatch.getTime(TimeUnit.MILLISECONDS));

        return result;
    }
}
