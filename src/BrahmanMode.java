import java.util.Scanner;

public class BrahmanMode {
    public static void Brahman_Go(LineDataBase lineDataBase){
        System.out.println("Come!!On!!!");
        System.out.print("Super Brahman ");
        System.out.println("Go!!");
        System.out.println("DuluDulu");
        Scanner cin = new Scanner(System.in);
        String argStr;
        while (cin.hasNextLine()) {
            argStr = cin.nextLine();
            String[] argline = argStr.split(" ");
            //超级管理员的控制操作
            if (argline[0].equals("addLine")||
                    argline[0].equals("delLine")||
                    argline[0].equals("addStation")||
                    argline[0].equals("delStation")||
                    argline[0].equals("listLine")||
                    argline[0].equals("lineInfo")||
                    argline[0].equals("addTrain")||
                    argline[0].equals("delTrain"))
            {
                LineControl.Brahman_Run(argline ,lineDataBase);
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


