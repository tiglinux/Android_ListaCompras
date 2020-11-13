/*
        Created by : Tiago Ribeiro Santos
        email : tiago.programador@hotmail.com

 */

package com.tiagoribeirosantos.listadecompras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TextView footer;
    private Spinner spinner;
    private EditText editText;
    private CheckBox checkbox;
    private Button addProduto;

    private ArrayList<Produto> produtos;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        footer = (TextView) findViewById(R.id.footer);
        spinner = (Spinner) findViewById(R.id.spinner);
        editText = (EditText) findViewById(R.id.editText);
        checkbox = (CheckBox) findViewById(R.id.checkbox);

        produtos = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, produtos);
        listView.setAdapter(arrayAdapter);

        AdapterView.OnItemLongClickListener itemClickListener = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int localPosition = position;

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Remover Produto da Lista")
                        .setMessage("Você realmente deseja remover o produto selecionado da lista?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                produtos.remove(localPosition);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show();
                return true;
            }
        };
        listView.setOnItemLongClickListener(itemClickListener);
    }

    public void addProduto(View view){
        String item = String.valueOf(spinner.getSelectedItem());
        boolean checked = checkbox.isChecked();
        float preco = Float.parseFloat(editText.getText().toString());

        Produto produto  = new Produto(preco,item,checked);
        produtos.add(produto);  //Add the new product
        arrayAdapter.notifyDataSetChanged();
    }


}