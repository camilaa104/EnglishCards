
package english_cards;

public enum Level {
    A1(1),
    A2(2),
    B1(3),
    B2(4),
    C1(5),
    C2(6);
    private final int code;

    Level(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Level fromCode(int code) {
        for (Level c : values()) {
            if (c.code == code) {
                return c;
            }
        }
        return null;
    }
}
