import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Backuper {
    public static void CopyMe(String source, String dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

            is.close();
            os.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Возвращаем дату когда будет сделан бэкап и делаем из него название архива
    public static String DateToBackup() {
        DateFormat dt = new SimpleDateFormat("MM-dd-yyyy");
        Date today = Calendar.getInstance().getTime();
        String dayToBackup = dt.format(today);

        return dayToBackup;
    }
}
