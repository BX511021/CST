import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        UserDatabase userDatabase = new UserDatabase();
        LineDataBase lineDataBase = new LineDataBase();
        Scanner scan = new Scanner(System.in);
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
                BrahmanMode.Brahman_Go(lineDataBase);
            }


            else if (argStr.equals("NutKanutKanut"))
            {
                System.out.println("WaNiba");
            }
            else if(argline[0].equals("lineInfo")){
                LineControl.Brahman_Run(argline,lineDataBase);
            }


            else {

                userDatabase.addUser(argline);
            }

        }
        scan.close();
        System.exit(0);

    }
}




