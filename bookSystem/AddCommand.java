package bookSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddCommand implements CLICommand {

	protected BookCatalog catalog;

	public AddCommand(BookCatalog catalog){
		this.catalog = catalog;
	}

	@Override
	public void prosses(BufferedReader in, PrintWriter out) throws IOException {

		Book book = new Book();
		String inData = null;

		//	以下、入力処理
		System.out.print("ID:");
		inData = catalog.createUniqueBookId();
		out.println(catalog.createUniqueBookId());
		book.setBookId(inData);


		System.out.print("タイトル:");
		book.setTitle(in.readLine());

		System.out.print("著者:");
		book.setAuthor(in.readLine());

		System.out.print("訳者:");
		book.setTranslater(in.readLine()) ;

		System.out.print("出版社:");
		book.setPublisher(in.readLine());

		while(!checkDate(inData)){
			System.out.print("出版年月日:");
			inData = in.readLine();
			if (checkDate(inData)){
		    } else {
		        System.out.println("正しい日付を入力して下さい(0000-00-00)");
		    }
		}
		book.setPublicationDate(inData);

		System.out.print("コード:");
		book.setCode(in.readLine());

		System.out.print("状態:");
		book.setStatus(in.readLine());

		System.out.print("キーワード:");
		book.setKeyword(in.readLine());

		System.out.print("備考:");
		book.setMemo(in.readLine());

		System.out.print("登録者:");
		book.setDetaCreator(in.readLine());

		Date now = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String s = f.format(now);
		System.out.print("登録日:" + s);
		book.setDataCreatedDate(s);

		out.println();
		out.println("登録が完了しました。");
		out.println();
		catalog.addBook(book);
	}

	//	日付確認ﾒｿｯﾄﾞ
	public static boolean checkDate(String date) {
        if (date == null || date.length() != 10) {
            return false;
        }
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            format.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}