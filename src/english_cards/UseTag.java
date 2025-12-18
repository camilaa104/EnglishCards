
package english_cards;

public enum UseTag implements CodeEnum {
    REGULAR(1), 
    IRREGULAR(2);
    
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
