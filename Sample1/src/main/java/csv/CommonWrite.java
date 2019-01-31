package csv;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CommonWrite {
	public void execute(String realPath) {
		System.out.println("CommonWrite");

		//try-resourceでOutputStreamWriterを取得
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(realPath), "UTF-8"))) {

		    // CSVPrinterを取得。書き込みの設定とかする
		    CSVPrinter printer = CSVFormat
		        .EXCEL                             // ExcelのCSV形式を指定
		        .withHeader("Header1", "Header2")  // ヘッダの指定
		        .print(bw);

		    // CSVのレコードを書込
		    printer.printRecord("Col1-1", "Col2-1", "Col3-1");
		    printer.printRecord("Col1-2", "Col2-2", "Col3-2");

		} catch (IOException e) {
		    // 例外ハンドリング
		}
	}
}
