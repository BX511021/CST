import java.util.ArrayList;
import java.util.Iterator;

    class UserDatabase {
        //使用列表来进行管理和检查
        private ArrayList<User> userArray;
        public UserDatabase(){

            this.userArray = new ArrayList<>();
        }
        //检查是否为空
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

