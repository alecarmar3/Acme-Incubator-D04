
package acme.entities;

import javax.persistence.Entity;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DiscussionForum extends DomainEntity {

	// Serialization identifier -----------------------------------------------

	private static final long serialVersionUID = 1L;

	// Attributes --------------------------------------------------------------

}
