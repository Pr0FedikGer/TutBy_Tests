package entities;

public enum GenreSections {
    FILMS(0), SERIALS(1), MULTFILMS(2);
    int value;

    GenreSections(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
