package it.polimi.ingsw.ps09.model.GsonAdapters;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by francesco995 on 19/06/2017.
 */
public class IntegerArrayListAdapter implements
        JsonSerializer<ArrayList<Integer>>, JsonDeserializer<ArrayList<Integer>> {

    private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE  = "INSTANCE";

    @Override
    public JsonElement serialize(ArrayList<Integer> src, Type typeOfSrc,
                                 JsonSerializationContext context) {

        JsonObject retValue = new JsonObject();
        String className = src.getClass().getName();
        retValue.addProperty(CLASSNAME, className);
        JsonElement elem = context.serialize(src);
        retValue.add(INSTANCE, elem);
        return retValue;
    }

    @Override
    public ArrayList<Integer> deserialize(JsonElement json, Type typeOfT,
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