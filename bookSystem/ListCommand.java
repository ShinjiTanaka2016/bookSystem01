package bookSystem;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class ListCommand implements CLICommand {

	BookCatalog catalog;

	public ListCommand(BookCatalog catalog){
		this.catalog = catalog;
	}

	@Override
	public void prosses(BufferedReader in, PrintWriter out) {

		if(catalog.getBooks().length == 0){
			out.println("ファイルデータがありません。");
		}
		out.println("合計" + catalog.getBooks().length + "項目");
		out.println("*--------------------------------------------*");

		for(Book book:catalog.getBooks()){

				out.println("ＩＤ		：" + book.getBookId());
				out.println("タイトル	：" + book.getTitle());
				out.println("著者		：" + book.getAuthor());
				out.println("訳者		：" + book.getTranslater());
				out.println("出版社		：" + book.getPublisher());
				out.println("出版年月日	：" + book.getPublicationDate());
				out.println("コード		：" + book.getCode());
				out.println("状態		：" + book.getStatus());
				out.println("備考		：" + book.getMemo());
				out.println("登録者		：" + book.getDetaCreator());
				out.println("登録日		：" + book.getDataCreatedDate());
				out.println("*--------------------------------------------*");
		}
	}
}
