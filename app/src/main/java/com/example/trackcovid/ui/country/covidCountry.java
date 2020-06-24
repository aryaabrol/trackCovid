package com.example.trackcovid.ui.country;
import android.os.Parcel;
import android.os.Parcelable;

public class covidCountry implements Parcelable {
    String country,cases,todayCases,deaths,todayDeaths,recovered,critical;

    public covidCountry(String dataString, String cases, String todayCases, String deaths, String todayDeaths, String recovered, String string, String country) {
        this.country = country;
        this.cases = this.cases;
        this.todayCases = this.todayCases;
        this.deaths = this.deaths;
        this.todayDeaths = this.todayDeaths;
        this.recovered = this.recovered;
        this.critical = critical;
    }

    protected covidCountry(Parcel in) {
        country = in.readString();
        cases = in.readString();
        todayCases = in.readString();
        deaths = in.readString();
        todayDeaths = in.readString();
        recovered = in.readString();
        critical = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(country);
        dest.writeString(cases);
        dest.writeString(todayCases);
        dest.writeString(deaths);
        dest.writeString(todayDeaths);
        dest.writeString(recovered);
        dest.writeString(critical);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<covidCountry> CREATOR = new Creator<covidCountry>() {
        @Override
        public covidCountry createFromParcel(Parcel in) {
            return new covidCountry(in);
        }

        @Override
        public covidCountry[] newArray(int size) {
            return new covidCountry[size];
        }
    };

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getCritical() {
        return critical;
    }

    public String getCountry() {
        return country;
    }

    public String getCases() {
        return cases;
    }
}
