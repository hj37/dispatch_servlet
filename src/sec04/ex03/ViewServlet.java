package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//request객체의 getAttribute()메소드를 이용해 첫 번째 서블릿에서 바인딩한 
//조회한 회원정보가 저장된 List를 request 객체 영역에서 꺼내와
//클라이언트의 웹브라우저에 출력! 하는 역할을 하는 두 번째 서블릿 

@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException {
		//클라이언트의 웹브라우저 응답(출력)할 데이터 설정 
		response.setContentType("text/html;charset=utf-8");
		
		//MemberServlet에서 재요청시 전달된 request메모리의 데이터 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 2.응답데이터를 웹브라우저로 출력할 PrintWriter 객체 얻기
		PrintWriter out = response.getWriter();
		
		//MemberServlet에서 재요청시 전달된 request메모리에 저장되어 있는 조회한 List 얻기 
		Object obj1 = request.getAttribute("membersList");	//업캐스팅이 일어남 
		
		//다운캐스팅
		ArrayList membersList = (ArrayList)obj1; //다운캐스팅 
		
		//클라이언트의 웹브라우저로 DB로부터 조회한 회원정보를 출력 
		out.print("<html>");
		out.print("<body>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor ='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td>");
		out.print("</tr>");

		for (int i = 0; i < membersList.size(); i++) {
			// 조회한 회원정보는 ArrayList라는 가변길이 배열공간에 저장되어 있으므로
			// ArrayLsit가변길이 배열에 저장된 검색한 회원정보(MemberVO객체)를 하나씩 얻는다.

			/*
			 * //업캐스팅 : 부모클래스 타입의 참조변수에 자식객체를 저장하는 것! //업캐스팅 Object obj = list.get(i);
			 * //다운캐스팅 자식클래스타입의 참조변수로 형변환(캐스팅) 해주어야함. MemberVO memberVO = (MemberVO)obj;
			 * MemberVO memberVO = (MemberVO)list.get(i); //get(i) Object타입이 무조건 반환이 됨
			 * 다형성(다양한 형태의 성질을 지닐 수 있는 것) 메소드 오버로딩 : 하나의 같은 이름으로 매개변수 개수 또는 타입을 달리해서 메소드를
			 * 여러개 만들어 놓는것 메소드 오버라이딩 : 메소드 선언부는 같게 하되 구현부만 재구현해서 여러개의 메소드를 만들 수 있다. 업캐스팅 :
			 * 하나의 부모클래스타입의 참조변수에 여러 가지 객체를 저장할 수 있다.
			 * 
			 */
			
			MemberVO memberVO = (MemberVO) membersList.get(i);
			// getter메소드를 이용하여 MemberVO의 각 변수에 저장된 회원 정보를 얻는다.
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoindate();

			out.print("<tr>");
			out.print("<td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td>" + "<td>" + email + "</td><td>"
					+ joinDate + "</td>" + "<td><a href='/pro10/member4?command=delMember&id=" + id + "'>삭제</a></td>");
			out.print("</tr>");
		}

		out.print("</table>");
		out.print("</body>");
		out.print("</html>");

		out.print("<a href='/pro10/memberForm.html'>새회원등록하기</a>");

		
	}
}
