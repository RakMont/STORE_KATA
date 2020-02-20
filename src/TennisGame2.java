
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
		if (isNormal())
			score = getLiteral(P1point)+ "-" + getLiteral(P2point);
		
		if (isTie())
		    score =getLiteral(P1point)+ "-All";
    		
		if (isDeuce())
			score = "Deuce";
		
		
        
       
        
        score = advantage(score);
        
        score = win(score);
        return score;
    }

	private String win(String score) {
		if (isWinner(P1point,P2point))
        {
            score = "Win for player1";
        }
		if (isWinner(P2point,P1point))
        {
            score = "Win for player2";
        }
		return score;
	}

	private boolean isWinner(int firstPlayerPoints,int secondPlayerPoints) {
		return firstPlayerPoints>=4 && secondPlayerPoints>=0 && (firstPlayerPoints-secondPlayerPoints)>=2;
	}

	private String advantage(String score) {
		if (isAdvantage(P1point,P2point))
        {
            score = "Advantage player1";
        }
        
        if (isAdvantage(P2point,P1point))
        {
            score = "Advantage player2";
        }
		return score;
	}

	private boolean isAdvantage(int firstPlayerPoints,int secondPlayerPoints) {
		return firstPlayerPoints > secondPlayerPoints && secondPlayerPoints >= 3;
	}

	
	private boolean isNormal() {
		return P1point != P2point;
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

	private boolean isTie() {
		return P1point == P2point && P1point < 4;
	}

	private boolean isDeuce() {
		return P1point==P2point && P1point>=3;
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
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}