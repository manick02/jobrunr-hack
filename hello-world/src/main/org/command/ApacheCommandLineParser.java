package org.command;


import org.apache.commons.cli.*;

public class ApacheCommandLineParser {
    public static void main(String[] args) throws ParseException {
        Option logFile = Option.builder("logfile")
                .argName("file")
                .hasArg()
                .desc("use given file for log")
                .build();

        Options options = new Options();
        options.addOption(logFile);
        String[] args1 = new String[] {"-logfile","tea"};
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args1);
        if (cmd.hasOption("logfile")) {
            String t = cmd.getOptionValue("logfile");
            System.out.println(t);
        }
    }
}
