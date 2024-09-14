package client;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ScriptReader {
    private final TerminalManager terminalManager = new TerminalManager();
    LinkedList<String> lines;
    String path;
    public ScriptReader(String path) {
        lines = new LinkedList<String>();
        this.path = path;
        try (FileReader file = new FileReader(this.path);
            BufferedReader reader = new BufferedReader(file)){
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            terminalManager.printText("[!] File not found!");
        } catch (Throwable e) {
            terminalManager.printText("[!] Throwable!");
        }
    }

    public LinkedList<String> readLine() {
        String line = lines.pollFirst();
        if (line == null){
            return null;
        }else{
            return new LinkedList<String>(List.of(line.toLowerCase().trim().split("\\s")));
        }
    }

    public LinkedList<String> readLineWithoutDelete() {
        String line = lines.peekFirst();
        if (line == null){
            return null;
        }else{
            return new LinkedList<String>(List.of(line.toLowerCase().trim().split("\\s")));
        }
    }

    public String getPath(){
        return this.path;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
