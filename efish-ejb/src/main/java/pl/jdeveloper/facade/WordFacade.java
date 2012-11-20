/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jdeveloper.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.jdeveloper.entities.Word;

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
    
}
