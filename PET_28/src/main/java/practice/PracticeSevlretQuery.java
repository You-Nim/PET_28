package practice;

import java.io.IOException;
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


@WebServlet("/practice/PracticeSevlretQuery")
public class PracticeSevlretQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Session session = null;
		try {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		session = factory.getCurrentSession();		
		
		PetMembersService pmService = new PetMembersService(session);
		PetMembers result = pmService.selectPetMembers(request.getParameter("username"), request.getParameter("password"));
		
		HttpSession Hsession = request.getSession();
		Hsession.setAttribute("petMembers", result);
		
//		Hsession.setAttribute("memberId", result.getMemberId());
//		Hsession.setAttribute("usename", result.getUsername());
//		Hsession.setAttribute("password", result.getPassword());
//		Hsession.setAttribute("email", result.getEmail());
//		Hsession.setAttribute("gender", result.getGender());
//		Hsession.setAttribute("bday", result.getBday());
//		Hsession.setAttribute("age", result.getAge());
//		Hsession.setAttribute("address", result.getAddress());
//		Hsession.setAttribute("phone", result.getPhone());
//		Hsession.setAttribute("petType", result.getPetType());
//		Hsession.setAttribute("rt", result.getRegisterTime());
		
		 }catch(Exception e) {
			 e.printStackTrace();
			 session.getTransaction().rollback();
		 }
		
//		HibernateUtil.closeSessionFactory();
		
		response.sendRedirect("/PET_28/practicePage/Success.jsp");
	}

}
