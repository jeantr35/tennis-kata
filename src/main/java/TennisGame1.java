
public class TennisGame1 implements TennisGame {
    
    private int mScore1 = 0;
    private int mScore2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            mScore1 += 1;
        else
            mScore2 += 1;
    }

    private String getEqualsScore(){
        switch (mScore1)
        {
            case 0:
                return  "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return  "Thirty-All";
            default:
                return  "Deuce";
        }
    }

    private String getAdvantageScore(int minusResult){
        if (minusResult==1) return "Advantage " + this.player1Name;
        if (minusResult ==-1) return "Advantage " + this.player2Name;
        if (minusResult>=2) return "Win for " + this.player1Name;
        return "Win for " + this.player2Name;
    }

    private String getPlayerScore(int score){
        switch(score)
        {
            case 0:
                return "Love";
            case 1:
               return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";

        }
    }

    private String setScores(int mScore1, int mScore2){
        String score = "";
        score = score.concat(getPlayerScore(mScore1));
        score = score.concat("-");
        score = score.concat(getPlayerScore(mScore2));
        return score;
    }


    public String getScore() {
        if (mScore1 == mScore2)
            return getEqualsScore();
        if (mScore1 >=4 || mScore2 >=4)
            return getAdvantageScore(mScore1 - mScore2);
        return setScores(mScore1, mScore2);
    }
}
