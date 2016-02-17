package com.example.weixin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnPageChangeListener {
private ViewPager myViewPager;
private String[] mTitles={"微信首页","微信通讯录","微信发现 ","微信我"};
private List<ExchangeColorView> mTabIndicator=new ArrayList<ExchangeColorView>();
private Fragment fragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		
		myViewPager=(ViewPager) findViewById(R.id.id_viewpager);
		NavFragmentAdapter adapter=new 	NavFragmentAdapter(getSupportFragmentManager())	;
		myViewPager.setAdapter(adapter);
		myViewPager.setOnPageChangeListener(this);
	}
	private void init(){
		
		
		

		ExchangeColorView one=(ExchangeColorView) findViewById(R.id.id_indicator_one);
		ExchangeColorView two=(ExchangeColorView) findViewById(R.id.id_indicator_two);
		ExchangeColorView three=(ExchangeColorView) findViewById(R.id.id_indicator_three);
		ExchangeColorView four=(ExchangeColorView) findViewById(R.id.id_indicator_four);

		mTabIndicator.add(one);
		mTabIndicator.add(two);
		mTabIndicator.add(three);
		mTabIndicator.add(four);
		one.setIconAlpha(1.0f);
	
	}
	
	
class  NavFragmentAdapter extends FragmentPagerAdapter{

	public NavFragmentAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		
		Log.v("ew", ""+arg0);
	switch (arg0) {
	case 0:
		TabFragment f=new TabFragment();
		Bundle bundle=new Bundle();
		bundle.putString("title", mTitles[arg0]);
		f.setArguments(bundle);
		fragment=f;
		break;
case 1:
	TabFragment2 f2=new TabFragment2();
	Bundle bundle1=new Bundle();
	bundle1.putString("title", mTitles[arg0]);
	f2.setArguments(bundle1);
	fragment=f2;
		
		break;
case 2:
	TabFragment3 f3=new TabFragment3();
	Bundle bundle2=new Bundle();
	bundle2.putString("title", mTitles[arg0]);
	f3.setArguments(bundle2);
	fragment=f3;
	
	break;
case 3:
	TabFragment4 f4=new TabFragment4();
	Bundle bundle3=new Bundle();
	bundle3.putString("title", mTitles[arg0]);
	f4.setArguments(bundle3);
	fragment=f4;
	
	break;

	default:
		break;
	}
		
		
	
		
		
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mTitles.length;
	}



	
}


@Override
public void onPageScrollStateChanged(int arg0) {
	// TODO Auto-generated method stub
	
}
/**
 * positionOffset是划出去的偏移量
 */
@Override
public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
	// TODO Auto-generated method stub
	//监听滑动过程-->自定义控件 的颜色的透明度  
	Log.v("偏移量", ""+positionOffset);
	if(positionOffset>0){
		
		ExchangeColorView left=mTabIndicator.get(position);
		ExchangeColorView right=mTabIndicator.get(position+1);
		left.setIconAlpha(1-positionOffset);
		right.setIconAlpha(positionOffset);
		Log.v("position", ""+position);
		
	}
	
	
}

@Override
public void onPageSelected(int arg0) {
	// TODO Auto-generated method stub
	//已经选中的状态
	
}


}
