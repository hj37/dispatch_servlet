package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec04.ex03.MemberVO;

//첫 번째 서블릿에서 조회한 회원정보를 List에 저장한 후 ~~
//다시~ request객체영역에 바인딩하여 두 번째 서블릿 재요청시 전달하는 역할을 함.
@WebServlet("/member4")
public class MemberServlet extends HttpServlet {

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 1. 요청한 값(DB에 insert할? 입력한 새로운 회원정보)얻기 */

		// 요청값 한글처리
		request.setCharacterEncoding("UTF-8");

		// DB에 입력한 회원정보를 검색 조회하기 위해 DAO객체 생성
		MemberDAO dao = new MemberDAO();
		
		// 회원정보들을 모두 조회하여 클라이언트의 웹브라우저로 출력하자.
		// 서블릿은 회원정보 조회 요청을 받아 조회한 회원정보를 클라이언트의 웹브라우저로 응답해야한다.
		// 1.응답할 데이터의 MIME-TYPE설정
		response.setContentType("text/html;charset=utf-8");
		// 2.응답데이터를 웹브라우저로 출력할 PrintWriter 객체 얻기
		PrintWriter out = response.getWriter();

		// 4.MemberDAO의 listMembers()메소드를 호출하여 검색한 모든 회원정보를 각각 MemberVO객체에 저장하여
		// 각각의 MemberVO객체들을 최종적으로 ArrayList라는 가변길이 배열에 추가후 ....
		// DB에서 검색한 모든 회원정보인? ArrayList를 리턴(반환)받는다.
		ArrayList list = dao.listMembers();

		//조회된 회원정보 ArrayList를 request객체 내부에 바인딩(저장)함.
		request.setAttribute("membersList", list);
		
		//디스패치 방식의 재요청(포워딩) 
		//바인딩한 request객체를 두 번째 서블릿 재요청(포워딩)시 전달함.
		RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
		dispatch.forward(request,response);
		//--------------------------------------------------------------------------
		
		
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request,response);
	}
}
