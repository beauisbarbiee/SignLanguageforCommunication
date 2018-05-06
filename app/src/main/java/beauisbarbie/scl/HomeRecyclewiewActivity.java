package beauisbarbie.scl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import beauisbarbie.scl.adapters.HomeRecycleAdapter;

public class HomeRecyclewiewActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    private List<String> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_recyclewiew);

        setupList();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.HomeRecycleiew);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        HomeRecycleAdapter adapter = new HomeRecycleAdapter(listData,this);
        recyclerView.setAdapter(adapter);

    }

    private void setupList() {

        for(int i = 1;i<=5;i++)
            listData.add("Click me "+i);
    }
}
