import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FileUtils {


    @Test
    public void convertFileEncoding2UTF8() throws IOException {
        String fileAbsPath = "C:\\Users\\Wenllar\\Desktop\\JettyServer.java";
        String newfileAbsPath = "C:\\Users\\Wenllar\\Desktop\\JettyServer2.java";
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileAbsPath)), "GBK"));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(newfileAbsPath)), "UTF-8"))){
            String line = null;
            while((line = bf.readLine()) != null){
                bw.write(new String(line.getBytes("GBK"),StandardCharsets.UTF_8));
                bw.newLine();
            }
            bw.flush();
        }



    }

}
