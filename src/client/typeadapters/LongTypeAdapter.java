package client.typeadapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import static com.google.gson.stream.JsonToken.*;

public class LongTypeAdapter extends TypeAdapter<Long> {

    @Override
    public void write(JsonWriter jsonWriter, Long aLong) throws IOException {

    }

    @Override
    public Long read(JsonReader jsonReader) throws IOException {
        final JsonToken peek = jsonReader.peek();
        if ( peek != NUMBER ) {
            jsonReader.skipValue();
            return null;
        }
        return jsonReader.nextLong();
    }
}
