package sec04.ex01;

//이전 FirstServlet서블릿에서 전달된 값을 request객체의 getParameter()메소드를 이용해 가져와
//클라이언트의 웹브라우저로 응답하는 두번째 서블릿임 

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
				
				//FirstServlet에서 전달된 request객체의 getAttribute()메소드를 통해 address값을 꺼내옴
				String address= (String) request.getAttribute("address");	//다운캐스팅
				
				
				
				//클라이언트의 웹브라우저로 응답(출력)할 PrintWriter스트림통로 객체 얻기 
				PrintWriter out = response.getWriter();
				
				out.println("<html><body>");
				out.println("주소 : " + address + "<br>");		
				out.println("redirect방식을 이용한 재요청(포워딩)실습임.<br>" );
				out.println("</body></html>");
	}

}
