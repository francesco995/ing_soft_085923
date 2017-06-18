package it.polimi.ingsw.ps09.model.GsonAdapters;

import com.google.gson.*;
import it.polimi.ingsw.ps09.model.Player;

import java.lang.reflect.Type;

/**
 * Created by francesco995 on 18/06/2017.
 * Adapter to allow correct serialization and deserialization of Player
 */
public class PlayerAdapter implements JsonSerializer<Player>, JsonDeserializer<Player> {

    private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE  = "INSTANCE";

    @Override
    public JsonElement serialize(Player src, Type typeOfSrc,
                                 JsonSerializationContext context) {

        JsonObject retValue = new JsonObject();
        String className = src.getClass().getName();
        retValue.addProperty(CLASSNAME, className);
        JsonElement elem = context.serialize(src);
        retValue.add(INSTANCE, elem);
        return retValue;
    }

    @Override
    public Player deserialize(JsonElement json, Type typeOfT,
                            JsonDeserializationContext context) throws JsonParseException  {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
        String className = prim.getAsString();

        Class<?> klass = null;
        try {
            klass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new JsonParseException(e.getMessage());
        }
        return context.deserialize(jsonObject.get(INSTANCE), klass);
    }

}