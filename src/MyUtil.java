

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyUtil {
	// 工具类中的方法都是静态方式访问的因此将构造器私有不允许创建对象(绝对好习惯)
	private MyUtil() {
		throw new AssertionError();
	}

	/**
	 * 统计给定文件中给定字符串的出现次数
	 * 
	 * @param filename
	 *            文件名
	 * @param word
	 *            字符串
	 * @return 字符串在文件中出现的次数
	 */
	public static int countWordInFile(String filename, String word) {
		int counter = 0;

		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				int index = -1;
				while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
					counter++;
					line = line.substring(index + word.length());//继续查看这一行后面是否有相同字符串
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return counter;
	}

	public static void main(String[] args) {
		int count=countWordInFile("D:\\123.txt", "hello");
		System.out.println(count);
	}
}
