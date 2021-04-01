package com.demo.service.aspect;

import com.demo.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
在Spring AOP应用中，基于@Aspect注解描述的类型为一个切面类型，
此类中要封装切入点及通知方法的定义：
  1)切入点:要切入扩展业务逻辑的一些目标方法集合(例如使用了特点注解描述的方法)
  2)通知：封装了扩展业务逻辑的一个方法(spring中也可使用特定注解进行描述)
 <p>on 2021/3/21 23:35 */

@Slf4j
@Component
@Aspect
public class LogAspect {

    //public static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 基于注解 @Pointcut 定义切入点，这里的 @annotation为一种切入点表达式，
     * 表示由RequiredLog注解描述的方法为一个切入点方法，
     * 我们要在这样的方法上添加扩展业务逻辑
     */
    @Pointcut("@annotation(com.demo.common.annotation.RequiredLog)")
    //此方法用于承载切入点的定义
    public void doLog() { }


    /**
     * 定义一个通知方法，这里使用@Around进行描述，表示在此方法内部可以调用目标方法，
     * 可以在目标方法执行之前或之后做一些拓展业务
     * @param pjp 连接点，用于封装要执行的目标切入点方法信息，
     *            ProceedingJoinPoint此类型参数只能定义在@Around注解描述的方法中
     * @return 这里的返回值一般为目标切入点方法的执行结果
     * @throws Throwable
     */
    @Around("doLog()")
    public Object doAround(ProceedingJoinPoint pjp) {
        long t1 = System.currentTimeMillis();
        log.info("Method Begin: {}",t1);
        //Object result = pjp.proceed();
        return null;
    }

    @Autowired
    private LogService logService;

    public void doSaveLogInfo(ProceedingJoinPoint pjp, long time, Throwable e) {
        //模拟获取用户行为日志
        //1.1获取登录用户信息,后续是系统的登录用户
        String userName = "lee";
        //1.2获取登录用户的ip地址,后续可以借助第三方工具类
        String ipAddress = "1.1.1.1";

        //获取用户操作
        //1.3.1获取方法所在类的字节码对象(目标对象对应的字节码对象)
        Class<?> clazz = pjp.getTarget().getClass();
        //1.3.2获取注解描述的方法对象(字节码对象，方法名，参数列表)
        Signature signature= pjp.getSignature();


    }

}
