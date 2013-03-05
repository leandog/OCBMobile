package com.ohiocityburrito.mobile.menu;

import java.util.Arrays;
import java.util.List;

import android.test.AndroidTestCase;
import android.view.View;
import android.widget.TextView;

import com.ohiocityburrito.mobile.R;

public class MenuContentAdapterTest extends AndroidTestCase {

    private static final int ITEM_IN_MENU_ITEMS = 1;
    private static final int HEADER_IN_MENU_ITEMS = 0;
    private static final List<MenuContentItem> DEFAULT_ITEMS = Arrays.asList(
            new MenuContentItem("Burritos"),
            new MenuContentItem("Brothers Burrito", "Mmmmm", "$6.15"));

    public void testThatItReturnsTheCorrectNumberOfViewTypes() {
        MenuContentAdapter adapter = new MenuContentAdapter(getContext(), DEFAULT_ITEMS);
        assertEquals(2, adapter.getViewTypeCount());
    }

    public void testThatHeadersAreType0() {
        MenuContentAdapter adapter = new MenuContentAdapter(getContext(), DEFAULT_ITEMS);
        assertEquals(0, adapter.getItemViewType(HEADER_IN_MENU_ITEMS));
    }

    public void testThatItemsAreType1() {
        MenuContentAdapter adapter = new MenuContentAdapter(getContext(), DEFAULT_ITEMS);
        assertEquals(1, adapter.getItemViewType(ITEM_IN_MENU_ITEMS));
    }

    public void testThatItOnlyInflatesAViewIfTheViewPassedToItIsNotNull() {
        MenuContentAdapter adapter = new MenuContentAdapter(getContext(), DEFAULT_ITEMS);

        View view = new View(getContext());

        assertEquals(view, adapter.getView(0, view, null));
    }

    public void testThatItReturnsAHeaderViewForMenuContentItem() {
        MenuContentAdapter adapter = new MenuContentAdapter(getContext(), DEFAULT_ITEMS);

        View view = adapter.getView(0, null, null);

        assertEquals(R.id.menu_header_view, view.getId());
    }

    public void testThatTheHeaderTitleIsDisplayedOnTheViewReturned() {
        MenuContentAdapter adapter = new MenuContentAdapter(getContext(), DEFAULT_ITEMS);

        View view = adapter.getView(0, null, null);

        assertEquals("Burritos", textByTextViewId(view, R.id.header_title));
    }

    public void testThatTheMenuItemTitleIsDisplayedOnTheViewReturned() {
        MenuContentAdapter adapter = new MenuContentAdapter(getContext(), DEFAULT_ITEMS);

        View view = adapter.getView(1, null, null);

        assertEquals(R.id.menu_item_view, view.getId());
    }

    public void testThatAllTheMenuItemInformationIsDisplayedOnTheViewReturned() {
        MenuContentAdapter adapter = new MenuContentAdapter(getContext(), DEFAULT_ITEMS);

        View view = adapter.getView(1, null, null);

        assertEquals("Brothers Burrito", textByTextViewId(view, R.id.item_title));
        assertEquals("Mmmmm", textByTextViewId(view, R.id.item_description));
        assertEquals("$6.15", textByTextViewId(view, R.id.item_price));
    }

    private static String textByTextViewId(View sourceView, int id) {
        TextView textView = (TextView) sourceView.findViewById(id);
        return textView.getText().toString();
    }

}
