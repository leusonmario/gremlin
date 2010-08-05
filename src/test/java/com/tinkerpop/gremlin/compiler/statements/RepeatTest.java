package com.tinkerpop.gremlin.compiler.statements;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.GremlinScriptEngine;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class RepeatTest extends BaseTest {

    public void testRepeatCounter() {
        final GremlinScriptEngine engine = new GremlinScriptEngine();
        final GremlinScriptContext context = new GremlinScriptContext();

        this.stopWatch();
        List results = (List) engine.eval("$x := 10\n$counter := 0\nrepeat 10\n$x := $x - 1\n$counter := $counter + 1\nend\n$x\n$counter\n", context);
        printPerformance("repeat statement", 10, "iterations", this.stopWatch());
        //System.out.println(results);
        assertEquals(results.size(), 5);
        assertEquals(results.get(0), 10);
        assertEquals(results.get(1), 0);
        assertNull(results.get(2));
        assertEquals(results.get(3), 0);
        assertEquals(results.get(4), 10);
    }
}