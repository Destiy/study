package facade.home;

/**
 * @author wy
 * @date 2020/11/09
 */
public class PopcornPopper {
    String description;

    public PopcornPopper(String description) {
        this.description = description;
    }

    public PopcornPopper() {

    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void pop() {
        System.out.println(description + " popping popcorn!");
    }

    @Override
    public String toString() {
        return description;
    }
}
