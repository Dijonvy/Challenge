package com.questions.datastructures;

import android.os.Parcel;
import android.os.Parcelable;

public class Node implements Parcelable {
    public String data;
    public Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    protected Node(Parcel in) {
        data = in.readString();
        next = in.readParcelable(Node.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(data);
        dest.writeParcelable(next, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Node> CREATOR = new Creator<Node>() {
        @Override
        public Node createFromParcel(Parcel in) {
            return new Node(in);
        }

        @Override
        public Node[] newArray(int size) {
            return new Node[size];
        }
    };
}