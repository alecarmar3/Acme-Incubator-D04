
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AccountingRecord extends DomainEntity {

	// Serialization identifier -----------------------------------------------

	private static final long		serialVersionUID	= 1L;

	// Attributes --------------------------------------------------------------

	@NotBlank
	private String					title;

	@NotNull
	private AccountingRecordStatus	status;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date					creationDate;

	@NotBlank
	private String					body;

}
