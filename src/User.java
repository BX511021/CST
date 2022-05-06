import java.util.ArrayList;

class User {
    private String name;
    private char gender;
    private String aadharrId;
    public ArrayList<String> My_Trains;

    public void setName(String name) {
        this.name = name;
        this.My_Trains=new ArrayList<>();
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