import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archiver extends Counter{
    private static int count;
    private static int countAll;

    public static void Zip(String sourseFolder, String zipFile) {
        try {
            FileOutputStream fout = new FileOutputStream(zipFile);
            ZipOutputStream zout = new ZipOutputStream(fout);

            File fileSource = new File(sourseFolder);

            count = CountAllFiles(sourseFolder); // Считаем сколько у нас всего папок и файлов (для вычета соотношения в процентах)

            addDirectory(zout, fileSource);

            zout.close();

            System.out.println("Zip-файл создан!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addDirectory(ZipOutputStream zout, File fileSource) throws Exception {
        try {
            File[] files = fileSource.listFiles();

            // Выводим количество оставшихся файлов в процентах
            //countAll += files.length;
            //countAll = count;

            System.out.println("Добавление папки - " + fileSource.getName() + " - " + CountWatch(count, countAll) + "%");

            for (int i = 0; i < files.length; i++) {

                if (files[i].isDirectory()) {
                    addDirectory(zout, files[i]);
                    countAll++;
                    continue;
                }

                System.out.println("Добавление файла - " + files[i].getName() + " - " + CountWatch(count, countAll) + "%");

                FileInputStream fis = new FileInputStream(files[i]);

                zout.putNextEntry(new ZipEntry(files[i].getPath()));

                byte[] buffer = new byte[4048];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zout.write(buffer, 0, length);
                }

                zout.closeEntry();
                fis.close();
                countAll++;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
