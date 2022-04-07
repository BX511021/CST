import Train_type.Train;

import java.util.*;

public class Line {

        private String Line_name;
        private String  Line_id;
        public int content;
        public int train_num=0;


        //使用Map的方式来存储站点相关信息
        public Map<String ,Integer> Line_map = new HashMap<>();
//        Map<String, String> map = new TreeMap<String, String>(
//                new Comparator<String>() {
//                        public int compare(String obj1, String obj2) {
//                                // 降序排序
//                                return obj2.compareTo(obj1);
//                        }
//                });

        public Line(String line_name, String  line_id, int content, Map<String, Integer> line_map) {
                Line_name = line_name;
                Line_id = line_id;
                this.content = content;
                Line_map = line_map;
        }

        public Line() {
        }

        public String getLine_name() {
                return Line_name;
        }

        public String  getLine_id() {
                return Line_id;
        }

        public int getContent() {
                return content;
        }

        public Map<String, Integer> getLine_map() {
                return Line_map;
        }

        public void setLine_name(String line_name) {
                Line_name = line_name;
        }

        public void setLine_id(String  line_id) {
                Line_id = line_id;
        }

        public void setContent(int content) {
                this.content = content;
        }

        public void setTrain_num(int train_num) {
                this.train_num = train_num;
        }

        public int getTrain_num() {
                return train_num;
        }


//        public void add_train(String [] args_line){
//                if (this.train_num<this.content){
//                        if (this.trainDataBase.add_train(args_line)){
//                                this.train_num++;
//                                return;
//                        }
//                }
//                else {
//                        System.out.println("Line illegal");
//                        return;
//                }
//
//        }
//        public void del_train(String[] args_line){
//
//                if (this.trainDataBase.del_train(args_line)){
//
//                        this.train_num--;
//                }
//
//        }
//
//        public void check_ticket(String[] args_line){
//                if(this.trainDataBase.isEmpty()){
//                        System.out.println("No Trains");
//                        return;
//                }
//                if(this.Line_map.get(args_line[2])==null||this.Line_map.get(args_line[3])==null){
//                        System.out.println("Station duplicate");
//                        return;
//                }
//                if(!this.trainDataBase.isExist(args_line[1])){
//                        System.out.println("Train_type.Train serial does not exist");
//                        return;
//                }
//
//                int num=1;
//                Iterator<Train> it = this.trainDataBase.Train_list.iterator();
//                while(it.hasNext())
//                {
//                        Train temp_train=it.next();
//                        if(temp_train.Train_id.equals(args_line[1])){
//                                if (temp_train.get_num(args_line[4])!=-8){
//                                        System.out.println("["+temp_train.Train_id+" "+args_line[2]+"->"+args_line[3]+" seat:"+args_line[4]+"remain:"+temp_train.get_num(args_line[4])
//                                        +" distance:"+Math.abs(this.Line_map.get(args_line[2])-this.Line_map.get(args_line[3]))+" remain:"+temp_train.get_price(args_line[4]));
//                                        return;
//                                }
//                        }
//
//                        num++;
//                }
//                return ;
//
//
//
//        }
//
//        public void list_train(String[] args_line){
//                if (this.trainDataBase.isEmpty()){
//                        System.out.println("No Train");
//                        return;
//                }
//
//                Collections.sort(this.trainDataBase.Train_list, new Comparator<Train>() {
//                        @Override
//                        public int compare(Train o1, Train o2) {
//                                return o2.Train_id.compareTo(o1.Train_id);
//                        }
//                });
//
//                int num=1;
//                Iterator<Train> it = this.trainDataBase.Train_list.iterator();
//                while(it.hasNext())
//                {
//                        Train temp_train=it.next();
//                        System.out.print("["+num+"] ["+temp_train.getTrain_id()+"] ["+this.Line_id+"] ");
//                        temp_train.toString();
//                        num++;
//                }
//                return ;
//        }

        public void add_station(String Station_name, int Station_far,boolean b) {
                if(this.Line_map.get(Station_name)!=null){
                        System.out.println("Station duplicate");
                        return;
                }
                this.Line_map.put(Station_name,Station_far);
                if(b){
                        System.out.println("Add Station success");
                }

        }

        public void delete_station (String Station_name){
                if(this.Line_map.get(Station_name)==null){
                        System.out.println("Station duplicate");
                        return;
                }
                this.Line_map.remove(Station_name);
                System.out.println("Delete Station success");
        }



        @Override
        public String toString() {
                System.out.print("["+this.Line_id+"] ");
                System.out.print("["+this.train_num+"]/["+this.content+"] ");
//                List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
//                Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
//                        //升序排序
//                        public int compare(Entry<String, String> o1,
//                                           Entry<String, String> o2) {
//                                return o1.getValue().compareTo(o2.getValue());
//                        }
//                });
//                for(Map.Entry<String,String> mapping:list){
//                        System.out.println(mapping.getKey()+":"+mapping.getValue());
//                }
                List<Map.Entry<String,Integer>> list=new ArrayList<Map.Entry<String,Integer>>(this.Line_map.entrySet());
                Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                        @Override
                        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                                return o1.getValue().compareTo(o2.getValue());
                        }
                });
                for (Map.Entry<String ,Integer> mapping:list){
                        System.out.print("["+mapping.getKey()+"] ["+mapping.getValue()+"] ");
                }
                System.out.println("");
                return null;
        }
}
