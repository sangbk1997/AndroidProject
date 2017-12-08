package com.example.sangbk.fragmentdemo;

//import android.app.Fragment;

//import android.app.Fragment;
//import android.content.Context;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//
///**
// * Created by Sangbk on 10/13/2017.
// */
//

//
//    private EditText name;
//    private EditText age;
//    private Button apply;
//    private MainActivity mainActivity;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        View view=inflater.inflate(R.layout.topfragment,container,false);
//        name=(EditText)view.findViewById(R.id.editText1);
//        age=(EditText)view.findViewById(R.id.editText2);
//        apply=(Button)view.findViewById(R.id.button);
//        apply.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                applyText();
//            }
//        });
//        return view;
//    }
//    // phuong thuc nay duoc goi sau khi fragment duoc ghep vao activity
//
//    @Override
//    public void onAttachFragment(Fragment childFragment) {
//        super.onAttachFragment(childFragment);
//    }
//
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof MainActivity) {
//            this.mainActivity = (MainActivity) context;
//        }
//    }
//    private void applyText(){
//        String topText=name.getText().toString();
//        String bottomText=age.getText().toString();
//        mainActivity.showText(topText,bottomText);
//    }
//}


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TopFagment extends Fragment {

    private EditText inputTopImageText;
    private EditText inputBottomImageText;

    private MainActivity mainActivity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Đọc file xml tạo ra đối tượng View.

        // inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot)
        View view = inflater.inflate(R.layout.topfragment, container, false);

        inputTopImageText = (EditText) view.findViewById(R.id.editText1);
        inputBottomImageText = (EditText) view.findViewById(R.id.editText2);

        Button applyButton = (Button) view.findViewById(R.id.button);

        applyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                applyText();
            }
        });

        return view;
    }


    //  Phương thức này được gọi sau khi Fragment được ghép vào Activity.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof MainActivity) {
            this.mainActivity = (MainActivity) context;
        }
    }


    private void applyText() {
        String topText = this.inputTopImageText.getText().toString();
        String bottomText = this.inputBottomImageText.getText().toString();

        this.mainActivity.showText(topText, bottomText);
    }
}