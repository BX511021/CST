import java.net.Inet4Address;
import java.util.*;

class LineDataBase {
    public ArrayList<Line> Line_List;
    public LineDataBase() {
        this.Line_List= new ArrayList<>();

    }
    public boolean isEmpty(){
       return this.Line_List.isEmpty();
    }

    public boolean isExist(String  line_id)
    {
        for (Line temp_line : this.Line_List) {
            if (Objects.equals(line_id, temp_line.getLine_id()))
                return true;
        }
        return false;
    }

    public Line line_isExist(String  line_id)
    {
        for (Line temp_line : this.Line_List) {
            if (Objects.equals(line_id, temp_line.getLine_id()))
                return temp_line;
        }
        return null;
    }

    public void add_Line(String[] args_line){
        double d =args_line.length;
        if(d%2.0!=1.0)
        {
            System.out.println("Arguments illegal Ohh!");
            return;
        }

            Line lin1=new Line();
            if (isExist((args_line[1]))){
                System.out.println("Line already exists");
                return;
            }
            try {
                String  id=(args_line[1]);
                int content = Integer.parseInt(args_line[2]);

                int miles;


                if (content<=0){
                    System.out.println("Capacity illegal");
                    return;
                }
                for (int i=3;i<args_line.length;i=i+2){
                   miles=Integer.parseInt(args_line[i+1]);
                }

                for (int i=3;i<args_line.length;i=i+2){
                    lin1.add_station(args_line[i],Integer.parseInt(args_line[i+1]),false);
                }
                lin1.setLine_id(id);
                lin1.setContent(content);

            }catch (NumberFormatException e){
                System.out.println("Arguments illegal");
                return;
            }
            System.out.println("Add Line success");
            this.Line_List.add(lin1);

        }


    public void delete_Line(String[] args_Line){
        if (args_Line.length!=2){
            System.out.println("Arguments illegal");
            return;
        }

        try {
            if (!isExist((args_Line[1]))){
                System.out.println("Line does not exist");
                return;
            }
            Iterator<Line> it = this.Line_List.iterator();

            while(it.hasNext())
            {
                Line temp_line = it.next();
                if(Objects.equals(args_Line[1], temp_line.getLine_id()))
                    it.remove();
                System.out.println("Del Line success");
                return;
            }
        }catch (NumberFormatException e){
            System.out.println("Arguments illegal");
            return;

        }
    }

    public void add_station(String[] args_line){
        if(args_line.length!=4){
            System.out.println("Arguments illegal");
            return;
        }
        try {
            if (!isExist((args_line[1]))){
                System.out.println("Line does not exist");
                return;
            }

            Iterator<Line> it = this.Line_List.iterator();
            int num=0;
            while(it.hasNext())
            {
                Line temp_line = it.next();
                if(Objects.equals(args_line[1], temp_line.getLine_id())){
                    temp_line.add_station(args_line[2], Integer.parseInt(args_line[3]),true);
                    Line_List.set(num,temp_line);
                    return;
                }
                num++;

            }
        }catch (NumberFormatException e){
            System.out.println("Arguments illegal");
            return;
        }
    }
    public void del_station(String[] args_line){
        if(args_line.length!=3){
            System.out.println("Arguments illegal");
            return;
        }
        try {
            if (!isExist((args_line[1]))){
                System.out.println("Line does not exist");
                return;
            }

            Iterator<Line> it = this.Line_List.iterator();
            int num=0;
            while(it.hasNext())
            {
                Line temp_line = it.next();

                if(Objects.equals(args_line[1], temp_line.getLine_id())){
                    {
                        temp_line.delete_station(args_line[2]);
                        Line_List.set(num,temp_line);
                        return;
                    }
                }
                num++;

            }
        }catch (NumberFormatException e){
            System.out.println("Arguments illegal");
            return;
        }
    }


    public void list_it(String[] args_line) {
        if (args_line.length!=2){
            System.out.println("Arguments illegal");
            return;
        }
        try {
            if (!isExist((args_line[1]))) {
                System.out.println("Line does not exist");
                return;
            }
            for (Line temp_line : this.Line_List) {
                if (Objects.equals(args_line[1], temp_line.getLine_id())) {
                    {
                        temp_line.toString();
                        return;
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Arguments illegal");
            return;
        }
//        System.out.println("Change Success");

    }

    public void List_all(String[] args_line) {
        if (args_line.length!=1){

            System.out.println("Arguments illegal");
            return;
        }

        if (isEmpty()){
            System.out.println("No Lines");
            return;
        }

        Collections.sort(this.Line_List, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.getLine_id().compareTo(o2.getLine_id());
            }
        });
        int num=1;
        for (Line temp_line : this.Line_List) {
            System.out.print("["+num+"] ");
            temp_line.toString();
            num++;
        }
        return ;
    }



}
