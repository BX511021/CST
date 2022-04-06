
import Train_type.*;
import com.sun.jdi.connect.Connector;

import java.util.ArrayList;

public class TrainDataBase {
    private ArrayList<Train> Train_list ;

    public TrainDataBase() {
        this.Train_list=new ArrayList<>(Train_list);
    }
    public boolean isEmpty(){
        return this.Train_list.isEmpty();
    }

    public void add_train(Train train,String [] args_line){
        if(train.Train_id.charAt(0)=='K'){
            Train_K train1=new Train_K(train.Train_id);

            train1.setA1_price(Integer.parseInt(args_line[2]));
            train1.setA1_num(Integer.parseInt(args_line[3]));

            train1.setA2_price(Integer.parseInt(args_line[4]));
            train1.setA2_num(Integer.parseInt(args_line[5]));

            Train_list.add(train1);

        }
        else if(train.Train_id.charAt(0)=='0'){
            Train_0 train1=new Train_0(train.Train_id);

            train1.setCC_price(Integer.parseInt(args_line[2]));
            train1.setCC_num(Integer.parseInt(args_line[3]));

            train1.setSB_price(Integer.parseInt(args_line[4]));
            train1.setCC_num(Integer.parseInt(args_line[5]));

            train1.setGG_price(Integer.parseInt(args_line[6]));
            train1.setGG_num(Integer.parseInt(args_line[7]));

            Train_list.add(train1);
        }else if (train.Train_id.charAt(0)=='G'){
            Train_G train1 =new Train_G(train.Train_id);

            train1.setSC_price(Integer.parseInt(args_line[2]));
            train1.setSC_num(Integer.parseInt(args_line[3]));

            train1.setCC_price(Integer.parseInt(args_line[4]));
            train1.setCC_num(Integer.parseInt(args_line[5]));

            train1.setSB_price(Integer.parseInt(args_line[6]));
            train1.setSB_num(Integer.parseInt(args_line[7]));

            Train_list.add(train1);


        }
    }

}
