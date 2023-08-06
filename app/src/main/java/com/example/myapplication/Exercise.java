package com.example.myapplication;
import org.json.JSONException;
import org.json.JSONObject;

public class Exercise {
    private String name;
    private String[] attribute;
    private String[] unit;

    public Exercise() {
        attribute = new String[6];
        unit = new String[6];
    }

    public Exercise(String name, String[] attribute) {
        this.name = name;
        this.attribute = attribute;
    }

    // Getter and Setter for "name"
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for the "attribute" array
    public String[] getAttribute() {
        return attribute;
    }

    public void setAttribute(String[] attribute) {
        this.attribute = attribute;
    }

    // Getter and Setter for the "unit" array
    public String[] getUnit() {
        return unit;
    }

    public void setUnit(String[] unit) {
        this.unit = unit;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", name);
            for (int i = 0; i < attribute.length; i++) {
                jsonObject.put("attribute" + (i + 1), attribute[i]);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static Exercise fromJson(JSONObject jsonObject) {
        try {
            String name = jsonObject.getString("name");
            String[] attribute = new String[6];
            for (int i = 0; i < attribute.length; i++) {
                String attributeName = "attribute" + (i + 1);
                attribute[i] = jsonObject.getString(attributeName);
            }
            return new Exercise(name, attribute);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
