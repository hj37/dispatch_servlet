package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹브라우저 주소창에 입력할 주소 : http://localhost:8090/pro10/first

//@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//응답할 데이터의 MIME-TYPE 설정 
		response.setContentType("text/html;charset=UTF-8");
		
		//클라이언트의 웹브라우저로 응답(출력)할 PrintWriter스트림통로 객체 얻기 
		PrintWriter out = response.getWriter();
		
		//자바스크립트의 location객체 방법을 이용한 포워딩(재요청) 
		out.print("<script='text/javascript'>");
		//자바스크립트의 location객체의 href속성에 SecondServlet을 재요청할 매핑주소를 작성하여 재요청(포워딩)함.
		out.print("location.href='second'");
		out.print("</script>");
	}

}
