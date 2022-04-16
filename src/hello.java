import Train_type.Train;

public class hello {
    public static void main(String[] args) {
        System.out.println("hello world");
        String d ="459";
        System.out.println(Double.parseDouble(d));
        if (Train.isPureDigital("-45")){
            System.out.println("Well Done");
        }else {
            System.out.println("Nope");
        }

    }
}
