/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jdeveloper.efish.web.jsf;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import pl.jdeveloper.entities.Lesson;
import pl.jdeveloper.facade.LessonFacadeLocal;
import pl.jdeveloper.facade.filters.LessonsFilter;

/**
 *
 * @author lukasz
 */
@ManagedBean(name = "lessonsController")
@ViewScoped
public class LessonsController {
    
    @EJB
    private LessonFacadeLocal lessonFacade;
    
    private String queryByTitle;
    private Date queryByDateFrom;
    private Date queryByDateTo;
    
    private List<Lesson> lessons;
    
    public void readLessons() {
        LessonsFilter filter = new LessonsFilter(queryByTitle, queryByDateFrom, queryByDateTo);
        lessons = lessonFacade.findAllBy(filter);
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public String getQueryByTitle() {
        return queryByTitle;
    }

    public void setQueryByTitle(String queryByTitle) {
        this.queryByTitle = queryByTitle;
    }

    public Date getQueryByDateFrom() {
        return queryByDateFrom;
    }

    public void setQueryByDateFrom(Date queryByDateFrom) {
        this.queryByDateFrom = queryByDateFrom;
    }

    public Date getQueryByDateTo() {
        return queryByDateTo;
    }

    public void setQueryByDateTo(Date queryByDateTo) {
        this.queryByDateTo = queryByDateTo;
    }
}
