//package kr.ac.kopo.board.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//import kr.ac.kopo.board.domain.Reservation;
//import kr.ac.kopo.board.domain.User;
//
//@Aspect
//@Component
//public class ServiceAspect {
//	
//	// kr.ac.kopo.board.aop.UserServiceImpl.selectOne
//	// *..*Service..selectOne
//	
//	// 포인트컷
//	@Before("execution(* *..*Service..selectOne(long))")
//	public void before() {
//		// 메서드 시작 시 동작하는 어드바이스
//		System.out.println("selectOne Before! *** 메서드가 호출되기 전에 나온다!");
//	}
//
////	@After("execution(* selectOne(long))")
////	public void after() {
////		// 메서드 종료 후 동작하는 어드바이스
////		System.out.println("selectOne After! *** 메서드가 호출된 후에 나온다!");
////	}
////	
////	@AfterReturning(value="execution(* selectOne(long))", returning="g")
////	public void afterReturning(Gongji g) {
////		// 메서드 호출이 예외를 내보내지 않고 종료했을 때 동작하는 어드바이스
////		System.out.println("selectOne AfterReturning! *** 메서드를 호출한 후에 나온다!");
////	}
////
////	@Around("execution(* selectOne(long))")
////	public Gongji around(ProceedingJoinPoint pjp) throws Throwable {
////		// 메서드 호출 전후에 동작하는 어드바이스
////		System.out.println("Hello Around! before *** 메서드를 호출하기 전에 나온다!");
////		Gongji g = (Gongji)pjp.proceed();
////		System.out.println("Hello Around! after *** 메서드를 호출한 후에 나온다!");
////		return g;
////	}
////	
////	// 메서드 호출이 예외를 던졌을 때 동작하는 어드바이스
////	@AfterThrowing(value="execution(* selectOne(long))", throwing="ex")
////	public void afterThrowing(Throwable ex) {
////		System.out.println("Hello Throwing! *** 예외가 생기면 나온다!");
////	}
//	
//	
//	
//}
