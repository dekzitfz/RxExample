package id.dekz.code.rxexample.act;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.dekz.code.rxexample.R;
import id.dekz.code.rxexample.adapter.ListAdapter;
import rx.Observable;
import rx.Observer;

/**
 * Created by DEKZ on 4/10/2016.
 */
public class Example1 extends AppCompatActivity {

    private ListView lvColor;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_example1);
        lvColor = (ListView) findViewById(R.id.lvColor);

        createObservable();
    }

    @Override
    public void onBackPressed(){
        Example1.this.finish();
    }

    private void createObservable() {
        Observable<List<String>> listObservable = Observable.just(getColorList());
        listObservable.subscribe(new Observer<List<String>>() {
            @Override
            public void onCompleted() {
                Toast.makeText(getApplicationContext(),"COMPLETED",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNext(List<String> strings) {
                listAdapter = new ListAdapter(Example1.this,strings);
                lvColor.setAdapter(listAdapter);
            }
        });
    }

    private List<String> getColorList() {
        List<String> colorList = new ArrayList<>();
        colorList.add("blue");
        colorList.add("green");
        colorList.add("red");
        colorList.add("chartreuse");
        colorList.add("Van Dyke Brown");
        return colorList;
    }
}
