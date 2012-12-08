/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jdeveloper.facade;

import java.util.List;
import javax.ejb.Local;
import pl.jdeveloper.entities.Word;
import pl.jdeveloper.facade.filters.WordsFilter;

/**
 *
 * @author lukasz
 */
@Local
public interface WordFacadeLocal {

    void create(Word word);

    void edit(Word word);

    void remove(Word word);

    Word find(Object id);

    List<Word> findAll();

    List<Word> findRange(int[] range);
    
    List<Word> findAllBy(WordsFilter filter);

    int count();
    
}
