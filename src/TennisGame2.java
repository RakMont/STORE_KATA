
public class TennisGame2 implements TennisGame
{
    public int Player1Points = 0;
    public int Player2Points = 0;
    
   
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getLiteralScore(){
        String literalScore = "";
		if (isNormal())
			literalScore = getLiteral(Player1Points)+ "-" + getLiteral(Player2Points);
		
		if (isTie())
		    literalScore =getLiteral(Player1Points)+ "-All";
    		
		if (isDeuce())
			literalScore = "Deuce";
		if (isAdvantage(Player1Points,Player2Points))
		    literalScore = "Advantage player1";
		
		if (isAdvantage(Player2Points,Player1Points))
		    literalScore = "Advantage player2";
		
		if (isWinner(Player1Points,Player2Points))
		    literalScore = "Win for player1";
		
		if (isWinner(Player2Points,Player1Points))
		    literalScore = "Win for player2";
		
		
        return literalScore;
    }

	private boolean isWinner(int firstPlayerPoints,int secondPlayerPoints) {
		return firstPlayerPoints>=4 && secondPlayerPoints>=0 && (firstPlayerPoints-secondPlayerPoints)>=2;
	}

	private boolean isAdvantage(int firstPlayerPoints,int secondPlayerPoints) {
		return firstPlayerPoints > secondPlayerPoints && secondPlayerPoints >= 3;
	}

	
	private boolean isNormal() {
		return Player1Points != Player2Points;
	}


	private boolean isTie() {
		return Player1Points == Player2Points && Player1Points < 4;
	}

	private boolean isDeuce() {
		return Player1Points==Player2Points && Player1Points>=3;
	}
	private String getLiteral(int playerPoints) {
		String result="";
		if (playerPoints==0)
			result = "Love";
		if (playerPoints==1)
			result = "Fifteen";
		if (playerPoints==2)
			result = "Thirty";
		if (playerPoints==3)
			result = "Forty";
		return result;
	}
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        Player1Points++;
    }
    
    public void P2Score(){
        Player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}