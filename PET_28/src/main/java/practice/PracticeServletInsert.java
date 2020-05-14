package practice;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pet.member.register.model.PetMembers;
import pet.member.register.service.PetMembersService;
import util.HibernateUtil;

@WebServlet("/practicePage/PracticeServlet.do")
public class PracticeServletInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processInsertData(request, response);		
	}
	
	
	public void processInsertData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMsg = new HashMap<>();
		request.setAttribute("errorMsg", errorMsg);
		
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String bday = request.getParameter("bday");
		String age = request.getParameter("age");
		String addr = request.getParameter("address");
		String phone = request.getParameter("phone");
		String petType = request.getParameter("petType");
		
		
		Date bdate = null;
		try {
			bdate = Date.valueOf(bday);
		}catch(Exception e) {
			e.printStackTrace();
			errorMsg.put("mBbday", "出生日期格式錯誤");
		}
		
		int age2 = 0;
		try {
			age2 = Integer.parseInt(age);
			
		}catch(Exception e) {
			e.printStackTrace();
			errorMsg.put("mAge", "年齡格式錯誤");
		}
		
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/practicePage/practiceForm.jsp");
			rd.forward(request, response);
			return;
		}	
		
		Session session = null;
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			session = factory.getCurrentSession();
			
		PetMembersService pmService = new PetMembersService(session);

		PetMembers petMember = new PetMembers();
		
		petMember.setUsername(user);
		petMember.setPassword(pwd);
		petMember.setEmail(email);
		petMember.setGender(gender);
		petMember.setBday(bdate);
		petMember.setAge(age2);
		petMember.setAddress(addr);
		petMember.setPhone(phone);
		petMember.setPetType(petType);
		
		petMember.setRegisterTime(new Timestamp(System.currentTimeMillis()));		
		
		pmService.insertPetMembers(petMember);
		
//		pmService.selectPetMembers();
		
		 }catch(Exception e) {
			 e.printStackTrace();
			 session.getTransaction().rollback();
		 }	
		
//		HibernateUtil.closeSessionFactory();	
		
		RequestDispatcher rd = request.getRequestDispatcher("/practice/PracticeSevlretQuery");
		rd.forward(request, response);
		
	}
	
	
}
