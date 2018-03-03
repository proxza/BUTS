
public class Main {

    // Для 1С
    public static final String WHEREFROM = "B:\\b"; // Название файла который будет бэкапиться
    public static final String WHERE = "F:\\backups\\1C-" + Backuper.DateToBackup() + ".zip"; // Название конечного архива

    // Для 1ДФ
    public static final String WHEREFROM1DF = "B:\\1df";
    public static final String WHERE1DF = "F:\\backups\\1DF-" + Backuper.DateToBackup() + ".zip";


    public static void main(String[] args) throws Exception {


        System.out.println("-----------------------------------------------------");
        System.out.println("--     Утилита автобэкапа - BackUpThisShit v.1     --");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("Подождите, идет подсчет файлов...");
        System.out.println("-----------------------------------------------------");

        // архивируем 1C
        Archiver.Zip(WHEREFROM, WHERE);


        System.out.println("-----------------------------------------------------");
        System.out.println("Подождите, идет подсчет файлов...");
        System.out.println("-----------------------------------------------------");


        // архивируем 1дф
        Archiver.Zip(WHEREFROM1DF, WHERE1DF);



        // вызываем метод копирования
        //Backuper.CopyMe("C:\\1.dmg", "D:\\backup\\1.dmg");

        System.out.println("-----------------------------------------------------");
        System.out.printf("Резервное копирование за %s выполнено успешно!", Backuper.DateToBackup());
        System.out.println();
        System.out.println("-----------------------------------------------------");
    }
}
