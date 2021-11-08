public class TennisGame3 implements TennisGame {

    private int player2Point;
    private int player1Point;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (movePointsPlayers()) {
            return scorePlayers();
        } else {
            if (equalsPointsPlayers(player1Point, player2Point))
                return "Deuce";
            return advantageOrWinnerPlayer();
        }
    }

    private boolean equalsPointsPlayers(int pointPlayer1, int pointPlayer2) {
        return pointPlayer1 == pointPlayer2;
    }

    private String advantageOrWinnerPlayer() {
        return (equalsPointsPlayers((player1Point - player2Point)*(player1Point - player2Point), 1)) ? advantagePlayer() : winnerPlayer();
    }

    private String winnerPlayer() {
        return "Win for " + namepPlayerWinnerOAdvantage();
    }

    private String advantagePlayer() {
        return "Advantage " + namepPlayerWinnerOAdvantage();
    }

    private String namepPlayerWinnerOAdvantage() {
        return player1Point > player2Point ? player1Name : player2Name;
    }

    private String scorePlayers() {
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return (player1Point == player2Point) ?  p[player1Point] + "-All" :  p[player1Point] + "-" + p[player2Point];
    }

    private boolean movePointsPlayers() {
        return limitMovePoints() && !(player1Point + player2Point == 6);
    }

    private boolean limitMovePoints() {
        return player1Point < 4 && player2Point < 4;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            this.player1Point += 1;
        else
            this.player2Point += 1;

    }

}