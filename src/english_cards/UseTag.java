
package english_cards;

public enum UseTag {
    FORMAL(1), 
    INFORMAL(2), 
    COMMON(3), 
    UNCOMMON(4), 
    REGULAR(5), 
    IRREGULAR(6);
    
    private final int code;

    UseTag(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static UseTag fromCode(int code) {
        for (UseTag t : values()) {
            if (t.code == code) {
                return t;
            }
        }
        return null;
    }
}
