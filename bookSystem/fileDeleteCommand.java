package bookSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class fileDeleteCommand implements CLICommand{

	protected BookCatalog catalog;

	public fileDeleteCommand(BookCatalog catalog){
		this.catalog = catalog;
	}

	@Override
	public void prosses(BufferedReader in, PrintWriter out) throws IOException {

		catalog.deleteFile();
		out.println("ファイルを削除しました。");
	}
}
