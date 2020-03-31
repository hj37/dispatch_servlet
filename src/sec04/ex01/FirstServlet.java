package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹브라우저 주소창에 입력할 주소 : http://localhost:8090/pro10/first

/*@WebServlet("/first")
*/public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//응답할 데이터의 MIME-TYPE 설정 
		response.setContentType("text/html;charset=UTF-8");
		
		//웹브라우저에서 요청한 request객체영역 내부에.. 
		//address의 값으로 "서울시 성북구"값을 바인딩(저장)함 
		request.setAttribute("address", "서울시 성북구");
		
		//두번째 서블릿으로 request객체에 저장된 값을 전송 하기 위해.. redirect방식으로 재요청(포워딩)함.
		response.sendRedirect("second");
	}

}
