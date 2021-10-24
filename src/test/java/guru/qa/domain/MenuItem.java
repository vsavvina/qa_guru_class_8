package guru.qa.domain;

public enum MenuItem {
    IDEA("Идеи"),
    NOVELTY("Новинки"),
    CLOTHES("Одежда");

    private String desc;

    MenuItem(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
