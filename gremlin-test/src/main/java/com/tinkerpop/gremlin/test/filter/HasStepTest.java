package com.tinkerpop.gremlin.test.filter;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.PipeHelper;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class HasStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }

    public void test_g_V_hasXname_markoX(Pipe<Vertex, Vertex> pipe) {
        assertEquals(pipe.next().getProperty("name"), "marko");
        assertFalse(pipe.hasNext());
    }

    public void test_g_V_hasXname_blahX(Pipe<Vertex, Vertex> pipe) {
        assertFalse(pipe.hasNext());
    }

    public void test_g_V_hasXage_gt_30X(Pipe<Vertex, Vertex> pipe) {
        List<Vertex> list = new ArrayList<Vertex>();
        PipeHelper.fillCollection(pipe, list);
        assertEquals(list.size(), 2);
        for (Vertex v : list) {
            assertTrue((Integer) v.getProperty("age") > 30);
        }
    }

    public void test_g_v1_out_hasXid_2X(Pipe<Vertex, Vertex> pipe) {
        assertTrue(pipe.hasNext());
        assertEquals(pipe.next().getId().toString(), "2");
    }

    public void test_g_V_hasXblahX(Pipe<Vertex, Vertex> pipe) {
        assertFalse(pipe.hasNext());
    }

}