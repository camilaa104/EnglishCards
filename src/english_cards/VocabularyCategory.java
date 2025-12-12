
package english_cards;
public enum VocabularyCategory {
    VERB(1),
    NOUN(2),
    ADJECTIVE(3),
    ADVERB(4),
    IDIOM(5),
    PHRASAL_VERB(6),
    CONNECTOR(7),
    PRESPOSITION(8),
    ARTICLES(9),
    QUANTIFIERS(10);
    
    private final int code;

    VocabularyCategory(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static VocabularyCategory fromCode(int code) {
        for (VocabularyCategory c : values()) {
            if (c.code == code) {
                return c;
            }
        }
        return null;
    }
}
