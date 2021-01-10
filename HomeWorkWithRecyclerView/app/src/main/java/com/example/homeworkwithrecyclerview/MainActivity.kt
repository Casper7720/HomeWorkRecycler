package com.example.homeworkwithrecyclerview


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkwithrecyclerview.info.First1
import com.example.homeworkwithrecyclerview.info.RowType
import com.example.homeworkwithrecyclerview.info.Second1
import com.example.homeworkwithrecyclerview.info.Third1
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var tabLayout: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val firstList2: MutableList<RowType> = mutableListOf()

        for (i in 0..10){
            firstList2.add(First1(i.toString(), i.toString()))
            firstList2.add(Third1(i.toString(), i.toString(), i.toString()))
        }

        val firstList1: MutableList<RowType> = mutableListOf()

        for (i in 0..100) {
            firstList1.add(Second1(i.toString()))
        }



        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        tabLayout = findViewById(R.id.tabLayout)
        tabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> recyclerView.adapter = MyAdapter(firstList1)
                    1 -> recyclerView.adapter = MyAdapter(firstList2)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
            }
        })
        if (savedInstanceState == null) {
            recyclerView.adapter = MyAdapter(firstList1)
        }
        else{

            Log.i("Test", savedInstanceState.get("This").toString())
            if (savedInstanceState.get("This").toString() == "FIRST" ){
                recyclerView.adapter = MyAdapter(firstList1)
            }
            else{
                val tab = tabLayout.getTabAt(1)
                tab!!.select()
                recyclerView.adapter = MyAdapter(firstList2)
            }
        }



    }


    class MyAdapter(
        private var firstValues: MutableList<RowType>,
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), RowType {


        override val FIRST = 0
        override val SECOND = 1
        override val THIRD = 2


        private fun removeItem(position: Int) {
            firstValues.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemCount)
        }


        override fun getItemViewType(position: Int): Int {
            return when {
                firstValues[position] is First1 -> {
                    FIRST
                }
                firstValues[position] is Second1 -> {
                    SECOND
                }
                firstValues[position] is Third1 -> {
                    THIRD
                }
                else -> {
                    -1
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return if (viewType == FIRST) {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.first_type_item, parent, false)
                FirstHolder(view)
            } else (when (viewType) {
                SECOND -> {
                    val view: View = LayoutInflater.from(parent.context)
                        .inflate(R.layout.second_type_item, parent, false)
                    SecondHolder(view)
                }
                THIRD -> {
                    val view: View = LayoutInflater.from(parent.context)
                        .inflate(R.layout.third_type_item, parent, false)
                    ThirdHolder(view)
                }
                else -> {
                    null
                }
            })!!
        }


        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is FirstHolder -> {

                    (holder).textViewTitle?.text =
                        ((firstValues[position] as First1).getTitle() as CharSequence?)
                    (holder).textViewInfo?.text =
                        ((firstValues[position] as First1).getInfo() as CharSequence?)
                    (holder).buttonDel?.setOnClickListener {
                        removeItem(holder.adapterPosition)
                    }
                }
                is SecondHolder -> {

                    (holder).textView?.text =
                        ((firstValues[position] as Second1).getText() as CharSequence?)
                    (holder).buttonDel?.setOnClickListener {
                        removeItem(holder.adapterPosition)
                    }

                }
                is ThirdHolder -> {

                    (holder).title?.text =
                        ((firstValues[position] as Third1).getTitle() as CharSequence?)
                    (holder).secondText?.text =
                        ((firstValues[position] as Third1).getSecondText() as CharSequence?)
                    (holder).support?.text =
                        ((firstValues[position] as Third1).getSupport() as CharSequence?)
                    (holder).buttonDel?.setOnClickListener {
                        removeItem(holder.adapterPosition)
                    }
                }
            }


        }


        override fun getItemCount(): Int {
            return firstValues.size
        }


        class FirstHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var textViewTitle: TextView? = null
            var textViewInfo: TextView? = null
            var buttonDel: Button? = null

            init {
                textViewTitle = itemView.findViewById(R.id.textViewTitle)
                textViewInfo = itemView.findViewById(R.id.textViewInfo)
                buttonDel = itemView.findViewById(R.id.buttonDel)
            }

        }


        class SecondHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var textView: TextView? = null
            var buttonDel: Button? = null

            init {
                textView = itemView.findViewById(R.id.textViewTextTitle)
                buttonDel = itemView.findViewById(R.id.buttonDel)
            }
        }

        class ThirdHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var title: TextView? = null
            var secondText: TextView? = null
            var support: TextView? = null
            var buttonDel: Button? = null

            init {
                title = itemView.findViewById(R.id.textViewTitle)
                secondText = itemView.findViewById(R.id.textViewSecondaryText)
                support = itemView.findViewById(R.id.textViewSupportTxt)
                buttonDel = itemView.findViewById(R.id.buttonDel)
            }

        }


    }

    override fun onSaveInstanceState(outState: Bundle) {

        if (tabLayout.selectedTabPosition == 0){
            outState.putString("This", "FIRST")
        }

        super.onSaveInstanceState(outState)
    }




}

