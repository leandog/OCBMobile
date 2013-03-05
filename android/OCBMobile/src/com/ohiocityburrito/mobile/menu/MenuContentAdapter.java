package com.ohiocityburrito.mobile.menu;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ohiocityburrito.mobile.R;

public class MenuContentAdapter extends ArrayAdapter<MenuContentItem> {

	public MenuContentAdapter(Context context, List<MenuContentItem> items) {
		super(context, 0, items);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = inflateView(getItemViewLayoutResourceId(position));
		}

		populateViewWithItemData(position, convertView);

		return convertView;
	}

	
	@Override
	public int getViewTypeCount() {
		return 2;
	}
	
	private void populateViewWithItemData(int position, View convertView) {
		if (convertView.getId() == R.id.menu_header_view) {
			setText(convertView, R.id.header_title, getItem(position)
					.getTitle());
		} else if (convertView.getId() == R.id.menu_item_view) {
			MenuContentItem item = getItem(position);
			setText(convertView, R.id.item_title, item.getTitle());
			setText(convertView, R.id.item_description, item.getDescription());
			setText(convertView, R.id.item_price, item.getPrice());
		}
	}

	@Override
	public int getItemViewType(int position) {
		MenuContentItem item = getItem(position);
		return item.isHeader() ? 0 : 1;
	}
	
	public int getItemViewLayoutResourceId(int position) {
		MenuContentItem item = getItem(position);
		return item.isHeader() ? R.layout.menu_item_header
				: R.layout.menu_item_layout;
	}

	private View inflateView(int view_id) {
		LayoutInflater layoutInflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		return layoutInflater.inflate(view_id, null);
	}

	private void setText(View parent, int view_id, String text) {
		TextView textView = (TextView) parent.findViewById(view_id);
		textView.setText(text);
	}

}
