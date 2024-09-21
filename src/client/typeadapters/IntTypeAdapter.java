package client.typeadapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import static com.google.gson.stream.JsonToken.NUMBER;

public class IntTypeAdapter extends TypeAdapter<Integer> {

    @Override
    public void write(JsonWriter jsonWriter, Integer integer) throws IOException {

    }

    @Override
    public Integer read(JsonReader jsonReader) throws IOException {
        final JsonToken peek = jsonReader.peek();
        if ( peek != NUMBER ) {
            jsonReader.skipValue();
            return null;
        }
        return jsonReader.nextInt();
    }
}
