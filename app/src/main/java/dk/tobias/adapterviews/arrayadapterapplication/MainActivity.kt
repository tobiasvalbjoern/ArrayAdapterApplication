package dk.tobias.adapterviews.arrayadapterapplication

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animals:Array<String> = resources.getStringArray(R.array.animals)
        val adapter= ArrayAdapter(this,R.layout.list_item,animals)
        main_list_view.adapter=adapter

        //on click listener for spinner
        main_list_view?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?,
                                        pos: Int, id: Long) {
                val text:String=adapterView?.getItemAtPosition(pos) as String
                Toast.makeText(this@MainActivity,text,Toast.LENGTH_SHORT).show()
            }

        }

        //This listener works for both gridView and ListView, but not for spinner
        //main_list_view.setOnItemClickListener { adapterView: AdapterView<*>?,
           //                                     view: View?, pos: Int, id: Long ->
            //val text: String=adapterView?.getItemAtPosition(pos) as String
            //Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
        //}
    }
}
