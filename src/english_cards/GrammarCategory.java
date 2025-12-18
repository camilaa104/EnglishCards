
package english_cards;

public enum GrammarCategory implements CodeEnum {
    PRESENT_SIMPLE(1),
    PRESENT_CONTINUOUS(2),
    PRESENT_PERFECT(3),
    PRESENT_PERFECT_CONTINUOUS(4),
    PAST_SIMPLE(5),
    PAST_CONTINUOUS(6),
    PAST_PERFECT(7),
    PAST_PERFECT_CONTINUOUS(8),
    FUTURE(9),
    PASIVE_VOICE(10),
    REPORTED_SPEECH(11),
    COMPARATIVE_SUPERLATIVE(12),
    CONDICIONAL(13),
    GERUND_INFINITIVE(14),
    TAG_QUESTION(15),
    COMPOUND_SENTENCE(16),
    MODAL_VERBS(17),
    RELATIVE_CLAUSES(18);
    
    private final int code;

    GrammarCategory(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static GrammarCategory fromCode(int code) {
        for (GrammarCategory c : values()) {
            if (c.code == code) {
                return c;
            }
        }
        return null;
    }
}
