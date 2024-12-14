package tn.esprit.springexamen.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(public * tn.esprit.springexamen.service.ServiceImpl.*(..))")
    public void logAspectBefore(JoinPoint joinPoint) {
        log.info("Bienvenue à l’un des services de l’application Boycott");
    }

}
