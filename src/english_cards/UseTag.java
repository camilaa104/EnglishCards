
package english_cards;

public enum UseTag implements CodeEnum {
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
