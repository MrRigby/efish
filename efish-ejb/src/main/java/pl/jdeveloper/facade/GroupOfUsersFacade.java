/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jdeveloper.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.jdeveloper.entities.GroupOfUsers;

/**
 *
 * @author 125914
 */
@Stateless
public class GroupOfUsersFacade extends AbstractFacade<GroupOfUsers> implements GroupOfUsersFacadeLocal {

    @PersistenceContext(unitName = "efish-ejb-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupOfUsersFacade() {
        super(GroupOfUsers.class);
    }
}
