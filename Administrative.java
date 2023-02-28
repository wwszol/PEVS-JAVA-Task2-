import java.text.ParseException;

public class Administrative extends Task implements Comparable
{

    Administrative(String type, String description, String date) throws ParseException {
        super(type, description, date);
    }

    public long setDelay(long time) // priestor do buducna pre uzivatela na nastavenie konkretneho casu pre delay
    {
        if(getAge() >= time) return age -= time;
        else
        {
        System.out.println("You cannot delay it for so long");
        return 0;
        }
    }


    @Override
    public String toString() {
        return getType() + ";" + getDescription() + ";" + urgency;
    }
}
