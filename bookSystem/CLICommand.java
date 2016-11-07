package bookSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public interface CLICommand {
	public void prosses(BufferedReader in, PrintWriter out) throws IOException;
}
