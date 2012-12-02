/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jdeveloper.facade;

import java.util.List;
import javax.ejb.Local;
import pl.jdeveloper.entities.Lesson;
import pl.jdeveloper.facade.filters.LessonsFilter;

/**
 *
 * @author lukasz
 */
@Local
public interface LessonFacadeLocal {

    void create(Lesson lesson);

    void edit(Lesson lesson);

    void remove(Lesson lesson);

    Lesson find(Object id);

    List<Lesson> findAll();
    
    List<Lesson> findAllBy(LessonsFilter filter);

    List<Lesson> findRange(int[] range);
    
    int count();
}
