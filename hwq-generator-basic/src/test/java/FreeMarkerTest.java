import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:HWQ
 * @DateTime:2023/12/11 9:58
 * @Description:
 **/
public class FreeMarkerTest {
    @Test
    public void testFreeMarker() throws IOException, TemplateException {
        // 设置
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        configuration.setDefaultEncoding("utf-8");

        // 读取模板
        Template template = configuration.getTemplate("myweb.html.ftl");
        // 生成模型
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("user", "hwq");
        List<Map<String, Object>> menuItems = new ArrayList<>();
        HashMap<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url", "https://github.com/Hardork");
        menuItem1.put("label", "GitHub");
        menuItems.add(menuItem1);

        HashMap<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url", "https://github.com/Hardork2");
        menuItem2.put("label", "GitHub2");
        menuItems.add(menuItem2);
        dataMap.put("menuItems", menuItems);
        dataMap.put("currentYear", 2023);

        // 生成文件
        Writer out = new FileWriter("myweb.html");
        template.process(dataMap, out);
        // 关闭文件流
        out.close();

    }
}
