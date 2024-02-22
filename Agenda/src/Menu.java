import java.util.ArrayList;

public class Menu {
    private ArrayList<Main> tasks;

    public Menu() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Main task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        tasks.remove(index);
    }

    public void markTaskAsCompleted(int index) {
        tasks.get(index).markAsCompleted();
    }

    public void markTaskAsExpired(int index) {
        tasks.get(index).markAsExpired();
    }

    public ArrayList<Main> getTasks() {
        return tasks;
    }
}



