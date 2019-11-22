package zip;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        Path newFilePath = Paths.get("file1.txt");
        Path newFilePath1 = Paths.get("file2.txt");
        Path newFilePath2 = Paths.get("file3.txt");
        Files.createFile(newFilePath);
        Files.createFile(newFilePath2);
        Files.createFile(newFilePath1);
    }
    @Test
    void zipTest(){
        String[] fileNames = new String[]{"file1.txt", "file2.txt", "file3.txt"};
        Main.main(fileNames);

        Path zipFilePath = Paths.get("data.zip");
        assertTrue( Files.exists(zipFilePath) );
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() throws IOException {
        Path newFilePath = Paths.get("file1.txt");
        Path newFilePath1 = Paths.get("file2.txt");
        Path newFilePath3 = Paths.get("file3.txt");
        Path newFilePath2 = Paths.get("data.zip");
        Files.delete(newFilePath);
        Files.delete(newFilePath1);
        Files.delete(newFilePath2);
        Files.delete(newFilePath3);
    }
}