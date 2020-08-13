
package acme.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InvestmentRound extends DomainEntity {

	// Serialization identifier -----------------------------------------------

	private static final long		serialVersionUID	= 1L;

	// Attributes --------------------------------------------------------------

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}[-][0-9]{2}[-][0-9]{6}$", message = "{default.error.ticker-pattern}")
	private String					ticker;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date					creationDate;

	@NotBlank
	private String					kindOfRound; //SEED, ANGEL, SERIES-A, SERIES-B, SERIES-C, BRIDGE

	@NotBlank
	private String					title;

	@NotBlank
	private String					description;

	@NotNull
	@Valid
	private Money					amountOfMoney;

	@URL
	private String					additionalInfo;

	@NotNull
	private Collection<Activity>	workProgramme; //Association

}
