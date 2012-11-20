/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jdeveloper.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.jdeveloper.entities.Lesson;

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
    
}
