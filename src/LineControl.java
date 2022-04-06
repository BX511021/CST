public class LineControl {
    public static void Brahman_Run(String[] argsline, LineDataBase lineDataBase) {

        if (argsline[0].equals("addLine")) {
            lineDataBase.add_Line(argsline);
        } else if (argsline[0].equals("delLine")) {
            lineDataBase.delete_Line(argsline);
        } else if (argsline[0].equals("addStation")) {
            lineDataBase.add_station(argsline);

        } else if (argsline[0].equals("delStation")) {
            lineDataBase.del_station(argsline);
        } else if (argsline[0].equals("listLine")) {
            lineDataBase.List_all();
        } else if (argsline[0].equals("lineInfo")) {
            lineDataBase.list_it(argsline);
        }

    }

    public static void Dalit_Run() {
        System.out.println("oh Poor Dalit");
    }
}
