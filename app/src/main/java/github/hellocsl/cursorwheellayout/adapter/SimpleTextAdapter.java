package github.hellocsl.cursorwheellayout.adapter;

import android.content.Context;
import androidx.core.app.ActivityCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;
import github.hellocsl.cursorwheellayout.R;
import github.hellocsl.cursorwheellayout.data.MenuItemData;

/**
 * Created by chensuilun on 16/4/24.
 */
public class SimpleTextAdapter extends CursorWheelLayout.CycleWheelAdapter {
    private List<MenuItemData> mMenuItemDatas;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    public static final int INDEX_SPEC = 9;
    private int mGravity;

    public SimpleTextAdapter(Context context, List<MenuItemData> menuItemDatas) {
        this(context, menuItemDatas, Gravity.CENTER);
    }

    public SimpleTextAdapter(Context context, List<MenuItemData> menuItemDatas, int gravity) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mMenuItemDatas = menuItemDatas;
        mGravity = gravity;
    }

    @Override
    public int getCount() {
        return mMenuItemDatas == null ? 0 : mMenuItemDatas.size();
    }

    @Override
    public View getView(View parent, int position) {
        MenuItemData item = getItem(position);
        View root = mLayoutInflater.inflate(R.layout.wheel_menu_item, null, false);
        TextView textView = root.findViewById(R.id.wheel_menu_item_tv);
        textView.setVisibility(View.VISIBLE);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        textView.setText(item.mTitle);
        if (textView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) textView.getLayoutParams()).gravity = mGravity;
        }
        if (position == INDEX_SPEC) {
            textView.setTextColor(ActivityCompat.getColor(mContext, R.color.red));
        }
        return root;
    }

    @Override
    public MenuItemData getItem(int position) {
        return mMenuItemDatas.get(position);
    }

    @Override
    public int getColor(int position, int selected) {
        switch (position) {
            case 0: return 0xff000000;
            case 1: return 0xffffffff;
        }
        return 0;
    }
}
