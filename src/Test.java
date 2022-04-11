import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        UserDatabase userDatabase = new UserDatabase();
        LineDataBase lineDataBase = new LineDataBase();
        TrainDataBase trainDataBase = new TrainDataBase();
        Scanner scan = new Scanner(System.in);
        boolean Brahman_mode=false;
        String argStr;

        while (scan.hasNextLine()) {
            argStr = scan.nextLine();
            String[] argline = argStr.split(" ");

            if (argStr.equals("QUIT")) {
                System.out.println("----- Good Bye! -----");
                System.exit(0);
            }

            else if (argStr.equals("TunakTunakTun"))
            {
                if (Brahman_mode)
                {
                    System.out.println("WanNiBa");
                }else {
//                    System.out.println("Come!!On!!!");
//                    System.out.println("Super Brahman ");
//                    System.out.println("Go!!");
                    System.out.println("DuluDulu");
                    Brahman_mode=true;
                }

            }

            else if(argStr.equals("NutKanutKanut")) {
                if (!Brahman_mode) {
                    System.out.println("WanNiBa");
                } else {
//                    System.out.println("Nice Try");
                    System.out.println("DaDaDa");
                    Brahman_mode = false;
                }
            }

            else {
                CrossRoad.Cross_Z(argline,lineDataBase,trainDataBase,Brahman_mode,userDatabase);
            }

        }
        scan.close();
        System.exit(0);

    }
}




