package pl.maciek_rychlinski.records;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveRecord {

    PlayerStat playerStat =new PlayerStat("Dupa","1234","22.03.1998");

    public SaveRecord(){
        try {

            FileWriter writer = new FileWriter("rekord.txt",true);
            BufferedWriter bufferedWriter=new BufferedWriter(writer);
            bufferedWriter.write(""+playerStat.getPlayerName()+"@"+playerStat.getPlayerScore()+"@"+playerStat.getDateOfGame());
            bufferedWriter.newLine();
            bufferedWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
