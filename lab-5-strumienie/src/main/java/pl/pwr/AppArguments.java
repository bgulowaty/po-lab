package pl.pwr;

public class AppArguments {
    private final String inputFilePath;
    private final String outputFilePath;

    public AppArguments(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    @Override
    public String toString() {
        return "AppArguments{" +
                "inputFilePath='" + inputFilePath + '\'' +
                ", outputFilePath='" + outputFilePath + '\'' +
                '}';
    }
}
