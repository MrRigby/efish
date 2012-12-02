/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jdeveloper.facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang.StringUtils;
import pl.jdeveloper.entities.Lesson;
import pl.jdeveloper.entities.Lesson_;
import pl.jdeveloper.facade.filters.LessonsFilter;

/**
 *
 * @author lukasz
 */
@Stateless
public class LessonFacade extends AbstractFacade<Lesson> implements LessonFacadeLocal {
    @PersistenceContext(unitName = "efish-ejb-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LessonFacade() {
        super(Lesson.class);
    }

    @Override
    public List<Lesson> findAllBy(LessonsFilter filter) {
        
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        
        // select-clause
        Root<Lesson> root = cq.from(Lesson.class);
        cq.select(root);

        // where-clause
        Predicate wherePredicate = makeWherePredicate(cb, cq, root, filter);
        if (wherePredicate != null) {
            cq.where(wherePredicate);
        }

        return getEntityManager().createQuery(cq).getResultList();
    }

    private Predicate makeWherePredicate(CriteriaBuilder cb,
            CriteriaQuery cq, Root<Lesson> root, LessonsFilter filter) {

        List<Predicate> where = new ArrayList<Predicate>();

        if (StringUtils.isNotEmpty(filter.getTitle())) {
            where.add(cb.like(root.get(Lesson_.title), "%" + filter.getTitle() + "%"));
        }
        if (filter.getFrom() != null) {
            where.add(cb.greaterThanOrEqualTo(root.get(Lesson_.eventDate), filter.getFrom()));
        }
        if (filter.getTo() != null) {
            where.add(cb.lessThanOrEqualTo(root.get(Lesson_.eventDate), filter.getTo()));
        }

        if (where.size() > 0) {
            return cb.and(where.toArray(new Predicate[0]));
        } else {
            return null;
        }
    }

}
