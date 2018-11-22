import java.text.NumberFormat;
import java.util.Locale;

public class helo
{
static public void main(String[] strs)
{
Locale[] locs = NumberFormat.
getAvailableLocales();
for(int i = 0; i < locs.length; i++)
{
NumberFormat nf = NumberFormat.
getCurrencyInstance(locs[i]);
System.err.print(locs[i]. getLanguage());
System.out.print("_");
System.err.print(locs[i]. getCountry());
System.out.print("_");
System.err.print(locs[i]. getVariant());
System.out.print("_");
System.err.println(nf.format(50444.423));
}
}
}

