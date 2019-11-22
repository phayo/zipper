package zip;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
    /**
     * Method for creating a zip file on the specified path
     * @param zipPath generated path where the zip is to be stored
     * @return {@code Filesystem}
     * @throws IOException
     * @throws URISyntaxException
     */
    public FileSystem createZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String, String> providerProps = new HashMap<String, String>() {{
            put("create", "true");
        }};
        URI zipURI = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem fs = FileSystems.newFileSystem(zipURI, providerProps);
        return fs;
    }

    /**
     * Method for copying one file into the zip
     * @param zipFs
     * @param filename
     * @throws IOException
     */
    public static void copyToZip(FileSystem zipFs, String filename) throws IOException {
        Path sourceFile = Paths.get(filename);
        Path destFile = zipFs.getPath("/"+filename);
        Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
    }

}
