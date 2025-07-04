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
//	// ����Ʈ��
//	@Before("execution(* *..*Service..selectOne(long))")
//	public void before() {
//		// �޼��� ���� �� �����ϴ� �����̽�
//		System.out.println("selectOne Before! *** �޼��尡 ȣ��Ǳ� ���� ���´�!");
//	}
//
////	@After("execution(* selectOne(long))")
////	public void after() {
////		// �޼��� ���� �� �����ϴ� �����̽�
////		System.out.println("selectOne After! *** �޼��尡 ȣ��� �Ŀ� ���´�!");
////	}
////	
////	@AfterReturning(value="execution(* selectOne(long))", returning="g")
////	public void afterReturning(Gongji g) {
////		// �޼��� ȣ���� ���ܸ� �������� �ʰ� �������� �� �����ϴ� �����̽�
////		System.out.println("selectOne AfterReturning! *** �޼��带 ȣ���� �Ŀ� ���´�!");
////	}
////
////	@Around("execution(* selectOne(long))")
////	public Gongji around(ProceedingJoinPoint pjp) throws Throwable {
////		// �޼��� ȣ�� ���Ŀ� �����ϴ� �����̽�
////		System.out.println("Hello Around! before *** �޼��带 ȣ���ϱ� ���� ���´�!");
////		Gongji g = (Gongji)pjp.proceed();
////		System.out.println("Hello Around! after *** �޼��带 ȣ���� �Ŀ� ���´�!");
////		return g;
////	}
////	
////	// �޼��� ȣ���� ���ܸ� ������ �� �����ϴ� �����̽�
////	@AfterThrowing(value="execution(* selectOne(long))", throwing="ex")
////	public void afterThrowing(Throwable ex) {
////		System.out.println("Hello Throwing! *** ���ܰ� ����� ���´�!");
////	}
//	
//	
//	
//}
