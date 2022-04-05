import java.util.HashMap;
import java.util.Map;

public class Line {

        private String Line_name;
        private int Line_id;
        private int content;
        //使用Map的方式来存储站点相关信息
        private Map<String ,Integer> Line_map = new HashMap<>();

        public Line(String line_name, int line_id, int content, Map<String, Integer> line_map) {
                Line_name = line_name;
                Line_id = line_id;
                this.content = content;
                Line_map = line_map;
        }

        public String getLine_name() {
                return Line_name;
        }

        public int getLine_id() {
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

        public void setLine_id(int line_id) {
                Line_id = line_id;
        }

        public void setContent(int content) {
                this.content = content;
        }

        public void add_station(String Station_name,int Station_far) {
                if(this.Line_map.get(Station_name)==null){
                        System.out.println("Station duplicate");
                        return;
                }
                this.Line_map.put(Station_name,Station_far);
                System.out.println("Add Station success");
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
                return "Line{" +
                        "Line_name='" + Line_name + '\'' +
                        ", Line_id=" + Line_id +
                        ", content=" + content +
                        ", Line_map=" + Line_map +
                        '}';
        }
}
