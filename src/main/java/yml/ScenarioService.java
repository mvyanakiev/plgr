package yml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class ScenarioService {
    public static void main(String[] args) throws IOException {


        String path = "src/main/resources/test.yml";

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();

        File file = new File(path);

        Scenario scenario = mapper.readValue(file, Scenario.class);




        System.out.println(scenario.getName()); // Output: John Doe
        System.out.println(scenario.getAge());  // Output: 30




    }
}
