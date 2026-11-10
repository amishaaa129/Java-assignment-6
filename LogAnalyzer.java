import java.io.*;

public class LogAnalyzer {
    public static void main(String[] args) {

        int totalEntries = 0;
        int errorCount = 0;
        int warningCount = 0;

        try (
            BufferedReader br = new BufferedReader(
                new FileReader("application.log")
            );

            BufferedWriter bw = new BufferedWriter(
                new FileWriter("filtered.log")
            )
        ) {
            String line;

            while ((line = br.readLine()) != null) {

                totalEntries++;

                if (line.contains("ERROR")) {
                    errorCount++;
                    bw.write(line);
                    bw.newLine();
                }
                else if (line.contains("WARNING")) {
                    warningCount++;
                    bw.write(line);
                    bw.newLine();
                }
            }

            System.out.println("Log Analysis Completed!");
            System.out.println("Total Log Entries: " + totalEntries);
            System.out.println("ERROR Entries: " + errorCount);
            System.out.println("WARNING Entries: " + warningCount);
            System.out.println("Filtered logs saved to filtered.log");

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
