package OSHTask;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ParseErrorsToCsv implements ParseErrors  {
    private Path pathErr;
    BufferedWriter bw;
    StringBuilder sb = new StringBuilder();
    static int failedRecords;
    public int getFailedRecords(){
        return failedRecords;
    }

    public ParseErrorsToCsv(Path pathErr2) throws IOException {
        this.pathErr = pathErr2;
        this.bw = new BufferedWriter(new FileWriter(String.valueOf(pathErr)));
    }

    public void parseErrors(String[] fields) {

        sb.setLength(0);
        // Append strings from array
        for (String element : fields) {
            sb.append(element);
            sb.append(",");

        }
        try {
            sb.delete(sb.length()-1, sb.length());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
            failedRecords++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
