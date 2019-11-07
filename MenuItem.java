public class MenuItem extends MenuComponent {
    private final String name;
    private final String type;
    private final double price;

    public MenuItem(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }

    public String show() {
        return "\n" + getName() +
                "\n " + getPrice() +
                "\n--" + getType() + "\n";
    }

        return "";
    }
}