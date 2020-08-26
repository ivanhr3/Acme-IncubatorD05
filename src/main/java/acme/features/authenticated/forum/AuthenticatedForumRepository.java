
package acme.features.authenticated.forum;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.forums.Forum;
import acme.entities.messages.Message;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedForumRepository extends AbstractRepository {

	@Query("select f from Forum f where f.entrepreneur.userAccount.id = ?1")
	Collection<Forum> findAllByEntrepreneurId(int id);

	@Query("select f from Forum f where f.investor.userAccount.id = ?1")
	Collection<Forum> findAllByInvestorId(int id);

	@Query("select f from Forum f where f.id = ?1")
	Forum findForumById(int id);

	@Query("select m from Message m where m.forum.id = ?1")
	Collection<Message> findAllMessagesById(int id);

}
