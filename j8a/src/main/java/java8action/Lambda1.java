package java8action;

public class Lambda1 {

//        public void init() {
//        String[] str = new String[] {"mercury", "Venus", "Earth", "Mars", "Jupiter"};
//
//        System.out.println(Arrays.toString(str));
//        System.out.println("sort");
//        Arrays.sort(str);
//        System.out.println(Arrays.toString(str));
//        System.out.println("sort by length");
//        Arrays.sort(str, (f, s) -> f.length() - s.length());
//        System.out.println(str);
//        Timer t = new Timer(1000, event -> System.out.println(new Date()));
//        t.start();
//
//        JOptionPane.showMessageDialog(null, "quit");
//        System.exit(0);
//    }

    int a = 1;

    public void init() {
        Runnable runnable = () -> System.out.println(this.toString());
        runnable.run();
    }

    public static void main(String[] args) {
        Lambda1 Lambda1 = new Lambda1();
        Lambda1.init();
    }

//    @Override
//    public String toString() {
//        return "Lambda1{" +
//                "a=" + a +
//                '}';
//    }
}
