public class Main {
    private String description;
    private boolean completed;
    private boolean expired;

    public Main(String description) {
        this.description = description;
        this.completed = false;
        this.expired = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isExpired() {
        return expired;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public void markAsExpired() {
        this.expired = true;
    }
}


