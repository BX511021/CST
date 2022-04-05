import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class demo1 {
    public static void main(String[] args) {
        UserDatabase2 userDatabase = new UserDatabase2();
        Scanner scan = new Scanner(System.in);
        String argStr;
        while (scan.hasNextLine()) {
            argStr = scan.nextLine();
            if (argStr.equals("QUIT")) {
                System.out.println("----- Good Bye! -----");
                System.exit(0);
            } else {
                String[] argline = argStr.split(" ");
                userDatabase.addUser(argline);
            }

        }
        scan.close();
    }
}
class User2 {
        private String name;
        private char gender;
        private String aadharrId;

        public void setName(String name) {
            this.name = name;
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

        public String toString() {
            return new String("Name:" + this.name + "\nSex:" + this.gender + "\nAadhaar:" + this.aadharrId);
        }
    }

    class UserDatabase2 {
        private ArrayList<User> userArray;
        public UserDatabase2(){
            this.userArray = new ArrayList<>();
        }
        public boolean isEmpty()
        {
            return this.userArray.isEmpty();
        }
        public boolean addUser(String[] args)
        {
            if(args.length<4)
            {
                System.out.println("Arguments illegal");
                return false;
            }
            String name = args[1];
            char gender = args[2].toCharArray()[0];
            String aadharrId = args[3];
            //检查姓名格式
            char[] names = name.toCharArray();
            for(int i=0;i<name.length();i++)
            {
                if(Character.isLetter(names[i])||names[i]=='_')
                    continue;
                else
                {
                    System.out.println("Name illegal");
                    return false;
                }
            }
            //检查性别格式
            if(gender!='F'&&gender!='M'&&gender!='O')
            {
                System.out.println("Sex illegal");
                return false;
            }
            //检查ID格式
            int region = Integer.parseInt(aadharrId.substring(0,4));
            int category = Integer.parseInt(aadharrId.substring(4,8));
            int biology = Integer.parseInt(aadharrId.substring(8,11));
            int sex = Integer.parseInt(aadharrId.substring(11,12));
            if(region>=1&&region<=1237&&category>=20&&category<=460&&biology>=0&&biology<=100&&sex>=0&&sex<=2)
            {
                if(isExist(aadharrId))
                {
                    System.out.println("Aadhaar number exist");
                    return false;
                }
            }
            else{
                System.out.println("Aadhaar number illegal");
                return false;
            }
            User newUser = new User();
            newUser.setName(name);
            newUser.setGender(gender);
            newUser.setID(aadharrId);
            this.userArray.add(newUser);
            System.out.println(newUser);
            return true;
        }
        public boolean isExist(String aadharrId)
        {
            Iterator<User> it = this.userArray.iterator();
            while(it.hasNext())
            {
                User tempUser = it.next();
                if(aadharrId.equals(tempUser.getID()))
                    return true;
            }
            return false;
        }
    }

