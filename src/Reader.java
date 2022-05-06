import java.io.*;
import java.util.*;

/**
 * BufferedReader ∂¡»°
 * @param
 * @return
 */


public class Reader {
    Map<String , Character> cert_map;

    public Reader() {
        this.cert_map = new HashMap<>();
    }

    public void readCsvByBufferedReader(String[] args_line) {
        if (args_line.length!=2){
            System.out.println("Arguments illegal");
            return;
        }
        String filePath="data/"+args_line[1];
        File csv = new File(filePath);
        csv.setReadable(true);
        csv.setWritable(true);
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(new FileInputStream(csv), "gbk");
            br = new BufferedReader(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String line = "";
        String id="";
        char cert ;
        int pos=0;
        int neg=0;
        try {
            while ((line = br.readLine()) != null) {
                System.out.print(line);
                id=line.substring(0,11);
                cert=line.toCharArray()[13];
                if (cert=='N'){
                    neg++;
                }else {
                    pos++;
                }
                System.out.println("  "+id+"  "+cert);
                this.cert_map.put(id,cert);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Import Success, Positive:"+pos+ " Negative:"+neg);
    }
}