package pl.maciek_rychlinski.records;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import pl.maciek_rychlinski.records.SaveRecord;

public class LoadRecord {

    public String playerName;
    public String playerScore;
    public String dateOfGame;
    public int line=0;
    public LoadRecord() throws FileNotFoundException, IOException {

        FileReader fileReader=new FileReader("rekord.txt");
        BufferedReader bufferedReader=new BufferedReader(fileReader);

        String line;

        while( (line = bufferedReader.readLine() ) != null) {
            StringTokenizer stringTokenizer =new StringTokenizer(line,"@");
            playerName=stringTokenizer.nextToken();
            playerScore=stringTokenizer.nextToken();
            dateOfGame=stringTokenizer.nextToken();

            System.out.println(""+playerName+" : "+playerScore+" : "+dateOfGame);
        }


        //StringTokenizer stringTokenizer =new StringTokenizer(bufferedReader.readLine(),"@");


    }
}
