package Train_type;

import java.text.DecimalFormat;
import java.util.Objects;

public class Train_0 extends Train{
    private double CC_price;
    private  int CC_num;
    private  double SB_price;
    private  int SB_num;
    private  double GG_price;
    private int GG_num;

    public Train_0(String train_id, int CC_price, int CC_num, int SB_price, int SB_num, int GG_price, int GG_num) {

        super(train_id);
        if(CC_num<0||CC_price<0||
                SB_num<0||SB_price<0||
                GG_num<0||GG_price<0){
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

    public double getCC_price() {
        return CC_price;
    }

    public void setCC_price(double CC_price) {
        this.CC_price = CC_price;
    }

    public int getCC_num() {
        return CC_num;
    }

    public void setCC_num(int CC_num) {
        this.CC_num = CC_num;
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

    public double getGG_price() {
        return GG_price;
    }

    public void setGG_price(double GG_price) {
        this.GG_price = GG_price;
    }

    public int getGG_num() {
        return GG_num;
    }

    public void setGG_num(int GG_num) {
        this.GG_num = GG_num;
    }

    public double  get_price(String s){
        if(Objects.equals(s, "CC")){
            return this.getCC_price();
        }else if (Objects.equals(s, "SB")){
            return this.getSB_price();
        }else if (Objects.equals(s, "GG")){
            return this.getGG_price();
        }else {
            return -8;
        }

    }
    public int  get_num(String s){
        if(Objects.equals(s, "CC")){
            return this.getCC_num();
        }else if (Objects.equals(s, "SB")){
            return this.getSB_num();
        }else if (Objects.equals(s, "GG")){
            return this.getGG_num();
        }else {
            return -8;
        }

    }

    public String  minus_num(String ticket_type,int num){
            if (Objects.equals(ticket_type, "CC")){
                this.CC_num-=num;
                return new DecimalFormat(".00").format(num*this.CC_price);
            }else if (Objects.equals(ticket_type, "SB")){
                this.SB_num-=num;
                return new DecimalFormat(".00").format(num*this.SB_price);
            }else if (Objects.equals(ticket_type, "GG")){
                this.GG_num-=num;
                return new DecimalFormat(".00").format(num*this.GG_price);
            }else {
                System.out.println("Seat does not match");
            }
            return null;
    }

    public boolean check_num(String ticket_type,String num){
        if (Objects.equals(ticket_type, "CC")){

        }else if (Objects.equals(ticket_type, "SB")){

        }else if (Objects.equals(ticket_type, "GG")){

        }else {
            System.out.println("Seat does not match");
            return false;
        }

        if (!isPureDigital(num)){
            System.out.println("Ticket number illegal");
            return false;
        }

        if (Integer.parseInt(num)==0){
            System.out.println("Ticket number illegal");
            return false;
        }
        int num1=Integer.parseInt(num);

        if (Objects.equals(ticket_type, "CC")){
            if (this.CC_num<num1){
                System.out.println("Ticket does not enough");
                return false;
            }
        }else if (Objects.equals(ticket_type, "SB")){
            if (this.SB_num<num1){
                System.out.println("Ticket does not enough");
                return false;
            }
        }
        else if (Objects.equals(ticket_type, "GG")){
            if (this.GG_num<num1){
                System.out.println("Ticket does not enough");
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String Price;
        Price= new DecimalFormat(".00").format(this.CC_price);
        System.out.print("[CC]"+Price+":"+this.CC_num+" ");
        Price= new DecimalFormat(".00").format(this.SB_price);
        System.out.print("[SB]"+Price+":"+this.SB_num+" ");
        Price= new DecimalFormat(".00").format(this.GG_price);
        System.out.print("[GG]"+Price+":"+this.GG_num+" ");
        System.out.println("");
        return null;
    }
}
