package com.beta.config.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.beta.basic.annotation.EnableRedis;

//@Aspect
//@Component
public class AspectTest {
//	@Pointcut("execution(public * com.beta.basic.controller..*.*(..))")
	public void aspectTest() {}

//	@Before("aspectTest()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		System.out.println("URL:"+request.getRequestURL().toString());
		System.out.println("Http Method:"+request.getMethod());
		System.out.println("Remote Addr:"+request.getRemoteAddr());
		System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());  
	    System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));  
		
	}
//	@AfterReturning(returning="returnValue",pointcut="aspectTest()")
	public void doAfter(Object returnValue){
		//请求处理完成
		System.out.println("请求完成，返回：" + returnValue);
	}
	//后置异常通知  
//    @AfterThrowing("aspectTest()")
    public void throwss(JoinPoint jp){  
        System.out.println("方法异常时执行.....");  
    }  
  
    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行  
//    @After("aspectTest()")
    public void after(JoinPoint jp){  
        System.out.println("方法最后执行.....");  
    }  
  
    //环绕通知,环绕增强，相当于MethodInterceptor  
//    @Around("aspectTest()")
    public Object arround(ProceedingJoinPoint pjp) throws Exception {  
        System.out.println("方法环绕start....."); 
        Signature signature = pjp.getSignature();
        if (!(signature instanceof MethodSignature)) {
			throw new Exception("该注解");
		}
        System.out.println( signature instanceof MethodSignature);
        //获取method
        MethodSignature methodSignature = (MethodSignature)signature;
        Object target = pjp.getTarget();
        Method method = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        Parameter[] parameters = method.getParameters();
        if(method.isAnnotationPresent(EnableRedis.class)){
        	//...
        	
        	/*RequestAttributes ras = RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = ((ServletRequestAttributes) ras).getRequest();
			EnableRedis annotation = method.getAnnotation(EnableRedis.class);
			Object[] args = pjp.getArgs();
			String parameter = request.getParameter(annotation.poolId());
			String pool = PerpetualPool.get(parameter);
			// 方法名+参数 组成key
			StringBuilder redisKey = new StringBuilder(method.getName() + parameter + pool);
			for (Object arg : args) {
				if (arg!= null) {
					redisKey.append(arg.toString());
				}
			}
			String valueFromRedis = RedisFactory.getValueFromRedis(redisKey.toString());
			// 直接从redis中获取运行结果
			if (StringUtil.isNotEmpty(valueFromRedis)) {
				return ObjectUtil.toObject(valueFromRedis, CommonResult.class);
			}
			// 如果key不存在 把新运行的结果放到redis里边
			CommonResult commonResult = CommonResult.build(pjp.proceed());
			if (commonResult.getCode() == 200) {
				RedisFactory.setValueToRedis(redisKey.toString(), commonResult, annotation.cacheMinutes(),
						TimeUnit.MINUTES);
			}*/
        }
        try {  
            Object o =  pjp.proceed();  
            System.out.println("方法环绕end，结果是 :" + o);  
            return o;  
        } catch (Throwable e) {  
            e.printStackTrace();  
            return null;  
        } 
    }
//    @Around("@annotation(requestMapping)")
//    public Object authorize(ProceedingJoinPoint pjp, RequestMapping requestMapping) throws Throwable {
//
//    }
}
