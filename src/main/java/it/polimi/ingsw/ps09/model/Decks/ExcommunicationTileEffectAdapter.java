package it.polimi.ingsw.ps09.model.Decks;

import com.google.gson.*;
import it.polimi.ingsw.ps09.model.ExcommunicationTileEffects.ExcommunicationTileEffect;

import java.lang.reflect.Type;

/**
 * Created by franc on 06/06/2017.
 */
public class ExcommunicationTileEffectAdapter implements
        JsonSerializer<ExcommunicationTileEffect>, JsonDeserializer<ExcommunicationTileEffect> {

    private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE  = "INSTANCE";

    @Override
    public JsonElement serialize(ExcommunicationTileEffect src, Type typeOfSrc,
                                 JsonSerializationContext context) {

        JsonObject retValue = new JsonObject();
        String className = src.getClass().getName();
        retValue.addProperty(CLASSNAME, className);
        JsonElement elem = context.serialize(src);
        retValue.add(INSTANCE, elem);
        return retValue;
    }

    @Override
    public ExcommunicationTileEffect deserialize(JsonElement json, Type typeOfT,
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
