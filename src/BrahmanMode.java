import java.util.Scanner;

public class BrahmanMode {
    public static void Brahman_Go(){
        System.out.print("Super Brahman Lets Go");
        System.out.println("DuluDulu");
        Scanner cin = new Scanner(System.in);
        String argStr;
        while (cin.hasNextLine()) {
            argStr = cin.nextLine();
            if (argStr.equals("addStation")) {
                LineControl.runIt();
            }else if (argStr.equals("addTrain"))
            {
                TrainControl.RunIt();
            }
            else if (argStr.equals("NutKanutKanut")){
                System.out.println("DaDaDa");
                return ;
            }

        }
        cin.close();

    }
}

class LineControl{
    public static void runIt(){
        System.out.println("Liner Control Run");
        return;
    }
}

class TrainControl{
    public static void RunIt(){
        System.out.println("Train Control Run");
        return;
    }
}
