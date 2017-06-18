package it.polimi.ingsw.ps09.model.GsonAdapters;

import com.google.gson.*;
import it.polimi.ingsw.ps09.controller.Game.Game;

import java.lang.reflect.Type;

/**
 * Created by francesco995 on 18/06/2017.
 * Adapter to allow correct serialization and deserialization of Game
 */
public class GameAdapter implements JsonSerializer<Game>, JsonDeserializer<Game> {

    private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE  = "INSTANCE";

    @Override
    public JsonElement serialize(Game src, Type typeOfSrc,
                                 JsonSerializationContext context) {

        JsonObject retValue = new JsonObject();
        String className = src.getClass().getName();
        retValue.addProperty(CLASSNAME, className);
        JsonElement elem = context.serialize(src);
        retValue.add(INSTANCE, elem);
        return retValue;
    }

    @Override
    public Game deserialize(JsonElement json, Type typeOfT,
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