package demo.test.hr.com.myapplicationtest.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import demo.test.hr.com.myapplicationtest.R;


public class MyCommentAllAdapter extends BaseAdapter {
	private Context _context = null;
	private LayoutInflater _inflater = null;
	private List<Map<String, Object>> _listdata = null;
	private Intent _intent = null;
	private Handler _handler = null;
	private ScrollToLastCallBack mScrollToLastCallBack=null;
	private ListView _listView = null;


	public MyCommentAllAdapter(){

	}

//	

	public MyCommentAllAdapter(Context context, List<Map<String, Object>> listdata,Handler handler,ListView listView,ScrollToLastCallBack scrollToLastCallBack) {
		this._context = context;
		this._inflater = LayoutInflater.from(context);
		this._listdata = listdata;
		this._handler = handler;
		this.mScrollToLastCallBack = scrollToLastCallBack;
		this._listView = listView;

		Log.i("MyCommentAllAdapter", "success");
	}




	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return _listdata==null?0:_listdata.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return _listdata.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public class ViewHolder{
		LinearLayout listlayout;
		TextView listitemname ;
		TextView listitemChlName ;
		TextView listitemUserNname ;
		TextView listitemContent ;
		TextView listitemTime ;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		final Map<String, Object> map = (Map<String, Object>)getItem(position);
		ViewHolder viewHolder = null;
		if(convertView==null) {
			convertView = _inflater.inflate(R.layout.comment_all_listview_item, null);

			viewHolder = new ViewHolder();

			viewHolder.listlayout = (LinearLayout)convertView.findViewById(R.id.comment_all_layout);
			viewHolder.listitemname = (TextView)convertView.findViewById(R.id.comment_name);
			viewHolder.listitemChlName = (TextView)convertView.findViewById(R.id.comment_chl_name);
			viewHolder.listitemUserNname = (TextView)convertView.findViewById(R.id.comment_user_name);
			viewHolder.listitemContent = (TextView)convertView.findViewById(R.id.comment_detail_content);
			viewHolder.listitemTime = (TextView)convertView.findViewById(R.id.comment_detail_time);

			convertView.setTag(viewHolder);
		}
		else {
			viewHolder = (ViewHolder)convertView.getTag();
		}

		Log.i("getView", "get");

		viewHolder.listitemname.setText((CharSequence) "#"+map.get("listitemName").toString()+"#");
		viewHolder.listitemChlName.setText((CharSequence) map.get("listitemChlName"));
		viewHolder.listitemUserNname.setText((CharSequence) map.get("listitemUserName"));
		viewHolder.listitemContent.setText((CharSequence) "\t\t"+map.get("listitemContent").toString());

		String dateStr = map.get("listitemComTime").toString().substring(4, 6) + "月" + map.get("listitemComTime").toString().substring(6, 8) + "日"+map.get("listitemComTime").toString().substring(8, 10)+"时"+map.get("listitemComTime").toString().substring(10, 12)+"分";

		viewHolder.listitemTime.setText((CharSequence) dateStr);

		viewHolder.listlayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub


			}
		});

		Log.i("listitemname", map.get("listitemName").toString());

		//判断当前列表所在位置，当到最后两项时就加载
		int end=_listView.getLastVisiblePosition();
		if(getCount()-2<=end&&end<=getCount())
		{
			mScrollToLastCallBack.onScrollToLast(position);
		}

		return convertView;
	}

	public interface ScrollToLastCallBack
	{
		public void onScrollToLast(Integer pos);
	}


}
