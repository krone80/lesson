package csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Write {
	public void execute(String dirPath) throws IOException {
		File file = new File("write.csv");
		if(file.createNewFile()) {
			System.out.println("ファイルを作成");
		}
		String path = dirPath + "\\" + file;
		System.out.println(path);
		int[] idList = { 1, 2, 3 };
		String[] nameList = { "佐藤", "鈴木", "高橋" };

		try {
			// 出力ファイルの作成
			FileWriter f = new FileWriter(path, false);
			PrintWriter p = new PrintWriter(new BufferedWriter(f));

			// ヘッダーを指定する
			p.print("社員番号");
			p.print(",");
			p.print("名前");
			p.println();

			// 内容をセットする
			for (int i = 0; i < idList.length; i++) {
				p.print(idList[i]);
				p.print(",");
				p.print(nameList[i]);
				p.println(); // 改行
			}

			// ファイルに書き出し閉じる
			p.close();

			System.out.println("ファイル出力完了！");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
