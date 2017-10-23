package com.geely;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewForActivity extends Activity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lv = (ListView) findViewById(R.id.lvListView);
        ArrayList<String> mDatas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mDatas.add("item  " + (i + 1));

        }
        NormalAdapter adapter = new NormalAdapter(this, mDatas);
        lv.setAdapter(adapter);

    }


    public class NormalAdapter extends ArrayAdapter<String> {
        private List<String> mDatas;
        private Context mContext;

        public NormalAdapter(Context context, List<String> objects) {
            super(context, R.layout.item_group, objects);
            mDatas = objects;
            mContext = context;

        }

        @Override
        public View getView(final int position, View convertView,
                            final ViewGroup parent) {
            Log.e("tag", parent.toString());
            final Holder mHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(
                        R.layout.item_group, null);
                mHolder = new Holder();
                mHolder.tvTitle = (TextView) convertView
                        .findViewById(R.id.tvGroupTitle);
                mHolder.edtInput = (EditText) convertView
                        .findViewById(R.id.edtGroupContent);
                mHolder.edtInput2 = (EditText) convertView
                        .findViewById(R.id.edtGroupContent2);
                convertView.setTag(mHolder);
            } else {
                mHolder = (Holder) convertView.getTag();
            }
            //清除焦点
            mHolder.edtInput.clearFocus();
            mHolder.edtInput2.clearFocus();

            //先清除之前的文本改变监听
            if (mHolder.edtInput.getTag() instanceof TextWatcher) {
                mHolder.edtInput.removeTextChangedListener((TextWatcher) (mHolder.edtInput.getTag()));
            }
            if (mHolder.edtInput2.getTag() instanceof TextWatcher) {
                mHolder.edtInput2.removeTextChangedListener((TextWatcher) (mHolder.edtInput2.getTag()));
            }

            //文本改变监听
            final TextWatcher oneNameWatcher = new SimpeTextWather() {
                @Override
                public void afterTextChanged(Editable s) {
                    if (TextUtils.isEmpty(s)) {
                    } else {
                    }
                }
            };
            final TextWatcher oneAgeWatcher = new SimpeTextWather() {
                @Override
                public void afterTextChanged(Editable s) {
                    if (TextUtils.isEmpty(s)) {
                    }
                }
            };
            //吧监听设置到不同的EditText上
            mHolder.edtInput.addTextChangedListener(oneNameWatcher);
            mHolder.edtInput.setTag(oneNameWatcher);

            mHolder.edtInput2.addTextChangedListener(oneAgeWatcher);
            mHolder.edtInput2.setTag(oneAgeWatcher);


            mHolder.tvTitle.setText(mDatas.get(position));
//            mHolder.edtInput.setOnTouchListener(new View.OnTouchListener() {
//
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    ((ViewGroup) v.getParent())
//                            .setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
//                    return false;
//                }
//            });
//
//            mHolder.edtInput2.setOnTouchListener(new View.OnTouchListener() {
//
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    ((ViewGroup) v.getParent())
//                            .setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
//                    return false;
//                }
//            });
//            convertView.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    ((ViewGroup) v)
//                            .setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
//                    Toast.makeText(mContext, "点击了" + mDatas.get(position), Toast.LENGTH_SHORT).show();
//                    return false;
//                }
//            });
            return convertView;
        }

        private final class Holder {
            TextView tvTitle;
            EditText edtInput;
            EditText edtInput2;
        }

    }
    public abstract class SimpeTextWather implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

}
