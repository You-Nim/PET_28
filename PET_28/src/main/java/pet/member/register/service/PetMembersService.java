package pet.member.register.service;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;

import pet.member.register.dao.PetMembersDAO;
import pet.member.register.model.PetMembers;

public class PetMembersService implements IPetMembersService{
	
	private PetMembersDAO petMembersDAO;
	private Session session;

	public PetMembersService(Session session) {
		this.session = session;
		petMembersDAO = new PetMembersDAO(session);
	}	
	
	@Override
	public PetMembers insertPetMembers(PetMembers petMembers) {
		
		session.beginTransaction();		
		PetMembers	petMember = petMembersDAO.insertPetMembers(petMembers);		
		session.getTransaction().commit();
		
		return petMember;	
	}

	@Override
	public PetMembers selectPetMembers(int memberId) {
		session.beginTransaction();
		PetMembers petMember = petMembersDAO.selectPetMembers(memberId);
		session.getTransaction().commit();
		return  petMember;
	}
	
	@Override
	public PetMembers selectPetMembers(String password, String username) {
		session.beginTransaction();
		PetMembers petMember = petMembersDAO.selectPetMembers(password,username);
		session.getTransaction().commit();
		return  petMember;
	}

	@Override
	public List<PetMembers> selectAllPetMembers() {
		session.beginTransaction();
		List<PetMembers> list = petMembersDAO.selectAllPetMembers();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public PetMembers updatePetMembers(int memberId, String email, String password, String username, String gender,
			Date bday, int age, String address, String phone, String petType, Blob memberImage, String fileName,
			Timestamp registerTime) {
		session.beginTransaction();
		PetMembers petMember = petMembersDAO.updatePetMembers(memberId, email, password, username, gender, 
				bday, age, address, phone, petType, memberImage, fileName, registerTime);
		session.getTransaction().commit();
		return petMember; 
	}

	@Override
	public boolean deletePetMembers(int memberId) {
		session.beginTransaction();
		boolean result = petMembersDAO.deletePetMembers(memberId);
		session.getTransaction().commit();
		return result;
	}
	
	

}
