package client.typeadapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import static com.google.gson.stream.JsonToken.NUMBER;
import static com.google.gson.stream.JsonToken.STRING;

public class StringTypeAdapter extends TypeAdapter<String> {
    @Override
    public void write(JsonWriter jsonWriter, String s) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String read(JsonReader jsonReader) throws IOException {
        final JsonToken peek = jsonReader.peek();
        if ( peek != STRING ) {
            jsonReader.skipValue();
            return null;
        }
        return jsonReader.nextString();
    }
}
