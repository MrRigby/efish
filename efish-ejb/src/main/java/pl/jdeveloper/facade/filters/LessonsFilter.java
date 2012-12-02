/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jdeveloper.facade.filters;

import java.util.Date;

/**
 *
 * @author lukasz
 */
public class LessonsFilter {

    private String title;
    private Date from;
    private Date to;

    public LessonsFilter(String title, Date from, Date to) {
        this.title = title;
        this.from = from;
        this.to = to;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
