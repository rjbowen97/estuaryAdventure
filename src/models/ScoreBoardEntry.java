package models;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class ScoreBoardEntry.
 */
public class ScoreBoardEntry implements Serializable, java.lang.Comparable<ScoreBoardEntry>{
	
	/** The name. */
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

}
