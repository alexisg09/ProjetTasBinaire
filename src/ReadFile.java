import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
    private final String name;
    private String[] tabArbre;
       ReadFile(String name){
           this.name = name;
       }


   public String[] getTabArbre(){
       return this.tabArbre;
   }

    public void setTabArbre(int index, String line){
        this.tabArbre[index] = line;
    }

   public void read(){
       try {
           int index = 0;
           this.tabArbre = new String[6];
           File myObj = new File(this.name);
           Scanner myReader = new Scanner(myObj);
           while (myReader.hasNextLine()) {
               String data = myReader.nextLine();
               setTabArbre(index, data);
               index ++;
           }
           myReader.close();
       } catch (FileNotFoundException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
       }
   }
}
