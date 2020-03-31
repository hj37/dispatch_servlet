package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹브라우저 주소창에 입력할 주소 : http://localhost:8090/pro10/first

//주제 : redirect 방식을 이용하면 웹브라우저를 통해 다른 서블릿을 호출하면서 원하는 데이터를 전달할 수도 있다.
//예제 : redirect 방식으로 최초 요청한 서블릿에서 GET방식으로 다른 서블릿으로 데이터를 전달하는 예제.

/*@WebServlet("/first")
*/public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//응답할 데이터의 MIME-TYPE 설정 
		response.setContentType("text/html;charset=UTF-8");
		//GET방식을 이용해 이름=값 쌍으로 데이터를 묶어서 다른 서블릿 재요청시 전달함.
		response.sendRedirect("second?name=lee");
	}

}
