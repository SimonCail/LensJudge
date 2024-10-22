package lensjudge.compilation;

public class CompilerContext {
    private ICompilerStrategy strategy;

    public void setStrategy(ICompilerStrategy strategy) {
        this.strategy = strategy;
    }

    public void compile(String sourceFileName , String languageSelected) throws Exception {
        strategy.compile(sourceFileName, languageSelected);
    }
}
