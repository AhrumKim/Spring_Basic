package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
	//영문
	// MessageBean_en en = new MessageBean_en();
	// en.sayHello("hello");

	// MessageBean_kr kr = new MessageBean_kr();
	// kr.sayHello("hello");
	
		//인터페이스 (다형성) 느슨한 구조 .... 
	//	MessageBean messagebean = new MessageBean_kr();
	//	messagebean.sayHello("hong");
	
	//spring 통해서 컨테이너를 만들고 (메모리) 안에 객체 생성 , 조립
	
	ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
	MessageBean messagebean = context.getBean("messagebean",MessageBean.class);
	messagebean.sayHello("hong");	
	}

}
/*
요구사항
1. 한글버전 (hong) >> 안녕 hong
2. 영문버전 (hong) >> hello hong

MessageBean_kr 
MessageBean_en

interface 다형성 설계
*/