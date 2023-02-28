import java.text.ParseException;

public class Complaints extends Administrative implements Comparable
{
    private boolean urgent;
    private String resolution="unresolved yet";

    Complaints (String type,String description, String date) throws ParseException
    {
        super(type, description, date);
        this.urgent = isUrgent();
    }

    private boolean isUrgent() throws ParseException {
        if(getAge() >= 15)
        {
            urgency="urgent";
            return true;
        }
        else return false;
    }

    public String setResolution(String input)
    {
        return this.resolution=input;
    }

    @Override
    public String getWrite()
    {
        return getType() + ";" + getDescription()+ ";" + getDate() + ";" + resolution;
    }

}
