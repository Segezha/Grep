package Grep;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class GrepLauncher {
        @Option(name = "-v", metaVar = "Invert", usage = "Finds lines not including the searched word")
        private boolean isInvert;

        @Option(name = "-r", metaVar = "RegEx", usage = "Finds lines including the searched regular expression")
        private boolean expr;

        @Option(name = "-i", metaVar = "Ignore", usage = "Ignores the searched word's case")
        private boolean isIgnore;

        @Argument(required = true, metaVar = "word", usage = "Input word to search!")
        private String word;

        @Argument(required = true, metaVar = "InputName",index = 1, usage = "Input File Name")
        private String input;

    public static void main(String[] args) { new GrepLauncher().launch(args);
    }
    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("[-v] Inversion [-r] RegEx [-i] Ignore, word");
            parser.printUsage(System.err);
            System.exit(-2);
        }

        Grep grep = new Grep(expr, isInvert, isIgnore);

        grep.printResult(grep.options(word, input));
    }
}
