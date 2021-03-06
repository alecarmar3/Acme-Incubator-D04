
package acme.features.investor.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorApplicationRepository extends AbstractRepository {

	@Query("select ir from Application ir where ir.id = ?1")
	Application findOneById(int id);

	@Query("select a from Application a where a.investor.id = ?1")
	Collection<Application> findMyApplications(int id);

}
