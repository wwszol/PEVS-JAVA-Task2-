import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.util.stream.Collector;

abstract public class Task implements Comparable
{
    private String type;
    private String description;
    private String date;
    protected long age;

    protected String urgency = "normal";

    Task (String type,String description, String date) throws ParseException {
        this.type=type;
        this.description=description;
        this.date=date;
        howOld();
    }
    public String getDescription()
    {
        return description;
    }
    public String getDate() { return date;}
    public String getType()
    {
        return type;
    }
    public long getAge()
    {
        return age;
    }
    public long changeAge(long number)
    {
        return this.age-number;
    }


    public long howOld() throws ParseException // zistujeme ako dlho je task v systeme, udaj dolezity pre triedenie / sortowanie podla priority
    {
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        String today = df.format(new Date());
        String creation = df.format(new Date(getDate()));
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date1 = sdf.parse(today);
        Date date2 = sdf.parse(creation);
        long dayscalc = date1.getTime() - date2.getTime();
        long days = TimeUnit.DAYS.convert(dayscalc, TimeUnit.MILLISECONDS);
        return this.age=days;
    }


    @Override
    public int compareTo(Object o)  // podmienka pre komparator / sortowanie
    {
        Task sent = (Task) o;
        int result = -1 * this.urgency.compareTo(sent.urgency);
        if (result == 0)
        {
            return (int) sent.age - (int) this.age;
        }
        else return result;
    }

    public String getWrite()
    {
        return type + ";" + description+ ";" + date;
    }


}
