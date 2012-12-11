/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jdeveloper.efish.web.jsf;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import pl.jdeveloper.entities.Word;
import pl.jdeveloper.facade.WordFacadeLocal;
import pl.jdeveloper.facade.filters.WordsFilter;

/**
 *
 * @author lukasz
 */
@ManagedBean(name = "wordsController")
@ViewScoped
public class WordsController {

    @EJB
    private WordFacadeLocal wordFacade;

    private Integer queryByLessonId;
    private String queryByText1;
    private String queryByText2;

    private List<Word> words;

    public void readWords() {
        WordsFilter filter = new WordsFilter(queryByLessonId, queryByText1, queryByText2);
        words = wordFacade.findAllBy(filter);
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public Integer getQueryByLessonId() {
        return queryByLessonId;
    }

    public void setQueryByLessonId(Integer queryByLessonId) {
        this.queryByLessonId = queryByLessonId;
    }

    public String getQueryByText1() {
        return queryByText1;
    }

    public void setQueryByText1(String queryByText1) {
        this.queryByText1 = queryByText1;
    }

    public String getQueryByText2() {
        return queryByText2;
    }

    public void setQueryByText2(String queryByText2) {
        this.queryByText2 = queryByText2;
    }
}
