package org.example.atl;

import org.junit.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RouterTest {

    @Test
    public void testRouteSetupAndInvocationWithRouteExist() {
        Router r = new Router();
        r.withRoute("bar", "result");
        Optional<String> result = r.route("bar");
        assertEquals("result", result.get());
    }

    @Test
    public void testRouteSetupAndInvocationWithRouteNotExist() {
        Router r = new Router();
        Optional<String> result = r.route("/bar1");
        assertFalse(result.isPresent());
    }

    @Test
    public void testRouteWithWildCard() {
        Router r = new Router();
        r.withRoute("bar/*/foo","result");
        Optional<String> result = r.route("bar/baz/foo");
        assertEquals("result",result.get());
    }
}
