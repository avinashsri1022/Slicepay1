package com.example.avina.slicepay;


import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentContact extends Fragment {

    private ListView listView;
    private Cursor cursor;
    ArrayList<String> Contacts;
    ArrayAdapter<String> arrayAdapter ;
    String name, phonenumber;
    public  static final int RequestPermissionCode  = 1 ;

    public FragmentContact() {
        // Required empty public constructor
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contact, container, false);
        dothis(v);
        return v;
   }

   public void dothis(View v){
       listView = (ListView)v.findViewById(R.id.list);
       Contacts = new ArrayList<>();
       GetContacts();
       arrayAdapter = new ArrayAdapter<String>(getActivity(),R.layout.contactlist,R.id.textView,Contacts);
       listView.setAdapter(arrayAdapter);
   }

   public void GetContacts(){
       cursor = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);

       while (cursor.moveToNext()) {

           name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

           phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

           Contacts.add(name + " " + "\n " + "   " + phonenumber);
       }

       cursor.close();
   }

}
