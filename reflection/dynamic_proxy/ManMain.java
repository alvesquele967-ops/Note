package dynamic_proxy;

public class ManMain implements Man {
    private String name;

    public ManMain(String name) {
        this.name = name;
    }

    public String workIn(String place) {
        System.out.println(this.name + " works in " + place);
        return place;
    }

    public void eat() {
        System.out.println(this.name + " eating");
    }

}
