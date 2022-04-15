public class CrossRoad {

    public static void Cross_Z(String [] argsline,LineDataBase lineDataBase,TrainDataBase trainDataBase,boolean Brahman_mode,UserDatabase userDatabase){

        if (argsline[0].equals("addLine")||
                argsline[0].equals("delLine")||
                argsline[0].equals("addStation")||
                argsline[0].equals("delStation")||
                argsline[0].equals("listLine")||
                argsline[0].equals("lineInfo")||
                argsline[0].equals("addTrain")||
                argsline[0].equals("delTrain")||
                argsline[0].equals("listTrain")||
                argsline[0].equals("checkTicket")){

            if (Brahman_mode){
                switch (argsline[0]) {
                    case "addLine" -> lineDataBase.add_Line(argsline);
                    case "delLine" -> lineDataBase.delete_Line(argsline);
                    case "addStation" -> lineDataBase.add_station(argsline);
                    case "delStation" -> lineDataBase.del_station(argsline);
                    case "listLine" -> lineDataBase.List_all(argsline);
                    case "lineInfo" -> lineDataBase.list_it(argsline);
                    case "addTrain" -> trainDataBase.add_train(argsline, lineDataBase);
                    case "delTrain" -> trainDataBase.del_train(argsline, lineDataBase);
                    case "listTrain" -> trainDataBase.list_us(argsline, lineDataBase);
                    default -> {
                        System.out.println("Command does not exist");
                    }
                }
            }else {
                switch (argsline[0]) {
                    case "listLine" -> lineDataBase.List_all(argsline);
                    case "lineInfo" -> lineDataBase.list_it(argsline);
                    case "listTrain" -> trainDataBase.list_us(argsline, lineDataBase);
                    case "checkTicket"->trainDataBase.check_it(argsline,lineDataBase);
                    default -> {
                        System.out.println("Command does not exist");
                    }
                }

            }

            }

        else if (argsline[0].equals("addUser")){
            userDatabase.addUser(argsline);
        }
        else if (argsline[0].equals("login")){
            userDatabase.login(argsline);
        }
        else if (argsline[0].equals("logout")){
            userDatabase.logout(argsline);
        }
        else if (argsline[0].equals("buyTicket")){
            userDatabase.buyTicket(argsline,trainDataBase,lineDataBase);
        }
        else if (argsline[0].equals("listOrder"))
            userDatabase.listOrder(argsline);
        else {
            System.out.println("Command does not exist");
        }


        }
}
