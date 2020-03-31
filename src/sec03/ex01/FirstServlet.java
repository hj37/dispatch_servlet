package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹브라우저 주소창에 입력할 주소 : http://localhost:8090/pro10/first

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//응답할 데이터의 MIME-TYPE 설정 
		response.setContentType("text/html;charset=UTF-8");
		
		//디스패치 방식의 재요청(포워딩) 기술
		
		//request객체의 getRequestDispatcher()메소드 호출시...
		//재요청할(포워딩할) 두 번째 서블릿의 매핑주소를 전달하면
		//두번째 서블릿의 매핑주소를 저장하고 있는 RequestDispatcher인터페이스 타입의 자식객체ApplicationDispatcher를 반환함. 
		RequestDispatcher dispatcher = request.getRequestDispatcher("second?name=lee");
		
		//실제 두 번째 서블릿 재요청시... 기존에 존재했던 request객체영역과 response객체 영역전달
		dispatcher.forward(request,response);
	}

}
