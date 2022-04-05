import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        UserDatabase userDatabase = new UserDatabase();
        Scanner scan = new Scanner(System.in);
        String argStr;
        while (scan.hasNextLine()) {
            argStr = scan.nextLine();
            if (argStr.equals("QUIT")) {
                System.out.println("----- Good Bye! -----");
                System.exit(0);
            } else {
                String[] argline = argStr.split(" ");
                userDatabase.addUser(argline);
            }

        }
        scan.close();
        System.exit(0);

    }
}


