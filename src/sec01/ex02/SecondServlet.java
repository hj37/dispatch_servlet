package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/second")
*/public class SecondServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//응답할 데이터의 MIME-TYPE 설정 
				response.setContentType("text/html;charset=UTF-8");
				
				//클라이언트의 웹브라우저로 응답(출력)할 PrintWriter스트림통로 객체 얻기 
				PrintWriter out = response.getWriter();
				
				out.println("<html><body>");
				out.println("Response객체의 addHeader메소드를 이용한 refresh 방식의 포워딩(재요청)실습입니다.");
				out.println("</body></html>");
	}

}
