/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jdeveloper.efish.web.components;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import pl.jdeveloper.entities.Lesson;
import pl.jdeveloper.facade.LessonFacadeLocal;

/**
 *
 * @author lukasz
 */
@Named("lessonsComponent")
@RequestScoped
public class Lessons {

    private List<SelectItem> lessons = new ArrayList<SelectItem>();
    
    @EJB
    private LessonFacadeLocal lessonFacade;

    public List<SelectItem> getLessons() {
        return lessons;
    }

    @PostConstruct
    private void retrieve() {
        List<Lesson> allLessons = lessonFacade.findAll();
        if (allLessons != null) {
            this.lessons.clear();
            for (Lesson lesson : allLessons) {
                this.lessons.add(new SelectItem(lesson.getId(), lesson.getTitle()));
            }
        }
    }
}
