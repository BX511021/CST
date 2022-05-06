public class Student extends User{
    public int minus_count;

    public int getMinus_count() {
        return minus_count;
    }

    public void setMinus_count(int minus_count) {
        this.minus_count = minus_count;
    }

    @Override
    public String toString() {
        return new String("Name:" + this.getName() + "\nSex:" + this.getGender() + "\nAadhaar:" + this.getAadharrId() +"\nDiscount:"+this.minus_count);
    }
}
