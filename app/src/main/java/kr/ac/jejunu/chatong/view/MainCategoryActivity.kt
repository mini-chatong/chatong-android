package kr.ac.jejunu.chatong.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
//import com.afollestad.materialdialogs.MaterialDialog
//import com.afollestad.materialdialogs.customview.customView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_category_main.*
import kr.ac.jejunu.chatong.R
import kr.ac.jejunu.chatong.adapter.CateAdapter
import kr.ac.jejunu.chatong.data.MainCateData
//import kr.ac.jejunu.chatong.databinding.ActivityCategoryMainBinding

class MainCategoryActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_main)

        setSupportActionBar(materialToolbar)

        val cateList = urlList()
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainCategoryActivity)
            adapter = CateAdapter(cateList)
            (adapter as CateAdapter).itemClick = object : CateAdapter.ItemClick {
                override fun onClick(view: View, position: Int) {
                    when (position) {
                        in 0..2 ->
                            MaterialAlertDialogBuilder(this@MainCategoryActivity).apply {
                                val dialogView = this@MainCategoryActivity.layoutInflater.inflate(
                                    R.layout.new_dialog,
                                    null
                                )
                            }.create().show()

                        3 ->
                            MaterialAlertDialogBuilder(this@MainCategoryActivity).apply {
                                val dialogView = this@MainCategoryActivity.layoutInflater.inflate(
                                    R.layout.back_shoes_dialog,
                                    null
                                )
                                setView(dialogView)
                                scrollToPosition(position)
                            }.create().show()
                        4 ->
                            MaterialAlertDialogBuilder(this@MainCategoryActivity).apply {
                                val dialogView = this@MainCategoryActivity.layoutInflater.inflate(
                                    R.layout.acc_dialog,
                                    null
                                )
                                setView(dialogView)
                            }.create().show()
                        5 ->
                            MaterialAlertDialogBuilder(this@MainCategoryActivity).apply {
                                val dialogView = this@MainCategoryActivity.layoutInflater.inflate(
                                    R.layout.sale_dialog,
                                    null
                                )
                                setView(dialogView)
                            }.create().show()
                    }

                    scrollToPosition(position)
                }
            }
        }


    }

    private fun urlList(): ArrayList<MainCateData> {
        val cateList = arrayListOf<MainCateData>(
            MainCateData(
                "https://raw.githubusercontent.com/soohyeon13/database/master/chatong/new/NEW.JPG",
                "NEW"
            ),
            MainCateData(
                "https://raw.githubusercontent.com/soohyeon13/database/master/chatong/new/MAN.JPG",
                "MAN"
            ),
            MainCateData(
                "https://raw.githubusercontent.com/soohyeon13/database/master/chatong/new/WOMAN.JPG",
                "WOMAN"
            ),
            MainCateData(
                "https://raw.githubusercontent.com/soohyeon13/database/master/chatong/new/BG.JPG",
                "BAG & SHOES"
            ),
            MainCateData(
                "https://raw.githubusercontent.com/soohyeon13/database/master/chatong/new/ACC.JPG",
                "ACC"
            ),
            MainCateData(
                "https://raw.githubusercontent.com/soohyeon13/database/master/chatong/new/SALE.JPG",
                "SALE"
            ),
            MainCateData(
                "https://raw.githubusercontent.com/soohyeon13/database/master/chatong/new/LIKE.JPG",
                "LIKE"
            )
        )
        return cateList
    }
}
