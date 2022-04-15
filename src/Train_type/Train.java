package Train_type;

public class Train {
    public String Train_id;
    public String T_line_id;

    public Train(String train_id) {
        Train_id = train_id;
    }

    public String getTrain_id() {
        return Train_id;
    }

    public void setTrain_id(String train_id) {
        Train_id = train_id;
    }

    public String getT_line_id() {
        return T_line_id;
    }

    public void setT_line_id(String t_line_id) {
        T_line_id = t_line_id;
    }

    public String minus_num(String ticket_type,int num){
        return null;

    }
    public boolean check_num(String ticket_type,int num){
        return false;
    }

    public int get_num(String s){
        System.out.println("Ohh!! you failed");
        return -8;
    }
    public double get_price(String s){
        System.out.println("Ohh!! you failed");
        return -8;
    }
    @Override
    public String toString() {
        System.out.println("Ohh!! Nooo you failed");
        return null;
    }
}
