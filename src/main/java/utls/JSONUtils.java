package utls;

import com.fasterxml.jackson.databind.ObjectMapper;
import consts.Constant;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> List<T> readListFromFile(String fileName, Class<T> tClass) throws IOException {

        File file = getFile(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        return objectMapper
                .readValue(
                        file,
                        objectMapper
                                .getTypeFactory()
                                .constructCollectionType(List.class, tClass)
                );
    }

    public static void writeToFile(String fileName, Object object) throws IOException {
        File file = getFile(fileName);
        objectMapper.writeValue(file, object);
    }

    private static File getFile(String fileName) {
        File file = new File(Constant.BASE_PATH + File.separator + fileName);
        file.getParentFile().mkdirs();

        return file;
    }

}