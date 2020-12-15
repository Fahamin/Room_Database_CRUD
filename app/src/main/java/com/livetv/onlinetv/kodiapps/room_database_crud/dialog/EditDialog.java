package com.livetv.onlinetv.kodiapps.room_database_crud.dialog;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.livetv.onlinetv.kodiapps.room_database_crud.R;
import com.livetv.onlinetv.kodiapps.room_database_crud.database.UserDao;
import com.livetv.onlinetv.kodiapps.room_database_crud.database.UserDatabase;
import com.livetv.onlinetv.kodiapps.room_database_crud.model.User;


public class EditDialog {

    Context context;

    public EditDialog(Context context) {
        this.context = context;
    }

    public void showDialog(final Context activity, int id, String fn, String ln) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.item_download);
        dialog.setCancelable(false);


        EditText fname, lname;
        Button laterBtn, downBtn;

        laterBtn = dialog.findViewById(R.id.alert_LaterBtnId);

        fname = dialog.findViewById(R.id.filrstnameUpdatID);
        lname = dialog.findViewById(R.id.lastnameupdateID);

        fname.setText(fn);
        lname.setText(ln);
        laterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDatabase userDatabase = UserDatabase.getInstance(context);
                UserDao dao = userDatabase.userDao();

                User u = new User();

                String ff = fname.getText().toString();
                String ll = lname.getText().toString();
                u.setId(id);
                u.setFirstName(ff);
                u.setLastName(ll);
                dao.update(u);
                dialog.dismiss();
                Toast.makeText(context, "DONE,,Refresh data ", Toast.LENGTH_SHORT).show();

            }
        });
        dialog.show();
    }

}
