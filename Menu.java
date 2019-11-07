public class Menu extends MenuComponent {
    private final ArrayList menuComponents = new ArrayList();
    private final String name;
    private final String type;

    public Menu(String name, String type) {
        this.name = name;
        this.description = type;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int index) {
        return (MenuComponent)menuComponents.get(index);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return description;
    }

    public String show() {
        String menuDisplay = getMenuComponentInfo();
        Iterator iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            menuDisplay += "\n" + menuComponent.show();
        }
        return menuDisplay;
    }

    private String getMenuComponentInfo() {
        return getName() +
               "\n " + getDescription();
    }
}