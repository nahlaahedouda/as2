package com.example.as2

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.as2.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*


class MainActivity : AppCompatActivity() {
    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    val C=Calendar.getInstance()
    var hour: Int = C.get(Calendar.HOUR_OF_DAY)
    var minute: Int = C.get(Calendar.MINUTE)
    var second: Int = C.get(Calendar.SECOND)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        val db=Firebase.firestore
        setContentView(binding.root)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        screenTrack("Home screen");
        binding.stduy.setOnClickListener {
            val intent=Intent(this,studyActivity::class.java)
           startActivity(intent)
            btnEvent("stduy@123", "stduy screen", "Button")

        }

        binding.cook.setOnClickListener {
            val intent=Intent(this,cookActivity::class.java)
            startActivity(intent)
            btnEvent("cook@123", "cook screen", "Button")
        }

        binding.java.setOnClickListener {
            val intent=Intent(this,javaActivity::class.java)
            startActivity(intent)
            btnEvent("java@123", "java screen", "Button")

        }




    }
    fun btnEvent(id: String?, name: String?, contentType: String?) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id)
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name)
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType)
        mFirebaseAnalytics!!.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }
    fun screenTrack(name: String?) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, name)
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "Main Activity")
        mFirebaseAnalytics!!.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle)
    }

    override fun onPause() {
        val c = Calendar.getInstance()
        val hour2 = c[Calendar.HOUR_OF_DAY]
        val minute2 = c[Calendar.MINUTE]
        val second2 = c[Calendar.SECOND]
        val h = hour2 - hour
        val m = minute2 - minute
        val s = second2 - second
        Log.e("hour", h.toString())
        Log.e("minute", m.toString())
        Log.e("second", s.toString())
        val db = FirebaseFirestore.getInstance()
        val users: HashMap<String, Any> = HashMap()
        users["hours"] = h
        users["minute"] = m
        users["second"] = s
        users["screenName"] = "Home screen"
        db.collection("users")
            .add(users)
            .addOnSuccessListener { }
            .addOnFailureListener { }
        super.onPause()
    }
}