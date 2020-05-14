package pet.member.register.service;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import pet.member.register.model.PetMembers;

public interface IPetMembersService {
	
	public PetMembers insertPetMembers(PetMembers petMembers);
	
	public PetMembers selectPetMembers(int memberId);
	
	public List<PetMembers> selectAllPetMembers();
	
	public PetMembers updatePetMembers(int memberId, String email, String password, String username, String gender, 
			Date bday, int age, String address, String phone, String petType, Blob memberImage, String fileName, Timestamp registerTime);
	
	public boolean deletePetMembers(int memberId);

	PetMembers selectPetMembers(String password, String username);
	
}
