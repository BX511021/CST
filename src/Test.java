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
        String argStr;
        while (scan.hasNextLine()) {
            argStr = scan.nextLine();
            String[] argline = argStr.split(" ");
            //推出模式
            if (argStr.equals("QUIT")) {
                System.out.println("----- Good Bye! -----");
                System.exit(0);
            }
            //进入列车管理员模式
            else if (argStr.equals("TunakTunakTun"))
            {
                BrahmanMode.Brahman_Go(lineDataBase,trainDataBase);
            }
            //普通模式对于列车进行操作
            else if(argline[0].equals("lineInfo")||
                    argline[0].equals("listLine")||
                    argline[0].equals("checkTicket")||
                    argline[0].equals("listTrain")){
                LineControl.Dalit_Run(argline,lineDataBase,trainDataBase);
            }
            //错误判定
            else if (argStr.equals("NutKanutKanut"))
            {
                System.out.println("WaNiba");
            }
            //用户操作
            else {

                userDatabase.addUser(argline);
            }

        }
        scan.close();
        System.exit(0);

    }
}




