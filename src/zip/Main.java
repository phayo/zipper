package zip;

import java.nio.file.FileSystem;
import java.nio.file.Paths;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) {
        String name = "data.zip";
        FileHandler fh = new FileHandler();
        try (FileSystem fs = fh.createZip(Paths.get(name))) {
            for (String f : args) {
                FileHandler.copyToZip(fs, f.strip());
                System.out.println("added '" + f + "' to the archive!");
            }
            System.out.println("Your archive is ready : " + name);
            Path p = Paths.get(fs.toString());
            System.out.println(p.toUri().toString());
        } catch(Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }
}
