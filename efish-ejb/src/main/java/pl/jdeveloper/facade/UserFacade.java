/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jdeveloper.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import pl.jdeveloper.entities.Lesson;
import pl.jdeveloper.entities.User;
import pl.jdeveloper.entities.User_;

/**
 *
 * @author 125914
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {
    @PersistenceContext(unitName = "efish-ejb-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
        
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        
        // select-clause
        Root<User> root = cq.from(User.class);
        cq.select(root);

        // where-clause
        Predicate wherePredicate = cb.equal(root.get(User_.username), username);
        cq.where(wherePredicate);

        return (User) getEntityManager().createQuery(cq).getSingleResult();
    }
}
