package DI_02;

public class HelloApp {

	public static void main(String[] args) {
	//영문
	// MessageBean_en en = new MessageBean_en();
	// en.sayHello("hello");

	// MessageBean_kr kr = new MessageBean_kr();
	// kr.sayHello("hello");
	
		//인터페이스 (다형성) 느슨한 구조 .... 
		MessageBean messagebean = new MessageBean_kr();
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