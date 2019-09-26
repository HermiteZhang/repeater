package top.hermite.repeater.pigeon.core.component.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author hermite
 */
public class JsonUtil {

    private final static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String obj2str(Object object) {
        try {

            String jsonStr = objectMapper.writeValueAsString(object);
            return jsonStr;
        } catch (JsonProcessingException e) {
            logger.error("obj2str have JsonProcessingException {}", e.getMessage());
            return null;
        }
    }

    public <T> T str2obj(String jsonStr, Class<T> objType) {
        try {
            T obj = objectMapper.readValue(jsonStr, objType);
            return obj;
        } catch (IOException e) {
            logger.error(" str2obj have IOException {}", e.getMessage());
            return null;
        }
    }

    public  List str2list(String jsonStr){
        List list  = null;
        try {
            list = objectMapper.readValue(jsonStr, List.class);
        } catch (IOException e) {
            logger.error("str2list have IOException {}", e.getMessage());
        }
        return list;
    }


    public <T> List<T>  str2list(String jsonStr,Class<T> objType){
        List<T> list  = null;
        try {
            list = (List<T>)objectMapper.readValue(jsonStr, objType);
        } catch (IOException e) {
            logger.error("str2list have IOException {}", e.getMessage());
        }
        return list;
    }


}
