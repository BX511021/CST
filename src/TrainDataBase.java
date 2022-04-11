
import Train_type.*;

import java.util.*;

public class TrainDataBase {
    public ArrayList<Train> Train_list ;

    public TrainDataBase() {
        this.Train_list=new ArrayList<>();
    }
    public boolean isEmpty(){
        return this.Train_list.isEmpty();
    }

    public boolean isExist(String  line_id)
    {
        for (Train temp_train : this.Train_list) {
            if (Objects.equals(line_id, temp_train.Train_id))
                return true;
        }
        return false;
    }

    public boolean check_legal(String [] args_line,Train train,LineDataBase lineDataBase){
        if (!legal_train(train.Train_id)){
            System.out.println("Train serial illegal");
            return false;
        }


        if (isExist(train.Train_id))
        {
            System.out.println("Train serial duplicate");
            return false;
        }

        Line line=lineDataBase.line_isExist(args_line[2]);
        if (line!=null&& Objects.requireNonNull(line).train_num<line.content){
            ;
        }
        else {
            System.out.println("Line illegal");
            return false;
        }

        int i;
        double j;
        for (i=3;i<args_line.length;i++){
            if(i%2==1)
            {
                j=Double.parseDouble(args_line[i]);
                if (j<0)
                {
                    System.out.println("Price illegal");
                    return false;
                }
            }
            else
            {
                j=Integer.parseInt(args_line[i]);
                if (j<0){
                    System.out.println("Ticket num illegal");
                    return false;
                }

            }
        }
        return true;
    }

    public boolean legal_train(String train_id){

        if(train_id.charAt(0)!='K'&&train_id.charAt(0)!='G'&&train_id.charAt(0)!='0'){
            return false;
        }
        if (train_id.length()!=5){
            return false;
        }
        for (int i=1;i<=4;i++){
            if(!Character.isDigit(train_id.charAt(i))){
                return false;
            }
        }

        return true;

    }

    public void   add_train(String [] args_line,LineDataBase lineDataBase){

       try {

            Train train = new Train(args_line[1]);
            if(train.Train_id.charAt(0)=='K'){


                if(args_line.length!=7)
                {
                    System.out.println("Arguments illegal");
                    return ;
                }
                if (!check_legal(args_line,train,lineDataBase)){
                    return;
                }

                Train_K train1=new Train_K(train.Train_id);

                train1.setT_line_id(args_line[2]);

                train1.setA1_price(Double.parseDouble(args_line[3]));
                train1.setA1_num(Integer.parseInt(args_line[4]));

                train1.setA2_price(Double.parseDouble(args_line[5]));
                train1.setA2_num(Integer.parseInt(args_line[6]));

                Train_list.add(train1);
                lineDataBase.line_isExist(args_line[2]).train_num++;
                System.out.println("Add Train Success");


            }
            else if(train.Train_id.charAt(0)=='0'){


                if(args_line.length!=9)
                {
                    System.out.println("Arguments illegal");
                    return ;
                }
                if (!check_legal(args_line,train,lineDataBase)){
                    return;
                }



                Train_0 train1=new Train_0(train.Train_id);

                train1.setT_line_id(args_line[2]);

                train1.setCC_price(Double.parseDouble(args_line[3]));
                train1.setCC_num(Integer.parseInt(args_line[4]));

                train1.setSB_price(Double.parseDouble(args_line[5]));
                train1.setSB_num(Integer.parseInt(args_line[6]));

                train1.setGG_price(Double.parseDouble(args_line[7]));
                train1.setGG_num(Integer.parseInt(args_line[8]));

                Train_list.add(train1);
                lineDataBase.line_isExist(args_line[2]).train_num++;
                System.out.println("Add Train Success");

            }else if (train.Train_id.charAt(0)=='G'){


                if(args_line.length!=9)
                {
                    System.out.println("Arguments illegal");
                    return ;
                }

                if (!check_legal(args_line,train,lineDataBase)){
                    return;
                }

                Train_G train1 =new Train_G(train.Train_id);

                train1.setT_line_id(args_line[2]);

                train1.setSC_price(Double.parseDouble(args_line[3]));
                train1.setSC_num(Integer.parseInt(args_line[4]));

                train1.setHC_price(Double.parseDouble(args_line[5]));
                train1.setHC_num(Integer.parseInt(args_line[6]));

                train1.setSB_price(Double.parseDouble(args_line[7]));
                train1.setSB_num(Integer.parseInt(args_line[8]));

                Train_list.add(train1);
                lineDataBase.line_isExist(args_line[2]).train_num++;
                System.out.println("Add Train Success");

            }
            else {
                System.out.println("Train serial illegal");

            }
        }catch (NumberFormatException e){
           System.out.println("Number illegal");
       }
    }

    public void del_train(String [] args_line, LineDataBase lineDataBase){

//        if (lineDataBase.line_isExist(args_line[2])!=null){
//            lineDataBase.line_isExist(args_line[2]).train_num--;
//        }
//        else {
//            System.out.println("Line illegal");
//            return false;
//        }
        if (isExist((args_line[1]))){

//           System.out.println("Train does exist");
            Iterator<Train> it = this.Train_list.iterator();
            while(it.hasNext())
            {
                Train temp_train = it.next();
                if(Objects.equals(args_line[1], temp_train.Train_id)) {
                    it.remove();
                    lineDataBase.line_isExist(temp_train.T_line_id).train_num--;
                    System.out.println("Del Train Success");
                    return;
                }
            }
        }
        else {
            System.out.println("Train does not exist");
            return;
        }
    }

    public void list_us(String[] args_line,LineDataBase lineDataBase){
        if (isEmpty()){
            System.out.println("No Trains");
            return;
        }
        Collections.sort(this.Train_list, new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.Train_id.compareTo(o2.Train_id);
            }
        });

        if(args_line.length==1){
            int num=1;
            for (Train temp_train : this.Train_list) {
                if (temp_train.Train_id.charAt(0)=='K')
                {
                    System.out.print("[" + num + "] " + temp_train.Train_id + ": " + temp_train.T_line_id + " ");
                    temp_train.toString();
                    num++;
                }

            }
            for (Train temp_train : this.Train_list) {
                if (temp_train.Train_id.charAt(0)=='G'){
                    System.out.print("[" + num + "] " + temp_train.Train_id + ": " + temp_train.T_line_id + " ");
                    temp_train.toString();
                    num++;
                }

            }
            for (Train temp_train : this.Train_list) {
                if (temp_train.Train_id.charAt(0)=='0')
                {
                    System.out.print("[" + num + "] " + temp_train.Train_id + ": " + temp_train.T_line_id + " ");
                    temp_train.toString();
                    num++;
                }
            }
        }

        else if (args_line.length==2){
            if(lineDataBase.line_isExist(args_line[1])==null)
            {
                System.out.println("Line does not exist");
                return;
            }
            else if (lineDataBase.line_isExist(args_line[1]).train_num==0){
                System.out.println("No Trains");
                return;
            }
            else
            {
                int num=1;
                for (Train temp_train : this.Train_list) {
                    if (Objects.equals(temp_train.T_line_id, args_line[1])&&temp_train.Train_id.charAt(0)=='K'){
                        System.out.print("[" + num + "] " + temp_train.Train_id + ": " + temp_train.T_line_id + " ");
                        temp_train.toString();
                        num++;
                    }

                }
                for (Train temp_train : this.Train_list) {
                    if (Objects.equals(temp_train.T_line_id, args_line[1])&&temp_train.Train_id.charAt(0)=='G'){
                        System.out.print("[" + num + "] " + temp_train.Train_id + ": " + temp_train.T_line_id + " ");
                        temp_train.toString();
                        num++;
                    }

                }
                for (Train temp_train : this.Train_list) {
                    if (Objects.equals(temp_train.T_line_id, args_line[1])&&temp_train.Train_id.charAt(0)=='0'){
                        System.out.print("[" + num + "] " + temp_train.Train_id + ": " + temp_train.T_line_id + " ");
                        temp_train.toString();
                        num++;
                    }

                }
            }

        }
        else {
            System.out.println("Arguments illegal");
        }


    }

    public void check_it(String [] args_line,LineDataBase lineDataBase){
        if(this.isEmpty()){
                        System.out.println("No Trains");
                        return;
                }


//        if(lineDataBase.get(args_line[2])==null||this.Line_map.get(args_line[3])==null){
//                        System.out.println("Station duplicate");
//                        return;
//                }
                if(!this.isExist(args_line[1])){
                        System.out.println("Train serial does not exist");
                        return;
                }

                int num=1;
                Iterator<Train> it = this.Train_list.iterator();
                while(it.hasNext())
                {
                        Train temp_train=it.next();
                        Line temp_line=lineDataBase.line_isExist(temp_train.T_line_id);

                        if(temp_train.Train_id.equals(args_line[1])){

                            if (temp_line.Line_map.get(args_line[2])==null||temp_line.Line_map.get(args_line[3])==null){
                                System.out.println("Station does not exist");
                                return;
                            }

                                if (temp_train.get_num(args_line[4])!=-8&&temp_train.get_price(args_line[4])!=-8)

                                {       String Price;
                                        int distance;
                                        distance=Math.abs(temp_line.Line_map.get(args_line[2])-temp_line.Line_map.get(args_line[3]));
                                        Price=new java.text.DecimalFormat("#.00").format(distance*temp_train.get_price(args_line[4]));
                                        System.out.println("["+temp_train.Train_id+": "+args_line[2]+"->"+args_line[3]+"] seat:"+args_line[4]+" remain:"+temp_train.get_num(args_line[4])
                                        +" distance:"+distance+" price:"+Price);
                                        return;
                                }else
                                {
                                    System.out.println("Seat does not match");
                                }
                        }
                }
    }


}
