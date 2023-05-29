
package Nyc;

/**
 *
 * @author ul
 */
public enum Category {
    CATEGORY1("Kategorie 1", 119, 153),
    CATEGORY2("Kategorie 2", 154, 177),
    CATEGORY3("Kategorie 3", 178, 208),
    CATEGORY4("Kategorie 4", 209, 251),
    CATEGORY5("Kategorie 5", 252, Double.MAX_VALUE);
    
    private String description;
    private double minSpeed;
    private double maxSpeed;

    private Category(String description, double minSpeed, double maxSpeed) {
        this.description = description;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    public String getDescription() {
        return description;
    }

    public double getMinSpeed() {
        return minSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }
    
    public static Category getCategory (Hurricane h) {
        double speed = h.getSpeedInKmH();
        Category[] allCategories = Category.values();
        for(Category c : allCategories) {
            if (speed >= c.minSpeed && speed <= c.maxSpeed) {
                return c;
            }
        }
        throw new IllegalArgumentException ("Nelze zaradit do zadne kategorie.");
    }
    
    
    
    
}
