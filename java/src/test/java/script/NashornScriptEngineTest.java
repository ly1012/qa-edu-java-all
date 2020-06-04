package script;

import jdk.nashorn.api.scripting.NashornScriptEngine;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * {@link jdk.nashorn.api.scripting.NashornScriptEngine} 测试
 *
 * @author Li Yun
 * @date 2020/5/16 10:21
 */
public class NashornScriptEngineTest {

  NashornScriptEngine engine;

  @BeforeClass
  public void beforeClass() {
    ScriptEngineManager manager = new ScriptEngineManager();
    engine = (NashornScriptEngine) manager.getEngineByName("js");
  }

  @Test
  public void testEval() throws ScriptException {
    engine.eval("a = 5*7;");
    Object obj = engine.eval("a + 5");
    System.out.println(obj);
  }
}
