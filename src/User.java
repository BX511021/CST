import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

class User {
    private String name;
    private char gender;
    private String aadharrId;
    public ArrayList<String> My_Trains;
    public double balance;

    public void upgrade(String my_train) {
        Iterator<String> it = this.My_Trains.iterator();
        int num = 0;
        while (it.hasNext()) {
            String temp_my_train = it.next();
            if (Objects.equals(temp_my_train, my_train)) {
                this.My_Trains.set(num, my_train);
                return;
            }
            num++;
        }
    }

    public int getMinus_count() {
        return 0;
    }

    public void setName(String name) {
        this.name = name;
        this.My_Trains=new ArrayList<>();
        this.balance=0;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setID(String aadharrId) {
        this.aadharrId = aadharrId;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getID() {
        return aadharrId;
    }

    public String getAadharrId() {
        return aadharrId;
    }

    public String toString() {
        return new String("Name:" + this.name + "\nSex:" + this.gender + "\nAadhaar:" + this.aadharrId);
    }
}