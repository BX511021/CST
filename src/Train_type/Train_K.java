package Train_type;

import java.util.Objects;
import java.text.DecimalFormat;

public class Train_K extends Train {
    private double A1_price;
    private  int A1_num;
    private  double A2_price;
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

    public double getA1_price() {
        return A1_price;
    }

    public void setA1_price(double a1_price) {
        A1_price = a1_price;
    }

    public int getA1_num() {
        return A1_num;
    }

    public void setA1_num(int a1_num) {
        A1_num = a1_num;
    }

    public double getA2_price() {
        return A2_price;
    }

    public void setA2_price(double a2_price) {
        A2_price = a2_price;
    }

    public int getA2_num() {
        return A2_num;
    }

    public void setA2_num(int a2_num) {
        A2_num = a2_num;
    }

    public double get_price(String s) {
        if (Objects.equals(s, "1A")) {
            return this.getA1_price();
        } else if (Objects.equals(s, "2A")) {
            return this.getA2_price();
        }
         else {
            return -8;
        }

    }
    public int get_num(String s) {
        if (Objects.equals(s, "1A")) {
            return this.getA1_num();
        } else if (Objects.equals(s, "2A")) {
            return this.getA2_num();
        }
        else {
            return -8;
        }

    }
    public String minus_num(String ticket_type,int num){
        if (Objects.equals(ticket_type, "1A")){
            this.A1_num-=num;
            return new DecimalFormat(".00").format(num*this.A1_price);
        }else if (Objects.equals(ticket_type, "2A")){
            this.A2_num-=num;
            return new DecimalFormat(".00").format(num*this.A2_price);
        }else {
            System.out.println("Seat does not match");
        }
        return null;
    }

    public boolean check_num(String ticket_type,int num){
        if (Objects.equals(ticket_type, "1A")){
        }else if (Objects.equals(ticket_type, "2A")){
        }else {
            System.out.println("Seat does not match");
            return false;
        }
        if (num<0){
            System.out.println("Ticket number illegal");
            return false;
        }

        if (Objects.equals(ticket_type, "1A")){
            if (this.A1_num<num){
                System.out.println("Ticket does not enough");
                return false;
            }
        }else if (Objects.equals(ticket_type, "2A")){
            if (this.A2_num<num){
                System.out.println("Ticket does not enough");
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        String Price;
        Price= new DecimalFormat(".00").format(this.A1_price);
        System.out.print("[1A]"+Price+":"+this.A1_num+" ");
        Price= new DecimalFormat(".00").format(this.A2_price);
        System.out.print("[2A]"+Price+":"+this.A2_num+" ");

        System.out.println("");
        return null;
    }
}
