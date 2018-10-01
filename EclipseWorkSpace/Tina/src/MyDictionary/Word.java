package MyDictionary;

public class Word {
	String eWord;
	String cWord;

	public String geteWord() {
		return eWord;
	}

	public void seteWord(String eWord) {
		this.eWord = eWord;
	}

	public String getcWord() {
		return cWord;
	}

	public void setcWord(String cWord) {
		this.cWord = cWord;
	}

	public Word(String eWord, String cWord) {
		this.eWord = eWord;
		this.cWord = cWord;
	}

	public Word() {
		this.eWord = null;
		this.cWord = null;
	}

	public String toString() {
		return (this.eWord + "===" + this.cWord);
	}
}
