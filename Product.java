public class Product {
    private String name;
    private String description;
    private String ID;
    private Double cost;

    public Product(String name, String description, String ID, Double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ID='" + ID + '\'' +
                ", cost=" + cost +
                '}';
    }
    public String toCSVRecord(){
        return ID + "," + name + ","  + description + "," + cost;
    }

}
