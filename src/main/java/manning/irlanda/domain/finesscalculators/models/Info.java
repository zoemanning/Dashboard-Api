package manning.irlanda.domain.finesscalculators.models;

public class Info {
    private Double bmi;
    private String health;
    private String healthy_bmi_range;

    public Info() {
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHealthy_bmi_range() {
        return healthy_bmi_range;
    }

    public void setHealthy_bmi_range(String healthy_bmi_range) {
        this.healthy_bmi_range = healthy_bmi_range;
    }

    @Override
    public String toString() {
        return "Info{" +
                "bmi=" + bmi +
                ", health='" + health + '\'' +
                ", healthy_bmi_range='" + healthy_bmi_range + '\'' +
                '}';
    }
}
