package com.ohiocityburrito.mobile.menu;
import static com.ohiocityburrito.mobile.Utils.Json.jsonFromInputStream;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class LocallyStoredMenuSource implements MenuSource {

    private final InputStream resourceStream;

    public LocallyStoredMenuSource(InputStream resourceStream) {
        this.resourceStream = resourceStream;
    }

    @Override
    public List<MenuContentItem> getMenuContentItems() {
        List<MenuContentItem> items = new ArrayList<MenuContentItem>();
        try {
            JSONObject json = jsonFromInputStream(resourceStream);
            JSONArray jsonArray = json.getJSONArray("menu");
            addMenuContentItemsFromJsonArray(items, jsonArray);
        } catch (JSONException e) {
            Log.e("ocb", "error parsing menu json", e);
        }

        return items;
    }

    private void addMenuContentItemsFromJsonArray(List<MenuContentItem> items, JSONArray jsonArray) throws JSONException {
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject menuSection = jsonArray.getJSONObject(i);
            items.add(parseMenuHeader(menuSection));
            JSONArray sectionContents = menuSection.getJSONArray("contents");
            for(int j = 0; j < sectionContents.length(); j++) {
                JSONObject menuItem = sectionContents.getJSONObject(j);
                items.add(parseMenuItem(menuItem));
            }
        }
    }

    private MenuContentItem parseMenuHeader(JSONObject menuSection) throws JSONException {
        String headerTitle = menuSection.getString("title");
        MenuContentItem header = new MenuContentItem(headerTitle);
        return header;
    }

    private MenuContentItem parseMenuItem(JSONObject menuItem) throws JSONException {
        String title = menuItem.getString("name");
        String description = menuItem.getString("description");
        String price = menuItem.getString("price");
        MenuContentItem menuContentItem = new MenuContentItem(title,description,price);
        return menuContentItem;
    }

}
