package Train_type;

public class Train_K extends Train {
    private int A1_price;
    private  int A1_num;
    private  int A2_price;
    private int A2_num;

    public Train_K(String train_id, int a1_price, int a1_num, int a2_price, int a2_num) {
        super(train_id);
        A1_price = a1_price;
        A1_num = a1_num;
        A2_price = a2_price;
        A2_num = a2_num;
    }

    public Train_K(String train_id) {
        super(train_id);
    }

    public int getA1_price() {
        return A1_price;
    }

    public void setA1_price(int a1_price) {
        A1_price = a1_price;
    }

    public int getA1_num() {
        return A1_num;
    }

    public void setA1_num(int a1_num) {
        A1_num = a1_num;
    }

    public int getA2_price() {
        return A2_price;
    }

    public void setA2_price(int a2_price) {
        A2_price = a2_price;
    }

    public int getA2_num() {
        return A2_num;
    }

    public void setA2_num(int a2_num) {
        A2_num = a2_num;
    }
}
