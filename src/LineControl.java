public class LineControl {
    public static void Brahman_Run(String[] argsline, LineDataBase lineDataBase,TrainDataBase trainDataBase) {

        if (argsline[0].equals("addLine")) {
            lineDataBase.add_Line(argsline);
        } else if (argsline[0].equals("delLine")) {
            lineDataBase.delete_Line(argsline);
        } else if (argsline[0].equals("addStation")) {
            lineDataBase.add_station(argsline);

        } else if (argsline[0].equals("delStation")) {
            lineDataBase.del_station(argsline);
        } else if (argsline[0].equals("listLine")) {
            lineDataBase.List_all(argsline);
        } else if (argsline[0].equals("lineInfo")) {
            lineDataBase.list_it(argsline);
        }
        else if (argsline[0].equals("addTrain")){
            trainDataBase.add_train(argsline,lineDataBase);
        }
        else if (argsline[0].equals("delTrain")){
            trainDataBase.del_train(argsline,lineDataBase);
        }
        else if (argsline[0].equals("listTrain")){
            trainDataBase.list_us(argsline,lineDataBase);
        }

    }

    public static void Dalit_Run(String[] argsline,LineDataBase lineDataBase,TrainDataBase trainDataBase) {
        System.out.println("oh Poor Dalit");
      if (argsline[0].equals("listLine")) {
        lineDataBase.List_all(argsline);
    } else if (argsline[0].equals("lineInfo")) {
        lineDataBase.list_it(argsline);
    }
      else if (argsline[0].equals("listTrain")){
          trainDataBase.list_us(argsline,lineDataBase);

      }
      else if (argsline[0].equals("checkTicket")){
          trainDataBase.check_it(argsline,lineDataBase);
      }
    }
}
