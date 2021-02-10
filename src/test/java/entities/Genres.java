package entities;

public enum Genres {
    COMEDY("Комедия"),
    BOYEVIK("Боевик"),
    DETECTIVE("Детектив"),
    FANTASY("Фэнтези"),
    PHANTASTIC("Фантастика"),
    ANIME("Аниме"),
    HORROR("Ужасы"),
    THRILLER("Триллер"),
    DRAMA("Драма"),
    MELODRAMA("Мелодрама");

    private String value;

    Genres(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
