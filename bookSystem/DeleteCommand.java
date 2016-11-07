package bookSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteCommand implements CLICommand {

	protected BookCatalog catalog;


	public DeleteCommand(BookCatalog catalog){
		this.catalog = catalog;
	}

	@Override
	public void prosses(BufferedReader in, PrintWriter out) throws IOException {

		String inData = "";
		out.println("削除したい本のIDを入力して下さい。");
		inData = in.readLine();

		if(catalog.getBook(inData) == null){
			out.println("ID:" + inData +"はありません。");
		}else{
			catalog.deleteBook(inData);
			out.println("ID:" + inData +"を削除しました。");
		}
	}
}
