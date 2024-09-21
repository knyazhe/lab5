package client.typeadapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import static com.google.gson.stream.JsonToken.BOOLEAN;
import static com.google.gson.stream.JsonToken.NUMBER;

public class BooleanTypeAdapter extends TypeAdapter<Boolean> {
    @Override
    public void write(JsonWriter jsonWriter, Boolean aBoolean) throws IOException {

    }

    @Override
    public Boolean read(JsonReader jsonReader) throws IOException {
        final JsonToken peek = jsonReader.peek();
        if ( peek != BOOLEAN ) {
            jsonReader.skipValue();
            return null;
        }
        return jsonReader.nextBoolean();
    }
}
