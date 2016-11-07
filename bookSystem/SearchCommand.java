package bookSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchCommand implements CLICommand{

	protected BookCatalog catalog;

	public SearchCommand(BookCatalog catalog){
		this.catalog = catalog;
	}

	@Override
	public void prosses(BufferedReader in, PrintWriter out) throws IOException {

		out.println("検索したいワードを入力して下さい。");
		String inData = in.readLine();
		catalog.searchBooks(inData);

		if(catalog.searchBooks(inData) == null){
			out.println("その検索ワードに当てはまる書籍はありませんでした。");
		}else{
			for(Book book:catalog.searchBooks(inData)){

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
}
