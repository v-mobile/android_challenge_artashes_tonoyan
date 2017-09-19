
package global.volo.challengeapplication;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Person implements Parcelable {

    @SerializedName("first_name")
    private String mFirstName;
    @SerializedName("last_name")
    private String mLastName;

    public Person() {
    }

    public Person(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mFirstName);
        dest.writeString(this.mLastName);
    }

    protected Person(Parcel in) {
        this.mFirstName = in.readString();
        this.mLastName = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
