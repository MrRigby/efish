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
import pl.jdeveloper.entities.Lesson_;
import pl.jdeveloper.entities.Word;
import pl.jdeveloper.entities.Word_;
import pl.jdeveloper.facade.filters.WordsFilter;

/**
 *
 * @author lukasz
 */
@Stateless
public class WordFacade extends AbstractFacade<Word> implements WordFacadeLocal {

    @PersistenceContext(unitName = "efish-ejb-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WordFacade() {
        super(Word.class);
    }

    @Override
    public List<Word> findAllBy(WordsFilter filter) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();

        // select-clause
        Root<Word> root = cq.from(Word.class);
        cq.select(root);

        // where-clause
        Predicate wherePredicate = buildWherePredicate(cb, cq, root, filter);
        if (wherePredicate != null) {
            cq.where(wherePredicate);
        }

        return getEntityManager().createQuery(cq).getResultList();
    }

    private Predicate buildWherePredicate(CriteriaBuilder cb,
            CriteriaQuery cq, Root<Word> root, WordsFilter filter) {

        List<Predicate> where = new ArrayList<Predicate>();

        if (filter.getLessonId() != null) {
            where.add(cb.equal(root.get(Word_.lesson).get(Lesson_.id), filter.getLessonId()));
        }
        if (StringUtils.isNotEmpty(filter.getText1())) {
            where.add(cb.like(root.get(Word_.text1), "%" + filter.getText1() + "%"));
        }
        if (StringUtils.isNotEmpty(filter.getText2())) {
            where.add(cb.like(root.get(Word_.text2), "%" + filter.getText2() + "%"));
        }

        if (where.size() > 0) {
            return cb.and(where.toArray(new Predicate[0]));
        } else {
            return null;
        }
    }
}
