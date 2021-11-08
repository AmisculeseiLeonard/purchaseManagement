package ooad.purchasemanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Agent extends AbstractEmployee{
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

	public Agent(@NotBlank(message = "First name is mandatory") @Size(max = 100) String firstName,
			@NotBlank(message = "Last name is mandatory") @Size(max = 100) String lastName, Role role,
			@NotBlank(message = "Phone number is mandatory") String phoneNumber,
			@NotBlank(message = "Email is mandatory") @Email(message = "The format of email is invalid") String email,
			@Past Date birthDate) {
		super(firstName, lastName, role, phoneNumber, email, birthDate);
		
	}

}
