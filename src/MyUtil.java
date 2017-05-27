

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyUtil {
	// �������еķ������Ǿ�̬��ʽ���ʵ���˽�������˽�в�����������(���Ժ�ϰ��)
	private MyUtil() {
		throw new AssertionError();
	}

	/**
	 * ͳ�Ƹ����ļ��и����ַ����ĳ��ִ���
	 * 
	 * @param filename
	 *            �ļ���
	 * @param word
	 *            �ַ���
	 * @return �ַ������ļ��г��ֵĴ���
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
					line = line.substring(index + word.length());//�����鿴��һ�к����Ƿ�����ͬ�ַ���
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
