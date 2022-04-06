package Train_type;

public class Train_G extends Train{
    private int CC_price;
    private  int CC_num;
    private  int SB_price;
    private  int SB_num;
    private int SC_num;
    private  int SC_price;

    public Train_G(String train_id, int CC_price, int CC_num, int SB_price, int SB_num, int SC_num, int SC_price) {
        super(train_id);
        this.CC_price = CC_price;
        this.CC_num = CC_num;
        this.SB_price = SB_price;
        this.SB_num = SB_num;
        this.SC_num = SC_num;
        this.SC_price = SC_price;
    }

    public Train_G(String train_id) {
        super(train_id);
    }

    public int getCC_price() {
        return CC_price;
    }

    public void setCC_price(int CC_price) {
        this.CC_price = CC_price;
    }

    public int getCC_num() {
        return CC_num;
    }

    public void setCC_num(int CC_num) {
        this.CC_num = CC_num;
    }

    public int getSB_price() {
        return SB_price;
    }

    public void setSB_price(int SB_price) {
        this.SB_price = SB_price;
    }

    public int getSB_num() {
        return SB_num;
    }

    public void setSB_num(int SB_num) {
        this.SB_num = SB_num;
    }

    public int getSC_num() {
        return SC_num;
    }

    public void setSC_num(int SC_num) {
        this.SC_num = SC_num;
    }

    public int getSC_price() {
        return SC_price;
    }

    public void setSC_price(int SC_price) {
        this.SC_price = SC_price;
    }
}
