package regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileNameExtractorTest {

    private final static String EXPECTED = "74e9adc877132da367f26cbb7eba19f3.eps";

    @Test
    void testExtract(){

        String path = "{\"imageUrl\":\"\\/\\/api.qrcode-monkey.com\\/tmp\\/74e9adc877132da367f26cbb7eba19f3.eps\"}";

        FileNameExtractor extractor = new FileNameExtractor();

        String actual = extractor.extract(path);

        assertEquals(EXPECTED, actual);
    }

    @Test
    void testExtract1(){

        String path = "xvhasghv0254654xshbvxghsav";

        FileNameExtractor extractor = new FileNameExtractor();

        String actual = extractor.extract1(path);

        assertEquals("0254654xshbvxghsav", actual);
    }
}
