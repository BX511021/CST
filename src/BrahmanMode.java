import java.util.Scanner;

public class BrahmanMode {
    public static void Brahman_Go(LineDataBase lineDataBase){
        System.out.print("Super Brahman Lets Go");
        System.out.println("DuluDulu");
        Scanner cin = new Scanner(System.in);
        String argStr;
        while (cin.hasNextLine()) {
            argStr = cin.nextLine();
            String[] argline = argStr.split(" ");
            //超级管理员的控制操作
            if (argline[0].equals("addLine")||argline[0].equals("delLine")||argline[0].equals("addStation")||argline[0].equals("delStation")||argline[0].equals("listLine"))
            {
                LineControl.Brahman_Run(argline ,lineDataBase);
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
    public static void Brahman_Run(String[] argsline,LineDataBase lineDataBase){

        if (argsline[0].equals("addLine"))
        {
            lineDataBase.add_Line(argsline);
        }

        else if (argsline[0].equals("delLine"))
        {
            lineDataBase.delete_Line(argsline);
        }

        else if (argsline[0].equals("addStation")){
            lineDataBase.add_station(argsline);

        }
        else if (argsline[0].equals("delStation")){
            lineDataBase.del_station(argsline);
        }
        else if (argsline[0].equals("listLine")){
            lineDataBase.toString();
        }

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


