package com.example.cap11_materialdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbarMain)

        toolBar.setOnClickListener {
            startActivity(Intent(this, ToolbarActivity::class.java))
        }
        moveMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }

        fab.setOnClickListener {
                view ->
            Snackbar.make(view, "Data deleted", Snackbar.LENGTH_SHORT)
                .setAction("Undo") {
                    Toast.makeText(this, "Data restored", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        materialCardView.setOnClickListener {
            startActivity(Intent(this, CardActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.backup -> Toast.makeText(
                                this,
                                "You clicked Backup",
                                Toast.LENGTH_SHORT
                            ).show()
            R.id.delete -> Toast.makeText(
                                this,
                                "You clicked Delete",
                                Toast.LENGTH_SHORT
                            ).show()
            R.id.settings -> Toast.makeText(
                                this,
                                "You clicked Settings",
                                Toast.LENGTH_SHORT
                            ).show()
        }
        return true
    }
}
