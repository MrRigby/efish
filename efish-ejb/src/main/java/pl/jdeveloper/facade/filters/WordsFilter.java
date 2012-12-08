package pl.jdeveloper.facade.filters;

/**
 *
 * @author lukasz
 */
public class WordsFilter {

    private Integer lessonId;
    private String text1;
    private String text2;

    public WordsFilter(Integer lessonId, String text1, String text2) {
        this.lessonId = lessonId;
        this.text1 = text1;
        this.text2 = text2;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
