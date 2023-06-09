package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		/*
			//NewRecordView view = new NewRecordView(100, 50, 40);
			//view.print();
			NewRecordView view = new NewRecordView();
			//놀다가
			//나는 니가 필요해 NewRecord 객체 주소가
			NewRecord record = new NewRecord(100, 100, 100);
			view.setRecord(record); //의존객체의 주소를 주입 받는다 (DI) > spring 자동화 ...
			view.print();
	
		*/
		/*
		 스프링은 자신만의 메모리 공간을 가져요 ....
		 1. SpringFrameWork 컨테이너를 제공 (메모리 생성 : 컨테이너 (IOC 컨테이너)) 
		    ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		    ApplicationContext 메모리 공간을 만드는데  공간을 만들고 DIConfig.xml 컴파일 하고 read 그리고 설정
		 
		 2. 컨테이너 만들고 그 메모리에 필요한 [객체를 생성]하고 조립(주입:DI) .... ... 나중에 자동 소멸
		    >> 컨테이너 생성되고 DIConfig.xml read .... 
		    >>  DIConfig.xml 객체 생성과 조립 xml 코드가 있어요 ....
		    >>  생성된 객체를 bean 이라 합니다
		     
		    
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		//Spring 필요한 메모리 공간을 생성하고 생성된 메모리에  DIConfig.xml read 해서 객체 생성 주입
		
		//컨테이너 안에서 필요한 객체가 있다면 가지고 오면 되요
		RecordView view = (RecordView)context.getBean("view"); //getBean return Object
		view.input();
		view.print();
	}

}
