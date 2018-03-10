package net.thebix.sandbox

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import net.thebix.parkser.R
import net.thebix.sandbox.menu.MenuFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sandbox_activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.sandbox_activity_main_root, MenuFragment.newInstance(), "MAIN_ACTIVITY_FRAGMENT_TAG")
            .commit()
    }

}
