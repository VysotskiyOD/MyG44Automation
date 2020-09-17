package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.getProperty;

public class FileHelper {

    private final static Logger log = LogManager.getLogger("Помошник для работы с файлами");



    public static List<String> linesFromFile(String filePath){
        try {log.info(Files.readAllLines(Paths.get(filePath)));
            return Files.readAllLines(Paths.get(filePath));//, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    public static Map<String, String> loadDataForProvider(){
        String path = getProperty("user.dir") + "/src/test/resources/data/negativeAuthData.txt";
        Map<String, String> result = new TreeMap<>();
        linesFromFile(path).forEach(line -> {
            String[] tempLineArray = line.split(":");
            result.put(tempLineArray[0], tempLineArray[1]);
        });
        return result;
    }

    public static void writeToFile(String filePath, String text){
        List<String> textLines = Arrays.asList(text.split("\n"));
        try {
            File file = new File(filePath);
            if (!file.exists()){
                File dir = file.getParentFile();
                if(!dir.exists()){
                    dir.mkdirs();
                }
                file.createNewFile();
            }
            Files.write(Paths.get(filePath), textLines);
        } catch (IOException e) {
            log.error(e);
        }
    }

}
