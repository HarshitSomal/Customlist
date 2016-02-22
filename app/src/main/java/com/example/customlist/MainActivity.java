package com.example.customlist;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.listView);
        list.setAdapter(new MyAdapter(this));
   
    }}
    class Items
    {
    	String titles;
    	String description;
    	int images;
    	
    	Items(String titles,String description,int images){
    		this.titles=titles;
    		this.description=description ;
    		this.images=images;
    		
    	}
    }
class MyAdapter extends BaseAdapter{
ArrayList<Items> mylist;
Context context;
MyAdapter(Context c){
	context=c;
	mylist=new ArrayList<Items>();
	Resources res=c.getResources();
	String[] titles=res.getStringArray(R.array.titles);
	String[] descripation=res.getStringArray(R.array.description);
	int images[]={R.drawable.images1,R.drawable.images2,R.drawable.images3,R.drawable.images4,R.drawable.images5};
for(int i=0;i<5;i++)
{
	mylist.add(new Items(titles[i],descripation[i],images[i]));
}

}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mylist.size();
	}

	@Override
	public Object getItem(int i) {
		// TODO Auto-generated method stub
		return mylist.get(i);
	}

	@Override
	public long getItemId(int i) {
		// TODO Auto-generated method stub
		return i;
	}

	@Override
	public View getView(int i,View view, ViewGroup viewGroup) {
	LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	View row=inflater.inflate(R.layout.items,viewGroup,false);
	
	TextView title=(TextView)row.findViewById(R.id.text1);
	TextView description1=(TextView)row.findViewById(R.id.text2);
	ImageView images1=(ImageView)row.findViewById(R.id.imageView1);
	 
    Items temp=mylist.get(i);
  
	title.setText(temp.titles);
	description1.setText(temp.description);
	images1.setImageResource(temp.images);
	
	
	
	return row;
	}
	
}



