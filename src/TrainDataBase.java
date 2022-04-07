
import Train_type.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class TrainDataBase {
    private ArrayList<Train> Train_list ;

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

    public boolean  add_train(String [] args_line){

        try {
            int i,j;
            for (i=3;i<args_line.length;i++){
                j=Integer.parseInt(args_line[i]);
                if(j<=0)
                {
                    if(i%2==1){
                        System.out.println("Price illegal");
                    }
                    else {
                        System.out.println("Ticket num illegal");
                    }
                    return false;

                }
            }


            Train train = new Train(args_line[1]);
            if (isExist(train.Train_id))
            {
                System.out.println("Train_type.Train serial duplicate");
                return false;
            }

            if(train.Train_id.charAt(0)=='K'){

                if(args_line.length!=7)
                {
                    System.out.println("Train_type.Train serial illegal");
                    return false;
                }
                Train_K train1=new Train_K(train.Train_id);

                train1.setA1_price(Integer.parseInt(args_line[3]));
                train1.setA1_num(Integer.parseInt(args_line[4]));

                train1.setA2_price(Integer.parseInt(args_line[5]));
                train1.setA2_num(Integer.parseInt(args_line[6]));



                Train_list.add(train1);
                System.out.println("Train_type.Train Success");
                return true;

            }
            else if(train.Train_id.charAt(0)=='0'){

                if(args_line.length!=9)
                {
                    System.out.println("Train_type.Train serial illegal");
                    return false;
                }
                Train_0 train1=new Train_0(train.Train_id);

                train1.setCC_price(Integer.parseInt(args_line[3]));
                train1.setCC_num(Integer.parseInt(args_line[4]));

                train1.setSB_price(Integer.parseInt(args_line[5]));
                train1.setCC_num(Integer.parseInt(args_line[6]));

                train1.setGG_price(Integer.parseInt(args_line[7]));
                train1.setGG_num(Integer.parseInt(args_line[8]));

                Train_list.add(train1);
                System.out.println("Train_type.Train Success");
                return true;
            }else if (train.Train_id.charAt(0)=='G'){

                if(args_line.length!=9)
                {
                    System.out.println("Train_type.Train serial illegal");
                    return false;
                }
                Train_G train1 =new Train_G(train.Train_id);

                train1.setSC_price(Integer.parseInt(args_line[3]));
                train1.setSC_num(Integer.parseInt(args_line[4]));

                train1.setCC_price(Integer.parseInt(args_line[5]));
                train1.setCC_num(Integer.parseInt(args_line[6]));

                train1.setSB_price(Integer.parseInt(args_line[7]));
                train1.setSB_num(Integer.parseInt(args_line[8]));

                Train_list.add(train1);
                System.out.println("Train_type.Train Success");
                return true;

            }
            else {
                System.out.println("Train_type.Train serial illegal");
                return false;

            }
        }catch (NumberFormatException e){
            System.out.println("Number illegal");
            return false;
        }
    }

    public boolean del_train(String [] args_line){
        if (isExist((args_line[1]))){
            System.out.println("Line does exist");
            Iterator<Train> it = this.Train_list.iterator();
            while(it.hasNext())
            {
                Train temp_train = it.next();
                if(Objects.equals(args_line[1], temp_train.Train_id)) {
                    it.remove();
                    System.out.println("Del Train_type.Train Success");
                    return true;
                }
            }
        }
        return false;
    }
}
