import java.io.File;
import java.text.DecimalFormat;

public class Counter {
    private static int c = 0;

    public static int CountAllFiles(String folder) {
        File files = new File(folder);
        File[] arr = files.listFiles();

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].isDirectory()) {
                c++;
            }
            if (arr[i].isDirectory()) {
                c++;
                CountAllFiles(arr[i].getPath());
            }
        }

        return c;
    }


    public static String CountWatch(int allFiles, int catchFiles) {
        float c = ((float)catchFiles * 100.0f) / (float)allFiles;

        String formatFloat = new DecimalFormat("#0.00").format(c);
        return formatFloat;
    }
}
