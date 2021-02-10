package entities;

public enum MainSectionsOfGenres {
    FILMS(0), SERIALS(1), MULTFILMS(2);
    int index;

    MainSectionsOfGenres(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
