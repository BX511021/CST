package Train_type;

import java.text.DecimalFormat;
import java.util.Objects;

public class Train_G extends Train {
    private double HC_price;
    private int HC_num;
    private double SB_price;
    private int SB_num;
    private int SC_num;
    private double SC_price;

    public Train_G(String train_id, int CC_price, int CC_num, int SB_price, int SB_num, int SC_num, int SC_price) {
        super(train_id);
        this.HC_price = CC_price;
        this.HC_num = CC_num;
        this.SB_price = SB_price;
        this.SB_num = SB_num;
        this.SC_num = SC_num;
        this.SC_price = SC_price;
    }

    public Train_G(String train_id) {
        super(train_id);
    }

    public double getHC_price() {
        return HC_price;
    }

    public void setHC_price(double HC_price) {
        this.HC_price = HC_price;
    }

    public int getHC_num() {
        return HC_num;
    }

    public void setHC_num(int HC_num) {
        this.HC_num = HC_num;
    }

    public double getSB_price() {
        return SB_price;
    }

    public void setSB_price(double SB_price) {
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

    public double getSC_price() {
        return SC_price;
    }

    public void setSC_price(double SC_price) {
        this.SC_price = SC_price;
    }

    public double get_price(String s) {
        if (Objects.equals(s, "HC")) {
            return this.getHC_price();
        } else if (Objects.equals(s, "SB")) {
            return this.getSB_price();
        } else if (Objects.equals(s, "SC")) {
            return this.getSC_price();
        } else {
            return -8;
        }

    }
    public int get_num(String s) {
        if (Objects.equals(s, "HC")) {
            return this.getHC_num();
        } else if (Objects.equals(s, "SB")) {
            return this.getSB_num();
        } else if (Objects.equals(s, "SC")) {
            return this.getSC_num();
        } else {
            return -8;
        }

    }

    @Override
    public String toString() {
        String Price;
        Price= new DecimalFormat(".00").format(this.SC_price);
        System.out.print("[SC]" +Price + ":" + this.SC_num + " ");
        Price= new DecimalFormat(".00").format(this.HC_price);
        System.out.print("[HC]" + Price+ ":" + this.HC_num + " ");
        Price= new DecimalFormat(".00").format(this.SB_price);
        System.out.print("[SB]" + Price + ":" + this.SB_num + " ");
        System.out.println("");
        return null;
    }
}
