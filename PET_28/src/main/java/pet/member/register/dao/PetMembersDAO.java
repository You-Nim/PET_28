package pet.member.register.dao;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pet.member.register.model.PetMembers;

public class PetMembersDAO implements IPetMembersDAO  {
	
	private Session session;

	public PetMembersDAO(Session session) {
		this.session = session;
	}
	
	@Override
	public PetMembers insertPetMembers(PetMembers petMembers) {
		
		PetMembers petMember = session.get(PetMembers.class, petMembers.getMemberId());
		
		if(petMember == null) {
			session.save(petMembers);
		}
		
		return null;
	}
	
	@Override
	public PetMembers selectPetMembers(int memberId) {		
		
		return  session.get(PetMembers.class , memberId);
	}
	
	@Override
	public PetMembers selectPetMembers(String username, String password) {		
		
		Query<PetMembers> query = session.createQuery("from PetMembers where username=?1 and password=?2", PetMembers.class);
		query.setParameter(1, username);
		query.setParameter(2, password);
		System.out.println(username + "  " + password);
		PetMembers result = (PetMembers) query.getSingleResult();
		
		
		return (PetMembers) result;
	}
	
	@Override
	public List<PetMembers> selectAllPetMembers() {
		
		Query<PetMembers> query = session.createQuery("from PetMembers", PetMembers.class);
		List<PetMembers> list = query.list();
		return list;
		
	}
	
	@Override
	public PetMembers updatePetMembers(int memberId, String email, String password, String username, String gender, 
			Date bday, int age, String address, String phone, String petType, Blob memberImage, String fileName, Timestamp registerTime) {
		
		PetMembers petMember = session.get(PetMembers.class, memberId);
		
		if(petMember != null) {
			petMember.setEmail(email);
			petMember.setPassword(password);
			petMember.setUsername(username);
			petMember.setGender(gender);
			petMember.setBday(bday);
			petMember.setAge(age);
			petMember.setAddress(address);
			petMember.setPhone(phone);
			petMember.setPetType(petType);
			petMember.setMemberImage(memberImage);
			petMember.setFileName(fileName);
			
		}
		
		return petMember;
	}
	
	@Override
	public boolean deletePetMembers(int memberId) {
		PetMembers petMember = session.get(PetMembers.class, memberId);
		
		if(petMember!=null) {
			session.delete(petMember);
			return true;
		}
		
		return false;
	}
	
	
}
