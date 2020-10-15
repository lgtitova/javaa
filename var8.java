import java.io.*;
import java.util.Arrays;
//вариант 8

public class var8 {

    public static boolean checkchar(int w) {
        if (w>5) {return true;}
        return false;

    }


    public static void main(String[] args) throws IOException {
        InputStream in = null;
        Reader file = null;
        BufferedReader buf = null;
        OutputStream out = null;
        Writer wr = null;

        try {
            in = new FileInputStream("input.txt");
            file = new InputStreamReader(in, "cp1251");
            buf = new BufferedReader(file);

            File f1 = new File("output.txt");
            f1.createNewFile();
            if (f1.exists()) {
                out = new FileOutputStream(f1);
                wr = new OutputStreamWriter(out, "cp1251");
                String line = "";
                String[] words;

                while ((line = buf.readLine()) != null) {
                    words = line.split(" ");
                    for (int i=0;i<words.length;i++){
                        if (checkchar(words[i].length())) {
                            wr.append(words[i]+' ');
                        }
                        ;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        } finally {
            in.close();
            file.close();
            buf.close();
            wr.flush();
            out.close();
        }
    }
}

