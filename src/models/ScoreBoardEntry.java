package models;

import java.io.Serializable;

/**
 * The Class ScoreBoardEntry, which is comparable to other entries based on score.
 */
public class ScoreBoardEntry implements Serializable, java.lang.Comparable<ScoreBoardEntry>{
	
	/** The name associated with the score. */
	public String name;
	
	/** The score. */
	public int score;

	/**
	 * Instantiates a new score board entry.
	 */
	public ScoreBoardEntry() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "Name: " + this.name + "\nScore: " + this.score;
	}

}
