import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
public class Reader {
    public Map<String , Character> cert_map=new HashMap<>();
    int pos=0;
    int neg=0;

    public Reader() {

    }

    public void readCsvByBufferedReader(String[] args_line) {
        if (args_line.length!=2){
            System.out.println("Arguments illegal");
            return;
        }
        String filePath=args_line[1];
        File csv = new File(filePath);
        csv.setReadable(true);
        csv.setWritable(true);
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(new FileInputStream(csv), StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String line = "";
        String id="";
        char cert ;
        try {
            while ((line = br.readLine()) != null) {
//                System.out.print(line);
                id=line.substring(0,11);
                cert=line.toCharArray()[13];
                if (cert=='N'){
                    this.neg++;
                }else {
                    this.pos++;
                }

                this.cert_map.put(id,cert);
//                System.out.println(id+"  "+this.cert_map.get(id));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Import Success, Positive:"+this.pos+ " Negative:"+this.neg);
    }
}