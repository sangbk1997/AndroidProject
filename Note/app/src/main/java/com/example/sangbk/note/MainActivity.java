package com.example.sangbk.note;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private static final int MENU_ITEM_VIEW=111;
    private static final int MENU_ITEM_EDIT=222;
    private static final int MENU_ITEM_CREATE=333;
    private static final int MENU_ITEM_DELETE=444;

    private static final int MY_REQUEST_CODE=1000;
    private final List<note>noteList=new ArrayList<note>();
    private ArrayAdapter<note> listViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get listView object from xml
        listView=(ListView)findViewById(R.id.list);
        MyDatabaseHelper db=new MyDatabaseHelper(this);
        db.CreateDefaultNotesNeed();
        List<note> list=db.getAllNotes();
        this.noteList.addAll(list);
        // Định nghĩa một Adapter
        // 1 _ content
        // 2_ Layout cho các dòng
        // 3_ ID của TextView mà dữ liệu sẽ được ghi vào
        // 4_ Danh sách dữ liệu
        this.listViewAdapter=new ArrayAdapter<note>(this,android.R.layout.simple_list_item_1,this.noteList);
        // Đăng ký Adapter cho ListView
        this.listView.setAdapter(this.listViewAdapter);
        // dang ký context menu cho listview
        registerForContextMenu(this.listView);

    }
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuinfo){
        super.onCreateContextMenu(menu,view,menuinfo);
        menu.setHeaderTitle("Select The Action");
        // groupId, itemId, order, title
        menu.add(0,MENU_ITEM_VIEW,0,"View Note");
        menu.add(0,MENU_ITEM_CREATE,0,"Create Note");
        menu.add(0,MENU_ITEM_EDIT,0,"Edit Note");
        menu.add(0,MENU_ITEM_DELETE,0,"Delete Note");

    }
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo
                info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        final note selectedNote = (note) this.listView.getItemAtPosition(info.position);

        if(item.getItemId() == MENU_ITEM_VIEW){
            Toast.makeText(getApplicationContext(),selectedNote.getNoteContent(),Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId() == MENU_ITEM_CREATE){
            Intent intent = new Intent(this, AddEditNoteActivity.class);

            // Start AddEditNoteActivity, có phản hồi.
            this.startActivityForResult(intent, MY_REQUEST_CODE);
        }
        else if(item.getItemId() == MENU_ITEM_EDIT ){
            Intent intent = new Intent(this, AddEditNoteActivity.class);
            intent.putExtra("note", selectedNote);

            // Start AddEditNoteActivity, có phản hồi.
            this.startActivityForResult(intent,MY_REQUEST_CODE);
        }
        else if(item.getItemId() == MENU_ITEM_DELETE){
            // Hỏi trước khi xóa.
            new AlertDialog.Builder(this)
                    .setMessage(selectedNote.getNoteTitle()+". Are you sure you want to delete?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            deleteNote(selectedNote);
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }
        else {
            return false;
        }
        return true;
    }

    // Người dùng đồng ý xóa một Note.
    private void deleteNote(note note)  {
        MyDatabaseHelper db = new MyDatabaseHelper(this);
        db.deleteNote(note);
        this.noteList.remove(note);
        // Refresh ListView.
        this.listViewAdapter.notifyDataSetChanged();
    }


    // Khi AddEditNoteActivity hoàn thành, nó gửi phản hồi lại.
    // (Nếu bạn đã start nó bằng cách sử dụng startActivityForResult()  )
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == MY_REQUEST_CODE ) {
            boolean needRefresh = data.getBooleanExtra("needRefresh",true);
            // Refresh ListView
            if(needRefresh) {
                this.noteList.clear();
                MyDatabaseHelper db = new MyDatabaseHelper(this);
                List<note> list=  db.getAllNotes();
                this.noteList.addAll(list);
                // Thông báo dữ liệu thay đổi (Để refresh ListView).
                this.listViewAdapter.notifyDataSetChanged();
            }
        }
    }
}
