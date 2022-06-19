package ghaythali1710.e_commerce_store_app;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private CustomAdapter adapter;
    private Context mCtx;

    public HomeFragment(){}

    public HomeFragment(Context context) {
        this.mCtx = context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rvClasses);
        List<ClassObj> list = getClassesList();
        recyclerView.setHasFixedSize(true);
        adapter=new CustomAdapter(list,R.layout.rv_item_design,R.id.name_item,R.id.image_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mCtx,LinearLayoutManager.HORIZONTAL,false));
//        recyclerView.computeVerticalScrollExtent();
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<ClassObj> getClassesList(){
        List<ClassObj> list = new ArrayList<>();
        list.add(new ClassObj("T Shirt",R.drawable.t_shirt));
        list.add(new ClassObj("Shoes",R.drawable.shoes));
        list.add(new ClassObj("Short",R.drawable.short_men));
        list.add(new ClassObj("Jacket",R.drawable.jacket));
        list.add(new ClassObj("Buy Shirt",R.drawable.buy_shirt));
        return list;
    }

}