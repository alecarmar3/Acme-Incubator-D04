
package acme.features.entrepreneur.investmentRound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class EntrepreneurInvestmentRoundShowService implements AbstractShowService<Entrepreneur, InvestmentRound> {

	@Autowired
	private EntrepreneurInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creationDate", "kindOfRound", "title", "description", "amountOfMoney", "additionalInfo", "entrepreneur.userAccount.username");
	}

	@Override
	public InvestmentRound findOne(final Request<InvestmentRound> request) {
		assert request != null;

		InvestmentRound result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		result.setAmountOfMoney(this.repository.getBudgetSumOfInvestmentRound(id));

		return result;
	}

}
