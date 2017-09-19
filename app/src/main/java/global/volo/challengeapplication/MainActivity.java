package global.volo.challengeapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AddPersonDialogFragment.AddPersonListener {

    private List<Person> mPeople = new ArrayList<>();
    private RecyclerView mRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder().create();

        mRecycler = (RecyclerView) findViewById(R.id.main_recycler);
        if (mRecycler != null) {
            mRecycler.setLayoutManager(new LinearLayoutManager(this));

            mPeople = gson.fromJson(JsonSimulator.getJson(), new TypeToken<List<Person>>(){}.getType());
            if (mPeople == null) {
                return;
            }

            mRecycler.setAdapter(new PersonListAdapter(this, mPeople));
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.main_fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showNoticeDialog();
                }
            });
        }
    }

    public void showNoticeDialog() {
        DialogFragment dialog = new AddPersonDialogFragment();
        dialog.show(getSupportFragmentManager(), "AddPersonDialogFragment");
    }

    @Override
    public void onAddPerson(Person person) {
        mPeople.add(person);
        mRecycler.getAdapter().notifyItemInserted(mPeople.size() - 1);
    }
}
