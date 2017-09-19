package global.volo.challengeapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by artashes on 9/19/17.
 */

public class PersonListAdapter  extends RecyclerView.Adapter<PersonListAdapter.ViewHolder> {

    private List<Person> mPeople;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView fullName;

        public ViewHolder(View v) {
            super(v);
            fullName = (TextView) v.findViewById(R.id.item_person_list_fullname);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }

    public PersonListAdapter(Context context, List<Person> people) {
        mContext = context;
        mPeople = people;
    }

    @Override
    public PersonListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person_list, parent, false);

        PersonListAdapter.ViewHolder vh = new PersonListAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(PersonListAdapter.ViewHolder holder, int position) {

        Person person = mPeople.get(position);
        if (person == null) {
            return;
        }

        String fullName = String.format(mContext.getString(R.string.person_fullname_template),
                                        person.getLastName(),
                                        person.getFirstName());

        holder.fullName.setText(fullName);
    }

    @Override
    public int getItemCount() {
        return mPeople.size();
    }
}