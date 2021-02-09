package entities;

public enum MainSectionsOfGenres {
    FILMS(0), SERIALS(1), MULTFILMS(2);
    int value;

    MainSectionsOfGenres(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
