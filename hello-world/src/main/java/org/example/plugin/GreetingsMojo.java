package org.example.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "sayhi")
public class GreetingsMojo extends AbstractMojo {
    public void execute() throws MojoExecutionException
    {
        getLog().info("Hello, world.");
    }
}
