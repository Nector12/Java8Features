package java8_features;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * With Java 8, Nashorn, a much improved javascript engine is introduced,
 * to replace the existing Rhino. Nashorn provides 2 to 10 times better performance.
 * Created by nector on 28/02/17.
 */
public class NashornJS {

    public static void main(String[] args) {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine nashorn = manager.getEngineByName("nashorn");

        String name = "Nector";
        Integer result = null;

        try {
            // eval method executes the javascript code in brackets.
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");
        } catch (ScriptException ex) {
            System.err.println("Error executing script: " + ex.getMessage());
        }

        try {
            // Create a reader from an FileInputStream and execute its script
            Reader jsReader = new InputStreamReader(
                    new FileInputStream("src/java8_features/TestScript.js"));
            nashorn.eval(jsReader);

        } catch (ScriptException ex2) {
            System.err.println("Error executing script: " + ex2.getMessage());
        } catch (FileNotFoundException ex3) {
            System.err.println("Error finding file");
        }

        System.out.println(result.toString());

    }

}
