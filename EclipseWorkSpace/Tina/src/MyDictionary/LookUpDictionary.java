package MyDictionary;
import java.util.*;
public class LookUpDictionary {
	dictionaryFuction my;
	Scanner input;
	public LookUpDictionary() {
		// TODO Auto-generated constructor stub
		my = new dictionaryFuction();
		input = new Scanner(System.in);
	}
	// 开始
	public void welcome() {
		System.out.println("****************");
		System.out.println("欢迎使用我的字典");
		System.out.println("****************");
	}
	// 查询功能
	public void lookUp() {
		char choice;
		do {
			System.out.println("1、查单词");
			System.out.println("2、加单词");
			System.out.println("3、删除单词");
			System.out.println("4、产看所有单词");
			System.out.println("5、修改单词");
			System.out.println("0、退出");
			choice = input.nextLine().charAt(0);
			switch (choice) {
			case '1':
				showWord();
				break;
			case '2':
				showAdd();
				break;
			case '3':
				showDel();
				break;
			case '4':
				my.listAllWords();
				break;
			case '5':
				showUpdata();
				break;
			default:
				break;
			}
			
		} while (choice != '0');
	}

	public void showWord() {
		System.out.println("请输入你要产找单词的中英文");
		String str = input.nextLine();
		Word word = my.searchWord(str);
		if (word != null) {
			System.out.println("产找单词的中英文含义为：");
			System.out.println(word.toString());
		} else
			System.out.println("这个单词没找到");
	}

	public void showAdd() {
		if (my.count < 100) {
			System.out.println("请输入你想要添加单词的中文含义");
			String Cword = input.nextLine();
			System.out.println("请输入你想要添加单词的英文含义");
			String Eword = input.nextLine();
			Word word = new Word(Eword, Cword);
			my.add(word);
			System.out.println("添加单词成功");
		} else
			System.out.println("字典已满");
	}

	public void showDel() {
		System.out.println("请输入你要删除的单词的含义");
		String string = input.nextLine();
		boolean ifDel = my.deleteWords(string);
		if (ifDel)
			System.out.println("删除成功");
		else
			System.out.println("删除失败！！！");
	}

	public void showUpdata() {
		System.out.println("仅能修改单词的英文含义");
		System.out.println("请输入你想要修改单词的中文含义");
		String cStr = input.nextLine();
		System.out.println("请输入单词修改后的英文含义");
		String eStr = input.nextLine();
		Word word = new Word(eStr, cStr);
		if (my.updateWord(word))
			System.out.println("单词修改成功");
		else
			System.out.println("词典中没有这个单词");

	}

	// 结束
	public void bye() {
		System.out.println("****************");
		System.out.println("Bye —Bye");
		System.out.println("****************");
	}

	public void run() {
		welcome();
		lookUp();
		bye();
	}
}
