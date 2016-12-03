package no.gnome;

public class Location {
    
    private String name;

    public Location() {
    }
    
    public Location(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
