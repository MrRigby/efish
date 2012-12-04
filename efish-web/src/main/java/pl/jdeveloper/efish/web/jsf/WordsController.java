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

/**
 *
 * @author lukasz
 */
@ManagedBean(name = "wordsController")
@ViewScoped
public class WordsController {

    @EJB
    private WordFacadeLocal wordFacade;
    private List<Word> words;

    public void readWords() {
        words = wordFacade.findAll();
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
