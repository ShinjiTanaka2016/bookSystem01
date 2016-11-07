package bookSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	protected Map<String,CLICommand> commandMap = new HashMap<String,CLICommand>();

	//	コマンド別
	public Main(){
		BookCatalog catalog = BookCatalog.getInstance();
		CLICommand command;

		command = new ListCommand(catalog);
		commandMap.put("1", command);
		commandMap.put("list", command);
		command = new SearchCommand(catalog);
		commandMap.put("2", command);
		commandMap.put("search", command);
		command = new AddCommand(catalog);
		commandMap.put("3", command);
		commandMap.put("add", command);
		command = new DeleteCommand(catalog);
		commandMap.put("4", command);
		commandMap.put("delete", command);
		command = new fileDeleteCommand(catalog);
		commandMap.put("5", command);
		commandMap.put("fileDelete", command);
		command = new ExitCommand();
		commandMap.put("0", command);
		commandMap.put("exit", command);
	}

	//	メインメニュー
	public void process(BufferedReader in,PrintWriter out)throws IOException{

		while(true){

			try{
				out.println("--【MENU】---------------------------------------------");
				out.println("1)一覧(list)　　2)検索　　3)登録(add)　　4)削除(delete)");
				out.println("5)ファイル削除(fileDelete)　　0)終了(exit)");
				out.println("-------------------------------------------------------");
				commandMap.get(in.readLine()).prosses(in, out);

			}catch(Exception e){
				out.println("正しく入力して下さい。");
			}
		}
	}

	public static void main(String[]args){
		try{
			BufferedReader in = new BufferedReader(
					new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(System.out),true);
			Main main = new Main();
			main.process(in, out);

			ProcessBuilder pb = new ProcessBuilder("C:\\Windows\\System32\\notepad.exe","kekka.txt");
			pb.start();

		}catch(Exception e){
			// e.printStackTrace();  //	エラーの経緯を表示
		}
	}
}
