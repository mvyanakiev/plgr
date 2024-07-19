import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import yml.Scenario;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class BuildPrompt {
    public static void main(String[] args) throws IOException {

        Map<String, String> inputParams = new HashMap<>();

        String path = "src/main/resources/text-translation.yml";

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();

        File file = new File(path);

        TextTranslations scenario = mapper.readValue(file, TextTranslations.class);



//        inputParams.put("title", "Ana Karenina");
//        inputParams.put("description", "Anna Karenina is a classic Russian novel by Leo Tolstoy, delving into the scandalous affair between Anna, a married woman, and Count Vronsky. Set in 19th-century Russia, it's a compelling exploration of love, society, and the consequences of passion.");
//        inputParams.put("locale", "bg");

        String template = "Translate the text: { \"title\" : \"{{$title}}\" , \"description\" : \"{{$description}}\" } to the language i18n locale {{$locale}}. Reply in the format as a JSON : {\"title\" : \"<translated_title>\" , \"description\" : \"<translated_description>\"}. Note: Do not return any extra text apart from the JSON!";

        String result = template;
        for (Map.Entry<String, String> entry : inputParams.entrySet()) {
            result = result.replace("{{$" + entry.getKey() + "}}", entry.getValue());
        }

        System.out.println(result);
    }

    public static class TextTranslations {
        private String kind;
        Spec spec;

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public Spec getSpec() {
            return spec;
        }

        public void setSpec(Spec spec) {
            this.spec = spec;
        }
    }

    public static class Spec {
        private String description;
        private String template;
        private Inputs inputs;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }
    }

    public static class Inputs {
        private List<String> inputs;

        public List<String> getInputs() {
            return inputs;
        }

        public void setInputs(List<String> inputs) {
            this.inputs = inputs;
        }
    }
}
