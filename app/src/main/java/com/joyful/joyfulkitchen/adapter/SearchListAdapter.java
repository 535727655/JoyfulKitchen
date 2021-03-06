package com.joyful.joyfulkitchen.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.joyful.joyfulkitchen.R;
import com.joyful.joyfulkitchen.model.SearchMeauList;

import java.util.List;


/**
 * 根据 name lai
 */
public class SearchListAdapter extends BaseAdapter {
	private List<SearchMeauList> data;
	private Context context;
	private LayoutInflater inflater;


	public SearchListAdapter(Context context, List<SearchMeauList> data) {
		this.context = context;
		this.data = data;
		this.inflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}


	static class ViewHolder{

		public SimpleDraweeView albums; // 菜图片

		private TextView title,tags; // 菜名 和 tags
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder item;
		if(convertView == null){
			item = new ViewHolder();
			convertView = inflater.inflate(R.layout.search_list_item, null);
			item.albums = (SimpleDraweeView) convertView.findViewById(R.id.albums);
			item.title = (TextView) convertView.findViewById(R.id.title);
			item.tags = (TextView) convertView.findViewById(R.id.tags);

			convertView.setTag(item);
		}else{
			item = (ViewHolder) convertView.getTag();
		}

		item.title.setText(data.get(position).getTitle());

		item.tags.setText(data.get(position).getTags().replaceAll(";","、"));

		// 菜图片处理.....
		String imgUrl = data.get(position).getAlbums().get(0);

		Uri uri = Uri.parse(imgUrl);
		item.albums.setImageURI(uri);

		return convertView;
	}


}
