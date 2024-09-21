package client.typeadapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import server.model.Coordinates;

import java.io.IOException;

import static com.google.gson.stream.JsonToken.BEGIN_OBJECT;
import static com.google.gson.stream.JsonToken.NUMBER;

public class CoordinatesTypeAdapter extends TypeAdapter<Coordinates> {



    @Override
    public void write(JsonWriter jsonWriter, Coordinates coordinates) throws IOException {

    }

    @Override
    public Coordinates read(JsonReader jsonReader) throws IOException {
        final JsonToken peek = jsonReader.peek();
        if ( peek != BEGIN_OBJECT ) {
            jsonReader.skipValue();
            return null;
        }
        return null;
//        return jsonReader.nextDouble();
    }
}
