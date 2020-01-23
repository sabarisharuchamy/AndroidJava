package com.appin.javaexamples;

import android.os.Parcel;
import android.os.Parcelable;

public class Patient implements Parcelable {
    private int registerId;
    private String patientName,patientDisease;
public Patient(Parcel in){
    this.registerId = in.readInt();
    this.patientName = in.readString();
    this.patientDisease = in.readString();
}
    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientDisease() {
        return patientDisease;
    }

    public void setPatientDisease(String patientDisease) {
        this.patientDisease = patientDisease;
    }

    public Patient(int registerId, String patientName, String patientDisease) {
        this.registerId = registerId;
        this.patientName = patientName;
        this.patientDisease = patientDisease;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
parcel.writeInt(this.registerId);
parcel.writeString(this.patientName);
parcel.writeString(this.patientDisease);
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        @Override
        public Patient createFromParcel(Parcel parcel) {
            return new Patient(parcel);
        }

        @Override
        public Patient[] newArray(int i) {
            return new Patient[i];
        }
    };
}
