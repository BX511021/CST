import Train_type.Train;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hello {
    public static void main(String[] args) {
//        Reader reader=new Reader();
//        reader.readCsvByBufferedReader(new String[]{"importCert" + "cert.csv"});
            UserDatabase userDatabase=new UserDatabase();
            String[] message=userDatabase.take_message("[G1001: Shahe->Gaolimen] seat:SB num:20 price:12528.00 paid:F");
            System.out.println(Arrays.toString(message));

}
}



