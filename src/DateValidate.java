import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
public class DateValidate{
   public static boolean validateJavaDate(String strDate)
   {
	if (strDate.trim().equals(""))
	{
	    return true;
	}
	else
	{
	    SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
	    sdfrmt.setLenient(false);                           
	    
	    try
	    {
	        Date javaDate = sdfrmt.parse(strDate);
	    }
	    catch (ParseException e)
	    {
	    	return false;
	    }
	    return true;
	}
   }
}