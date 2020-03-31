package sec04.ex02;

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

		// 응답할 데이터의 MIME-TYPE 설정
		response.setContentType("text/html;charset=UTF-8");

		// 웹브라우저에서 요청한 request객체영역 내부에..
		// address의 값으로 "서울시 성북구"값을 바인딩(저장)함
		request.setAttribute("address", "서울시 성북구");
							//키, 값을 쌍으로 저장한다.

		/* dispatch방식의 포워딩 */
		// 바인딩된 request객체영역을 다시 두 번째 서블릿으로 포워딩(재요청)합니다.
		//이때 second라고 적은 것은 두번째 서블릿을 요청할 매핑 주소이다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("second");
		//두번째 서블릿 재요청시.. 기존에 존재했던 request, response메모리 전달 
		dispatcher.forward(request, response);

	}

}
