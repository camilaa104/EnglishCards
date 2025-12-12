package english_cards;

public enum VocabularyTag {
    FOOD(1),
    TRAVEL(2),
    SCHOOL(3),
    WORK(4),
    TECHNOLOGY(5),
    FAMILY(6),
    HEALTH(7),
    PROFESSIONS(8),
    COLORS(9),
    NATURE(10),
    HOUSE(11),
    TRANSPORTS(12),
    ANIMALS(13),
    WEATHER(14),
    CLOTHES(15),
    SPORTS(16),
    EMOTIONS(17);
    
    private final int code;

    VocabularyTag(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static VocabularyTag fromCode(int code) {
        for (VocabularyTag c : values()) {
            if (c.code == code) {
                return c;
            }
        }
        return null;
    }
    
}
