import Train_type.Train;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hello {
    public static void main(String[] args) {
        Reader reader=new Reader();
        String[] strings=new String[2];
        strings[0]="importCert";
        strings[1]="cert.csv";
        reader.readCsvByBufferedReader(strings);
        strings[1]="cert2.csv";
        reader.readCsvByBufferedReader(strings);


}
}



