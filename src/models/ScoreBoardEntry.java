package models;

import java.io.Serializable;

public class ScoreBoardEntry implements Serializable, java.lang.Comparable<ScoreBoardEntry>{
	
	public String name;
	public int score;

	public ScoreBoardEntry() {
	}

	@Override
	public int compareTo(ScoreBoardEntry o) {
		if(this.score<o.score){
			return 1;
		}
		else if (this.score>o.score){
			return -1;
		}
		else {
			return 0;
		}
	}

}
