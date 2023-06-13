package DI_07_Spring;

import java.util.List;

public class ProtocolHandler {
	//여러개의 filter
	List<MyFilter> filters;
	
	//setter
	public void setFilters(List<MyFilter> filters) {
		this.filters = filters;
	}
	//getter
	public List<MyFilter> getFilters(){
		return this.filters;
	}
	
	//검증함수
	public int filter_Length() {
		return this.filters.size();
	}
}
