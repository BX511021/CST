import Train_type.Train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.text.DecimalFormat;

class UserDatabase {

        private ArrayList<User> userArray;
        private User SuperUser=null;
        public UserDatabase(){

            this.userArray = new ArrayList<>();
        }

        public boolean isEmpty()
        {

            return this.userArray.isEmpty();
        }

    public void upgrade(User user1){
        Iterator<User> it = this.userArray.iterator();
        int num=0;
        while(it.hasNext())
        {
            User temp_user = it.next();
            if(Objects.equals(user1.getID(), temp_user.getID())){
                userArray.set(num,user1);
                return;
            }
            num++;
        }
    }
        public boolean addUser(String[] args) {
            if(args.length<4||args[3].length()!=12)
            {
                System.out.println("Arguments illegal");
                return false;
            }
            String name = args[1];
            char gender = args[2].toCharArray()[0];
            String aadharrId = args[3];

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

            if(gender!='F'&&gender!='M'&&gender!='O')
            {
                System.out.println("Sex illegal");
                return false;
            }

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

            if (args.length==5)
            {
                Student student=new Student();
                student.setName(name);
                student.setGender(gender);
                student.setID(aadharrId);
                student.setMinus_count(Integer.parseInt(args[4]));
                this.userArray.add(student);
                System.out.println(student);
                return true;
            }
            User newUser = new User();
            newUser.setName(name);
            newUser.setGender(gender);
            newUser.setID(aadharrId);

            this.userArray.add(newUser);
            System.out.println(newUser);
            return true;
        }

        public boolean isExist(String aadharrId) {
            Iterator<User> it = this.userArray.iterator();
            while(it.hasNext())
            {
                User tempUser = it.next();
                if(aadharrId.equals(tempUser.getID()))
                    return true;
            }
            return false;
        }


        public User User_isExist(String aadharrId) {
            for (User tempUser : this.userArray) {
                if (aadharrId.equals(tempUser.getID()))
                    return tempUser;
            }
            return null;
        }

        public void login(String [] args_line){
            if (args_line.length!=3){
                System.out.println("Arguments illegal");
                return;
            }

            User tempUser;

            if (this.SuperUser!=null){
                System.out.println("You have logged in");
                return;
            }

            tempUser=User_isExist(args_line[1]);

            if (tempUser==null){
                System.out.println("User does not exist");
                return;
            }

            if(!Objects.equals(tempUser.getName(), args_line[2])){
                System.out.println("Wrong name");
                return;
            }
            System.out.println("Login success");
            this.SuperUser=tempUser;
        }

        public void logout (String [] args_line){
            if (args_line.length!=1){
                System.out.println("Arguments illegal");
                return;
            }
            if (this.SuperUser==null){
                System.out.println("No user has logged in");
                return;
            }
            System.out.println("Logout success");

            this.SuperUser=null;
        }

        public void buyTicket (String [] args_line,TrainDataBase trainDataBase,LineDataBase lineDataBase){
            if (args_line.length!=6){
                System.out.println("Arguments illegal");
                return;
            }
            if (this.SuperUser==null){
                System.out.println("Please login first");
                return;
            }

            Train temp_train=trainDataBase.Train_isExist(args_line[1]);
            if (temp_train==null){
                System.out.println("Train does not exist");
                return;
            }


            Line temp_line = lineDataBase.line_isExist(temp_train.T_line_id);

            if (temp_line.Line_map.get(args_line[2])==null||temp_line.Line_map.get(args_line[3])==null){
                System.out.println("Station does not exist");
                return;
            }


            if (!temp_train.check_num(args_line[4],args_line[5])){
                return;
            }

            int ticket_num = Integer.parseInt(args_line[5]);
            temp_train.minus_num(args_line[4],ticket_num);

            Double price = ticket_num*(trainDataBase.ticket_price(args_line[2],args_line[3],temp_train,args_line[4],lineDataBase));
            String price_neo=new DecimalFormat(".00").format(price);
            this.SuperUser.My_Trains.add("["+args_line[1]+": "+args_line[2]+"->"+args_line[3]+"] "+"seat:"+args_line[4]+" "+"num:"+args_line[5]+" price:"+price_neo+" paid:"+"F");
            upgrade(this.SuperUser);
            System.out.println("Thanks for your order");

        }

        public void listOrder(String[] args_line){
            if (args_line.length!=1){
                System.out.println("Arguments illegal");
                return;
            }

            if (this.SuperUser==null){
                System.out.println("Please login first");
                return;
            }

            if (this.SuperUser.My_Trains.isEmpty()){
                System.out.println("No order");
                return;
            }
            ArrayList<String> temp_list=this.SuperUser.My_Trains;
            Collections.reverse(temp_list);
            for (String a1 : temp_list) {
                System.out.println(a1);
            }
        }
    }

