package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.NewArticleCommand;
import com.service.ArticleService;

/*
클라이언트 요청....
1. 화면주세요 (글쓰기, 로그인 화면) : write.do
2. 처리해 주세요(글쓰기 입력 처리 , 로그인 완료 처리) : writeok.do

요청주소가 : write.do 화면
요청주소가 : writeok.do 처리 

spring
클라이언트 요청
요청을  method 단위로 처리
* 1개의 요청 주소로 화면,처리 판단 > 근거 > 전송방식(GET,POST)
http:....../article/newArticle.do
요청방식이
GET : 화면 > view 제공
POST: 서비스 처리 >> insert, update >> 화면 제공


*/
@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {

	//NewArticleController  업무수행을 위해서 ArticleService 필요해(주소)
	//has-a >> 연관 
	private ArticleService articleService;
	
	@Autowired	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping   //5.x.x
	public String form() {  //화면
		System.out.println("GET 화면주세요");
		//public String form() 함수의 리턴 타입이 String 이면 ...뷰의 주소로 인지 ....
		//public ModelAndView form() >> return ...
		return "article/newArticleForm";
		//  /WEB-INF/views/  +  article/newArticleForm  + .jsp
	}
	
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping  //5.x.x
	public String sumbit(@ModelAttribute("Articledata") NewArticleCommand command) { //처리 
		System.out.println("POST 처리해주세요");
	
		this.articleService.writeArticle(command);

		//ModelAndView mv = new ModelAndView();
		//mv.addObject("newArticleCommand", command);
		//생략 자동 생성.....
		
		//뷰 key : NewArticleCommand >> newArticleCommand
		
		return "article/newArticleSubmitted";
	}
	
	
	
	/*
	호랑이 담배 피던 시절에 했던 코드 .... HttpServletRequest request >> spring 고민 고민 .... 
	@PostMapping  //5.x.x
	public ModelAndView sumbit(HttpServletRequest request) { //처리 
		System.out.println("POST 처리해주세요");
		
		NewArticleCommand article = new NewArticleCommand();
		article.setParentId( Integer.parseInt(request.getParameter("parentId")));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		
		
		this.articleService.writeArticle(article);
		ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand", article);  //request.setAttribute("newArticleCommand", article)
		mv.setViewName("article/newArticleSubmitted");
		
		
		return mv;
	} 
	  
	*/  
	 /*
	 2. Spring 에서 parameter DTO 객체로 받기
	 2.1 자동화 >> 선행조건 >> input 태그의 name값이 DTO 객체의 memberfield 명과 동일
	  
	   @PostMapping  //5.x.x
	public ModelAndView sumbit(NewArticleCommand command) { //처리 
		System.out.println("POST 처리해주세요");
		
		//1. 자동 DTO 객체 생성 : NewArticleCommand command = new NewArticleCommand();
		//2. 넘어온 parameter  setter 함수를 통해서 자동 주입  => article.setParentId 자동
		//3. NewArticleCommand command 객체 자동 IOC 컨테이너 안에 등록 : id=newArticleCommand
		//   <bean id="newArticleCommand"  class="....
		
		this.articleService.writeArticle(command);
		ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand", command);  //request.setAttribute("newArticleCommand", article)
		mv.setViewName("article/newArticleSubmitted");
		
		
		return mv;
	}
	   
	   
	 */
}





