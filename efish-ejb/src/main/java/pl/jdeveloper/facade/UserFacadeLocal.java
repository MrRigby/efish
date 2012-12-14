/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jdeveloper.facade;

import java.util.List;
import javax.ejb.Local;
import pl.jdeveloper.entities.User;

/**
 *
 * @author 125914
 */
@Local
public interface UserFacadeLocal {

    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);
    
    User findByUsername(String username);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();
}
