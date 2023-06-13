package AOP_Basic02_Java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

//보조업무(공통관심) 수현하는 클래스
//보조업무에서 실제 함수를 대리할 수 있어야 한다 (대리함수) : invoke 
//invoke 함수는 여러개의 실제 함수를 대리한다 ^^

public class LogPrintHandler implements InvocationHandler{
	//실 객체의 주소값
	private Object target;
	public LogPrintHandler(Object target) {
		
		System.out.println("LogPrintHandler 새성자 호출 : "+ target);
		this.target=target;

		
	}
	//invoke 함수가(ADD, MUL, SUB)람수를 대리한다.
	//마치 진자 처럼....
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		
		System.out.println("invoke 함수 호출");
		System.out.println("Method method" + method);
		System.out.println("Mehod parameter" + Arrays.toString(args));
		
		// 보조업무
		//시간처리 로직(시작시간_
		Log log = LigFactory.getLog(this.getClass());
		StopWathch sw = new Stopwatch();
		sw.strt();
		log.info("[타이머 시작]");
		
		
		//주업무(실제 함수 호출): 주 객체가 가지는 주함수 호출(ADD, MUL, SUB)
		int result = (int) method.invoke(this.target.args);
			
		//보조업무
		//시간처리 로직(끝시간)
		sw.stop();
		log.info("[타이머 종료]"):
	    log.info("[Time log Method : ]")
		
		return null;
	}
	
	

}
