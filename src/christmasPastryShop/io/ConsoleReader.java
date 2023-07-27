package christmasPastryShop.io;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import christmasPastryShop.io.interfaces.InputReader;

public class ConsoleReader  implements InputReader {
    private BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() throws IOException {
        return this.reader.readLine();
    }
}
