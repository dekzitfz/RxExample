package id.dekz.code.rxexample.act;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.Callable;

import id.dekz.code.rxexample.R;
import id.dekz.code.rxexample.RestClient;
import id.dekz.code.rxexample.adapter.ListAdapter;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DEKZ on 4/10/2016.
 */
public class Example2 extends AppCompatActivity {

    private ListView lvMovie;
    private ProgressBar pb;
    private RestClient restClient;
    private Subscription subscription;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_example2);
        lvMovie = (ListView) findViewById(R.id.lvMovies);
        pb = (ProgressBar) findViewById(R.id.pb);
        restClient = new RestClient(this);

        creeateObservable();
    }

    @Override
    public void onBackPressed(){
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
            Toast.makeText(getApplicationContext(),"unsubscribed",Toast.LENGTH_SHORT).show();
        }
        Example2.this.finish();
    }

    private void creeateObservable() {
        Observable<List<String>> listObservable = Observable.fromCallable(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                return restClient.getFavoriteTvShows();
            }
        });

        subscription = listObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<String> strings) {
                        listAdapter = new ListAdapter(Example2.this,strings);
                        lvMovie.setAdapter(listAdapter);
                        pb.setVisibility(View.GONE);
                    }
                });
    }
}
