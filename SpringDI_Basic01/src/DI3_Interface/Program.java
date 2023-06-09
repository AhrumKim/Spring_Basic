package DI3_Interface;

public class Program {

	public static void main(String[] args) {
		//NewRecordView view = new NewRecordView(100, 50, 40);
		//view.print();
		NewRecordView view = new NewRecordView();
		//놀다가
		//나는 니가 필요해 NewRecord 객체 주소가
		NewRecord record = new NewRecord(100, 100, 100);
		view.setRecord(record); //의존객체의 주소를 주입 받는다 (DI) > spring 자동화 ...
		view.print();
	}

}
