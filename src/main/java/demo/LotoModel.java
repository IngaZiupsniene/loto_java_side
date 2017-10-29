package demo;

public class LotoModel {
    private int id;
    private String name;
    private int amount;

    public LotoModel() {
    }

    public LotoModel(int id, String name, int amount) {
        this.setId(id);
        this.setName(name);
        this.setAmount(amount);
    }

    public LotoModel(String name, int amount) {
        this.setName(name);
        this.setAmount(amount);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "LotoModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
