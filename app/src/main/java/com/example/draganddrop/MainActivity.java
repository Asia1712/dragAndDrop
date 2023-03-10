package com.example.draganddrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipDescription;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.DragEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnDragListener {
    private TextView t;
    private ImageView i;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //settaggio dei nostri elementi
        TextView t=(TextView) findViewById(R.id.txt1);
        ImageView i=(ImageView) findViewById(R.id.img);
        Button b=(Button) findViewById(R.id.btndrag);
    }
    private void ImplementaEventi()
    {//implemento i 3 oggetti che possono essere spostati con il cursore se premuto
        t.setOnLongClickListener(this);
        i.setOnLongClickListener(this);
        b.setOnLongClickListener(this);

        //setto i 3 layout in modo che possano contenere i 3 oggetti spostati
        findViewById(R.id.layout1).setOnDragListener(this);
        findViewById(R.id.layout2).setOnDragListener(this);
        findViewById(R.id.layout3).setOnDragListener(this);
    }
    public boolean onLongClick(View v)
    {
        return false;
    }
    public boolean onDrag(View v,DragEvent event)
    {
        int action=event.getAction();
        switch(action)
        {
            case DragEvent.ACTION_DRAG_STARTED:
                if(event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)){
                    return true;
                }else {
                    return false;
                }
        }
        return false;
    }
}