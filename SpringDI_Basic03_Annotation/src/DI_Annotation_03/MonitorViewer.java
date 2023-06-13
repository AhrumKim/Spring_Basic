package DI_Annotation_03;
import javax.annotation.Resource;
/*

JAVA 1.9 버전부터 @Resource 사용하기 위해서 
javax.annotation-api-1.3.2.jar 파일 추가 해야 합니다 

maven
<dependency>
	<groupId>javax.annotation</groupId>
	<artifactId>javax.annotation-api</artifactId>
	<version>1.3.1</version>
</dependency>
*/
public class MonitorViewer {
	private Recorder recorder;
	
	public Recorder getRecorder() {
		return this.recorder;
	}
	
	//@Autowired  by type
	@Resource(name="yy") //같은 타입의 객체가 있을때 name 값으로 찿는다
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setRecorder : " + this.recorder);
	}
	
	
}
