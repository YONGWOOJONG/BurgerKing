package burger.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggerAspect {
	@Pointcut("execution(* burger..controller.*Controller.*(..)) || execution(* burger..service.*ServiceImpl.*(..)) || execution(* burger..mapper.*Mapper.*(..))")
	private void loggerTarget() {
	}

	@Around("loggerTarget()")
	public Object logPrinter(ProceedingJoinPoint joinPoint) throws Throwable {
		String type = "";
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		if (className.indexOf("Controller") > -1) {
			type = "Controller";
		} else if (className.indexOf("Service") > -1) {
			type = "Service";
		} else if (className.indexOf("Mapper") > -1) {
			type = "Mapper";
		}

		log.debug(type + " : " + className + "." + methodName + "()");
		return joinPoint.proceed();
	}
}