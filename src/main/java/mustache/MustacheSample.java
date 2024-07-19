package mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.StringWriter;

public class MustacheSample {

    public static void main(String[] args) throws IOException {

        // https://www.baeldung.com/mustache

        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("templates/todo.mustache");

        Todo todo = new Todo("Task 1", "Read report from John");
        StringWriter writer = new StringWriter();
        m.execute(writer, todo).flush();
        String html = writer.toString();

        System.out.println(html);
    }
}
