package mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.StringWriter;

public class Mustache {

    public static void main(String[] args) throws IOException {

        MustacheFactory mf = new DefaultMustacheFactory();
        com.github.mustachejava.Mustache m = mf.compile("todo.mustache");

        Todo todo = new Todo("Todo 1", "Description");
        StringWriter writer = new StringWriter();
        m.execute(writer, todo).flush();
        String html = writer.toString();

        System.out.println(html);
    }
}
