import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class FileWorker
{
    public void readme(String input_path, ArrayList database) throws ParseException, IOException
    {
        String line = "";
        BufferedReader db = new BufferedReader(new FileReader(input_path));
        while ((line = db.readLine()) != null) {
            String[] temp = line.split(";");
            if (temp[0].equals("admin")) {
                database.add(new Administrative(temp[0], temp[1], temp[2]));
            } else {
                database.add(new Complaints(temp[0], temp[1], temp[2]));
            }
        }

    }

    public void nicePrint(String type, String description, int age, String stamp)
    {
        System.out.printf("%2d %s",age,"days - ");
        System.out.printf("%-10s %-10s %-8s",type,stamp,description);

    }

    public void secondaryMenu()
    {
        System.out.println();
        System.out.println();
        System.out.println("Enter your choice:");
        System.out.println("1. Take ownership and solve");
        System.out.println("2. Take ownership and cancel this task");
        System.out.println("3. Delay for 1 day");
        System.out.println("4. Return to main menu");
    }

    public void primaryMenu()
    {
        System.out.println(" -------- LOCAL CRM SYSTEM ---------- ");
        System.out.println(" --------    MAIN MENU     ---------- ");
        System.out.println("1. Show all tasks in the database");
        System.out.println("2. Show all administrative tasks");
        System.out.println("3. Show all complaints");
        System.out.println("4. Take ownership of next task");
        System.out.println("5. Save database and quit");
        System.out.println("6. Load daily report");
        System.out.println("7. Quit without saving");
        System.out.println();
        System.out.println("Enter your choice:");
    }


}
