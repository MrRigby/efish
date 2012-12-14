/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jdeveloper.facade;

import java.util.List;
import javax.ejb.Local;
import pl.jdeveloper.entities.GroupOfUsers;

/**
 *
 * @author 125914
 */
@Local
public interface GroupOfUsersFacadeLocal {

    void create(GroupOfUsers groupOfUsers);

    void edit(GroupOfUsers groupOfUsers);

    void remove(GroupOfUsers groupOfUsers);

    GroupOfUsers find(Object id);

    List<GroupOfUsers> findAll();

    List<GroupOfUsers> findRange(int[] range);

    int count();
    
}
