package com.test.laba1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val uri: Uri? = result.data?.data

                Log.d("RESULT_LOG", "${uri}")

                findViewById<ImageView>(R.id.image).setImageURI(uri)

                Toast.makeText(this, "We have a result !!!", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)

        Log.d("ACTIVITY_LOGS","onCreate MainActivity")

        val buttonOpenActivity = findViewById<View>(R.id.open_activity)
        buttonOpenActivity.setOnClickListener( object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            }
        })

        findViewById<View>(R.id.get_image).setOnClickListener( object : View.OnClickListener{
            override fun onClick(v: View?) {

                val intent = Intent().apply {
                    type = "image/*"
                    action = Intent.ACTION_GET_CONTENT
                }

                resultLauncher.launch(intent)
            }
        })
    }

    override fun onPause() {
        super.onPause()
        Log.d("ACTIVITY_LOGS","onPause MainActivity")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ACTIVITY_LOGS","onResume MainActivity")
    }
}