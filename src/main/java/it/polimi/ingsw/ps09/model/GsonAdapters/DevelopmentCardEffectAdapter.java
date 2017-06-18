package it.polimi.ingsw.ps09.model.GsonAdapters;

import com.google.gson.*;
import it.polimi.ingsw.ps09.model.DevelopmentCardEffects.DevelopmentCardEffect;

import java.lang.reflect.Type;

/**
 * Created by francesco995 on 30/05/2017.
 * Adapter to allow correct loading of different DevelopmentCardEffects for json file
 */
public class DevelopmentCardEffectAdapter implements
        JsonSerializer<DevelopmentCardEffect>, JsonDeserializer<DevelopmentCardEffect> {

    private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE  = "INSTANCE";

    @Override
    public JsonElement serialize(DevelopmentCardEffect src, Type typeOfSrc,
                                 JsonSerializationContext context) {

        JsonObject retValue = new JsonObject();
        String className = src.getClass().getName();
        retValue.addProperty(CLASSNAME, className);
        JsonElement elem = context.serialize(src);
        retValue.add(INSTANCE, elem);
        return retValue;
    }

    @Override
    public DevelopmentCardEffect deserialize(JsonElement json, Type typeOfT,
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
