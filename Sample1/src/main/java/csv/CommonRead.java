package csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CommonRead {
	public void execute(String realPath) {
		System.out.println("Commonread");
		//try-resourceでInputStreamReaderを取得
		try (InputStream is = getClass().getResourceAsStream(realPath);
		     BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

		    //CSVParserを取得する。読み込み方とかはここで設定。
		    CSVParser parser = CSVFormat
		        .EXCEL                                        // ExcelのCSV形式を指定
		        .withIgnoreEmptyLines(true)                   // 空行を無視する
		        .withHeader("Header1", "Header2")             // ヘッダの指定
		        .withFirstRecordAsHeader()                    // 最初の行をヘッダーとして読み飛ばす
		        .withIgnoreSurroundingSpaces(true)            // 値をtrimして取得する
		        .parse(br);

		    // CSVのレコードを取得
		    List<CSVRecord> recordList = parser.getRecords();

		    // CSVRecordに各カラムが入っているので、よしなにやる
		    for (CSVRecord record : recordList ) {
		        System.out.println(record.get(0));
		    }
		} catch (IOException e) {
		    // 例外ハンドリング
		}
	}

}
