package client;

import client.typeadapters.LocalDateTimeTypeAdapter;
import com.google.gson.*;
import server.model.MyCollection;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class JsonManager {
    private static Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter()).setStrictness(Strictness.LENIENT).setPrettyPrinting().create();;

    public JsonManager() {
    }

    public static void saveToJson(MyCollection collection){
        String jsonCollection = gson.toJson(collection);
        System.out.println(collection);
        System.out.println(jsonCollection);
        try {
            FileWriter writer = new FileWriter("DragonCollectionSave.json", false);
            writer.write(jsonCollection);
            writer.close();
        } catch (IOException e) {
            System.out.println("[!] Error write on file: " + e.getMessage());
        }
    }
    public static MyCollection loadFromJson(){
        try{
            JsonElement jsonElement = JsonParser.parseReader(new FileReader("DragonCollectionSave.json"));
            JsonObject jsonObject = jsonElement.getAsJsonObject();



//            MyCollection fromJsonCollection = gson.fromJson(new FileReader("DragonCollectionSave.json"), MyCollection.class);
            return null;
        } catch (Throwable e){
            System.out.println("[!] Error read from file: " + e.getMessage());
            return new MyCollection();
        }
    }
}