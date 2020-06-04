package script;

import jdk.nashorn.api.scripting.NashornScriptEngine;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

/**
 * TODO
 *
 * @author Li Yun
 * @date 2020/5/16 9:31
 */
public class ScriptEngineManagerTest {

  ScriptEngineManager manager;

  @BeforeClass
  public void beforeClass() {
    manager = new ScriptEngineManager();
  }

  @Test(description = "getEngineFactories 获取所有引擎工厂")
  public void testGetEngineFactories() {
    List<ScriptEngineFactory> factories =  manager.getEngineFactories();
    for (ScriptEngineFactory factory : factories){
      System.out.println(factory.getEngineName());    //输出引擎名称
    }
  }

  @Test(description = "getEngineByName 根据引擎名称获取引擎")
  public void testGetEngineByName() {
    String[] names = {
        "nashorn",
        "Nashorn",
        "js",
        "JS",
        "JavaScript",
        "javascript",
        "ECMAScript",
        "ecmascript"
    };

    for (String name : names){
      testNashornEngine(manager.getEngineByName(name));
    }
  }

  @Test(description = "getEngineByExtension 根据文件扩展名获取引擎")
  public void testGetEngineByExtension() {
    ScriptEngine engine = manager.getEngineByExtension("js");
    testNashornEngine(engine);
  }

  @Test(description = "getEngineByMimeType 根据 MIME 类型获取引擎")
  public void testGetEngineByMimeType() {
    String[] mimeTypes = {
        "application/javascript",
        "application/ecmascript",
        "text/javascript",
        "text/ecmascript"
    };

    for (String mimeType : mimeTypes){
      testNashornEngine(manager.getEngineByMimeType(mimeType));
    }

  }

  //测试 NashornScriptEngine
  private void testNashornEngine(ScriptEngine engine){
    Assertions.assertThat(engine).isInstanceOf(NashornScriptEngine.class);    //断言 engine 为 NashornScriptEngine
    StringBuffer scriptBuffer = new StringBuffer();
    scriptBuffer.append("var a = 3;");
    scriptBuffer.append("var b = 2;");
    scriptBuffer.append("a + b;");
    Object c = null;
    try {
      c = engine.eval(scriptBuffer.toString());
    } catch (ScriptException e) {
      e.printStackTrace();
    }
    System.out.println(c);
  }

}
