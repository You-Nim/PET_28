package pet.member.register.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PetMembers")
public class PetMembers {
	
	private int memberId;
	private String email;
	private String password;
	private String username;
	private String gender;
	private Date bday;
	private int age;
	private String address;
	private String phone;
	private String petType;
	private Blob memberImage;
	private String fileName;
	private Timestamp registerTime;
		
	public PetMembers() {
		
	}
	
	@Id
	@Column(name="memberId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name="bday")
	public Date getBday() {
		return bday;
	}
	public void setBday(Date bday) {
		this.bday = bday;
	}
	
	@Column(name="age")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="petType")
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	
	@Column(name="memberImage")
	public Blob getMemberImage() {
		return memberImage;
	}
	public void setMemberImage(Blob memberImage) {
		this.memberImage = memberImage;
	}
	
	@Column(name="fileName")
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Column(name="registerTime")
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	
	
}
