
package acme.features.authenticated.entrepreneur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.entities.UserAccount;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedEntrepreneurCreateService implements AbstractCreateService<Authenticated, Entrepreneur> {

	@Autowired
	private AuthenticatedEntrepreneurRepository repository;


	@Override
	public boolean authorise(final Request<Entrepreneur> request) {
		assert request != null;

		Principal principal = request.getPrincipal();
		int userId = principal.getAccountId();

		UserAccount ua = this.repository.findOneUserAccountById(userId);
		Entrepreneur e = this.repository.findOneEntrepreneurByUserId(ua.getId());

		return e == null;
	}

	@Override
	public void bind(final Request<Entrepreneur> request, final Entrepreneur entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Entrepreneur> request, final Entrepreneur entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "startupName", "sector", "qualificationRecord", "skillsRecord");

		//Collection<Sector> sectors = this.repository.findAllSectors();
		//model.setAttribute("sectors", sectors);

	}

	@Override
	public Entrepreneur instantiate(final Request<Entrepreneur> request) {
		assert request != null;

		int userAccountId = request.getPrincipal().getAccountId();
		UserAccount userAccount = this.repository.findOneUserAccountById(userAccountId);
		Entrepreneur result = new Entrepreneur();

		result.setUserAccount(userAccount);

		return result;
	}

	@Override
	public void validate(final Request<Entrepreneur> request, final Entrepreneur entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Entrepreneur> request, final Entrepreneur entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

	@Override
	public void onSuccess(final Request<Entrepreneur> request, final Response<Entrepreneur> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
