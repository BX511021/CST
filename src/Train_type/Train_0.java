package Train_type;

public class Train_0 extends Train{
    private int CC_price;
    private  int CC_num;
    private  int SB_price;
    private  int SB_num;
    private  int GG_price;
    private int GG_num;

    public Train_0(String train_id, int CC_price, int CC_num, int SB_price, int SB_num, int GG_price, int GG_num) {

        super(train_id);
        if(CC_num<=0||CC_price<=0||
                SB_num<=0||SB_price<=0||
                GG_num<=0||GG_price<=0){
            return;
        }
        this.CC_price = CC_price;
        this.CC_num = CC_num;
        this.SB_price = SB_price;
        this.SB_num = SB_num;
        this.GG_price = GG_price;
        this.GG_num = GG_num;
    }

    public Train_0(String train_id) {
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

    public int getGG_price() {
        return GG_price;
    }

    public void setGG_price(int GG_price) {
        this.GG_price = GG_price;
    }

    public int getGG_num() {
        return GG_num;
    }

    public void setGG_num(int GG_num) {
        this.GG_num = GG_num;
    }
}
