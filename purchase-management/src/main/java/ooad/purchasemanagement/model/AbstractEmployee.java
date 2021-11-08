package ooad.purchasemanagement.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "First name is mandatory")
	@Size(max = 100)
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Last name is mandatory")
	@Size(max = 100)
	@Column(name = "last_name")
	private String lastName;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "role_id")
	private Role role;
	
	@NotBlank(message = "Phone number is mandatory")
	private String phoneNumber;
	
	@NotBlank(message = "Email is mandatory")
	@Email(message = "The format of email is invalid")
	private String email;
	
	@Past
	@Column(name = "birth_date")
	private Date birthDate;
	
	

	public AbstractEmployee() {
		super();
	}

	public AbstractEmployee(@NotBlank(message = "First name is mandatory") @Size(max = 100) String firstName,
			@NotBlank(message = "Last name is mandatory") @Size(max = 100) String lastName, Role role,
			@NotBlank(message = "Phone number is mandatory") String phoneNumber,
			@NotBlank(message = "Email is mandatory") @Email(message = "The format of email is invalid") String email,
			@Past Date birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
