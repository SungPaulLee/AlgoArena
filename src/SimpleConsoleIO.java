import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleConsoleIO {

    public static void main (String[] args) throws IOException
    {
        String input = "";
        while(!input.equals("quit"))
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            input = reader.readLine();
            System.out.println(input);
        }
    }

}
