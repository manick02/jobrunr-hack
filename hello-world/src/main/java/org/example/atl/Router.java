package org.example.atl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class Router {
    private final Map<String, Node> routes = new HashMap<>();

    public void withRoute(String path, String result) {
        String[] pathParts = path.split("/");
        configureRoute(pathParts, result);
    }

    private void configureRoute(String[] pathParts, String result) {
        if (pathParts.length == 0) {
            return;
        }
        Node startNode;
        if (routes.containsKey(pathParts[0])) {
            startNode = routes.get(pathParts[0]);
        } else {
            startNode = new Node(pathParts[0]);
            routes.put(pathParts[0], startNode);
        }

        for (int j = 1; j < pathParts.length; j++) {
            Node childPathPart;
            if (startNode.children.containsKey(pathParts[j])) {
                childPathPart = startNode.children.get(pathParts[j]);
            } else {
                childPathPart = new Node(pathParts[j]);
            }

            startNode.children.put(pathParts[j], childPathPart);
            startNode = childPathPart;
        }
        startNode.setResult(result);
    }


    public Optional<String> route(String path) {

        String[] pathParts = path.split("/");
        if (pathParts.length == 0) {
            return Optional.empty();
        }
        Node startNode = routes.get(pathParts[0]);
        if (startNode == null) {
            return Optional.empty();
        }

        for (int i = 1; i < pathParts.length; i++) {
            Node node = startNode.children.get(pathParts[i]);
            if (node == null) {
                if (startNode.children.containsKey("*")) {
                    node = startNode.children.get("*");
                } else {
                    return Optional.empty();
                }
            }
            startNode = node;
        }


        return startNode.result; //Optional.ofNullable(routes.get(path));
    }


    class Node {
        String pathPart;
        Optional<String> result;
        Map<String, Node> children = new HashMap<>();

        public Node(String pathPart) {
            this.pathPart = pathPart;
        }

        public void setResult(String result) {
            this.result = Optional.of(result);
        }
    }
}