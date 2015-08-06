package demo.test.hr.com.myapplicationtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import demo.test.hr.com.myapplicationtest.R;

/**
 * Created by winterfell on 8/6/2015.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private String[] groupsStrings;// = new String[] { "这里是group 0",
    // "这里是group 1", "这里是group 2" };
    private String[][] groupItems;
    private Context context;

    public ExpandableListAdapter(Context context)
    {
        this.context = context;
        groupsStrings = new String[8];
        for (int i = 0; i < groupsStrings.length; i++)
        {
            groupsStrings[i] = new String("这里是group " + i);
        }
        groupItems = new String[8][8];
        for (int i = 0; i < groupItems.length; i++)
            for (int j = 0; j < groupItems[i].length; j++)
            {
                groupItems[i][j] = new String("这里是group " + i + "里的item " + j);
            }
    }

    @Override
    public int getGroupCount()
    {
        return groupsStrings.length;
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        return groupItems[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return groupsStrings[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        return groupItems[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    @Override
    public boolean hasStableIds()
    {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_layout, null);
        TextView tv = (TextView) view.findViewById(R.id.name_tv);
        tv.setText(groupsStrings[groupPosition]);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_layout, null);
        TextView tv = (TextView) view.findViewById(R.id.name_tv);
        tv.setText(groupItems[groupPosition][childPosition]);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }

}
