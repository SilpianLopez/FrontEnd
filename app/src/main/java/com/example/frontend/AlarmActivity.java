package com.example.frontend;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AlarmActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AlarmAdapter adapter;
    private Button btnSaveAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Toolbar toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        recyclerView = findViewById(R.id.recyclerView);
        btnSaveAlarm = findViewById(R.id.btnSaveAlarm);

        List<AlarmRoom> roomList = new ArrayList<>();
        List<AlarmTask> taskList1 = new ArrayList<>();
        taskList1.add(new AlarmTask("청소 항목1", "알람시간1", true));
        taskList1.add(new AlarmTask("청소 항목2", "알람시간2", true));
        taskList1.add(new AlarmTask("청소 항목3", "알람시간3", true));
        roomList.add(new AlarmRoom("거실", taskList1));

        List<AlarmTask> taskList2 = new ArrayList<>();
        roomList.add(new AlarmRoom("화장실", taskList2));

        adapter = new AlarmAdapter(this, roomList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnSaveAlarm.setOnClickListener(v -> finish());
    }
}
