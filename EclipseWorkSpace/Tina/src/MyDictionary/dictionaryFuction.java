package MyDictionary;
public class dictionaryFuction {
	Word[] words;
	int count;

	public dictionaryFuction() {
		// TODO Auto-generated constructor stub
		words = new Word[100];
		count = 0;
	}

	// 添加单词
	public boolean add(Word word) {
		if (count < 100) {
			this.words[this.count++] = word;
			return true;
		} else
			return false;
	}

	// 查询单词
	public Word searchWord(String word) {
		for (int i = 0; i < count; i++) {
			if (this.words[i].geteWord().equalsIgnoreCase(word) || this.words[i].getcWord().equalsIgnoreCase(word))
				return words[i];
		}
		return null;
	}

	// 显示所有单词
	public void listAllWords() {
		System.out.println("以下是所有的单词");
		for (int i=0;i<count;i++)
			System.out.println(this.words[i].toString());
	}

	// 删除单词
	public boolean deleteWords(String word) {
		int location = -1;
		// 寻找要删除的元素，返回true
		for (int i = 0; i < count; i++) {
			if (this.words[i].geteWord().equalsIgnoreCase(word) || this.words[i].getcWord().equalsIgnoreCase(word)) {
				location = i;
				break;
			}
		}
		// 找到删除,如果是最后一个元素，count--直接覆盖
		if (location >= 0) {
			for (int i = location; i < count - 1; i++) {
				words[i] = words[i + 1];
			}
			count--;
			return true;
		}
		// 找不到返回false
		else
			return false;
	}

	// 根据中文单词的含义，更新词典中的单词
	public boolean updateWord(Word word) {
		if (word != null) {
			int i = indexOf(word.getcWord());
			if (i >= 0) {
				this.words[i] = word;
				return true;
			} else
				return false;
		} else
			return false;
	}

	// 判断单词的中文，显示在列表中的位置
	private int indexOf(String str) {
		// TODO Auto-generated method stub
		if (str == null)
			return -1;
		else {
			for (int i = 0; i < this.count; i++) {
				if (this.words[i].getcWord().equals(str))
					return i;
			}
			return -1;
		}
	}
}
