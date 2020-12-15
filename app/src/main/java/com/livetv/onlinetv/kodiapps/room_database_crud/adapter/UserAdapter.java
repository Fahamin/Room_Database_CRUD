package com.livetv.onlinetv.kodiapps.room_database_crud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.livetv.onlinetv.kodiapps.room_database_crud.R;
import com.livetv.onlinetv.kodiapps.room_database_crud.database.UserDao;
import com.livetv.onlinetv.kodiapps.room_database_crud.database.UserDatabase;
import com.livetv.onlinetv.kodiapps.room_database_crud.dialog.EditDialog;
import com.livetv.onlinetv.kodiapps.room_database_crud.model.User;

import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.homeHolder> {

    Context context;
    List<User> buildList, searchList;
    RecyclerView recyclerView;


    public UserAdapter(Context context, List<User> buildList, RecyclerView recyclerView) {
        this.context = context;
        this.buildList = buildList;
        this.searchList = buildList;
        this.recyclerView = recyclerView;

    }

    @NonNull
    @Override
    public homeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.example_item, null, false);
        return new homeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final homeHolder homeHolder, final int i) {

        UserDatabase userDatabase = UserDatabase.getInstance(context);
        UserDao dao = userDatabase.userDao();

        final User user = buildList.get(i);

        homeHolder.fname.setText(user.getFirstName());
        homeHolder.lname.setText(user.getLastName());

        homeHolder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditDialog dialog = new EditDialog(context);
                dialog.showDialog(context,user.getId(),user.getFirstName(),user.getLastName());

            }
        });

        homeHolder.delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.delete(user);
                Toast.makeText(context, "DONE,,Refresh data ", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public int getItemCount() {
        return buildList.size();
    }

    public class homeHolder extends RecyclerView.ViewHolder {

        TextView fname, lname;
        ImageView edit, delet;


        public homeHolder(@NonNull View itemView) {
            super(itemView);
            delet = itemView.findViewById(R.id.delet_view);
            edit = itemView.findViewById(R.id.edit_view);
            fname = itemView.findViewById(R.id.firstTxtID);
            lname = itemView.findViewById(R.id.lastTxtid);

        }
    }

}
