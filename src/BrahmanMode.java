import java.util.Scanner;

public class BrahmanMode {
    public static void Brahman_Go(){
        System.out.print("Super Brahman Lets Go");
        System.out.println("DuluDulu");
        Scanner cin = new Scanner(System.in);
        String argStr;
        while (cin.hasNextLine()) {
            argStr = cin.nextLine();
            String[] argline = argStr.split(" ");


            if (argline[0].equals("addLine")||argline[0].equals("delLine")||argline[0].equals("addStation")||argline[0].equals("delStation"))
            {
                LineControl.Brahman_Run();
            }


            else if (argStr.equals("addTrain"))
            {
                TrainControl.Brahman_Run();
            }



            else if (argStr.equals("TunakTunakTun"))
            {
                System.out.println("WaNiBa");
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
    public static void Brahman_Run(){
        System.out.println("Liner Control Run");
    }
    public static void Dalit_Run(){
        System.out.println("oh Poor Dalit");
    }
}

class TrainControl{
    public static void Brahman_Run(){
        System.out.println("Train Control Run");

    }
    public static void Dalit_Run(){
        System.out.println("Ohh poor Dalit");
    }
}


