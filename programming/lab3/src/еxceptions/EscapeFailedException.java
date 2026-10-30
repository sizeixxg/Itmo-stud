package еxceptions;

public class EscapeFailedException extends Exception {
    private final int slaveScore;
    private final int guardScore;

    public EscapeFailedException(int slaveScore, int guardScore){
        this.slaveScore=slaveScore;
        this.guardScore=guardScore;
    }

    @Override
    public String getMessage(){
        return "Охранник оказался сильнее"+guardScore +"заключенного"+slaveScore;
    }
}
